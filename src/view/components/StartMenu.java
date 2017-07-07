package view.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import view.DurakView;
import view.components.singlePlayer.SinglePlayerMenu;

/**
 * Created by HawkEye on 08/04/2017.
 */
public class StartMenu {
    private Button singlePlayer;
    private Button multiPlayer;
    private Button exit;


    public StartMenu(Shell shell, Display display, DurakView durakView) {

        GridData layoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 3, 1);
        layoutData.heightHint = SWT.HORIZONTAL;

        singlePlayer = new Button(shell, SWT.CENTER);
        singlePlayer.setLayoutData(layoutData);
        singlePlayer.setText("Single Player Game");

        multiPlayer = new Button(shell, SWT.CENTER);
        multiPlayer.setLayoutData(layoutData);
        multiPlayer.setText("Multiplayer Game");

        exit = new Button(shell, SWT.CENTER);
        exit.setLayoutData(layoutData);
        exit.setText("Exit");


        buttonsListeners(shell,display,durakView);



    }
    public Button getSinglePlayer() {
        return singlePlayer;
    }
    public Button getMultiPlayer() {
        return multiPlayer;
    }
    public Button getExit() {
        return exit;
    }

    public void buttonsListeners(final Shell shell,final Display display,final DurakView durakView) {
        display.asyncExec(new Runnable() {
            @Override
            public void run() {
                getSinglePlayer().addSelectionListener(new SelectionListener() {
                    @Override
                    public void widgetSelected(SelectionEvent playButton) {
                        getSinglePlayer().dispose();
                        getMultiPlayer().dispose();
                        getExit().dispose();
                        SinglePlayerMenu singlePlayerMenu = new SinglePlayerMenu(shell,display);
                        singlePlayerMenu.buttonsListeners(shell,display,durakView);

                        shell.layout();
//                        shell.redraw();
                        shell.update();
                    }

                    @Override
                    public void widgetDefaultSelected(SelectionEvent exitButton) {

                    }
                });

                getMultiPlayer().addSelectionListener(new SelectionListener() {
                    @Override
                    public void widgetSelected(SelectionEvent playButton) {
                        getSinglePlayer().dispose();
                        getMultiPlayer().dispose();
                        getExit().dispose();
                    }

                    @Override
                    public void widgetDefaultSelected(SelectionEvent exitButton) {

                    }
                });

                getExit().addSelectionListener(new SelectionListener() {
                    @Override
                    public void widgetSelected(SelectionEvent selectionEvent) {
                        shell.dispose();
                    }

                    @Override
                    public void widgetDefaultSelected(SelectionEvent selectionEvent) {

                    }
                });
            }
        });


    }
}
