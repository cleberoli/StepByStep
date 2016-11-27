package controllers;

import database.DataConnection;
import objects.User;

public class CreateUser {

    public static void createUser(String key, User user) {
        user.addUser(key);
        DataConnection.temp2();
    }
}
