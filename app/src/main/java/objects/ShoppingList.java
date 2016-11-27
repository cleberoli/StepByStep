package objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class ShoppingList {

    private String user;
    private ArrayList<String> components;

    public ShoppingList() {
        // Default constructor required for calls to DataSnapshot.getValue(ShoppingList.class)
    }

    public ShoppingList(String user, ArrayList<String> components) {
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<String> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<String> components) {
        this.components = components;
    }

    public void addShoppingList() {
        Map<String, Boolean> shoppingList = this.toMap();
        Map<String, Object> shoppingListValues = new HashMap<>();
        shoppingListValues.put(user, shoppingList);
        DataConnection.updateChild(DataConnection.SHOPPING_LIST, shoppingListValues);
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "user='" + user + '\'' +
                ", components=" + components +
                '}';
    }
}