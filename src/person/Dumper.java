package person;

import java.util.ArrayList;
import environment.collectables.*;
import environment.marker.*;
public class Dumper{
    public static ArrayList<Artefact> dumpArtefacts(int n){
        ArrayList<Artefact> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int iterNumber = 100+i;
            Color color = Color.values()[i%3];
            String shortColor = color.toString().substring(0, 2);
            String newLoc = (iterNumber+"-"+shortColor);
            if(i%2==0){
                Sample s = new Sample(newLoc, color);
                result.add(s);
            }
            else{
                Waste w = new Waste(newLoc, color);
                result.add(w);
            }
        }
        return result;
    }
}