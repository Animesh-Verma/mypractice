package Threading.ResourceSharing;

public class InventoryCounter {


    public static void main(String[] args) throws InterruptedException {
        InventoryCount inventoryCount = new InventoryCount();
        IncrementThread incrementThread = new IncrementThread(inventoryCount);
        DecrementThread decrementThread = new DecrementThread(inventoryCount);
        incrementThread.start();
        decrementThread.start();
        incrementThread.join();
        decrementThread.join();

        System.out.println(inventoryCount.getItems());
    }

    public static class IncrementThread extends Thread {

        private InventoryCount inventoryCount;

        public IncrementThread(InventoryCount inventoryCount) {
            this.inventoryCount = inventoryCount;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 1000; i++) {
                inventoryCount.increment();
            }
        }
    }

    public static class DecrementThread extends Thread {

        private InventoryCount inventoryCount;

        public DecrementThread(InventoryCount inventoryCount) {
            this.inventoryCount = inventoryCount;
        }

        @Override
        public void run() {
            for (int i = 1000; i >= 0; i--) {
                inventoryCount.decrement();
            }
        }
    }

    private static class InventoryCount {
        private int items = 0;
        Object lock = new Object();

        public void increment() {
            synchronized (this.lock){
                items++;
            }
        }

        public synchronized void decrement() {
            synchronized (this.lock){
                items--;
            }
        }

        public int getItems() {
            synchronized (this.lock){
                return items;
            }
        }
    }
}
