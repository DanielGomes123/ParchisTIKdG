package Parchis1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spel {
    private int beurt;
    private List<Speler> spelers;
    private Bord bord;
    private Dobbelsteen dice;
    Scanner kb = new Scanner(System.in);
    public Spel() {
        beurt = 1;
        spelers = new ArrayList<>(4);
        bord = new Bord();
        dice = new Dobbelsteen();
    }
    public void setUp(){
        kb = new Scanner(System.in);
        System.out.print("WAT IS DE NAAM VAN SPELER 1? (GEEL) : ");
        spelers.add(new Speler(kb.next(),Kleuren.GEEL));
        System.out.print("WAT IS DE NAAM VAN SPELER 2? (BLAUW) : ");
        spelers.add(new Speler(kb.next(),Kleuren.BLAUW));
        System.out.print("WAT IS DE NAAM VAN SPELER 3? (ROOD) : ");
        spelers.add(new Speler(kb.next(),Kleuren.ROOD));
        System.out.print("WAT IS DE NAAM VAN SPELER 4? (GROEN) : ");
        spelers.add(new Speler(kb.next(),Kleuren.GROEN));
    }
    public void startBeurt(){
        System.out.println("BEURT " + beurt);
        System.out.println("-------");
        for (Speler s : spelers){
            if(!s.isGewonnen()){
                System.out.println("----Het is " + s.getNaam() + " zijn beurt!----");
                dice.gooi();
                System.out.println("Je hebt een " + dice.getWaarde() + " gegooid.");
                if(dice.getWaarde()==5){
                    System.out.println("JE PION VERLAAT HET NEST!!!");
                    s.eersteVerlaatNest();
                    continue;
                }
                if(s.canMove()){
                    s.beweegPion(dice.getWaarde());
                }else{
                    System.out.println("Je kan geen enkele pion bewegen...");
                }
            }
        }
        System.out.print("Tik in 'enter' om naar de volgende beurt te gaan : ");
        String next = kb.next();
        beurt++;
    }
    public boolean isSpelGedaan(){
        for(Speler s : spelers){
            if (!s.isGewonnen()){
                return false;
            }
        }
        return true;
    }
}