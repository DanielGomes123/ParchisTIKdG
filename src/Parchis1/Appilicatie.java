package Parchis1;

public class Appilicatie {
    public static void main(String[] args) {
        System.out.println("WELKOM BIJ PARCHIS!\n" +
                "WE STARTEN NU HET SPEL OP...");
        Spel spelsessie = new Spel();
        spelsessie.setUp();
        while(!spelsessie.isSpelGedaan()){
            spelsessie.startBeurt();
        }
    }
}