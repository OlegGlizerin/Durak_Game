package model.board;

import model.card.Card;
import model.player.Player;

import java.util.ArrayList;

/**
 * Created by HawkEye on 25/02/2017.
 */
public interface Board {
    void initPack();
    void chooseKozir();
    void initPlayers(int numOfPlayers);
    void shufflePack();
    ArrayList<Player> getPlayers();
    Card getKozir();
    int getPlayingPlayerIndex();
    void putCardOnTable(Card card);
    ArrayList<Card> getCardsOnTable();
    void clearTable();
    void removePlayingPlayerCard(Card card);
    void setPlayingPlayerIndex(int index);
}
