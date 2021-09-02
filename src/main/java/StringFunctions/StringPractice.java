package StringFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPractice {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args)
    {
     p5();
    }

    private static void p5(){
        int k = 1;
        for(int i=2;i<=8;i++){
            k= i^k;
        }
        System.out.println(k);
    }


    private static void p4() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st
                = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x % k == 0)
                count++;
        }
        System.out.println(count);
    }

    private static void p3(){
        String st = "P<INDVERMA<<ANIMESH<<<<<<<<<<<<<<<<<<<<<<<<<\n" +
                "S7310387<7IND9804038M2811051<<<<<<<<<<<<<<<6";
        st = st.replaceFirst("\n","");
        Pattern pattern = Pattern.compile("^[A-Z0-9<]{2}[A-Z<]{3}([A-Z0-9<]{39})([A-Z0-9<]{9})[0-9]{1}[A-Z<]{3}[0-9]{6}[0-9]{1}[FM]{1}[0-9]{6}[0-9]{1}[A-Z0-9<]{15}[0-9]{1}$");
        Matcher m = pattern.matcher(st);
       // while(m.find()) {
            System.out.println((m.group(1).replaceAll("<<"," ").replaceAll("<","").trim()));
            System.out.println(m.group(2).replaceAll("<",""));
       // }
//        System.out.println((st.split("\n")[0]).matches("^[A-Z0-9<]{2}[A-Z<]{3}[A-Z0-9<]{39}$"));
//        System.out.println((st.split("\n")[1]).matches("^[A-Z0-9<]{9}[0-9]{1}[A-Z<]{3}[0-9]{6}[0-9]{1}[FM]{1}[0-9]{6}[0-9]{1}[A-Z0-9<]{15}[0-9]{1}$"));
        //^[A-Z0-9<]{2}[A-Z<]{3}[A-Z0-9<]{39}$^
        //System.out.println(st.matches(""));
    }

    private static void p2() {
        String w = "पिता का नाम / Father’s Name : HEMANT KUMAR VERMA";
        String z = "नाम / Name : ANIMESH VERMA\n" +
                " िता का नाम / Father’s Name : HEMANT KUMAR VERMA\n" +
                "    जन्म कि तारीख / Date of Birth : 03/04/1998\n" +
                "    पैन / PAN : BNDPV7646C";
        Pattern pattern = Pattern.compile("(.*?):([\\s].+)");
        Matcher m = pattern.matcher(z);
        while (m.find()) {
            System.out.println(m.group(1).trim() + ":" + m.group(2));
        }
        //System.out.println(Arrays.toString(w.split("/", 2)));
//        String pat = "key=\"value\" key=\"value\"";
//        String st = "uid=\"123455\" name=\"animesh\" ";
//        Pattern pattern = Pattern.compile("(.*?)=\"(.*?)\"");
//        Matcher m = pattern.matcher(st);
//        while (m.find()) {
//            System.out.print("Key=" + m.group(1));
//            System.out.println("; Value=" + m.group(2));
//        }

    }

    private static void p1() throws ParseException {
//        String st = "https://hotel-images-piyush.s3.ap-south-1.amazonaws.com/images/tablist/14_hotel3.jpg";
//        String[] pp = st.split("\\/", 4);
//        String aa = "animkumarverma";
//        LocalDate localDate = LocalDate.now();
//        Date date = java.sql.Date.valueOf(localDate);
//        Pattern pattern = Pattern.compile("(0/91)?[6-9][0-9]{9}");
//        Matcher m = pattern.matcher("9929390493");
        System.out.println("9929390493".matches("(0/91)?[6-9][0-9]{9}"));

       // Date date = Date.from(LocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
      //  String se[] = aa.split(" ", 2);
       // System.out.println(.length() > ?);
        // System.out.println(st.substring(0,st.length()-4));
//        for (String p:pp){
//            System.out.println(p);
//        }
    }
}


