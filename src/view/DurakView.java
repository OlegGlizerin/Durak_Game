package view;


import model.board.Board;
import model.card.Card;
import model.player.Player;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import view.components.BoardView;
import view.components.StartMenu;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by HawkEye on 25/02/2017.
 */
public class DurakView extends Observable implements View, Runnable{

    private Display display;
    private Shell shell;
    private BoardView boardView ;
    private StartMenu startMenu;

    private int userCommand;
    private Card playingCard;

    public DurakView() {

    }

    @Override
    public void displayTable(Board board) {
        for(Control control:shell.getChildren()){
            control.dispose();
        }
        displayBackground();
        displayKozir(board);
        displayPlayers(board);
        displayCardsOnTable(board);

    }

    private void displayPlayers(Board board) {
        ArrayList<Player> players = board.getPlayers();
        //draw player bot
        int space = 0;
//        for(int i = 0; i < 10 ; i++) {
//            Card card = new Card(EType.CLUB, ERank.SIX);
//            players.get(0).getHand().add(card);
//        }
        for(final Card card : players.get(0).getHand()) {
            Label label = new Label(shell, SWT.IMAGE_PNG);


            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseDoubleClick(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseDown(MouseEvent mouseEvent) {
                    playingCard = card;
                    userCommand = 10;
                    doUserCommand(userCommand);
                }

                @Override
                public void mouseUp(MouseEvent mouseEvent) {

                }
            });

            Image i =  boardView.getImage(card);
            label.setBackgroundImage(i);

            space += 40;
            label.setLocation(shell.getDisplay().getBounds().width/2 + (15*players.get(0).getHand().size()) - space, shell.getDisplay().getBounds().height/2 + 140);
            label.setSize(100,140);
            label.update();
        }

        space = 0;
        //draw computer
        if(players.size() == 2){
            for(Card card : players.get(1).getHand()) {
                Label label = new Label(shell, SWT.IMAGE_PNG);


                Image i =  boardView.getImage(card);
                label.setBackgroundImage(i);
                space += 40;
                label.setLocation(shell.getDisplay().getBounds().width/2 + (15*players.get(0).getHand().size()) - space, 10);
                label.setSize(100,140);
            }
            return;
        }

        for(int i = 1 ; i < players.size(); i++) {


        }
    }

    private void displayKozir(Board board) {
        Label label = new Label(shell, SWT.IMAGE_PNG);

        Card kozir = board.getKozir();

        System.out.println(kozir.getType() + "kozir" + kozir.getRank());
        Image i =  boardView.getImageRotated(kozir);
        label.setBackgroundImage(i);
        label.setLocation(shell.getDisplay().getBounds().x + 50,shell.getDisplay().getBounds().y + 50);
        label.setSize(140,100);
    }

    private void displayBackground() {
        for(int j = 0; j < 15; j += 2) {
            Label label = new Label(shell, SWT.IMAGE_PNG);
            Image i = boardView.getImageBackground();
            label.setBackgroundImage(i);

            label.setLocation(shell.getDisplay().getBounds().x + 20 -j , shell.getDisplay().getBounds().y + 30 - j);
            label.setSize(100, 140);
        }
    }

    private void displayCardsOnTable(Board board) {
        for(int i = 0; i < board.getCardsOnTable().size(); i++) {
            Label label = new Label(shell, SWT.IMAGE_PNG);
            Image k = boardView.getImage(board.getCardsOnTable().get(i));
            label.setBackgroundImage(k);

            label.setLocation(shell.getDisplay().getBounds().x + 520 -i , shell.getDisplay().getBounds().y + 330 - i);
            label.setSize(100, 140);
        }
    }

    @Override
    public void initTable(int numberOfPlayers) {
        System.out.println("hi");
    }



    @Override
    public void showMenu() {
        display = new Display();
        shell 	= new Shell(display);
        shell.setMaximized(true);
        boardView = new BoardView(shell.getDisplay());
        shell.setText("Durak Game Oleg & Phil");
//        shell.setSize(800 , 550);
//        shell.setLocation(0,0);

        shell.setLayout(new GridLayout(3,true));

        Image i = new Image(shell.getDisplay(), "C:\\Users\\HawkEye\\IdeaProjects\\Durak_Game\\images\\22.jpg");
        Rectangle rect = shell.getClientArea();
        Image newImage = new Image(display, Math.max(1, rect.width), 1);
        GC gc = new GC(i);
        gc.fillGradientRectangle(rect.x, rect.y, rect.width, 1, false);
        gc.dispose();
        shell.setBackgroundImage(i);

        startMenu = new StartMenu(shell,display,this);



        shell.open();
    }




    @Override
    public int getUserCommand() {
        return userCommand;
    }

    @Override
    public void doUserCommand(int command) {

        switch(command) {
            case 2:
                userCommand = command;
                setChanged();
                notifyObservers();
                break;
            case 10:
                setChanged();
                notifyObservers(playingCard);
                break;
        }
    }



    @Override
    public void run() {
        showMenu();

        while(!shell.isDisposed()){
            if(!display.readAndDispatch()){
                display.sleep();
            }
        }
        display.dispose();
    }
}
