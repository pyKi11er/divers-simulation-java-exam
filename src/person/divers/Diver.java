package person.divers;

import environment.collectables.Artefact;
import person.util.*;
import environment.marker.Color;
import java.util.ArrayList;

public class Diver {
    private final ArrayList<Artefact> artefacts;
    private final String teamId;
    private final Color specialityColor;

    public Diver(String teamId, Color color){
        artefacts = new ArrayList<>();
        this.teamId = teamId;
        this.specialityColor = color;
    }

    public Diver(){
        artefacts = new ArrayList<>();
        this.teamId = "T1";
        this.specialityColor = Color.values()[0];
    }

    public ArrayList<Artefact> getArtefacts(){
        ArrayList<Artefact> copyArtefacts = new ArrayList<>();
        for(Artefact a : artefacts){
            copyArtefacts.add(a);
        }

        return copyArtefacts;
    }

    public Color getColor(){
        return this.specialityColor;
    }

    public String getTeamId(){
        return this.teamId;
    }

    public void tagArtefacts(ArrayList<Artefact> toTag){
        if(specialityColor == Color.BLUE){
            return;
        }
        else if(specialityColor == Color.RED){
            for(Artefact a : toTag){
                if(a.getRigidStructure()){
                    a.tag();
                }
            }
            return;
        }
        else{
            for(Artefact a : toTag){
                a.tag();
            }
        }
    }

    public boolean tryToGetArtefact(Artefact artefact){
        if(specialityColor == artefact.getColor()){
            if(artefact.retrieve()!= null){
                artefacts.add(artefact);
                return true;
            }
            else{
                artefact.tag();
                return false;
            }
        }
        return false;

    }

    public void forceInsertArtefact(Artefact artefact) throws WrongArtefact {
        if(specialityColor != artefact.getColor()) throw new WrongArtefact("Wrong Color");
        else{
            if(artefact.retrieve() != null){
                artefacts.add(artefact);     
            }
            else{
                artefact.tag();
                if(artefact.retrieve() == null && artefact.getLocationData().contains("#KO")) throw new WrongArtefact("Got Waste");
            }
        }
        
    }
}
