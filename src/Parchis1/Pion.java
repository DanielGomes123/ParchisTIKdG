package Parchis1;

public class Pion {
    private int pionNummer;
    private int locatie;
    private boolean inSpel;
    private boolean isUit;
    private boolean canMove;
    public Pion(int pionNummer){
        this.pionNummer = pionNummer;
        inSpel = false;
        isUit = false;
        canMove = false;
    }
    public int getLocatie(){
        return locatie;
    }

    public int getPionNummer() {
        return pionNummer;
    }

    public void leaveNest(int startpositie){
        locatie = startpositie;
        inSpel = true;
    }
    public void toNest(int nest){
        locatie = nest;
        inSpel = false;
    }
    public boolean isInSpel() {
        return inSpel;
    }
    public boolean isUit() {
        return isUit;
    }
    public void move(int move){
        locatie+=move;
    }
    public boolean isCanMove(){
        return !isUit && isInSpel();
    }
    @Override
    public String toString() {
        return "Pion is op plaats " + locatie;
    }
}