package environment.collectables;

import environment.marker.*;
public class Sample extends Artefact{
    private boolean tagged;

    public Sample(String locationData, Color color){
        super(locationData, color);
        tagged = false;
    }

    public void extendLocationData(String locationData){
        this.locationData+=locationData;
    }
    
    public Sample retrieve(){
        if(tagged || getRigidStructure()){
            int combinedLength = getLocationData().length() + getColor().toString().length();
            if(!locationData.contains("#")){
                if(combinedLength > 9 && combinedLength < 14){
                    extendLocationData("#OK");
                    return this;
                }
                else{
                    extendLocationData("#NO");
                    return this;
                }
            }
        }
        return null;
    }

    @Override
    public void tag(){
        boolean struct = !getRigidStructure();
        setRigidStructure(struct);
        if(!tagged){
            tagged=true;
        }
    }
}
