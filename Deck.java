package Solitaire;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private int size;
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck(){
        size = 52;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                Card addCard = new Card(j, i);
                cards.add(addCard);
            }
        }


    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size1){
        size = size1;
    }

    public ArrayList getCards(){
        return cards;
    }

    public void setCards(ArrayList<Card> cards1){
        cards = cards1;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
