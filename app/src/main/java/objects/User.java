package objects;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class User {

    private String name;
    private String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("email", email);

        return result;
    }

    public void addUser(String key) {
        Map<String, Object> user = this.toMap();
        Map<String, Object> userValues = new HashMap<>();
        userValues.put(key, user);
        DataConnection.updateChild(DataConnection.USER, userValues);
    }
}
