package ui;

import game.Game;
import game.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //variable declaration - UI elements
    @FXML
    private TabPane mainTabbedPane;
    @FXML
    private Tab mainMenuTab;
    @FXML
    private Tab gameplayTab;
    @FXML
    private Tab helpTab;
    @FXML
    private Button attackBtn;
    @FXML
    private Button forfeitBtn;
    @FXML
    private Button specialCardActionBtn;
    @FXML
    private Button tradeActionBtn;
    @FXML
    private Button passTurnBtn;
    @FXML
    private Button groupActionBtn;
    @FXML
    private Button endTurnBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Button startGameBtn;
    @FXML
    private Button addPlayerBTN;
    @FXML
    private Button giveMoneyActionBtn;
    @FXML
    private TextArea mainMenuTA;
    @FXML
    private TextArea gameplayTA;
    @FXML
    private TextArea helpTextArea;
    @FXML
    private TextArea powerStructureTA;
    @FXML
    private TitledPane viewPlayersHandTP;
    @FXML
    private TitledPane attacksTP;
    @FXML
    private TitledPane groupsTP;
    @FXML
    private TitledPane specialCardsTP;
    @FXML
    private TitledPane giveMoneyTP;
    @FXML
    private TitledPane tradeTP;
    @FXML
    private TitledPane endTurnTP;
    @FXML
    private TitledPane exitGameTP;
    @FXML
    private Slider transferAmountSlider;
    @FXML
    TextField usernameTF;
    @FXML
    private ToggleGroup endTurnGroup;
    @FXML
    private ChoiceBox<String> attackChoiceBox;
    @FXML
    private ChoiceBox<String> attackingCardCB;
    @FXML
    private ChoiceBox<String> attackPlayerCB;
    @FXML
    private ChoiceBox<String> attackTargetGroupCB;
    @FXML
    private ChoiceBox<String> groupChoiceBox;
    @FXML
    private ChoiceBox<String> groupCardToGiveCB;
    @FXML
    private ChoiceBox<String> groupTargetPlayerCB;
    @FXML
    private ChoiceBox<String> groupTargetGroupCB;
    @FXML
    private ChoiceBox<String> specialCardChoiceBox;
    @FXML
    private ChoiceBox<String> specialCardToUseCB;
    @FXML
    private ChoiceBox<String> specialTargetPlayerCB;
    @FXML
    private ChoiceBox<String> transferMoneyPlayerCB;
    @FXML
    private ChoiceBox<String> tradeGiveCardCB;
    @FXML
    private ChoiceBox<String> tradePersonCB;
    @FXML
    private ChoiceBox<String> tradeGetCardCB;
    @FXML
    private ChoiceBox<String> playerToViewChoiceBox;
    @FXML
    private RadioButton exitDenyRB;
    @FXML
    private RadioButton exitConfirmRB;

    //variable declaration - source code dependant
    Game gamePlay = new Game();
    ArrayList<String> opponents = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //UI Initial setup
        startGameBtn.setDisable(true);
        attackChoiceBox.getItems().add("Control");
        attackChoiceBox.getItems().add("Neutralize");
        attackChoiceBox.getItems().add("Destroy");
        attackChoiceBox.getSelectionModel().select(0);
        groupChoiceBox.getItems().add("Give");
        groupChoiceBox.getItems().add("Move");
        groupChoiceBox.getSelectionModel().select(0);
        specialCardChoiceBox.getItems().add("Give");
        specialCardChoiceBox.getItems().add("Use");
        specialCardChoiceBox.getSelectionModel().select(0);
        mainTabbedPane.getTabs().remove(gameplayTab);

        mainMenuTA.setWrapText(true);
        powerStructureTA.setWrapText(false);
        helpTextArea.setWrapText(true);

        //setting tooltips for all buttons
        playerToViewChoiceBox.setTooltip(new Tooltip("View: " + playerToViewChoiceBox.getValue() + "'s Structure"));
        addPlayerBTN.setTooltip(new Tooltip("Add the username above to the lobby"));
        startGameBtn.setTooltip(new Tooltip("Start game with current players in lobby"));
        attackChoiceBox.setTooltip(new Tooltip("Select a form of attack"));
        attackingCardCB.setTooltip(new Tooltip("Select a card to attack with"));
        attackPlayerCB.setTooltip(new Tooltip("Select a player whose group you want to attack"));
        attackTargetGroupCB.setTooltip(new Tooltip("Pick a target group"));
        attackBtn.setTooltip(new Tooltip("Attack to " + attackChoiceBox.getValue()));
        groupChoiceBox.setTooltip(new Tooltip("Would you like to Move or Give a group?"));
        groupCardToGiveCB.setTooltip(new Tooltip("List of cards in your structure"));
        groupTargetPlayerCB.setTooltip(new Tooltip("List of players available"));
        groupTargetGroupCB.setTooltip(new Tooltip("All groups available on the board"));
        groupActionBtn.setTooltip(new Tooltip(groupChoiceBox.getValue() + " a Group"));
        specialCardChoiceBox.setTooltip(new Tooltip("Would you like to Use or Give away a Special Card?"));
        specialCardToUseCB.setTooltip(new Tooltip("Select a Special Card from your structure"));
        specialTargetPlayerCB.setTooltip(new Tooltip("Select a player to give the special card to"));
        specialCardActionBtn.setTooltip(new Tooltip(specialCardChoiceBox.getValue() + " a Special Card"));
        transferMoneyPlayerCB.setTooltip(new Tooltip("Select a player to receive the money"));
        transferAmountSlider.setTooltip(new Tooltip("Select amount to transfer"));
        giveMoneyActionBtn.setTooltip(new Tooltip("Give money to another player"));
        tradeGiveCardCB.setTooltip(new Tooltip("Select a Card to give"));
        tradePersonCB.setTooltip(new Tooltip("Select a player to trade with"));
        tradeGetCardCB.setTooltip(new Tooltip("Select a Card to get"));
        tradeActionBtn.setTooltip(new Tooltip("Perform a Trade with another player"));
        passTurnBtn.setTooltip(new Tooltip("Pass your turn without performing any actions"));
        endTurnBtn.setTooltip(new Tooltip("End your turn after completing planned actions"));
        forfeitBtn.setTooltip(new Tooltip("Select this if you want to leave the game"));
        mainMenuTab.setTooltip(new Tooltip("View the Main Menu"));
        gameplayTab.setTooltip(new Tooltip("View the Gameplay Board"));
        helpTab.setTooltip(new Tooltip("View the game rules"));
        exitBtn.setTooltip(new Tooltip("Exit to Main Menu"));

        transferAmountSlider.valueProperty().addListener((obs, oldval, newVal) ->
                transferAmountSlider.setValue(Math.round(newVal.doubleValue())));

        //define all handle functions required for UI interaction
        attackChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Attack Mode changed to: " + attackChoiceBox.getValue() + "\n");
                attackBtn.setTooltip(new Tooltip("Attack to " + attackChoiceBox.getValue()));
            }
        });

        groupChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Group action changed to: " + groupChoiceBox.getValue() + "\n");
                groupActionBtn.setTooltip(new Tooltip(groupChoiceBox.getValue() + " a Group"));
                if(groupChoiceBox.getValue().equalsIgnoreCase("Give")){
                    groupTargetPlayerCB.setDisable(false);
                }
                else {
                    groupTargetPlayerCB.setDisable(true);
                }
            }
        });

        specialCardChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Special Card action changed to: " + specialCardChoiceBox.getValue() + "\n");
                specialCardActionBtn.setTooltip(new Tooltip(specialCardChoiceBox.getValue() + " a Special Card"));
                if(specialCardChoiceBox.getValue().equalsIgnoreCase("Give")){
                    specialTargetPlayerCB.setDisable(false);
                }
                else{
                    specialTargetPlayerCB.setDisable(true);
                }
            }
        });

        usernameTF.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (usernameTF.getText().length() >= 10) {
                        usernameTF.setText(usernameTF.getText().substring(0, 10));
                    }
                }
            }
        });

        usernameTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addPlayerUI();
            }
        });

        addPlayerBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addPlayerUI();
            }
        });

        startGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Start Game Button - Clicked");
                gameplayTA.appendText("Welcome to the Arena! Good Luck!\n\n");
                gamePlay.initGame();
                gamePlay.assignIlluminatiCards();
                gamePlay.initialUncontrolled();
                gamePlay.setCurrentPlayer(gamePlay.getPlayerList().get(0));
                for(Person player: gamePlay.getPlayerList()){
                    gameplayTA.appendText(player.getUsername() + " - " + player.getIlluminatiCard().getName() + "\n");
                }
                gameplayTA.appendText("\n");
                mainTabbedPane.getTabs().remove(mainMenuTab);
                mainTabbedPane.getTabs().add(0, gameplayTab);
                mainTabbedPane.getSelectionModel().select(0);
                playerToViewChoiceBox.getSelectionModel().select(0);
                updateOpponentsUI();
                syncAllTargetBoxes(gamePlay.getPlayerList().get(1).getUsername());
            }
        });

        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " is attacking to "
                        + attackChoiceBox.getValue() + "\n"
                        + "- Attacking Group: " + attackingCardCB.getValue()  + "\n"
                        + "- Target Group: " + attackPlayerCB.getValue()
                        + "'s " + attackTargetGroupCB.getValue() + "\n\n");
                System.out.println("Attack Button - Clicked");
                System.out.println("- Attack to " + attackChoiceBox.getValue() + "\n"
                        + " from " + attackingCardCB.getValue() + "\n"
                        + "- Target Player: " + attackPlayerCB.getValue() + "\n"
                        + "- Target Group: " + attackTargetGroupCB.getValue() + "\n");
                //call attack method here. Parameters: attacking card, target player name, target group
            }
        });

        groupActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername()
                        + " decided to " + groupChoiceBox.getValue()
                        + " the group: "  + groupCardToGiveCB.getValue() + "\n\n");
                System.out.println("Group Actions Button - Clicked");
                System.out.println("- Action: " + groupChoiceBox.getValue() + "\n"
                        + "- Selected group: " + groupCardToGiveCB.getValue() + "\n"
                        + "- Target Player: " + groupTargetPlayerCB.getValue() + "\n"
                        + "- Target Card: " + groupTargetGroupCB.getValue() + "\n");
                //call group method here. Pass in action type, card to give, target player, target group
            }
        });

        specialCardActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " "
                        + specialCardChoiceBox.getValue() + "d " + specialCardToUseCB.getValue() + "\n\n");
                System.out.println("Special Card Actions Button - Clicked");
                System.out.println("- Action: " + specialCardChoiceBox.getValue() + "\n"
                        + "- Selected Card: " + specialCardToUseCB.getValue() + "\n"
                        + "- Target Player: " + specialTargetPlayerCB.getValue() + "\n");
            }
        });

        giveMoneyActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " gave "
                        + transferMoneyPlayerCB.getValue() + ": " + transferAmountSlider.getValue() + "MB's\n\n");
                System.out.println("Give Money Button - Clicked");
                System.out.println("- Recipient: " + transferMoneyPlayerCB.getValue() + "\n"
                        + "- Amount: " + transferAmountSlider.getValue() + "\n");
            }
        });

        tradeActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " traded "
                        + tradeGiveCardCB.getValue() + " with "
                        + tradePersonCB.getValue() + "'s "
                        + tradeGetCardCB.getValue() + "\n\n");
                System.out.println("Trade Button - Clicked");
                System.out.println("- Card to trade: " + tradeGiveCardCB.getValue()  + "\n"
                        + "- Player to trade with: " + tradePersonCB.getValue()  + "\n"
                        + "- Card to receive: " + tradeGetCardCB.getValue() + "\n");
            }
        });

        passTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " passes their turn\n\n");
                gamePlay.passTurn();
                updateOpponentsUI();
            }
        });

        endTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " passes their turn\n\n");
                gamePlay.endTurn();
                updateOpponentsUI();
            }
        });

        forfeitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Forfeit Button - Clicked \n");
                //reset all choice boxes to null, remove the player from arraylist, and repopulate the choice boxes
                if(exitConfirmRB.isSelected()){
                    gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " Forfiets!\n\n");
                    exitDenyRB.setSelected(true);
                }
                else{
                    gameplayTA.appendText("Please select \"Yes\" in order to Forfiet.\n\n");
                }
            }
        });

        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Exit Button - Clicked\n");

                if(exitConfirmRB.isSelected()){
                    gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + " Forfiets!\n\n");
                    addPlayerBTN.setDisable(false);
                    mainTabbedPane.getTabs().add(0, mainMenuTab);
                    mainTabbedPane.getTabs().remove(gameplayTab);
                    resetGameUI();
                    exitDenyRB.setSelected(true);
                }
                else{
                    gameplayTA.appendText("Please select \"Yes\" in order to Exit.\n\n");
                }

            }
        });

        playerToViewChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameplayTA.appendText("Viewing: " + playerToViewChoiceBox.getValue() + "'s cards\n");
                playerToViewChoiceBox.setTooltip(new Tooltip("Viewing: "
                        + playerToViewChoiceBox.getValue() + "'s Structure"));
                powerStructureTA.clear();
                powerStructureTA.appendText("Print " + playerToViewChoiceBox.getValue() + "'s PowerStructure here");
            }
        });

        attackPlayerCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String targetPlayer = attackPlayerCB.getValue();
                syncAllTargetBoxes(targetPlayer);
            }
        });

        groupTargetPlayerCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String action = groupChoiceBox.getValue();
                if(action.equals("Give")){
                    String recipient = groupTargetPlayerCB.getValue();
                    String cardToGive = groupCardToGiveCB.getValue();
                    String cardToFather = groupTargetGroupCB.getValue();
                    syncAllTargetBoxes(recipient);
                }
                else{   //move the group card within personal structure
                    String cardParent = groupTargetGroupCB.getValue();
                    String cardChild = groupCardToGiveCB.getValue();
                    //if both cards are same, print error
                    //else if parent has space, move under it
                    //else, error that the parent doesn't have space
                }
            }
        });

        specialTargetPlayerCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String action = specialCardChoiceBox.getValue();
                if(action.equals("Give")){
                    specialTargetPlayerCB.setDisable(false);
                    String recipient = specialTargetPlayerCB.getValue();
                    String cardToGive = specialCardToUseCB.getValue();
                    syncAllTargetBoxes(recipient);
                }
                else{   //use the group card within personal structure
                    specialTargetPlayerCB.setDisable(true);
                    String cardToUse = specialCardToUseCB.getValue();
                }
            }
        });

        transferMoneyPlayerCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String personSelected = transferMoneyPlayerCB.getValue();
                syncAllTargetBoxes(personSelected);
            }
        });

        tradePersonCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String playerSelected = tradePersonCB.getValue();
                syncAllTargetBoxes(playerSelected);
            }
        });
    }

    public void resetGameUI(){
        //send all cards back to their decks
        mainMenuTA.clear();
        gameplayTA.clear();
        playerToViewChoiceBox.getItems().clear();
        attackingCardCB.getItems().clear();
        attackPlayerCB.getItems().clear();
        attackTargetGroupCB.getItems().clear();

        groupCardToGiveCB.getItems().clear();
        groupTargetPlayerCB.getItems().clear();
        groupCardToGiveCB.getItems().clear();

        specialCardToUseCB.getItems().clear();
        specialTargetPlayerCB.getItems().clear();

        transferMoneyPlayerCB.getItems().clear();
        transferAmountSlider.setValue(0);

        tradePersonCB.getItems().clear();
        tradeGiveCardCB.getItems().clear();
        tradeGetCardCB.getItems().clear();

        usernameTF.setDisable(false);
        startGameBtn.setDisable(true);
        gamePlay.setPlayerList(new ArrayList<>());
        System.out.println("UI status: Reset Complete\n");
    }


    public void addPlayerUI(){
        System.out.println("Add Player Button - Clicked");
        String username = usernameTF.getText();
        if (username.isEmpty()){
            mainMenuTA.appendText("Username not entered. Please enter a valid username.\n");
        }
        else if(gamePlay.addAPlayer(new Person(username))){     //attempt to add player results in T/F
            System.out.println(username + " joined\n");         //if true, then output that the player is added
            mainMenuTA.appendText(username + " joined\n");
            playerToViewChoiceBox.getItems().add(usernameTF.getText());
            if(gamePlay.getPlayerList().size() >= 2){
                startGameBtn.setDisable(false);
                gameplayTab.setDisable(false);
            }
        }
        else{                                                   //if false, then output that the player exists
            mainMenuTA.appendText(username + " is already taken.\n");
        }

        if(gamePlay.getPlayerList().size() == 4){
            usernameTF.setDisable(true);
            addPlayerBTN.setDisable(true);
        }
        usernameTF.clear();
        playerToViewChoiceBox.setTooltip(new Tooltip("View: " + playerToViewChoiceBox.getValue() + "'s Structure"));
    }


    public void updateOpponentsUI(){
        gameplayTA.appendText(gamePlay.getCurrentPlayer().getUsername() + "'s Turn - "
                + gamePlay.getCurrentPlayer().getIlluminatiCard().getName() + "\n");
        attackPlayerCB.getItems().clear();
        groupTargetPlayerCB.getItems().clear();
        specialTargetPlayerCB.getItems().clear();
        transferMoneyPlayerCB.getItems().clear();
        tradePersonCB.getItems().clear();

        opponents = gamePlay.resetOpponents();
        attackPlayerCB.getItems().add("Uncontrolled");
        for(String oppName: opponents){
            attackPlayerCB.getItems().add(oppName);
            groupTargetPlayerCB.getItems().add(oppName);
            specialTargetPlayerCB.getItems().add(oppName);
            transferMoneyPlayerCB.getItems().add(oppName);
            tradePersonCB.getItems().add(oppName);
        }

        attackPlayerCB.getSelectionModel().select(0);
        groupTargetPlayerCB.getSelectionModel().select(0);
        specialTargetPlayerCB.getSelectionModel().select(0);
        transferMoneyPlayerCB.getSelectionModel().select(0);
        tradePersonCB.getSelectionModel().select(0);
    }

    public void syncAllTargetBoxes(String playerSelected) {
        attackPlayerCB.getSelectionModel().select(playerSelected);
        groupTargetPlayerCB.getSelectionModel().select(playerSelected);
        specialTargetPlayerCB.getSelectionModel().select(playerSelected);
        transferMoneyPlayerCB.getSelectionModel().select(playerSelected);
        tradePersonCB.getSelectionModel().select(playerSelected);

        attackTargetGroupCB.getItems().clear();
        groupTargetGroupCB.getItems().clear();
        transferAmountSlider.setValue(0);
        tradeGetCardCB.getItems().clear();

        //TODO - Populate the bottom target groups with the cards belonging to playerSelected
        attackTargetGroupCB.getItems().clear();
        groupTargetGroupCB.getItems().clear();
        tradeGetCardCB.getItems().clear();
    }

}
