package model.card;

/**
 * Created by HawkEye on 25/02/2017.
 */
public class Card {
    private EType type;
    private ERank rank;

    public Card(EType type, ERank rank) {
        this.type = type;
        this.rank = rank;
    }

    //type
    public EType getType(){
        return type;
    }
    public void setType(EType type) {
        this.type = type;
    }
    //rank
    public ERank getRank(){
        return rank;
    }

    public void setRank(ERank rank){
        this.rank = rank;
    }
}
