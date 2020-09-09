package com.digi.pay.Models;

public class RecentSendData {

    String Name;
    String number;
    String image;

    public RecentSendData(String Name,String number,String image)
    {
        this.Name = Name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
