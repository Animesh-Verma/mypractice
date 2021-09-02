package Threading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiThreadingFactorial {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(100000L, 245L, 234L, 2345L, 2334L, 666L, 12L);
        List<FactorialThread> threads = new ArrayList<>(inputNumbers.size());
        for (long inp : inputNumbers) {
            threads.add(new FactorialThread(inp));
        }

        int ii=1;
        for (FactorialThread f : threads) {
            f.setName(String.valueOf(ii));
            f.setDaemon(true);
            f.start();
            ii++;
        }

        for (Thread th : threads) {
            if(th.getName().equals("1")){
                th.interrupt();
            }
            th.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("factorial of input number " + inputNumbers.get(i) + " is" + factorialThread.getResult());
            } else {
                System.out.println("factorial of input number " + inputNumbers.get(i) + " is processing");
            }
        }
    }
}

class FactorialThread extends Thread {
    private long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    public BigInteger factorial(long inputNumber) {
        BigInteger bi = BigInteger.ONE;

        for (long i = inputNumber; i >= 0; i--) {
            if(isInterrupted()){
                System.out.println("Thread interrupted");
                return BigInteger.ZERO;
            }
            bi = bi.multiply(new BigInteger(Long.toString(inputNumber)));
        }
        return bi;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public BigInteger getResult() {
        return result;
    }

}

