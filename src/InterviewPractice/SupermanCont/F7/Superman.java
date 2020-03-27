package InterviewPractice.SupermanCont.F7;

class Demonstration {
    public static void main(String args[]) {
        Superman superman = Superman.getInstance();
        superman.fly();
    }
}

class Superman {

    private Superman() {
    }

    private static class Holder {
        private static final Superman superman = new Superman();
    }

    public static Superman getInstance() {
        return Holder.superman;
    }

    public void fly() {
        System.out.println("I am flyyyyinggggg ...");
    }
}
