package view.components;


import model.card.Card;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * Created by HawkEye on 13/05/2017.
 */
public class BoardView {
    private Image[][] images = new Image[4][9];
    private Image[][] imagesRotated = new Image[4][9];
    
    private String path = "C:\\Users\\HawkEye\\IdeaProjects\\DurakGame\\images\\cards\\";
    private String pathRotated = "C:\\Users\\HawkEye\\IdeaProjects\\DurakGame\\images\\rotated.cards\\";


    private Image background;
            
    public BoardView(Display display) {
        // spade
        images[0][0] = new Image(display, path + "6_spade.jpg");
        images[0][1] = new Image(display, path + "7_spade.jpg");
        images[0][2] = new Image(display, path + "8_spade.jpg");
        images[0][3] = new Image(display, path + "9_spade.jpg");
        images[0][4] = new Image(display, path + "10_spade.jpg");
        images[0][5] = new Image(display, path + "J_spade.jpg");
        images[0][6] = new Image(display, path + "Q_spade.jpg");
        images[0][7] = new Image(display, path + "k_spade.jpg");
        images[0][8] = new Image(display, path + "A_spade.jpg");
        // heart
        images[1][0] = new Image(display, path + "6_heart.jpg");
        images[1][1] = new Image(display, path + "7_heart.jpg");
        images[1][2] = new Image(display, path + "8_heart.jpg");
        images[1][3] = new Image(display, path + "9_heart.jpg");
        images[1][4] = new Image(display, path + "10_heart.jpg");
        images[1][5] = new Image(display, path + "j_heart.jpg");
        images[1][6] = new Image(display, path + "q_heart.jpg");
        images[1][7] = new Image(display, path + "k_heart.jpg");
        images[1][8] = new Image(display, path + "a_heart.jpg");
        // club
        images[2][0] = new Image(display, path + "6_club.jpg");
        images[2][1] = new Image(display, path + "7_club.jpg");
        images[2][2] = new Image(display, path + "8_club.jpg");
        images[2][3] = new Image(display, path + "9_club.jpg");
        images[2][4] = new Image(display, path + "10_club.jpg");
        images[2][5] = new Image(display, path + "j_club.jpg");
        images[2][6] = new Image(display, path + "q_club.jpg");
        images[2][7] = new Image(display, path + "k_club.jpg");
        images[2][8] = new Image(display, path + "a_club.jpg");
        // diamond
        images[3][0] = new Image(display, path + "6_diamond.jpg");
        images[3][1] = new Image(display, path + "7_diamond.jpg");
        images[3][2] = new Image(display, path + "8_diamond.jpg ");
        images[3][3] = new Image(display, path + "9_diamond.jpg");
        images[3][4] = new Image(display, path + "10_diamond.jpg");
        images[3][5] = new Image(display, path + "j_diamond.jpg");
        images[3][6] = new Image(display, path + "q_diamond.jpg");
        images[3][7] = new Image(display, path + "k_diamond.jpg");
        images[3][8] = new Image(display, path + "a_diamond.jpg");


        imagesRotated[0][0] = new Image(display, pathRotated + "6_spade.jpg");
        imagesRotated[0][1] = new Image(display, pathRotated + "7_spade.jpg");
        imagesRotated[0][2] = new Image(display, pathRotated + "8_spade.jpg");
        imagesRotated[0][3] = new Image(display, pathRotated + "9_spade.jpg");
        imagesRotated[0][4] = new Image(display, pathRotated + "10_spade.jpg");
        imagesRotated[0][5] = new Image(display, pathRotated + "J_spade.jpg");
        imagesRotated[0][6] = new Image(display, pathRotated + "Q_spade.jpg");
        imagesRotated[0][7] = new Image(display, pathRotated + "k_spade.jpg");
        imagesRotated[0][8] = new Image(display, pathRotated + "A_spade.jpg");
        // heart
        imagesRotated[1][0] = new Image(display, pathRotated + "6_heart.jpg");
        imagesRotated[1][1] = new Image(display, pathRotated + "7_heart.jpg");
        imagesRotated[1][2] = new Image(display, pathRotated + "8_heart.jpg");
        imagesRotated[1][3] = new Image(display, pathRotated + "9_heart.jpg");
        imagesRotated[1][4] = new Image(display, pathRotated + "10_heart.jpg");
        imagesRotated[1][5] = new Image(display, pathRotated + "j_heart.jpg");
        imagesRotated[1][6] = new Image(display, pathRotated + "q_heart.jpg");
        imagesRotated[1][7] = new Image(display, pathRotated + "k_heart.jpg");
        imagesRotated[1][8] = new Image(display, pathRotated + "a_heart.jpg");
        // club
        imagesRotated[2][0] = new Image(display, pathRotated + "6_club.jpg");
        imagesRotated[2][1] = new Image(display, pathRotated + "7_club.jpg");
        imagesRotated[2][2] = new Image(display, pathRotated + "8_club.jpg");
        imagesRotated[2][3] = new Image(display, pathRotated + "9_club.jpg");
        imagesRotated[2][4] = new Image(display, pathRotated + "10_club.jpg");
        imagesRotated[2][5] = new Image(display, pathRotated + "j_club.jpg");
        imagesRotated[2][6] = new Image(display, pathRotated + "q_club.jpg");
        imagesRotated[2][7] = new Image(display, pathRotated + "k_club.jpg");
        imagesRotated[2][8] = new Image(display, pathRotated + "a_club.jpg");
        // diamond
        imagesRotated[3][0] = new Image(display, pathRotated + "6_diamond.jpg");
        imagesRotated[3][1] = new Image(display, pathRotated + "7_diamond.jpg");
        imagesRotated[3][2] = new Image(display, pathRotated + "8_diamond.jpg ");
        imagesRotated[3][3] = new Image(display, pathRotated + "9_diamond.jpg");
        imagesRotated[3][4] = new Image(display, pathRotated + "10_diamond.jpg");
        imagesRotated[3][5] = new Image(display, pathRotated + "j_diamond.jpg");
        imagesRotated[3][6] = new Image(display, pathRotated + "q_diamond.jpg");
        imagesRotated[3][7] = new Image(display, pathRotated + "k_diamond.jpg");
        imagesRotated[3][8] = new Image(display, pathRotated + "a_diamond.jpg");

        background = new Image(display, "C:\\Users\\HawkEye\\IdeaProjects\\DurakGame\\images\\cardBackground.jpg");
    }
    
    public Image getImage(Card card) {
        return images[card.getType().ordinal()][card.getRank().ordinal()];
    }
    public Image getImageRotated(Card card) {
        return imagesRotated[card.getType().ordinal()][card.getRank().ordinal()];
    }

    public Image getImageBackground() {
        return background;
    }
}
