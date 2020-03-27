package InterviewPractice.SupermanCont.F6;

class Demonstration {
    public static void main(String args[]) {
        Superman superman = Superman.getInstance();
        superman.fly();
    }
}

class Superman {
    private static Superman superman;

    private Superman() {
    }

    public synchronized static Superman getInstance() {

        if (superman == null) {
            superman = new Superman();
        }

        return superman;
    }

    public void fly() {
        System.out.println("I am flyyyyinggggg ...");
    }
}