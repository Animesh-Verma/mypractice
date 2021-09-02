package Threading;

import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Long duration = (long) (Math.random() * 20);
          //  System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);
          //  System.out.println("Doing a task during : " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
