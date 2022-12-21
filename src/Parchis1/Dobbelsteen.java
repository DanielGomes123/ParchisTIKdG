package Parchis1;


import java.util.Random;

public class Dobbelsteen {
    private int waarde;
    Random rn;
    Dobbelsteen(){
        rn = new Random();
    }
    public void gooi(){
        waarde = rn.nextInt(1,7);
    }
    public int getWaarde(){
        return waarde;
    }
}