package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panelWindow;
    private JLabel outLabel;
    private JButton passButton;
    private JButton attackButton;
    private JTabbedPane tabbedPane1;
    private JPanel menuPane;
    private JPanel boardPane;

    public App() {
        passButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(outLabel.getText() == "a"){
                    outLabel.setText("b");
                }
                else{
                    outLabel.setText("a");
                }

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Appa");
        frame.setContentPane(new App().panelWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
