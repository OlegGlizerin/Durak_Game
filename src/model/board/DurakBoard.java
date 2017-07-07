package model.board;

import model.card.Card;
import model.card.ERank;
import model.card.EType;
import model.player.CompDurakPlayer;
import model.player.DurakPlayer;
import model.player.Player;
import properties.Globals;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HawkEye on 25/02/2017.
 */
public class DurakBoard implements Board {
    private ArrayList<Player> players;
    private ArrayList<Card> pack;
    private Card kozir;
    private int playingPlayerIndex;
    private Card smallestKozir = null;
    private ArrayList<Card> cardsOnTable = null;

    public DurakBoard() {
        pack = new ArrayList<Card>();
        players = new ArrayList<Player>();
        cardsOnTable = new ArrayList<Card>();
    }

    @Override
    public int getPlayingPlayerIndex() {
        return playingPlayerIndex;
    }

    //create 36 cards and put in pack
    public void initPack() {
        for(EType eType : EType.values()) {
            for(ERank eRank : ERank.values()) {
                Card newCard = new Card(eType,eRank);
                pack.add(newCard);
            }
        }
        shufflePack();
//        for(Card card : pack)  {
//            System.out.println(card.getRank()  + "," + card.getType());
//        }
    }

    public void chooseKozir() {
        kozir = pack.remove(0);
    }

    @Override
    public void initPlayers(int numOfPlayers) {
        for(int i = 0; i < numOfPlayers; i++) {
            Player player;
            if(i == 0) {
                player = new DurakPlayer();
            }
            else {
                player = new CompDurakPlayer();
            }
            for(int j = 0; j < 6; j++) {
                player.addCard(pack.remove(0));
            }
            players.add(player);
        }
        calcStartingPlayerIndex();
    }

    //shuffle the pack
    public void shufflePack() {
        Random random = new Random();
        for(int i = 0; i < Globals.NUM_OF_CARDS; i++) {
            int index1 = random.nextInt(Globals.NUM_OF_CARDS - 1);
            int index2 = random.nextInt(Globals.NUM_OF_CARDS - 1);
//            System.out.println(index1 + "..." + index2);
            Card first = pack.get(index1);
            Card second = pack.get(index2);
            pack.set(index1, second);
            pack.set(index2, first);
        }
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public Card getKozir() {
        return kozir;
    }

    @Override
    public void putCardOnTable(Card card){
        cardsOnTable.add(card);
    }

    @Override
    public ArrayList<Card> getCardsOnTable(){
        return this.cardsOnTable;
    }

    @Override
    public void clearTable() {

    }

    @Override
    public void removePlayingPlayerCard(Card card) {
        players.get(playingPlayerIndex).removeCard(card);
    }

    @Override
    public void setPlayingPlayerIndex(int index) {
        playingPlayerIndex = index;
    }

    private void calcStartingPlayerIndex() {
        for (int i = 0; i < players.size(); i++) {
            for(Card playerCard : players.get(i).getHand()){
                if(playerCard.getType().equals(kozir.getType())) {
                    if(smallestKozir == null) {
                        smallestKozir = playerCard;
                        playingPlayerIndex = i;
                    }
                    else if(smallestKozir.getRank().ordinal() > playerCard.getRank().ordinal()) {
                        smallestKozir = playerCard;
                        playingPlayerIndex = i;
                    }
                }
            }
        }
        if(smallestKozir == null) {
            playingPlayerIndex = new Random().nextInt(players.size());
        }
    }

}
