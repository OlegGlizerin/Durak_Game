package view;

import model.board.Board;

/**
 * Created by HawkEye on 25/02/2017.
 */
public interface View {
    void displayTable(Board board);
    void initTable(int numberOfPlayers);
    void showMenu();
    int getUserCommand();
    void doUserCommand(int command);
}
