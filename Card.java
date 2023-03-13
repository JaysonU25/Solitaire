package Solitaire;

import java.io.File;

public class Card {
    private Kind kind;
    private Suit suit;
    private File pic;
    private boolean faceUp;

    public Card(){
        shuffle();
        pic = new File(String.format("%s_%s.txt", getKind(), getSuit()));
        faceUp = false;
    }

    public Card(Kind kind1, Suit suit1){
        kind = kind1;
        suit = suit1;
        pic = new File(String.format("%s_%s.txt", kind1, suit1));
        faceUp = false;
    }

    public Card(double x, int y){
        shuffle(x,y);
        pic = new File(String.format("%s_%s.txt", getKind(), getSuit()));
        faceUp = false;
    }

    public Kind getKind() {
        return kind;
    }
    public Suit getSuit(){
        return suit;
    }
    public File getPic(){
        return pic;
    }
    public boolean isFaceUp() {
        return faceUp;
    }


    public void setPic(File pic1){
        pic = pic1;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public void shuffle(){
        double kindChance = (Math.random() * 13) + 0;
        int suitChance = (int)(Math.random() * 4);

        if(kindChance <= 1){
            kind = Kind.ACE;
        } else if(kindChance <= 2){
            kind = Kind.TWO;
        } else if(kindChance <= 3){
            kind = Kind.THREE;
        } else if(kindChance <= 4){
            kind = Kind.FOUR;
        } else if(kindChance <= 5){
            kind = Kind.FIVE;
        } else if(kindChance <= 6){
            kind = Kind.SIX;
        } else if(kindChance <= 7){
            kind = Kind.SEVEN;
        } else if(kindChance <= 8){
            kind = Kind.EIGHT;
        } else if(kindChance <= 9){
            kind = Kind.NINE;
        } else if(kindChance <= 10){
            kind = Kind.TEN;
        } else if(kindChance <= 11){
            kind = Kind.JACK;
        } else if(kindChance <= 12){
            kind = Kind.QUEEN;
        } else {
            kind = Kind.KING;
        }

        if (suitChance == 1){
            suit = Suit.SPADE;
        } else if (suitChance == 2){
            suit = Suit.CLUB;
        } else if(suitChance == 3){
            suit = Suit.HEART;
        } else {
            suit = Suit.DIAMOND;
        }
    }

    public void shuffle(double kindChance1, int suitChance1){
        double kindChance = kindChance1;
        int suitChance = suitChance1;

        if(kindChance <= 0){
            kind = Kind.ACE;
        } else if(kindChance <= 1){
            kind = Kind.TWO;
        } else if(kindChance <= 2){
            kind = Kind.THREE;
        } else if(kindChance <= 3){
            kind = Kind.FOUR;
        } else if(kindChance <= 4){
            kind = Kind.FIVE;
        } else if(kindChance <= 5){
            kind = Kind.SIX;
        } else if(kindChance <= 6){
            kind = Kind.SEVEN;
        } else if(kindChance <= 7){
            kind = Kind.EIGHT;
        } else if(kindChance <= 8){
            kind = Kind.NINE;
        } else if(kindChance <= 9){
            kind = Kind.TEN;
        } else if(kindChance <= 10){
            kind = Kind.JACK;
        } else if(kindChance <= 11){
            kind = Kind.QUEEN;
        } else {
            kind = Kind.KING;
        }

        if (suitChance == 1){
            suit = Suit.SPADE;
        } else if (suitChance == 2){
            suit = Suit.CLUB;
        } else if(suitChance == 3){
            suit = Suit.HEART;
        } else {
            suit = Suit.DIAMOND;
        }
    }

    public boolean equals(Card card1){
        if(this.kind == card1.getKind() && this.suit == card1.getSuit()){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return String.format("This is a %s of %s.", this.kind, this.suit);
    }
}
