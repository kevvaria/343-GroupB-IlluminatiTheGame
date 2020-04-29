package game;

import cardsSrc.*;

import java.util.ArrayList;

public class Game {
    ArrayList<IlluminatiCard> illuminatiCards;
    ArrayList<Person> playerList = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> discardPile = new ArrayList<>();
    ArrayList<GroupCard> uncontrolledGroupsPile = new ArrayList<>();
    String currentPlayer;

    public Game(){
        illuminatiCards = new ArrayList<IlluminatiCard>();
        playerList = new ArrayList<>();
        deck = new ArrayList<>();
        discardPile = new ArrayList<>();
        uncontrolledGroupsPile = new ArrayList<>();
        currentPlayer = "";
    }

    public ArrayList<IlluminatiCard> getIlluminatiCards() {
        return illuminatiCards;
    }

    public void setIlluminatiCards(ArrayList<IlluminatiCard> illuminatiCards) {
        this.illuminatiCards = illuminatiCards;
    }

    public ArrayList<Person> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Person> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(ArrayList<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public ArrayList<GroupCard> getUncontrolledGroupsPile() {
        return uncontrolledGroupsPile;
    }

    public void setUncontrolledGroupsPile(ArrayList<GroupCard> uncontrolledGroupsPile) {
        this.uncontrolledGroupsPile = uncontrolledGroupsPile;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void initGame(){
        illuminatiCards.add(new TheUFOs());
        illuminatiCards.add(new TheBavarianIlluminati());
        illuminatiCards.add(new TheBermudaTriangle());
        illuminatiCards.add(new TheDiscordianSociety());
        illuminatiCards.add(new TheGnomesOfZurich());
        illuminatiCards.add(new TheNetwork());
        illuminatiCards.add(new TheServantsOfCthulhu());
        illuminatiCards.add(new TheSocietyOfAssassins());
        //add each card to the deck
//        deck.add()


        //shuffle deck
        //add players to the gameboard
        //give each player an illuminati card
        //give each player an initial balance based on their illuminati card
        //grab 4 groupcards and place them on the board. All specialcards are left in the original deck.
    }

    public void addAPlayer(Person playerToAdd){
        playerList.add(playerToAdd);
    }

    public void shuffleDeck(){
        //deck.shuffle();
    }

    public void drawCardToUncontrolled(){
        //pop from deck
        //if card is specialCard, add to their inventory.
        //else push to uncontrolled deck
    }

    public void shufflePlayOfOrder(){
        //use collections to randomize the playerList
    }

    public void assignIlluminatiCards(){
        //for each player in the playerList, assign an Illuminati Card using the Person.setter()
    }

    public void attack(String attackType, String attackingGroup, String targetGroup){
        if(attackType.equalsIgnoreCase("control")){

        }
        else if(attackType.equalsIgnoreCase("neutralize")){

        }
        else{

        }
    }

    public void groupAction(String actionType, String cardToGive, String targetPlayer, String targetGroup){
        //if actionType.equalsLowercase("give) and targetGroup.hasOutwardArrow()
        // - place cardToGive under targetGroups control.
        //else, targetPlayer = self
        // - place cardToGive under targetGroups control.
    }

    public void specialCardAction(String attackType, String targetPlayer, String targetGroup){
        //use or give special card

    }

    public void giveMoney(IlluminatiCard fromCard, IlluminatiCard toCard, int amount){
        //subtract amount from fromCard.balance
        //add amount to toCard.balance
    }

    public void trade(GroupCard fromCard, Person targetPlayer, GroupCard toCard){
        //initialize trade between currentPlayer.getPlayerHand().selectedGroupCard
        // with targetPlayer.getPlayerHand().selectedGroupCard
    }

    public void passMyTurn(){
        //currentPlayer updates to the next player in playerList
    }

    public void startNextTurn(){
        //currentPlayer picks up income
        //currentPlayer places a valid groupCard. Call drawCardToUncontrolled() method.
    }

    public void endTurn(){
        //currentPlayer updates to the next player in the playerList
        //call on next player to start their turn by: startNextTurn()
    }

    public void forfeit(){
        //take all of currentPlayer.getPlayerHand and put it into discardPile. Then
        //if playerList.size() == 2, remove currentPlayer and the last man standing is the winner
        //else, remove current player from playerList and ensure the next players turn begins.
    }


//
//    public void test() {
//        System.out.println("Testing");
//        illuminatiCards.add(new TheUFOs());
//        System.out.println("UFO: " + illuminatiCards.get(0).toString());
//    }
}
