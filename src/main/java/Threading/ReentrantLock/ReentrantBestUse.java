package Threading.ReentrantLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantBestUse {
    public static void main(String[] args) {

    }

    public static class PriceContainer {

        private Lock lockObject = new ReentrantLock();

        private double bitcoinPrice;
        private double etherPrice;
        private double litecoinPrice;
        private double bitcoincashPrice;
        private double ripplePrice;

        public Lock getLockObject() {
            return lockObject;
        }

        public void setLockObject(Lock lockObject) {
            this.lockObject = lockObject;
        }

        public double getBitcoinPrice() {
            return bitcoinPrice;
        }

        public void setBitcoinPrice(double bitcoinPrice) {
            this.bitcoinPrice = bitcoinPrice;
        }

        public double getEtherPrice() {
            return etherPrice;
        }

        public void setEtherPrice(double etherPrice) {
            this.etherPrice = etherPrice;
        }

        public double getLitecoinPrice() {
            return litecoinPrice;
        }

        public void setLitecoinPrice(double litecoinPrice) {
            this.litecoinPrice = litecoinPrice;
        }

        public double getBitcoincashPrice() {
            return bitcoincashPrice;
        }

        public void setBitcoincashPrice(double bitcoincashPrice) {
            this.bitcoincashPrice = bitcoincashPrice;
        }

        public double getRipplePrice() {
            return ripplePrice;
        }

        public void setRipplePrice(double ripplePrice) {
            this.ripplePrice = ripplePrice;
        }
    }

    public static class priceUpdater extends Thread {
        private PriceContainer priceContainer;
        Random random = new Random();

        public priceUpdater(PriceContainer priceContainer) {
            this.priceContainer = priceContainer;
        }

        @Override
        public void run() {
            while (true) {
                priceContainer.getLockObject().lock();
                try {
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){}
                    priceContainer.setBitcoinPrice(random.nextInt(20000));
                    priceContainer.setBitcoincashPrice(random.nextInt(2000));
                    priceContainer .setEtherPrice(random.nextInt(500));
                    priceContainer.setLitecoinPrice(random.nextInt(5000));
                    priceContainer.setRipplePrice(random.nextInt(1000));
                } finally {
                    priceContainer.lockObject.unlock();
                }
                try{
                    Thread.sleep(2000);
                }catch (Exception e){}
            }
        }
    }

}
