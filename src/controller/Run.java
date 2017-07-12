package controller;

import model.DurakModel;
import model.Model;
import view.DurakView;
import view.View;

import java.util.Observable;


/**
 * Created by HawkEye on 25/02/2017.
 */
public class Run {
    public static void main(String[] args) {
        Model modelDurak = new DurakModel();
        View viewDurak = new DurakView();

        Thread viewThread = new Thread((DurakView) viewDurak);
        System.out.println("durak model&view initialized!");
        Presenter presenter = new Presenter(viewDurak, modelDurak);
        ((Observable) viewDurak).addObserver(presenter);
        ((Observable) modelDurak).addObserver(presenter);
        System.out.println("observers initialized");
        viewThread.start();
        System.out.println("dfsg");//




    }
}
