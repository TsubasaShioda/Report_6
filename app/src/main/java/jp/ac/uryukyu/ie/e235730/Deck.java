package jp.ac.uryukyu.ie.e235730;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards; 
    
    public Deck() {
        cards = new ArrayList<>();
        for (int i=0; i<4; i++)
            for (String color : new String[]{"red", "blue", "yellow", "green"}) {
                for (String number : new String[]{"0","1","3","4","5","6","7","8","9"}) {
                    cards.add(new Card(color, number));
                }
            }
    }
    
}