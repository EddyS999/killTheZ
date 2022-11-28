package com.akira.game;

import javax.swing.*;

public class Main {

    public static MainWindow mainWindow;
    public static void main(String[] args) {
        JFrame windows = new JFrame();
        windows.setTitle("Just Kill all Z.");
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setResizable(false);
        windows.setSize(700,360);
        windows.setLocationRelativeTo(null);
        windows.setAlwaysOnTop(true);

        mainWindow = new MainWindow();

        windows.setContentPane(mainWindow);
        windows.setVisible(true);


    }

}
