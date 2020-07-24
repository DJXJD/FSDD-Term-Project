package goFishGame;

/**
 *
 * @author Daniel Crawford
 */
public enum Rank {
    
    ACE(1, "Ace", "A"),
    TWO(2, "Two", "2"),
    THREE(3, "Three", "3"),
    FOUR(4, "Four", "4"),
    FIVE(5, "Five", "5"),
    SIX(6, "Six", "6"),
    SEVEN(7, "Seven", "7"),
    EIGHT(8, "Eight", "8"),
    NINE(9, "Nine", "9"),
    TEN(10, "Ten", "10"),
    JACK(11, "Jack", "J"),
    QUEEN(12, "Queen", "Q"),
    KING(13, "King", "K");
    
    
    private int num;
    private String name;
    private String letter;
    
    private Rank(int num, String name, String letter) {
        this.num = num;
        this.name = name;
        this.letter = letter;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getLetter() {
        return letter;
    }
    
    
}
