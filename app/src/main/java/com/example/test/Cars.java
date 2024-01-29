package com.example.test;

public class Cars {
    private String name;
    private String model;
    private int comment;

    public Cars(String name, String capital, int flag){

        this.name=name;
        this.model=capital;
        this.comment=flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return this.model;
    }

    public void setComment(String capital) {
        this.model = capital;
    }

    public int getCarsIMG() {
        return this.comment;
    }

    public void setCarsIMG(int flagResource) {
        this.comment = flagResource;
    }
}
