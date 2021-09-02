package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExec {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Worker thread");
            }
        });
        thread.start();
        System.out.println("hi");
//        for(int i=0;i<10;i++){
//            TimeUnit.SECONDS.sleep(1);
//            System.out.print(i+"\r");
//        }
//        System.out.println();
//            async();
//            System.out.println("async");

//        int input = 50;
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute(() ->
//        {
//            for (int i=0;i<5;i++){
//                System.out.println(i);
//            }
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("Async task");
//        });

//        for (int i = 0; i < 10; i++)
//        {
//            Task task = new Task("Task " + i);
//            System.out.println("A new task has been added : " + task.getName());
//            executorService.execute(task);
//        }
//        executorService.shutdown();
//        Future<?> future = executorService.submit(() ->{
//                    System.out.println(String.format("starting task %s",Thread.currentThread().getName()));
//                }
//        );
        //String result = future.get();
    }

    private static void async() throws InterruptedException, ExecutionException {
        List<Future<?>> futures = new ArrayList<Future<?>>();
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            Task task = new Task("Task " + i);
            // System.out.println("A new task has been added : " + task.getName());
            Future<?> f = executorService.submit(task);
            futures.add(f);
        }

        int j = 0;
        for (Future<?> future : futures) {
            if (future.get() == null) {
                System.out.print(++j + " of 20 \r");
            }
        }
        executorService.shutdown();

//        executorService.execute(() ->
//        {
//            for (int i=0;i<50;i++){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(i+"--"+Thread.currentThread().getName());
//            }
//        });
//        executorService.shutdown();
    }
}
