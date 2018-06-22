package com.ceruti.battleships;

import java.util.Random;

public class Battlefield {
    private String[][] field = new String[100][100];
    static public final int numberOfShips=5;
    public void drawField() {
        System.out.println("**** Welcome to Battle Ships Game! ****");
        System.out.println("Battle field empty!");
        System.out.print("   0123456789\n");
        for (int i = 0; i < field.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == null||field[i][j]=="2") {
                    System.out.print(" ");
                } else {
                    System.out.print("@");
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

    public void deployComputerShips(){
        int i=1;
        while (i<=numberOfShips){
            int x=new Random().nextInt(10);
            int y=new Random().nextInt(10);
            if (isAvailable(x,y)){
                recordComputerShip(x,y);
                System.out.println("Computer Ship # "+i+"Deployed");
                i++;
            }
        }

    }
    public boolean isValid(int x,int y){
    return x < field.length && x >= 0 && y < field.length && y >= 0;
    }
    public boolean isAvailable(int x, int y) {
        if (isValid(x,y)){
            return (field[x][y].equals("@") || (field[x][y].equals("2")));
        } else {
            return false;
        }

    }

}