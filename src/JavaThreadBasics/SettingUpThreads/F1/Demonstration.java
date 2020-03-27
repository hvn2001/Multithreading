package JavaThreadBasics.SettingUpThreads.F1;

class Demonstration {
    public static void main(String args[]) {

        ExecuteMe executeMe = new ExecuteMe();
        Thread t = new Thread(executeMe);
        t.start();
    }
}

class ExecuteMe implements Runnable {

    public void run() {
        System.out.println("Say Hello");
    }

}
