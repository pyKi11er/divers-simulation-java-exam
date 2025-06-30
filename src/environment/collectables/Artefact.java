package environment.collectables;

import java.util.Objects;

import environment.marker.*;

public abstract class Artefact implements Marked{
    protected String locationData;
    protected final Color color;
    private boolean rigidStructure;

    public Artefact(String locationData, Color color){
        if(locationData.length() <= 3 || locationData==null) throw new IllegalArgumentException();
        this.locationData = locationData;
        this.color = color;
        if(this instanceof Waste){
            this.rigidStructure = true;
        }
        else{
            this.rigidStructure = false;
        }
        
    }

    public Color getColor(){
        return color;
    }

    public String getLocationData(){
        return locationData;
    }

    public boolean getRigidStructure(){
        return rigidStructure;
    }

    public void setRigidStructure(boolean rigidStructure){
        if(this instanceof Waste){
            return;
        }
        this.rigidStructure = rigidStructure;
    }

    public abstract void extendLocationData(String newData);

    public abstract Artefact retrieve();

    @Override
    public String toString(){
        String output = ("LocationData: "+locationData+", Color: "+color+", isRigid: "+rigidStructure+"");
        return output;
    }

    @Override
    public boolean equals(Object that){
        if(this == that) return true;
        if(!(that instanceof Artefact)) return false;
        Artefact other = (Artefact) that;
        if(other.getLocationData() == null || this.locationData == null) {
            return false;
        }
        
        return this.locationData.substring(0, 3).equals(other.getLocationData().substring(0, 3)) 
                && this.color == other.getColor() && this.rigidStructure == other.getRigidStructure();
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationData.substring(0, 3), color, rigidStructure);
    }

}
