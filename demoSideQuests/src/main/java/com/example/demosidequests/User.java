package com.example.demosidequests;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private List<Attributes> attributes;


    User(String userName) {
        this.userName = userName;
        this.attributes = new ArrayList<>();
    }

    public String getUserName() { return userName; }

    public List<Attributes> getAttributes() { return attributes; }

    @Override
    public String toString() {
        return super.toString();
    }
}
