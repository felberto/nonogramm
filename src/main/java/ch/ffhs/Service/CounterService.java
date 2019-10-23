package ch.ffhs.Service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CounterService extends Service<Void> {

    private int timer;

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = timer; true; i++) {
                    if (isCancelled()) {
                        break;
                    }

                    updateMessage(String.valueOf(i));

                    Thread.sleep(1000);
                }
                return null;
            }
        };
    }

    public int getTimer() {
        return this.timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
