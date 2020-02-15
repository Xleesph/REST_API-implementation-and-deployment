package com.mycompany.mavenproject1;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "posts")
public class Post {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String usernameFrom;
    @DatabaseField
    String usernameTo;
    @DatabaseField
    String message;

    public Post() {
    }

    public Post(int id, String usernameFrom, String usernameTo) {
        this.id = id;
        this.usernameFrom = usernameFrom;
        this.usernameTo = usernameTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsernameFrom() {
        return usernameFrom;
    }

    public void setUsernameFrom(String usernameFrom) {
        this.usernameFrom = usernameFrom;
    }

    public String getUsernameTo() {
        return usernameTo;
    }

    public void setUsernameTo(String usernameTo) {
        this.usernameTo = usernameTo;
    }

}
