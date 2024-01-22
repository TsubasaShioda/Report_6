package jp.ac.uryukyu.ie.e235730;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;  //名前     
    private List<Card> hand;   //手札のリスト
    private List<Card> playedCards;  //出したカードのリスト
    
    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.playedCards = new ArrayList<>();
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

        public void displayHand() {  //手札を表示
            System.out.println(name + "さんの手札：");
            for (Card card : hand) {
                System.out.println("色：" + card.getColor() + "  数字：" + card.getNumber());
            }
        }
        
        public void playCard(Card card) {  //カードを出す
            playedCards.add(card);
        }

        public Card moveCard(int index) {  //手札から移動
            return hand.remove(index);
        }
        
        public void drawCard(Card card) {  //手札に追加
            hand.add(card);
        }
        
    }
