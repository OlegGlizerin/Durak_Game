package controller;

import model.Model;
import model.board.Board;
import model.board.DurakBoard;
import view.View;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by HawkEye on 25/02/2017.
 */
public class Presenter implements Observer {
    private Model model;
    private View view;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void update(Observable o, Object e) {
        if (o == view){
            model.setObject(e);
            model.doUserCommand(view.getUserCommand());
        }
        else if(o == model) {
            if(e.getClass().equals(DurakBoard.class)) {
                view.displayTable((Board)e);
            }

        }
    }
}
