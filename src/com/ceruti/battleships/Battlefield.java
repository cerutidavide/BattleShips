package com.ceruti.battleships;

import java.util.Random;

public class Battlefield {
    private int fieldHeight;
    private int fieldWidth;
    private String[][] field;


    private int computerShips;
    private int playerShips;
    private int numberOfShips;

    Battlefield(int width, int height, int ships) {
        this.fieldWidth = width;
        this.fieldHeight = height;
        this.numberOfShips = ships;
        this.computerShips = ships;
        this.playerShips = ships;
        this.field = new String[width][height];
        for (int i = 0; i < this.getFieldWidth(); i++) {
            for (int j = 0; j < this.getFieldHeight(); j++) {
                this.field[i][j] = "0";
            }
        }
    }

    Battlefield() {
        this.fieldWidth = 10;
        this.fieldHeight = 10;
        this.numberOfShips = 5;
        this.computerShips = 5;
        this.playerShips = 5;
        for (int i = 0; i < this.getFieldWidth(); i++) {
            for (int j = 0; j < this.getFieldHeight(); j++) {
                this.field[i][j] = "0";
            }
        }
    }

    public int getComputerShips() {
        return computerShips;
    }

    public int getPlayerShips() {
        return playerShips;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    //TODO aggiungere casi durante battaglia
//TODO aggiungere stampa numero di navi ancora vive
    public void drawField(boolean revealed) {
        System.out.println("**** Welcome to Battle Ships Game! ****");
        System.out.println("Battle field empty!");
        System.out.print("   0123456789\n");
        for (int i = 0; i < this.getFieldWidth(); i++) {
            System.out.print(i + " |");
            for (int j = 0; j < this.getFieldHeight(); j++)
                if (revealed) {
                    if (field[i][j].equals("0")) System.out.print(" ");
                    else if (field[i][j].equals("2")) System.out.print("*");
                    else System.out.print("@");
                } else {
                    switch (field[i][j]) {
                        case "0":
                            System.out.print(" ");
                            break;
                        case "2":
                            System.out.print(" ");
                            break;

                    }
                }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.print("   0123456789\n");
    }

    public void recordPlayerShip(int x, int y) {
        field[x][y] = "@";
    }

    public void recordComputerShip(int x, int y) {
        field[x][y] = "2";
    }

    public void deployComputerShips() {
        int i = 1;
        while (i <= numberOfShips) {
            int x = new Random().nextInt(10);
            int y = new Random().nextInt(10);
            if (isAvailable(x, y)) {
                recordComputerShip(x, y);
                System.out.println("Computer Ship # " + i + "Deployed");
                i++;
            }
        }
    }

    public void setShotResult(int x, int y) {
        String result = "";
        switch (this.field[x][y]) {
            case "0":
                System.out.println("Sorry, you missed");
                this.field[x][y] = "-";
                break;
            case "2":
                System.out.println("Boom! You sunk the ship!");
                this.computerShips--;
                this.field[x][y] = "!";
                break;
            case "@":
                System.out.println("Oh no, you sunk your own ship :(");
                this.playerShips--;
                this.field[x][y] = "x";
                break;
            default:
                result = this.field[x][y];
                break;
        }


    }

    public boolean isValid(int x, int y) {
        return (x < field.length && x >= 0 && y < field.length && y >= 0);
    }

    public boolean isAvailable(int x, int y) {
        return !(field[x][y].equals("@") || (field[x][y].equals("2")));
    }


}