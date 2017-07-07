package model.player;


import model.card.Card;

import java.util.ArrayList;


/**
 * Created by HawkEye on 25/02/2017.
 */
public class DurakPlayer implements Player {
    private ArrayList<Card> hand;


    public DurakPlayer() {
        hand = new ArrayList<Card>();
    }

    @Override
    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public ArrayList<Card> getHand() {
         return hand;
    }

    @Override
    public void removeCard(Card card) {
        hand.remove(card);
    }


}

