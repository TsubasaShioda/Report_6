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
        List<Card> hand1 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            hand1.add(deck.drawCard());
        }
        List<Card> hand2 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            hand2.add(deck.drawCard());
        }
        List<Card> hand3 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            hand3.add(deck.drawCard());
        }
        
        Player player = new Player("Player", hand);
        Player CPU1 = new CPUPlayer("CPU1", hand1);
        Player CPU2 = new CPUPlayer("CPU2", hand2);
        Player CPU3 = new CPUPlayer("CPU3", hand3);
        
        player.displayHand();
        CPU1.displayHand();
        CPU2.displayHand();
        CPU3.displayHand();

    }
}