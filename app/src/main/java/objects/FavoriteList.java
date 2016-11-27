package objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.DataConnection;

@IgnoreExtraProperties
public class FavoriteList {

    private String user;
    private ArrayList<String> sbs;

    public FavoriteList() {
        // Default constructor required for calls to DataSnapshot.getValue(FavoriteList.class)
    }

    public FavoriteList(String user, ArrayList<String> sbs) {
        this.user = user;
        this.sbs = sbs;
    }

    @Exclude
    public Map<String, Boolean> toMap() {
        HashMap<String, Boolean> result = new HashMap<>();

        for (String s : sbs) {
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

    public ArrayList<String> getSbs() {
        return sbs;
    }

    public void setSbs(ArrayList<String> sbs) {
        this.sbs = sbs;
    }

    public void addFavoriteList() {
        Map<String, Boolean> favoriteList = this.toMap();
        Map<String, Object> favoriteListValues = new HashMap<>();
        favoriteListValues.put(user, favoriteList);
        DataConnection.updateChild(DataConnection.FAVORITE_LIST, favoriteListValues);
    }

    @Override
    public String toString() {
        return "FavoriteList{" +
                "user='" + user + '\'' +
                ", sbs=" + sbs +
                '}';
    }
}

