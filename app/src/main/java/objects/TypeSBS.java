package objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class TypeSbs {

    private String name;

    public TypeSbs() {
        // Default constructor required for calls to DataSnapshot.getValue(TypeSbs.class)
    }

    public TypeSbs(String name) {
        this.name = name;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTypeSbs() {
        Map<String, Object> typeSbsValues = this.toMap();
        DataConnection.updateChild(DataConnection.TYPE_SBS, typeSbsValues);
    }

    @Override
    public String toString() {
        return "TypeSbs{" +
                "name='" + name + '\'' +
                '}';
    }
}
