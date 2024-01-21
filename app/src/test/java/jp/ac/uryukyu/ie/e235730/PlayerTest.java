package jp.ac.uryukyu.ie.e235730;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testDrawCard() {
        Card card1 = new Card("Red", "5");
        Card card2 = new Card("Blue", "9");
        Card card3 = new Card("Green", "2");

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);

        Player player = new Player("Player1", hand);

        assertEquals(2, player.getNumCardsInHand());
        
        player.drawCard(card3);
        
        assertEquals(3, player.getNumCardsInHand());
        assertEquals(hand.get(2), card3);
    }
}