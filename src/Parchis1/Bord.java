package Parchis1;
import java.util.*;
public class Bord {
    Map<Integer, Vak> bord;
    public Bord(){
        bord = new HashMap<>();
        int id = 0;
        ArrayList<int[]> safeSpots = new ArrayList<>(Collections.singleton(new int[]{5, 12, 17, 22, 29, 34, 39, 46, 51, 56, 63, 68}));
        ArrayList<int[]> nest = new ArrayList<>(Collections.singleton(new int[]{69,70,71,72}));
        ArrayList<int[]> landingsbaan = new ArrayList<>(Collections.singleton(new int[]{73,74,75,76,77,78,79,81,82,83,84,85,86,87,89,94,96,97,98,99,100,101,102}));
        ArrayList<int[]> centrum = new ArrayList<>(Collections.singleton(new int[]{80,88,95,103}));
        for (int i = 0 ; i<103 ; i++){
            id++;
            if(safeSpots.contains(id)){
                bord.put(id, new Vak(soortVak.SAFESPACE,id));
            }else if(nest.contains(id)){
                bord.put(id, new Vak(soortVak.NEST,id));
            }else if(landingsbaan.contains(id)){
                bord.put(id, new Vak(soortVak.LANDINGSBAAN,id));
            }else if(centrum.contains(id)){
                bord.put(id,new Vak(soortVak.CENTRUM,id));
            }else{
                bord.put(id,new Vak(soortVak.WANDELVAK,id));
            }
        }
    }
    public void printBord(){
        System.out.println(bord.values());
    }
}