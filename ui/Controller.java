package ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        addPlayerBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Player Button - Clicked");
                if (usernameTF.getText().isEmpty()){
                    mainMenuTA.appendText("Username not entered. Please enter a valid username.\n");
                }
//                else if(){
//                 check for usernames in the arraylist of usernames
//                }
//                else if(number of players in the lobby must be <=4){
//                    mainMenuTA.appendText("LOBBY FULL. Cannot add any more players.\n");
//                }
                else{                   //enable startGame button
                    System.out.println(usernameTF.getText() + " joined\n");
                    mainMenuTA.appendText(usernameTF.getText() + " joined\n");
                    playerToViewChoiceBox.getItems().add(usernameTF.getText());
                    playerToViewChoiceBox.getSelectionModel().select(0);
                    gameplayTab.setDisable(false);
                    startGameBtn.setDisable(false);             //scrap this and uncomment the code below
                    usernameTF.clear();
                }

//                if(number of players in lobby < 2){
//                    startGameBtn.setDisable(false);
//                    playerToViewChoiceBox.getSelectionModel().select(0);
//                }

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
