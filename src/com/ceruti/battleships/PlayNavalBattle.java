package com.ceruti.battleships;
import java.util.Scanner;
public class PlayNavalBattle {
    public static void main(String[] argv){
        System.out.println();
        Battlefield play = new Battlefield(10, 10, 5);
        play.drawField(false);
        int toBeDeployedShips = play.getNumberOfShips();
        int deployedShips=1;
        while (toBeDeployedShips>0) {
            System.out.println("Dammi la x della prossima nave coordinate della prossima nave");
            Scanner input=new Scanner(System.in);
            int x=input.nextInt();
            System.out.println("Dammi la y della prossima nave coordinate della prossima nave");
            int y=input.nextInt();
            if ((play.isValid(x, y)) && (play.isAvailable(x, y))) {
                play.recordPlayerShip(x,y);
                System.out.println("Ship # "+deployedShips+"...Deployed");
                toBeDeployedShips--;
                deployedShips++;
            }else{
                System.out.println("Invalid ship placement please retry!");
            }
        }
        play.deployComputerShips();
        play.drawField(false);
        while (play.getPlayerShips() > 0 && play.getComputerShips() > 0) {
            System.out.println("Indovina la X");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            System.out.println("Indovina la Y");
            int y = input.nextInt();
            if (play.isValid(x, y)) {
                play.setShotResult(x, y);
            } else {
                System.out.println("Invalid ship placement please retry!");
            }
            play.drawField(false);
        }
    }
}
