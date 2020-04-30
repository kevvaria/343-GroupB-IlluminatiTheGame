package game;

import cardsSrc.Card;
import cardsSrc.IlluminatiCard;
import cardsSrc.SpecialCard;

import java.util.ArrayList;

public class Person {

    private String username;
    private IlluminatiCard illuminatiCard;
    private ArrayList<Card> playerHand;
    private ArrayList<SpecialCard> specialCards;
    private int numOfRegActionsLeft;

    Person(String username){
        this.username = username;
        numOfRegActionsLeft = 2;
        playerHand = new ArrayList<>();
        specialCards = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public IlluminatiCard getIlluminatiCard() {
        return illuminatiCard;
    }

    public void setIlluminatiCard(IlluminatiCard illuminatiCard) {
        this.illuminatiCard = illuminatiCard;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }
    public void setCardPlayerHand(Card cardPlayerHand)
    {
        playerHand.add(cardPlayerHand);
    }

    public ArrayList<SpecialCard> getSpecialCards() {
        return specialCards;
    }

    public void setSpecialCards(ArrayList<SpecialCard> specialCards) {
        this.specialCards = specialCards;
    }

    public int getNumOfRegActionsLeft() {
        return numOfRegActionsLeft;
    }

    public void setNumOfRegActionsLeft(int numOfRegActionsLeft) {
        this.numOfRegActionsLeft = numOfRegActionsLeft;
    }

    public int rollDice(){
        //generate random number between 1 and 12. NO 0's
        //return it
        return 0;
    }

}
