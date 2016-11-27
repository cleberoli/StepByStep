package objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class ComponentSbs {

    private String sbs;
    private ArrayList<String> components;

    public ComponentSbs() {
        // Default constructor required for calls to DataSnapshot.getValue(ComponentSbs.class)
    }

    public ComponentSbs(String sbs, ArrayList<String> components) {
        this.sbs = sbs;
        this.components = components;
    }

    @Exclude
    public Map<String, Boolean> toMap() {
        HashMap<String, Boolean> result = new HashMap<>();

        for (String s : components) {
            result.put(s, true);
        }

        return result;
    }

    public String getSbs() {
        return sbs;
    }

    public void setSbs(String sbs) {
        this.sbs = sbs;
    }

    public ArrayList<String> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<String> components) {
        this.components = components;
    }

    public void addComponentSbs() {
        Map<String, Boolean> componentSbs = this.toMap();
        Map<String, Object> componentSbsValues = new HashMap<>();
        componentSbsValues.put(sbs, componentSbs);
        DataConnection.updateChild(DataConnection.COMPONENT_SBS, componentSbsValues);
    }

    @Override
    public String toString() {
        return "ComponentSbs{" +
                "sbs='" + sbs + '\'' +
                ", components=" + components +
                '}';
    }
}
