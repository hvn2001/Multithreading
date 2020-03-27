package InterviewPractice.AsynchronousToSynchronous.F2;

import InterviewPractice.AsynchronousToSynchronous.F0.Callback;
import InterviewPractice.AsynchronousToSynchronous.F0.Executor;

class SynchronousExecutor extends Executor {
    public void asynchronousExecution(Callback callback) throws Exception {
        Object signal = new Object();
        // Call the asynchronous executor
        super.asynchronousExecution(callback);
        synchronized (signal) {
            // signal();
        }
    }
}