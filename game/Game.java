package game;

import cardsSrc.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {
    ArrayList<IlluminatiCard> illuminatiCards;
    ArrayList<Person> playerList;
    ArrayList<Card> deck;
    ArrayList<Card> discardPile;
    ArrayList<GroupCard> uncontrolledGroupsPile;
    Person currentPlayer;
    int playerCount = 0;
    PowerStructure powerStructure;

    public Game(){
        illuminatiCards = new ArrayList<IlluminatiCard>();
        playerList = new ArrayList<Person>();
        deck = new ArrayList<>();
        discardPile = new ArrayList<>();
        uncontrolledGroupsPile = new ArrayList<>();
        //currentPlayer = new Person(get);
        int playerCount = 0;

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


        resetGameData();

    }

    public boolean addAPlayer(Person playerToAdd){
        boolean playerAdded = true;
        for (Person target:playerList) {
            if(target.getUsername().equalsIgnoreCase(playerToAdd.getUsername())){
                playerAdded = false;
                break;
            }
        }
        if(playerAdded){
            playerList.add(playerToAdd);
        }
        return playerAdded;
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
    public void shufflePlayOfOrder(){

        Collections.shuffle(playerList);
        // Display order of players
        System.out.println("Turn order determined:");
        for(int i = 0; i < playerList.size(); i++) {
            System.out.println((i + 1) + ". " + playerList.get(i));
        }

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


    public void assignIlluminatiCards(){
        //for each player in the playerList, assign an Illuminati Card using the Person.setter()
        int i = 0;
        //Person p = new Person("");
        for(Person p:playerList)
        {
            p.setIlluminatiCard(illuminatiCards.get(i));
            p.pStructure = new PowerStructure(p.getIlluminatiCard(),4);
            i++;
        }
    }


    public void attack(String attackType, String attacking, String target, String opName){
        Person opponent = stringToPerson(opName); // change the opponent from string to person
        GroupCard attackingGroup = stringToGroupCard(attacking,getCurrentPlayer());
        GroupCard targetGroup;

        if(opName.equalsIgnoreCase("Uncontrolled") ) {
            targetGroup = stringToGroupCard(target,uncontrolledGroupsPile);
        }else {
            targetGroup = stringToGroupCard(target, opponent);
        }

        if(attackType.equalsIgnoreCase("control")){
            int maxControlTotal = attackingGroup.getPower() - targetGroup.getResistance();
            int numberRolled = (int) (Math.random() * (12-0+1)+1);
            if(numberRolled <= maxControlTotal && numberRolled <11)
                if(uncontrolledGroupsPile.contains(targetGroup))
                    currentPlayer.pStructure.findPowerStructure(currentPlayer.pStructure, attackingGroup, targetGroup, 0); //add
                else
                {
                    for(int k = 0; k < playerList.size(); k++)
                    {
                        Person p = playerList.get(k);
                        PowerStructure newPlans =p.pStructure.returnPowerStructure(p.pStructure,targetGroup,0);
                        for(PowerStructure power : newPlans.getChildren())
                        {
                            GroupCard c = (GroupCard) power.LABEL;
                            uncontrolledGroupsPile.add(c);
                        }

                        p.pStructure.removePowerStructure(p.pStructure,targetGroup,0);
                    }
                }



        }
        else if(attackType.equalsIgnoreCase("neutralize")){
            int maxNeutralizeTotal = (attackingGroup.getPower() + 6) - targetGroup.getResistance();
            int numberRolled = (int) (Math.random() * (12-0+1)+1);
            if(numberRolled <= maxNeutralizeTotal && numberRolled <11)
            {
                uncontrolledGroupsPile.add(targetGroup);

            }

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
    void loadCards(){
        // Illuminati Cards
        illuminatiCards.add(new TheDiscordianSociety());
        illuminatiCards.add(new TheNetwork());
        illuminatiCards.add(new TheSocietyOfAssassins());
        illuminatiCards.add(new TheUFOs());
        illuminatiCards.add(new TheServantsOfCthulhu());
        illuminatiCards.add(new TheGnomesOfZurich());
        illuminatiCards.add(new TheBavarianIlluminati());
        illuminatiCards.add(new TheBermudaTriangle());
        Collections.shuffle(illuminatiCards);

        // Group Cards
        deck.add(new AmericanAutoduelAssociation());
        deck.add(new AntiNuclearActivists());
        deck.add(new AntiWarActivists());
        deck.add(new BigMedia());
        deck.add(new BoySprouts());
        deck.add(new California());
        deck.add(new CFLAIO());
        deck.add(new ChineseCampDonor());
        deck.add(new CIA());
        deck.add(new CloneArrangers());
        deck.add(new ComicBooks());
        deck.add(new CongressionalWives());
        deck.add(new ConvenienceStores());
        deck.add(new CopyShops());
        deck.add(new CycleGangs());
        deck.add(new Democrats());
        deck.add(new EcoGuerrillas());
        deck.add(new EmptyVee());
        deck.add(new EvilGeniusesForABetterTomorrow());
        deck.add(new FastFoodChains());
        deck.add(new FBI());
        deck.add(new FederalReserve());
        deck.add(new Feminists());
        deck.add(new FiendishFluidators());
        deck.add(new FlatEarthers());
        deck.add(new FnordMotorCompany());
        deck.add(new FraternalOrders());
        deck.add(new GirlieMagazines());
        deck.add(new GoldfishFanciers());
        deck.add(new GunLobby());
        deck.add(new Hackers());
        deck.add(new HealthFoodStores());
        deck.add(new Hollywood());
        deck.add(new Intellectuals());
        deck.add(new InternationalCocaineSmugglers());
        deck.add(new InternationalCommConspiracy());
        deck.add(new IRS());
        deck.add(new JunkMail());
        deck.add(new KGB());
        deck.add(new KKK());
        deck.add(new L4Society());
        deck.add(new Libertarians());
        deck.add(new LoanSharks());
        deck.add(new LocalPoliceDepartments());
        deck.add(new MadisonAvenue());
        deck.add(new Militias());
        deck.add(new Moonies());
        deck.add(new MoralMinority());
        deck.add(new Morticians());
        deck.add(new MultinationalOilCompanies());
        deck.add(new NephewsOfGod());
        deck.add(new NewYork());
        deck.add(new NuclearPowerCompanies());
        deck.add(new OrbitalMindControlLasers());
        deck.add(new ParentTeacherAgglomeration());
        deck.add(new Pentagon());
        deck.add(new ThePhoneCompany());
        deck.add(new PhonePhreaks());
        deck.add(new PostOffice());
        deck.add(new ProfessionalSports());
        deck.add(new Psychiatrists());
        deck.add(new PunkRockers());
        deck.add(new Recyclers());
        deck.add(new Republicans());
        deck.add(new RobotSeaMonsters());
        deck.add(new SciFiFans());
        deck.add(new SemiconsciousLiberationArmy());
        deck.add(new SMOF());
        deck.add(new SocietyForCreativeAnarchism());
        deck.add(new SouthAmericanNazis());
        deck.add(new Survivalists());
        deck.add(new Tabloids());
        deck.add(new Texas());
        deck.add(new TheMafia());
        deck.add(new TheMenInBlack());
        deck.add(new TheUnitedNations());
        deck.add(new TobaccoAndLiquorCompanies());
        deck.add(new Trekkies());
        deck.add(new TriliberalCommission());
        deck.add(new TVPreachers());
        deck.add(new UndergroundNewspaper());
        deck.add(new VideoGames());
        deck.add(new Yuppies());
        Collections.shuffle(deck);



        // Ability Cards
        deck.add(new Assassination());
        deck.add(new Bribery());
        deck.add(new ComputerEspionage());
        deck.add(new DeepAgent());
        deck.add(new Interference());
        deck.add(new Interference());
        deck.add(new MarketManipulation());
        deck.add(new MediaCampaign());
        deck.add(new MurphysLaw());
        deck.add(new SecretsManWasNotMeantToKnow());
        deck.add(new SenateInvestigatingCommittee());
        deck.add(new SlushFund());
        deck.add(new SwissBankAccount());
        deck.add(new WhisperingCampaign());
        deck.add(new WhiteCollarCrime());
    }

    //method to convert string to GroupCard
    //Parameter is String and Person
    public GroupCard stringToGroupCard(String name,Person p){
        GroupCard card = null;

        for (PowerStructure crd : p.pStructure.getChildren()) {
            if(crd.LABEL.getName().equals(name)){
                card = (GroupCard) crd.LABEL;
                break;
            }
        }
        return card;
    }
    //method to convert string to GroupCard.
    //Parameter is String and ArrayList of GroupCards
    public GroupCard stringToGroupCard(String name, ArrayList<GroupCard> a){
        GroupCard card = null;

        for (GroupCard crd : a) {
            if(crd.getName().equals(name)){
                card = crd;
                break;
            }
        }
        return card;
    }

    public Person stringToPerson(String name){
        Person player = null;
        for(Person person: playerList){
            if(person.getUsername().equals(name)){
                player = person;
            }
        }
        return player;
    }

    public ArrayList<String> resetOpponents(){
        ArrayList<String> opponents = new ArrayList<>();
        for(Person person : playerList){
            if(!person.getUsername().equals(currentPlayer.getUsername())){
                opponents.add(person.getUsername());
            }
        }
        return opponents;
    }

    public void resetGameData(){
        illuminatiCards.clear();
        deck.clear();
        uncontrolledGroupsPile.clear();
        System.out.println("Decks Cleared\n\n");
        playerCount = 0;
        currentPlayer = null;
        loadCards();
    }

//
//    public void test() {
//        System.out.println("Testing");
//        illuminatiCards.add(new TheUFOs());
//        System.out.println("UFO: " + illuminatiCards.get(0).toString());
//        drawCard();
//
//
//    }
}
