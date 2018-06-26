package com.ceruti.battleships;

import java.util.Random;

public class Battlefield {


    private int fieldRows;
    private int fieldCols;
    private String[][] field;
    private int computerShips;
    private int playerShips;
    private int numberOfShips;

    Battlefield(int rows, int cols, int ships) {
        this.fieldRows = rows;
        this.fieldCols = cols;
        this.numberOfShips = ships;
        this.computerShips = ships;
        this.playerShips = ships;
        initWater();
    }

    Battlefield() {
        this.fieldRows = 10;
        this.fieldCols = 10;
        this.numberOfShips = 5;
        this.computerShips = 5;
        this.playerShips = 5;
        initWater();
    }

    public int getComputerShips() {
        return computerShips;
    }

    public void setComputerShips(int computerShips) {
        this.computerShips = computerShips;
    }

    public int getPlayerShips() {
        return playerShips;
    }

    public void setPlayerShips(int playerShips) {
        this.playerShips = playerShips;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    public void setNumberOfShips(int numberOfShips) {
        this.numberOfShips = numberOfShips;
    }

    public int getFieldRows() {
        return fieldRows;
    }

    public int getFieldCols() {
        return fieldCols;
    }

    private void initWater() {
        this.field = new String[this.fieldRows][this.fieldCols];
        for (int row = 0; row < this.getFieldRows(); row++) {
            for (int col = 0; col < this.getFieldCols(); col++) {
                this.field[row][col] = " ";
            }
        }
    }


    public void decreseComputerShips() {
        this.computerShips--;
    }

    public void decreasePlayerShips() {
        this.playerShips--;
    }


    public void drawField(boolean revealed) {
        System.out.println("**** Welcome to Battle Ships Game! ****");
        //System.out.println("Battle field empty!");
        //TODO rendere dinamica la prima riga e anche l'ultima
        // System.out.print("   0123456789\n");
        for (int row = 0; row < this.getFieldRows(); row++) {
            System.out.print("\t\t" + row + " |");
            for (int col = 0; col < this.getFieldCols(); col++) {
                switch (this.field[row][col]) {
                    case " ":
                        System.out.print(" ");
                        break;
                    case "2":
                        if (revealed) {
                            System.out.print("2");
                        } else {
                            System.out.print(" ");
                        }
                        break;
                    case "-":
                        System.out.print("-");
                        break;
                    case "x":
                        System.out.print("x");
                        break;
                    case "!":
                        System.out.print("!");
                        break;
                    case "@":
                        System.out.print("@");
                        break;
                    default:
                        System.out.print("MESSAGGIO DI ERRORE STRANO");
                    }
                }
            System.out.print("| " + row);
            System.out.println();
        }
        System.out.print("\t\t   0123456789\n");
        System.out.println("Actual Score * * * * * * * * *  \nPlayer: " + this.getPlayerShips() + "\nComputer: " + this.getComputerShips());
        System.out.println("Actual Score * * * * * * * * *  ");
    }

    public void recordPlayerShip(int row, int col) {
        this.field[row][col] = "@";
    }

    public void recordComputerShip(int row, int col) {
        this.field[row][col] = "2";
    }
    public void deployComputerShips() {
        int i = 1;
        while (i <= this.numberOfShips) {
            int row = new Random().nextInt(this.getFieldRows());
            int col = new Random().nextInt(this.getFieldCols());
            if (isAvailable(row, col)) {
                recordComputerShip(row, col);
                System.out.println("Computer Ship # " + i + "Deployed");
                i++;
            }
        }
    }

    public void setShotResult(int row, int col) {
        switch (this.field[row][col]) {
            case " ": {
                System.out.println("Sorry, you missed");
                this.field[row][col] = "-";
                break;
            }
            case "2": {
                System.out.println("Boom! You sunk the ship!");
                this.decreseComputerShips();
                this.field[row][col] = "!";
                break;
            }
            case "@": {
                System.out.println("Oh no, you sunk your own ship :(");
                this.decreasePlayerShips();
                this.field[row][col] = "x";
                break;
            }
            default:
                break;
        }
    }

    public void setComputerShotResult(int row, int col) {
        switch (this.field[row][col]) {
            case "0": {
                this.field[row][col] = " ";
                System.out.println("Wow, COMPUTER MISSED!");
                break;
            }
            case "2": {
                this.decreseComputerShips();
                this.field[row][col] = "!";
                break;
            }
            case "@": {
                this.decreasePlayerShips();
                this.field[row][col] = "x";
                System.out.println("COMPUTER sunk yout SHIP!");
                break;
            }
            default:
                break;
        }
    }


    public boolean isValid(int row, int col) {
        return (row < field.length && row >= 0 && col < field.length && col >= 0);
    }

    public boolean isAvailable(int row, int col) {
        return !(field[row][col].equals("@") || (field[row][col].equals("2")));
    }

    public int[] getRandomShot() {
        int result[] = new int[2];
        result[0] = new Random().nextInt(this.getFieldRows());
        result[1] = new Random().nextInt(this.getFieldCols());
        return result;
    }
}