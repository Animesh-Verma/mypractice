package Threading.OptimizingThroughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {
    private static final String inputFile = "src/main/resources/throughput/war_and_peace.txt";
    public static final int NO_OF_THREAD = 4;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(inputFile)));
        startServer(text);
    }

    public static void startServer(String text) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/search",new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NO_OF_THREAD);
        server.setExecutor(executor);
        server.start();
    }

    private static class WordCountHandler implements HttpHandler {

        private String text;

        public WordCountHandler(String text){
            this.text = text ;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String[] keyvalue = query.split("=");
            String action = keyvalue[0];
            String word = keyvalue[1];
            if(!action.equals("word")){
                exchange.sendResponseHeaders(400,0);
                return;
            }
            long count = countWord(word);
            byte[] response = Long.toString(count).getBytes();
            exchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }
        private long countWord(String word){
            long count =0;
            int index = 0;
            while (index >= 0){
                index = text.indexOf(word,index);
                if(index >= 0){
                    count++;
                    index++;
                }
            }
            return count;
        }
    }
}
