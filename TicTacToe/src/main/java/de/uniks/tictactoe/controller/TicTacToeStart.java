package de.uniks.tictactoe.controller;

public class TicTacToeStart {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(TicTacToeMain.class);
            }
        }.start();
    }
}