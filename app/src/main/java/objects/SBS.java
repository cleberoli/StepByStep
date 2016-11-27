package objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class Sbs {

    private String name;
    private String typeID;
    private String userID;
    private String steps;
    private String components;

    public Sbs() {
        // Default constructor required for calls to DataSnapshot.getValue(Sbs.class)
    }

    public Sbs(String name, String typeID, String userID, String steps) {
        this.name = name;
        this.typeID = typeID;
        this.userID = userID;
        this.steps = steps;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("typeid", typeID);
        result.put("userid", userID);
        result.put("steps", steps);
        result.put("components", components);

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public void addSbs() {
        Map<String, Object> sbsValues = this.toMap();
        DataConnection.updateChild(DataConnection.SBS, sbsValues);
    }

    @Override
    public String toString() {
        return "Sbs{" +
                "name='" + name + '\'' +
                ", typeID='" + typeID + '\'' +
                ", userID='" + userID + '\'' +
                ", steps='" + steps + '\'' +
                '}';
    }
}
