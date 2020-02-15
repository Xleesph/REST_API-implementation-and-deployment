
package com.mycompany.mavenproject1;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "friends")
public class Friends {
    
    
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String usernameFrom;
    @DatabaseField
    String usernameTo;

    public Friends() {
    }

    public Friends(int id, String usernameFrom, String usernameTo) {
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
