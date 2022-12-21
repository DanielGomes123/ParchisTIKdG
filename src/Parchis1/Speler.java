package Parchis1;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Speler {
    private Scanner kb;
    private String naam;
    private Kleuren kleur;
    private List<Pion> pionen;
    public Speler(String naam, Kleuren kleur) {
        this.naam = naam;
        this.kleur = kleur;
        pionen = new ArrayList<>(4);
        pionen.add(new Pion(1));
        pionen.add(new Pion(2));
        pionen.add(new Pion(3));
        pionen.add(new Pion(4));
        kb = new Scanner(System.in);
    }
    public String getNaam() {
        return naam;
    }
    public Kleuren getKleur() {
        return kleur;
    }
    public boolean canMove(){
        for(Pion p : pionen){
            if(p.isCanMove()){
                return true;
            }
        }
        return false;
    }
    public void eersteVerlaatNest(){
        for(Pion p : pionen){
            if(!p.isInSpel()){
                if(kleur.equals(Kleuren.GEEL)){
                    p.leaveNest(5);
                    break;
                }
                if(kleur.equals(Kleuren.BLAUW)){
                    p.leaveNest(22);
                    break;
                }
                if(kleur.equals(Kleuren.ROOD)){
                    p.leaveNest(39);
                    break;
                }
                if(kleur.equals(Kleuren.GROEN)){
                    p.leaveNest(56);
                    break;
                }
            }
        }
    }
    public void beweegPion(int move){
        List<Integer> moveablePionnen = new ArrayList<>(4);
        System.out.println("Welke pion wil je bewegen?");
        for (Pion p : pionen){
            if(p.isCanMove()){
                System.out.println(p.getPionNummer() + " op locatie " + p.getLocatie());
                moveablePionnen.add(p.getPionNummer());
            }
        }
        int keuze = 0;
        if (moveablePionnen.size()>1){
            boolean validKeuze = false;
            while(!validKeuze){
                System.out.print("Wie wil je bewegen: ");
                keuze = kb.nextInt();
                if(moveablePionnen.contains(keuze)){
                    validKeuze = true;
                }else{
                    System.out.println("Deze pion kan je niet bewegen! Kies een ander.");
                }
            }
        }else{
            keuze = moveablePionnen.get(0);
        }
        for(Pion p : pionen){
            if (keuze == p.getPionNummer()){
                System.out.println("Deze pion is van positie " + p.getLocatie() + " naar " + p.getLocatie()+move + " verplaatst.");
                p.move(move);
                break;
            }
        }
    }
    public boolean isGewonnen(){
        for(Pion p : pionen){
            if(!p.isUit()){
                return false;
            }
        }
        return true;
    }
}