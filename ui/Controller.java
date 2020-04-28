package ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //variable declaration
    @FXML
    private Button attackBtn;
    @FXML
    private TextArea mainMenuTA;
    @FXML
    private Button groupActionBtn;
    @FXML
    private TextField usernameTF;
    @FXML
    private ChoiceBox<String> groupChoiceBox;
    @FXML
    private HBox actionsHB;
    @FXML
    private Button endTurnBtn;
    @FXML
    private Button addPlayerBTN;
    @FXML
    private Tab gameplayTab;
    @FXML
    private TextArea helpTextArea;
    @FXML
    private ChoiceBox<String> specialCardChoiceBox;
    @FXML
    private Button giveMoneyActionBtn;
    @FXML
    private Button forfeitBtn;
    @FXML
    private Tab helpTab;
    @FXML
    private ChoiceBox<String> playerToViewChoiceBox;
    @FXML
    private Button specialCardActionBtn;
    @FXML
    private ChoiceBox<String> attackChoiceBox;
    @FXML
    private Button tradeActionBtn;
    @FXML
    private Tab mainMenuTab;
    @FXML
    private Button startGameBtn;
    @FXML
    private Button passTurnBtn;
    @FXML
    private TabPane mainTabbedPane;
    ArrayList<String> usernames;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //UI Initial setup
        gameplayTab.setDisable(true);
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
        mainMenuTA.setWrapText(true);
        helpTextArea.setWrapText(true);
        usernames = new ArrayList<String>();

        //setting tooltips for all buttons
        addPlayerBTN.setTooltip(new Tooltip("Add the username above to the lobby"));
        startGameBtn.setTooltip(new Tooltip("Start game with current players in lobby"));
        attackChoiceBox.setTooltip(new Tooltip("Select a form of attack"));
        attackBtn.setTooltip(new Tooltip("Attack a group"));
        groupChoiceBox.setTooltip(new Tooltip("Would you like to Move or Give a group?"));
        groupActionBtn.setTooltip(new Tooltip("Move or Give a Group"));
        specialCardChoiceBox.setTooltip(new Tooltip("Would you like to Use or Give away a Special Card?"));
        specialCardActionBtn.setTooltip(new Tooltip("Use or Give a Special Card"));
        giveMoneyActionBtn.setTooltip(new Tooltip("Give money to another player"));
        tradeActionBtn.setTooltip(new Tooltip("Perform a Trade with another player"));
        passTurnBtn.setTooltip(new Tooltip("Pass your turn without performing any actions"));
        endTurnBtn.setTooltip(new Tooltip("End your turn after completing planned actions"));
        forfeitBtn.setTooltip(new Tooltip("Select this if you want to leave the game"));
        mainMenuTab.setTooltip(new Tooltip("View the Main Menu"));
        gameplayTab.setTooltip(new Tooltip("View the Gameplay Board"));
        helpTab.setTooltip(new Tooltip("View the game rules"));

        //define all handle functions required for UI interaction
        addPlayerBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Player Button - Clicked");
                if (usernameTF.getText().isEmpty()){
                    mainMenuTA.appendText("Username not entered. Please enter a valid username.\n");
                }
                else if(usernames.contains(usernameTF.getText())){
                    mainMenuTA.appendText(usernameTF.getText() + " is already taken.\n");
                }
                else if(usernames.size()>=4){
                    mainMenuTA.appendText("LOBBY FULL. Cannot add any more players.\n");
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
                usernameTF.clear();
                }
            }
        });

        startGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Start Game Button - Clicked");
                mainTabbedPane.getSelectionModel().select(1);
            }
        });

        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Attack Button - Clicked");
                System.out.println("- Attack: " + attackChoiceBox.getValue());
            }
        });

        groupActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Group Actions Button - Clicked");
                System.out.println("- Action: " + groupChoiceBox.getValue());
            }
        });

        specialCardActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Special Card Actions Button - Clicked");
                System.out.println("- Action: " + specialCardChoiceBox.getValue());
            }
        });

        giveMoneyActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Popup prompts user to enter a recipient and amount of money to transfer.");
            }
        });

        tradeActionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("User is prompted to mandatorily select 3 things");
                System.out.println("1. Item to give. 2. Player to trade with. 3. Item to receive");
            }
        });

        passTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Player turn has been passed. Player+1 has control now.");
                System.out.println("Any actions taken in this turn will not be recorded.");
            }
        });

        endTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("All actions attempted so far will be recorded.\nPlayer turn goes to next player.");
            }
        });

        forfeitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("User X has be removed from the gameplay.");
                System.out.println("If only one player remains, then they are declared winner. Else, game continues.");
            }
        });


    }
}
