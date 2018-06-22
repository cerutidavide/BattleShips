package com.ceruti.battleships;
import java.util.Scanner;
public class PlayNavalBattle {
    public static void main(String[] argv){
        System.out.println();
        Battlefield play=new Battlefield();
        play.drawField();
        int toBeDeployedShips = Battlefield.numberOfShips;
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
        play.drawField();
        play.deployComputerShips();
        play.drawField();
    }
}
