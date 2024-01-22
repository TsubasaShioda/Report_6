package jp.ac.uryukyu.ie.e235730;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;  //カードリスト
    
    public Deck() {  //カード生成
        cards = new ArrayList<>();
        for (int i=0; i<7; i++)
            for (String color : new String[]{"red", "blue", "yellow", "green"}) {
                for (String number : new String[]{"0","1","3","4","5","6","7","8","9"}) {
                    cards.add(new Card(color, number));
                }
            }
    }
    public Card drawCard() {  //デッキから1枚のカードを返す
        if (cards.isEmpty()) {
            return null;  
        }
        return cards.remove(cards.size() - 1);
    }
    
    public void shuffle() {  //デッキのカードをシャッフルする
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = rand.nextInt(cards.size());

            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }
}