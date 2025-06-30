package environment.collectables;

import environment.marker.Color;

public class Waste extends Artefact{
    private boolean tagged;

    public Waste(String locationData, Color color){
        super(locationData, color);
        tagged = false;
    }

    public void extendLocationData(String locationString){
        this.locationData+=locationString;
    }

    public Waste retrieve(){
        if(tagged && !locationData.contains("#KO")){
            extendLocationData("#KO");
            return this;
        }
        return null;
    }

    @Override
    public void tag(){
        tagged = !tagged;
    }

    public void setRigidStructure(boolean rigidStructure){}
}
