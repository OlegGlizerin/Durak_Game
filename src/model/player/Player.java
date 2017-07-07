package model.player;

import model.card.Card;

import java.util.ArrayList;

/**
 * Created by HawkEye on 25/02/2017.
 */
public interface Player {



    void addCard(Card card);
    ArrayList<Card> getHand();
    void removeCard(Card card);




}
