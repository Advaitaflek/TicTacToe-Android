package com.example.tiktactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    private int[][] gameBoard;

    private String[] playerName= {"Player 1", "Player 2"};
    private int[] winType = {-1,-1,-1}; //{row, col, line type}
    private Button playAgainBT;
    private Button homeBt;
    private TextView playerTurn;
    private int player = 1;
    GameLogic(){
        gameBoard = new int [3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col){
        if(gameBoard[row-1][col-1] == 0){
            gameBoard[row-1][col-1] = player;

            if(player == 1){
                playerTurn.setText((playerName[1]+ "'s Turn"));
            }
            else {
                playerTurn.setText((playerName[0]+ "'s Turn"));
            }

            return true;
        }
        else {
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;

        for (int i = 0; i < 3; i++) {
            if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][0] != 0){
                winType = new int[] { i, 0, 1};
                isWinner = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i] && gameBoard[0][i] != 0){
                winType = new int[] { 0, i, 2};
                isWinner = true;
            }
        }
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != 0){
            winType = new int[] { 0, 2, 3};
            isWinner = true;
        }
        if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[1][1] != 0){
            winType = new int[] { 2, 2, 4};
            isWinner = true;
        }

        int boardFilled = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(gameBoard[i][j] != 0){
                    boardFilled++;
                }
            }

        }

        if(isWinner){
            playAgainBT.setVisibility(View.VISIBLE);
            homeBt.setVisibility(View.VISIBLE);
            playerTurn.setText((playerName[player-1] + " Won!!!"));
            return true;

        } else if (boardFilled == 9) {
            playAgainBT.setVisibility(View.VISIBLE);
            homeBt.setVisibility(View.VISIBLE);
            playerTurn.setText(("Tie!!!"));
            return true;
        }
        else {
            return false;
        }
    }

    public void resetGameBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = 0;
            }
        }

        player = 1;
        playAgainBT.setVisibility(View.GONE);
        homeBt.setVisibility(View.GONE);

        playerTurn.setText((playerName[0] + "'s turn"));
    }

    public void setPlayAgainBT(Button playAgainBT){
        this.playAgainBT = playAgainBT;
    }

    public void setHomeBt(Button homeBt) {
        this.homeBt = homeBt;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int[][] getGameBoard(){
        return gameBoard;
    }

    public void setPlayer(int player){
        this.player=player;
    }

    public void setPlayerNames(String[] playerName) {
        this.playerName = playerName;
    }

    public int getPlayer(){
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
