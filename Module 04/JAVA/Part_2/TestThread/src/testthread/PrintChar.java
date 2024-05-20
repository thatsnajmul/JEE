package testthread;

//Printchar Class
class PrintChar implements Runnable {

    //Variable declare
    private char charToPrint;
    private int times;

    //Parameterazid or argument contactor
    public PrintChar(char charToPrint, int times) {
        this.charToPrint = charToPrint;
        this.times = times;
    }

    //Override method
    @Override
    public void run() {
        //Logic
        for (int i = 0; i <= times; i++) {
            System.out.print("," + charToPrint);
        }
    }

}

//PrintNum Class
class PrintNum implements Runnable {

    //Variable declare
    private int lastNum;

    //Constactor
    public PrintNum(int lastNum) {
        this.lastNum = lastNum;
    }

    //Override method
    @Override
    public void run() {

        //Logic
        for (int i = 1; i <= lastNum; i++) {
            System.out.print("," + i);
        }
    }

}
