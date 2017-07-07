package model;

import model.board.Board;
import model.board.DurakBoard;
import model.card.Card;

import java.util.Observable;

/**
 * Created by HawkEye on 25/02/2017.
 */
public class DurakModel extends Observable implements Model {

    private Board board;
    private Object e;
    private int userCommand;
    private int turn;

    public DurakModel() {
        board = new DurakBoard();
    }


    @Override
    public void doUserCommand(int command) {
        switch(command) {
            case 2:
                initGame(2);
                userCommand = 12;
                setChanged();
                notifyObservers(board);
                break;
            case 10:
                atackCard((Card)e);
                setChanged();
                notifyObservers(board);
                break;
        }
    }



    @Override
    public void initGame(int numOfPlayers) {
        board.initPack();
        board.shufflePack();
        board.chooseKozir();
        board.initPlayers(numOfPlayers);
    }

    @Override
    public int getUserCommand() {
        return userCommand;
    }

    @Override
    public void setObject(Object e) {
        this.e = e;
    }

    private void atackCard(Card e) {
        board.putCardOnTable(e);
        board.removePlayingPlayerCard(e);
        board.setPlayingPlayerIndex(board.getPlayingPlayerIndex() + 1);
    }


}
