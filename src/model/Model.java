package model;

/**
 * Created by HawkEye on 25/02/2017.
 */
public interface Model {

    void doUserCommand(int command);
    void initGame(int numOfPlayers);
    int getUserCommand();
    void setObject(Object e);
}
