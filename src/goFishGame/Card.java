package goFishGame;

public class Card {

    private Rank rank;
    private Suit suit;
    
    public Card(Rank value, Suit suit) {
        this.rank = value;
        this.suit = suit;
    }
    
    public int getRankNum() {
        return rank.getNum();
    }
    
    public String getRankName() {
        return rank.getName();
    }
    
    public String getRankShortName() {
        return rank.getShortName();
    }

    public int getSuitNum() {
        return suit.getNum();
    }
    
    public String getSuitName() {
        return suit.getName();
    }
    
    public char getSuitSymbol() {
        return suit.getSymbol();
    }

    @Override
    public String toString() {
        
        return String.format(""
		+ "%5s of %-8s [%s]",
		getRankName(),
		getSuitName(),
		getSuitSymbol());
    }

}