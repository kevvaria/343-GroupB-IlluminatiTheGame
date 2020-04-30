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
    private TextField transferMoneyAmountTF;
    @FXML
    private TextField usernameTF;
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
    private ChoiceBox<String> specialCardTargetCB;
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
        addPlayerBTN.setTooltip(new Tooltip("Add the username above to the lobby"));
        startGameBtn.setTooltip(new Tooltip("Start game with current players in lobby"));
        attackChoiceBox.setTooltip(new Tooltip("Select a form of attack"));
        attackBtn.setTooltip(new Tooltip("Attack to " + attackChoiceBox.getValue()));
        groupChoiceBox.setTooltip(new Tooltip("Would you like to Move or Give a group?"));
        groupActionBtn.setTooltip(new Tooltip(groupChoiceBox.getValue() + " a Group"));
        specialCardChoiceBox.setTooltip(new Tooltip("Would you like to Use or Give away a Special Card?"));
        specialCardActionBtn.setTooltip(new Tooltip(specialCardChoiceBox.getValue() + " a Special Card"));
        giveMoneyActionBtn.setTooltip(new Tooltip("Give money to another player"));
        tradeActionBtn.setTooltip(new Tooltip("Perform a Trade with another player"));
        passTurnBtn.setTooltip(new Tooltip("Pass your turn without performing any actions"));
        endTurnBtn.setTooltip(new Tooltip("End your turn after completing planned actions"));
        forfeitBtn.setTooltip(new Tooltip("Select this if you want to leave the game"));
        playerToViewChoiceBox.setTooltip(new Tooltip("View: " + playerToViewChoiceBox.getValue() + "'s Structure"));
        mainMenuTab.setTooltip(new Tooltip("View the Main Menu"));
        gameplayTab.setTooltip(new Tooltip("View the Gameplay Board"));
        helpTab.setTooltip(new Tooltip("View the game rules"));
        exitBtn.setTooltip(new Tooltip("Exit to Main Menu"));

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

        attackChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Attack Mode changed to: " + attackChoiceBox.getValue() + "\n");
                attackBtn.setTooltip(new Tooltip("Attack to " + attackChoiceBox.getValue()));
            }
        });

        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Attack Button - Clicked");
                System.out.println("- Attack to " + attackChoiceBox.getValue() + " from " + attackingCardCB.getValue());
                System.out.println("- Target Player: " + attackPlayerCB.getValue());
                System.out.println("- Target Group: " + attackTargetGroupCB.getValue() + "\n");
                //call attack method here. Parameters: attacking card, target player name, target group
            }
        });

        groupChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Group action changed to: " + groupChoiceBox.getValue() + "\n");
                groupActionBtn.setTooltip(new Tooltip(groupChoiceBox.getValue() + " a Group"));
            }
        });

        groupActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Group Actions Button - Clicked");
                System.out.println("- Action: " + groupChoiceBox.getValue());
                System.out.println("- Selected group: " + groupCardToGiveCB.getValue());
                System.out.println("- Target Player: " + groupTargetPlayerCB.getValue());
                System.out.println("- Target Card: " + groupTargetGroupCB.getValue() + "\n");
                //call group method here. Pass in action type, card to give, target player, target group
            }
        });

        specialCardChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Special Card action changed to: " + specialCardChoiceBox.getValue() + "\n");
                specialCardActionBtn.setTooltip(new Tooltip(specialCardChoiceBox.getValue() + " a Special Card"));
            }
        });

        specialCardActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Special Card Actions Button - Clicked");
                System.out.println("- Action: " + specialCardChoiceBox.getValue());
                System.out.println("- Selected Card: " + specialCardToUseCB.getValue());
                System.out.println("- Target Player: " + specialTargetPlayerCB.getValue());
                System.out.println("- Target Card: " + specialCardTargetCB.getValue() + "\n");
            }
        });

        giveMoneyActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Give Money Button - Clicked");
                System.out.println("- Player chosen: " + transferMoneyPlayerCB.getValue());
                System.out.println("- Amount to Transfer: " + transferMoneyAmountTF.getText() + "\n");
            }
        });

        tradeActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Trade Button - Clicked");
                System.out.println("- Card to trade: " + tradeGiveCardCB.getValue());
                System.out.println("- Player to trade with: " + tradePersonCB.getValue());
                System.out.println("- Card to receive: " + tradeGetCardCB.getValue() + "\n");
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
        addPlayerBTN.setDefaultButton(true);
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
            startGameBtn.setDefaultButton(true);
        }
        usernameTF.clear();
        playerToViewChoiceBox.setTooltip(new Tooltip("View: " + playerToViewChoiceBox.getValue() + "'s Structure"));
    }
}
