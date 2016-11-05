/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpoker;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.lang.String;
import java.util.Arrays;

/**
 *
 * @author mk
 */

public class MainGUI extends JFrame {
    
    //method to take string input and convert to ints and return
    public static int[] convertToCards(String input){
    int[] inputcards = new int[4];
    //convert here
    
    return inputcards;
    }

    public MainGUI() {
        super("Super Poker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setLayout(new BorderLayout());

        //North Panel
        JPanel northPanel = new JPanel();
        northPanel.setBorder(BorderFactory.createTitledBorder("Game Type"));
        JButton localGame = new JButton("Local Game");
        JButton serverGame = new JButton("Server Game");

        northPanel.add(localGame, BorderLayout.NORTH);
        northPanel.add(serverGame, BorderLayout.NORTH);

        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        JLabel soultionLabel = new JLabel("Soultion");
        soultionLabel.setAlignmentY(JLabel.LEFT_ALIGNMENT);

        JTextField soultion = new JTextField();
        soultion.setColumns(20);

        JPanel gameButtonsPanel = new JPanel();
        JButton newGame = new JButton("New Game");
        JButton exitGame = new JButton("Exit Game");

        gameButtonsPanel.add(newGame, BorderLayout.SOUTH);
        gameButtonsPanel.add(exitGame, BorderLayout.SOUTH);

        southPanel.add(soultionLabel);
        southPanel.add(soultion);
        southPanel.add(gameButtonsPanel);

        //Center
        JPanel gameModePanel = new JPanel();
        CardLayout gameModeLayout = new CardLayout();
        gameModePanel.setLayout(gameModeLayout);

        gameModePanel.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED));

        //Local GUI
        JPanel localGamePanel = new JPanel();

        JTextField cardSelection = new JTextField();
        cardSelection.setColumns(20);

        JButton send = new JButton("Send");

        localGamePanel.add(cardSelection);
        localGamePanel.add(send);

        //Server GUI
        JPanel serverGamePanel = new JPanel();
        serverGamePanel.setLayout(
                new BoxLayout(serverGamePanel, BoxLayout.Y_AXIS));

        JTextArea serverInfo = new JTextArea();
        serverInfo.append("Connecting to server...");
        JScrollPane scrollPane = new JScrollPane(serverInfo);

        serverGamePanel.add(scrollPane);

        gameModePanel.add(localGamePanel, "Local Game");
        gameModePanel.add(serverGamePanel, "Server Game");

        //Set the card layout
        gameModeLayout.first(gameModePanel);

        //MainGUI
        add(northPanel, BorderLayout.NORTH);
        add(gameModePanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        //Action listeners
        localGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModeLayout.first(gameModePanel);
            }
        });
        
        serverGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModeLayout.last(gameModePanel);
            }
        });
        
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //grabbing input from jtextfield
                String  inputText = cardSelection.getText();
                //testing 
                soultion.setText(inputText);
            }
        });

        setVisible(true);
    }
}
