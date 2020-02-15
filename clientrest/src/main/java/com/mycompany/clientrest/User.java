package com.mycompany.clientrest;

public class User {

    String username;
    String name;
    String surname;
    String date;
    String genre;
    String description;
    String xwra;
    String poli;
    String password;

    public User() {
    }

    public User(String username, String name, String surname, String date, String genre, String description, String xwra, String poli, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.genre = genre;
        this.description = description;
        this.xwra = xwra;
        this.poli = poli;
        this.password = password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getXwra() {
        return xwra;
    }

    public void setXwra(String xwra) {
        this.xwra = xwra;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

}
