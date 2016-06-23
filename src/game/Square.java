package game;

import java.awt.*;
import java.util.*;

public class Square {
    int cowSquare;
    int rowSquare;
    boolean isXtoe;
    boolean isOtoe;
    boolean isEmthy;

    public Square(int cowSquare, int rowSquare) {
        this.cowSquare = cowSquare;
        this.rowSquare = rowSquare;
        this.isXtoe = false;
        this.isOtoe = false;
        this.isEmthy = false;
    }

    public int getCowSquare() {
        return cowSquare;
    }

    public int getRowSquare() {
        return rowSquare;
    }

    public boolean isXtoe() {
        return isXtoe;
    }

    public boolean isOtoe() {
        return isOtoe;
    }

    public boolean isEmthy() {
        return isEmthy;
    }

    public void setCowSquare(int cowSquare) {
        this.cowSquare = cowSquare;
    }

    public void setRowSquare(int rowSquare) {
        this.rowSquare = rowSquare;
    }

    public void setXtoe(boolean xtoe) {
        isXtoe = xtoe;
    }

    public void setOtoe(boolean otoe) {
        isOtoe = otoe;
    }

    public void setEmthy(boolean emthy) {
        isEmthy = emthy;
    }

    boolean haveWinner(ArrayList<Square> squares) {
        boolean isWin = false;
        //CoWReadWineer
        for (int i = 0; i < 9; i+=3) {
            if (squares.get(i).isXtoe == true && squares.get(i+1).isXtoe == true && squares.get(i+2).isXtoe == true) {
                isWin = true;

            }
            if(squares.get(i).isOtoe == true && squares.get(i+1).isOtoe == true && squares.get(i+2).isOtoe == true){
                    isWin=true;

            }
        }
        if(squares.get(0).isOtoe==true && squares.get(4).isOtoe==true && squares.get(8).isOtoe==true){
            isWin=true;

        }
        if(squares.get(0).isXtoe==true && squares.get(4).isXtoe==true && squares.get(8).isXtoe==true){
            isWin=true;

        }

        if(squares.get(2).isOtoe==true && squares.get(4).isOtoe==true && squares.get(6).isOtoe==true){
            isWin=true;

        }
        if(squares.get(2).isXtoe==true && squares.get(4).isXtoe==true && squares.get(6).isXtoe==true){
            isWin=true;

        }

        for (int i = 0; i < 3; i++) {
            if (squares.get(i).isXtoe == true && squares.get(i+3).isXtoe == true && squares.get(i+6).isXtoe == true) {
                isWin = true;
            }
            if(squares.get(i).isOtoe == true && squares.get(i+3).isOtoe == true && squares.get(i+6).isOtoe == true){
                isWin=true;
            }
        }
        return isWin;
    }

    public ArrayList<Square> SquareLeft(ArrayList<Square> squares){
        ArrayList<Square> countOfSquares = new ArrayList<>();
        for (int i = 0; i < squares.size(); i++) {
            if(squares.get(i).isEmthy==false){
                countOfSquares.add(squares.get(i));
            }
        }
        return countOfSquares;
    }

}
