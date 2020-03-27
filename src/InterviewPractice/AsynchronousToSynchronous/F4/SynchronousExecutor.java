package InterviewPractice.AsynchronousToSynchronous.F4;

import InterviewPractice.AsynchronousToSynchronous.F0.Callback;
import InterviewPractice.AsynchronousToSynchronous.F0.Executor;

class SynchronousExecutor extends Executor {
    public void asynchronousExecution(Callback callback) throws Exception {
        Object signal = new Object();
        boolean isDone = false;
        Callback cb = new Callback() {
            @Override
            public void done() {
                callback.done();
                synchronized (signal) {
                    signal.notify();
                    // isDone = true;
                }
            }
        };
        // Call the asynchronous executor
        super.asynchronousExecution(cb);
        synchronized (signal) {
            while (!isDone) {
                signal.wait();
            }
        }
    }
}