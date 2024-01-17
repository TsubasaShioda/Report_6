package jp.ac.uryukyu.ie.e235730;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            hand.add(deck.drawCard());
        }
        
        Player player = new Player("Player1", hand);
        
        player.displayHand();
        
    }
}