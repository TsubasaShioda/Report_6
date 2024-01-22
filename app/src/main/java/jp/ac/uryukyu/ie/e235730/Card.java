package jp.ac.uryukyu.ie.e235730;

public class Card {
    private String color; //色
    private String number; //数字

    public Card(String color, String number){
        this.color=color;
        this.number=number; 
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

}
