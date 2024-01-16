package jp.ac.uryukyu.ie.e235730;

import java.util.List;

public class Player {
    private String name;        
    private List<Card> hand;     
    
    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }
        public void displayHand() {
            System.out.println(name + "さんの手札：");
            for (Card card : hand) {
                System.out.println("色：" + card.getColor() + "  数字：" + card.getNumber());
            }
        }
        
        public Card playCard(int index) {
            return hand.remove(index);
        }
        
        public void drawCard(Card card) {
            hand.add(card);
        }
        
        public int getNumCardsInHand() {
            return hand.size();
        }
    }
