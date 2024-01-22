package jp.ac.uryukyu.ie.e235730;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

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
        
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(CPU1);
        players.add(CPU2);
        players.add(CPU3);
        
        player.displayHand();

        Scanner scanner = new Scanner(System.in);

        Card currentCard = deck.drawCard();
        int currentPlayerIndex = 0;

        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            
            System.out.println("現在のプレイヤー" + currentPlayer.getName());
            System.out.println("現在のカード：色：" + currentCard.getColor() + "  数字：" + currentCard.getNumber());

            boolean validPlay = false;
            
            if (currentPlayer instanceof CPUPlayer) {
                int cardIndex = new Random().nextInt(currentPlayer.getNumCardsInHand());
                Card selectedCard = currentPlayer.moveCard(cardIndex);

                if (selectedCard.getColor().equals(currentCard.getColor())
                        || selectedCard.getNumber().equals(currentCard.getNumber())) {
                    validPlay = true;
                    currentCard = selectedCard;
                    currentPlayer.playCard(selectedCard);
                    System.out.println(currentPlayer.getName() + "は 色：" + currentCard.getColor() + "  数字：" + currentCard.getNumber() + "を出した！");
                    System.out.println(currentPlayer.getName() + "残り" + (currentPlayer.getNumCardsInHand() ) + "枚");
                } else {
                    currentPlayer.drawCard(selectedCard);
                    System.out.println(currentPlayer.getName() + "はパスした");
                    currentPlayer.getHand().add(deck.drawCard());
                    System.out.println(currentPlayer.getName() + "残り" + currentPlayer.getNumCardsInHand() + "枚");
                    validPlay = true;
                }
            } else {
                while (!validPlay) {
                    player.displayHand();
                    System.out.println("現在のカード：色：" + currentCard.getColor() + "  数字：" + currentCard.getNumber());
                    System.out.println("プレイするカードの番号を入力してください（0から" + (currentPlayer.getNumCardsInHand() - 1) + "）:");
                    int cardIndex = scanner.nextInt();

                    Card selectedCard = currentPlayer.moveCard(cardIndex);

                    if (selectedCard.getColor().equals(currentCard.getColor())
                            || selectedCard.getNumber().equals(currentCard.getNumber())) {
                        validPlay = true;
                        currentCard = selectedCard;
                        System.out.println(currentPlayer.getName() + "は 色：" + currentCard.getColor() + "  数字：" + currentCard.getNumber() + "を出した！");
                        currentPlayer.playCard(selectedCard);
                    } else {
                        System.out.println("選択したカードはプレイできません。別のカードを選択してください。");
                        currentPlayer.drawCard(selectedCard);
                        hand.add(deck.drawCard());
                        System.out.println(currentPlayer.getName() + "はパスした");
                        validPlay = true;
                    }
                }
            }
            
            if (currentPlayer.getHand().isEmpty()) {
                System.out.println(currentPlayer.getName() + "の勝ち！");
                break;
            }
            
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        scanner.close();
    }
}