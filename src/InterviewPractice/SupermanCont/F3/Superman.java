package InterviewPractice.SupermanCont.F3;

class Demonstration {
    public static void main(String args[]) {
        Superman superman = Superman.getInstance();
        superman.fly();
    }
}

class Superman {
    private static Superman superman = new Superman();

    private Superman() {
    }

    public static Superman getInstance() {
        return superman;
    }

    public void fly() {
        System.out.println("I am flyyyyinggggg ...");
    }
}