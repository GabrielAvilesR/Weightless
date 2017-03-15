package com.gabo.weightless;

/**
 * Created by LIC on 08/03/2017.
 */

public class Equipment {
    private String name, owner;
    private int id;
    public Equipment(int id, String name, String owner){
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public String getName(){
        return this.name;
    }
    public String getOwner(){
        return this.owner;
    }
    public int getId(){
        return this.id;
    }
}
