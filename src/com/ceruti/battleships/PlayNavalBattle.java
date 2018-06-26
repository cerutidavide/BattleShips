package com.ceruti.battleships;
import java.util.Scanner;
public class PlayNavalBattle {
    public static void main(String[] argv){
        //TODO NASCONDERE LE NAVI DEL COMPUTER
        //TODO evitare di far fare al computer le mosse già fatte
        System.out.println();
        Battlefield play = new Battlefield(3, 3, 3);
        play.drawField(true);
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
        play.drawField(true);
        while (play.getPlayerShips() > 0 && play.getComputerShips() > 0) {
            System.out.println("Choose ROW");
            Scanner input = new Scanner(System.in);
            int row = input.nextInt();
            System.out.println("Choose COLUMN");
            int col = input.nextInt();
            if (play.isValid(row, col)) {
                play.setShotResult(row, col);
                play.drawField(true);
            } else {
                System.out.println("Invalid MOVE!");
            }

            int[] computerTurn = new int[2];
            computerTurn = play.getRandomShot();
            if (play.isValid(computerTurn[0], computerTurn[1])) {
                play.setComputerShotResult(computerTurn[0], computerTurn[1]);
                play.drawField(true);
            }
            System.out.println("Your turn!!!");
        }
        if (play.getPlayerShips() > play.getComputerShips()) {
            System.out.println("HAI VINTO!!");
        } else {
            System.out.println("HAI PERSO!!!");
        }
    }
}
