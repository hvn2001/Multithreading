package JavaThreadBasics.SettingUpThreads.F3;

class Demonstration {
    public static void main(String args[]) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        executeMe.join();

    }
}

class ExecuteMe extends Thread {

    @Override
    public void run() {
        System.out.println("I ran after extending Thread class");
    }

}
