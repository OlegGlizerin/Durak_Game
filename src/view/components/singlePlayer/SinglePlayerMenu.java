package view.components.singlePlayer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import view.DurakView;

/**
 * Created by HawkEye on 21/04/2017.
 */
public class SinglePlayerMenu{
    private Label howManyPlayers;
    private Button oneComputer;
    private Button twoComputer;




    public SinglePlayerMenu(Shell shell, Display display) {

        GridData layoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 3, 1);
        layoutData.heightHint = SWT.HORIZONTAL;

        howManyPlayers = new Label(shell,SWT.CENTER);
        howManyPlayers.setLayoutData(layoutData);
        howManyPlayers.setText("How many computer oponents?");
        howManyPlayers.setBackground(new Color(display, 200,0,0));


        oneComputer = new Button(shell, SWT.CENTER);
        oneComputer.setLayoutData(layoutData);
        oneComputer.setText("1 computer oponent");


        twoComputer = new Button(shell, SWT.CENTER);
        twoComputer.setLayoutData(layoutData);
        twoComputer.setText("2 computer oponent");

//        shell.setSize(800,551);


    }

    public void buttonsListeners(final Shell shell,final Display display,final DurakView durakView) {
        display.asyncExec(new Runnable() {
            @Override
            public void run() {
                oneComputer.addSelectionListener(new SelectionListener() {
                    @Override
                    public void widgetSelected(SelectionEvent selectionEvent) {
                        howManyPlayers.dispose();
                        oneComputer.dispose();
                        twoComputer.dispose();

                        Image i = new Image(shell.getDisplay(), "C:\\Users\\HawkEye\\IdeaProjects\\Durak_Game\\images\\33.jpg");
                        Rectangle rect = shell.getClientArea();
                        Image newImage = new Image(display, Math.max(1, rect.width), 1);
                        GC gc = new GC(i);
                        gc.fillGradientRectangle(rect.x, rect.y, rect.width, 1, false);
                        gc.dispose();
                        shell.setBackgroundImage(i);

                        System.out.println("bla");
                        durakView.doUserCommand(2);


                    }

                    @Override
                    public void widgetDefaultSelected(SelectionEvent selectionEvent) {

                    }
                });
            }
        });
    }


}

