package objects;

import android.util.Log;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class ComponentItem {

    private String name;

    public ComponentItem() {
        // Default constructor required for calls to DataSnapshot.getValue(ComponentItem.class)
    }

    public ComponentItem(String name) {
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

    public void addComponentItem() {
        Map<String, Object> componentItemValues = this.toMap();
        DataConnection.updateChild(DataConnection.COMPONENT_ITEM, componentItemValues);
    }

    @Override
    public String toString() {
        return "ComponentItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
