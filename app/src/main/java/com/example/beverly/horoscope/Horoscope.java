package com.example.beverly.horoscope;

public class Horoscope {

    private int img;
    private String name, date;

    public Horoscope(int img, String name, String date) {
        super();
        this.img = img;
        this.name = name;
        this.date = date;
    }

    public int getImg() {

        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
