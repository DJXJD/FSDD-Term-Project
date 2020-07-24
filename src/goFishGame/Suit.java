package goFishGame;

/**
 *
 * @author Daniel Crawford
 */
public enum Suit {
    
    CLUBS(1, "Clubs", '\u2663'),
    DIAMONDS(2, "Diamonds", '\u2666'),
    HEARTS(3, "Hearts", '\u2665'),
    SPADES(4, "Spades", '\u2660');
    
    private int num;
    private String face;
    private char symbol;

    private Suit(int num, String face, char symbol) {
        this.num = num;
        this.face = face;
        this.symbol = symbol;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return face;
    }

    public char getSymbol() {
        return symbol;
    }
    
}
