package JavaThreadBasics.SettingUpThreads.F0;

class Demonstration {
    public static void main(String args[]) {
        Thread t = new Thread(new Runnable() {

            public void run() {
                System.out.println("Say Hello");
            }
        });
        t.start();
    }
}