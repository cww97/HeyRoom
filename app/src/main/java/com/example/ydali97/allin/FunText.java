package com.example.ydali97.allin;

public class FunText {
    private String funname;
    private int imageid;
    public FunText(String name, int resid){
        this.funname = name;
        this.imageid = resid;
    }
    public String getname(){
        return funname;
    }
    public int getImageid(){
        return imageid;
    }
}
