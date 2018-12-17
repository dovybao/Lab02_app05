package com.example.vybao.lab02_app05;

public class Employee {
    private String id;
    private String name;
    private boolean position;

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPosition(boolean position){
        this.position = position;
    }

    public boolean isManager() {
        return position;
    }
    public String toString(){
        return this.name;
    }
}
