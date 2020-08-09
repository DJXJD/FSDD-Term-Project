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
    private String name;
    private char symbol;

    private Suit(int num, String name, char symbol) {
        this.num = num;
        this.name = name;
        this.symbol = symbol;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
    
}
