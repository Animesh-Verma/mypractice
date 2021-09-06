package Threading.DataRace;

public class MainDataRace {
    public static void main(String[] args) {

        SharedClass sharedClass = new SharedClass();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = Integer.MAX_VALUE; i >= 0; i--) {
                sharedClass.checkRace();
            }
        });

        t1.start();
        t2.start();
    }

    public static class SharedClass {
        private volatile int x = 0;
        private volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkRace() {
            if (y>x) {   //y must be on left side
                System.out.println("Race occurs");
            }
        }
    }
}
