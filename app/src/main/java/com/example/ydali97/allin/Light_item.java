package com.example.ydali97.allin;

public class Light_item {
    private String roomname;
    private int imageid;
    public Light_item(String name, int resid){
        this.roomname = name;
        this.imageid = resid;
    }
    public String getname(){
        return roomname;
    }
    public int getImageid(){
        return imageid;
    }
}
