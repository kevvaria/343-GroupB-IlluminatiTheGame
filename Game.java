package game;

import cardsSrc.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {
    ArrayList<IlluminatiCard> illuminatiCards;
    ArrayList<Person> playerList = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> discardPile = new ArrayList<>();
    ArrayList<GroupCard> uncontrolledGroupsPile = new ArrayList<>();
    Person currentPlayer;
    int playerCount = 0;

    public Game(){
        illuminatiCards = new ArrayList<IlluminatiCard>();
        playerList = new ArrayList<Person>();
        deck = new ArrayList<>();
        discardPile = new ArrayList<>();
        uncontrolledGroupsPile = new ArrayList<>();
        //currentPlayer = new Person(get);
        int playerCount = 0;
        currentPlayer = playerList.get(playerCount);
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

    public Person getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Person currentPlayer) {
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

        //deck.add(new Yuppies());
        Person littleMan = new Person("Beginner");



        //shuffle deck
        //add players to the gameboard
        //give each player an illuminati card
        //give each player an initial balance based on their illuminati card
        //grab 4 groupcards and place them on the board. All specialcards are left in the original deck.
    }

    public void addAPlayer(Person playerToAdd){
        playerList.add(playerToAdd);
    }
    public void collectIncome(Person currentPlayer)
    {
        currentPlayer.getIlluminatiCard().addIncome();
        //add group cards to the list and check in list for income
    }

    public void shuffleDeck(){
        //deck.shuffle();
        Collections.shuffle(deck);

    }
    public void initialUncontrolled()
    {
        Card drawnCard = deck.remove(0);
        while (uncontrolledGroupsPile.size()<4)
        {
            if (drawnCard instanceof SpecialCard)
            {
                deck.add(drawnCard);
                shuffleDeck();
            }
            else
            {
                GroupCard gC = (GroupCard) drawnCard;
                uncontrolledGroupsPile.add(gC);
            }

        }
    }

    public void drawCard(){
        //pop from deck
        //if card is specialCard, add to their inventory.
        //else push to uncontrolled deck
        //Card drawnCard = deck.get(0);
         Card drawnCard = deck.remove(0);
        if (drawnCard instanceof SpecialCard)
        {
            currentPlayer.setCardPlayerHand(drawnCard);
            System.out.println(currentPlayer.getPlayerHand());

        }
        else
        {
            GroupCard group = (GroupCard) drawnCard;
            uncontrolledGroupsPile.add(group);
            System.out.println(uncontrolledGroupsPile);

        }



    }
    public void drawUncontrolled()
    {
        Card drawnCard = deck.remove(0);
        while (uncontrolledGroupsPile.size()<2)
        {
            if (drawnCard instanceof SpecialCard)
            {
                //add to player hand
                //SpecialCard special = (SpecialCard) drawnCard;
                deck.add(drawnCard);
                //add shuffle deck
            }
            else
            {
                GroupCard gC = (GroupCard) drawnCard;
                uncontrolledGroupsPile.add(gC);
            }

        }
    }

    public void shufflePlayOfOrder(){
        //use collections to randomize the playerList
        Collections.shuffle(playerList);
    }

    public void assignIlluminatiCards(){
        //for each player in the playerList, assign an Illuminati Card using the Person.setter()
        int i = 0;
        //Person p = new Person("");
        for(Person p:playerList)
        {
            p.setIlluminatiCard(illuminatiCards.get(i));
        }
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

    public void passTurn(){
        //currentPlayer updates to the next player in playerList
        int actionCheck = currentPlayer.getNumOfRegActionsLeft();
        if (actionCheck == 2) {
            currentPlayer.getIlluminatiCard().addBalance(5);
            currentPlayer.setNumOfRegActionsLeft(0);
        }
        System.out.println(currentPlayer.getUsername() + " has collected 5 MB");
        endTurn();
    }

    public void startNextTurn(){
        //currentPlayer picks up income
        //currentPlayer places a valid groupCard. Call drawCard() method.
        collectIncome(currentPlayer);
        drawCard();

    }

    public void endTurn(){
        //currentPlayer updates to the next player in the playerList
        //call on next player to start their turn by: startNextTurn()
        int actions = currentPlayer.getNumOfRegActionsLeft();
        if(actions != 0)
            //prompt message asking player to continue
        System.out.println(currentPlayer.getUsername() + "'s turn has ended");
        playerCount = playerCount + 1;
        if(playerCount == playerList.size())
            playerCount = 0;
        currentPlayer = playerList.get(playerCount);
        System.out.println(currentPlayer.getUsername() + "'s turn");
    }

    public void forfeit(){
        //take all of currentPlayer.getPlayerHand and put it into discardPile. Then
        //if playerList.size() == 2, remove currentPlayer and the last man standing is the winner
        //else, remove current player from playerList and ensure the next players turn begins.
        for(Card c : currentPlayer.getSpecialCards())
        {
            discardPile.add(c);

        }
        for(Card c : currentPlayer.getPlayerHand())
        {
            discardPile.add(c);
        }
        discardPile.add(currentPlayer.getIlluminatiCard());
        currentPlayer.setIlluminatiCard(null);
        ArrayList emptyList = currentPlayer.getSpecialCards();
        emptyList.clear();
        currentPlayer.setSpecialCards(emptyList);
        currentPlayer.setPlayerHand(emptyList);
        currentPlayer.setNumOfRegActionsLeft(0);
        playerList.remove(currentPlayer);
        if(playerList.size()==1) {
            currentPlayer = playerList.get(0);
            System.out.println(currentPlayer.getUsername() + " has won!");
        }
        else
            endTurn();
    }



    public void test() {
        System.out.println("Testing");
//        illuminatiCards.add(new TheUFOs());
//        System.out.println("UFO: " + illuminatiCards.get(0).toString());
        drawCard();

    }
}
