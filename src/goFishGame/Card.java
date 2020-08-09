package goFishGame;

public class Card {

    private Rank rank;
    private Suit suit;
    /**
     * 
     * @param value
     * @param suit 
     */
    public Card(Rank value, Suit suit) {
        this.rank = value;
        this.suit = suit;
    }
    /**
     * 
     * @return 
     */
    public int getRankNum() {
        return rank.getNum();
    }
    /**
     * 
     * @return 
     */
    public String getRankName() {
        return rank.getName();
    }
    /**
     * 
     * @return 
     */
    public String getRankShortName() {
        return rank.getShortName();
    }
    /**
     * 
     * @return 
     */
    public int getSuitNum() {
        return suit.getNum();
    }
    /**
     * 
     * @return 
     */
    public String getSuitName() {
        return suit.getName();
    }
    /**
     * 
     * @return 
     */
    public char getSuitSymbol() {
        return suit.getSymbol();
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        
        return String.format(""
		+ "%-5s of %-8s [%s]",
		getRankName(),
		getSuitName(),
		getSuitSymbol());
    }

}
