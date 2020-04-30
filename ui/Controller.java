package ui;

import game.Game;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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
    ArrayList<String> usernames;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //UI Initial setup
//        gamePlay.test();
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
        helpTextArea.setWrapText(true);
        usernames = new ArrayList<String>();
        System.out.println("Arraylist size: " + usernames.size());

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
                addPlayer();
            }
        });

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
            }
        });

        specialCardChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Special Card action changed to: " + specialCardChoiceBox.getValue() + "\n");
                specialCardActionBtn.setTooltip(new Tooltip(specialCardChoiceBox.getValue() + " a Special Card"));
            }
        });

        addPlayerBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addPlayer();
            }
        });

        startGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Start Game Button - Clicked");
                mainTabbedPane.getTabs().remove(mainMenuTab);
                mainTabbedPane.getTabs().add(0, gameplayTab);
                mainTabbedPane.getSelectionModel().select(0);
            }
        });

        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                System.out.println("Special Card Actions Button - Clicked");
                System.out.println("- Action: " + specialCardChoiceBox.getValue() + "\n"
                        + "- Selected Card: " + specialCardToUseCB.getValue() + "\n"
                        + "- Target Player: " + specialTargetPlayerCB.getValue() + "\n");
            }
        });

        giveMoneyActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Give Money Button - Clicked");
                System.out.println("- Recipient: " + transferMoneyPlayerCB.getValue() + "\n"
                                + "- Amount: " + transferAmountSlider.getValue() + "\n");
            }
        });

        tradeActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Trade Button - Clicked");
                System.out.println("- Card to trade: " + tradeGiveCardCB.getValue()  + "\n"
                        + "- Player to trade with: " + tradePersonCB.getValue()  + "\n"
                        + "- Card to receive: " + tradeGetCardCB.getValue() + "\n");
            }
        });

        passTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Pass Button - Clicked\n");
            }
        });

        endTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("End Turn Button - Clicked\n");
            }
        });

        forfeitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Forfiet Button - Clicked \n");
                //reset all choice boxes to null, remove the player from arraylist, and repopulate the choice boxes
            }
        });


        playerToViewChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Viewing: " + playerToViewChoiceBox.getValue() + "'s Hand\n");
                playerToViewChoiceBox.setTooltip(new Tooltip("Viewing: "
                        + playerToViewChoiceBox.getValue() + "'s Structure"));
            }
        });

        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Exit Button - Clicked\n");
                addPlayerBTN.setDisable(false);
                mainTabbedPane.getTabs().add(0, mainMenuTab);
                mainTabbedPane.getTabs().remove(gameplayTab);
                resetGameUI();
            }
        });

    }

    public void resetGameUI(){
        //send all cards back to their decks
        mainMenuTA.clear();
        usernames.clear();
        playerToViewChoiceBox.getItems().clear();
        usernameTF.setDisable(false);
        startGameBtn.setDisable(true);
        System.out.println("UI status: Reset Complete\n");
    }

    public void addPlayer(){
        System.out.println("Add Player Button - Clicked");

        if (usernameTF.getText().isEmpty()){
            mainMenuTA.appendText("Username not entered. Please enter a valid username.\n");
        }
        else if(usernames.contains(usernameTF.getText())){
            mainMenuTA.appendText(usernameTF.getText() + " is already taken.\n");
        }
        else{
            System.out.println(usernameTF.getText() + " joined\n");
            mainMenuTA.appendText(usernameTF.getText() + " joined\n");
            playerToViewChoiceBox.getItems().add(usernameTF.getText());
            usernames.add(usernameTF.getText());
            if(usernames.size() >= 2){
                startGameBtn.setDisable(false);
                gameplayTab.setDisable(false);
                playerToViewChoiceBox.getSelectionModel().select(0);
            }
        }

        if(usernames.size() == 4){
            addPlayerBTN.setDisable(true);
            usernameTF.setDisable(true);
        }
        usernameTF.clear();
        playerToViewChoiceBox.setTooltip(new Tooltip("View: " + playerToViewChoiceBox.getValue() + "'s Structure"));
    }
}
