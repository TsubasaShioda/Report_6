package jp.ac.uryukyu.ie.e235730;

import java.util.List;

public class Player {
    private String name;        
    private List<Card> hand;   
    private List<Card> playedCards;  
    
    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }
        public String getName() {
        return name;
        }
        public List<Card> getHand() {
            return hand;
        }
        public List<Card> getPlayedCards() {
            return playedCards;
        }
        public int getNumCardsInHand() {
            return hand.size();
        }

        public void displayHand() {
            System.out.println(name + "さんの手札：");
            for (Card card : hand) {
                System.out.println("色：" + card.getColor() + "  数字：" + card.getNumber());
            }
        }
        
        public void playCard(Card card) {
            playedCards.add(card);
        }

        public Card moveCard(int index) {
            return hand.remove(index);
        }
        
        public void drawCard(Card card) {
            hand.add(card);
        }
        public boolean canPlay(Card card) {
            for (Card c : hand) {
                if (c.getColor().equals(card.getColor()) || c.getNumber().equals(card.getNumber())) {
                    return true;
                }
            }
            return false;
        }
        
    }
