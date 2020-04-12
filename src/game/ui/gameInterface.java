package game.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameInterface {
    private JTabbedPane mainPane;
    private JPanel mainPanel;
    private JPanel mainMenuPanel;
    private JPanel gameplayPanel;
    private JPanel helpPanel;
    private JButton startGameButton;
    private JLabel playerNameLabel;
    private JButton attackButton;
    private JButton moveGroupButton;
    private JButton giveGroupButton;
    private JButton giveMoneyButton;
    private JButton giveSpecialCardButton;
    private JButton useSpecialCardButton;
    private JButton tradeButton;
    private JButton leaveGameButton;
    private JButton passButton;
    private JButton endTurnButton;
    private JLabel PLACEHOLDERlabel;
    private JToolBar actionsToolBar;

    public gameInterface() {
        startGameButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerNameLabel.getText() == "a")
                    playerNameLabel.setText("b");
                else
                    playerNameLabel.setText("a");
            }
        });

        leaveGameButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


    public static void main(String[] args){
        JFrame frame = new JFrame("Illuminati: The Game of Conspiracy");
        frame.setContentPane(new gameInterface().mainPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
