/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import org.json.JSONObject;

/**
 *
 * @author harryanto
 */
public class Users {
    
    private int userID;
    private String name;
    private String title;
    private String birthDate;
    private String hireDate;
    private String position;
    private String email;
    private String password;
    
    public Users() {
    }

    public Users(JSONObject json) {
        this.userID = json.optInt("userID", 0);
        this.name = json.optString("name", "");
        this.title = json.optString("title", "");
        this.birthDate = json.optString("birthDate", "");
        this.hireDate = json.optString("hireDate", "");
        this.position = json.optString("position", "");
        this.email = json.optString("email", "");
        this.password = json.optString("password", "");
    }
    
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("userID", userID);
        json.put("name", name);
        json.put("title", title);
        json.put("birthDate", birthDate);
        json.put("hireDate", hireDate);
        json.put("position", position);
        json.put("email", email);
        json.put("password", password);
        return json;
    }
    
    public Object getValue(int index){
        switch(index){
            case 0: return userID;
            case 1: return name;
            case 2: return title;
            case 3: return birthDate;
            case 4: return hireDate;
            case 5: return position;
            case 6: return email;
            case 7: return password;
            
            default: return null;
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
