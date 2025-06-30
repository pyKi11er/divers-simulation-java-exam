package environment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import person.divers.*;
import environment.collectables.*;
import environment.marker.*;
import person.util.*;
import person.*;
import person.util.*;

public class DivingOperation {
    public final ArrayList<Diver> teams;
    public final ArrayList<Artefact> allArtefacts;

    public DivingOperation(int totalTeams){
        if(totalTeams % 3 != 0) throw new IllegalArgumentException("The number of teams should be divisible by 3");
        teams = new ArrayList<>();
        allArtefacts = new ArrayList<>();
        for(int i = 1; i <= totalTeams; i++){
            String teamId = ("T"+i);
            Color specColor = Color.values()[(i-1)%3];
            Diver team = new Diver(teamId, specColor);
            teams.add(team);
        }
    }

    private void registerArtefacts(Artefact... n){
        for(Artefact a : n){
            if(a.getColor() == Color.GREEN){
                registerArtefact(a);
            }
        }
    }

    private void registerArtefact(Artefact artefact){
        if(!allArtefacts.contains(artefact)){
            allArtefacts.add(artefact);
        }
    }

    public void prepareOperation(int n){
        ArrayList<Artefact> dumperArtefacts = Dumper.dumpArtefacts(n);
        boolean hasGreen = false;
        int[] checkIndices = {0,2,n/2,n-1};
        for(int i : checkIndices){
            if(i < dumperArtefacts.size() && dumperArtefacts.get(i).getColor() == Color.GREEN){
                hasGreen = true;
                break;
            }
        }
        if(!hasGreen){
            throw new IllegalStateException();
        }
        registerArtefacts(dumperArtefacts.toArray(new Artefact[0]));
    }

    public HashSet<Artefact> conductOperation() throws WrongArtefact {
        HashSet<Artefact> retrieved = new HashSet<Artefact>();
        for(Diver team : teams){
            for(Artefact a : allArtefacts){
                if(!retrieved.contains(a)){
                    team.tagArtefacts(allArtefacts);
                    boolean isRetrieved = team.tryToGetArtefact(a);
                    if(!isRetrieved && team.getColor() == Color.RED){
                        if(!a.getLocationData().contains("#KO")){
                            team.forceInsertArtefact(a);
                        }
                    }
                    if(isRetrieved){
                        retrieved.add(a);
                    }
                }
            }
        }
        return retrieved;
    }

}
