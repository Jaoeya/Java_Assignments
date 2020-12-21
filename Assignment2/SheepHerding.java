/*
 * The Entry point of the Java Program
 * This class SheepHerding models a sheep herding game
 *
 * @author:Jiaxing Zhou
 * Date: 10.12.2020
 * */

import sheffield.EasyReader;


public class SheepHerding {

    private static Sheep[] sheeps=null;
    private static int dogRow;
    private static int dogCol;
    private static boolean  isOver=false;
    private static EasyReader reader=new EasyReader();
    private static DisplayGame displayGame=new DisplayGame();

    public static void main(String[] args) {
        startGame();
    }


    public static void startGame(){
        sheeps=displayGame.getSheeps();
        while(!isOver) {
            System.out.print("Please enter new dog row:");
            dogRow = inputInteger("Please enter new dog row:");
            System.out.print("Please enter new dog column (0 to quit):");
            dogCol = inputInteger("Please enter new dog column (0 to quit):");
            if (dogCol == 0) {
                System.out.println("User quit");
                System.exit(0);
            }
            System.out.println("Moving Sheep");
            moveSheep();
            displayGame.redrawDisplay(dogRow,dogCol);
            isOver = displayGame.isInOneSquare();

            if (isOver) {
                System.out.println("All sheep in one square!");
            }
        }
    }

    public static void moveSheep(){
        for (Sheep sheep:sheeps) {
            sheep.move(dogRow, dogCol);
        }
    }

    // first check if inputString is consisted of number and then transfer the inputstring to number
    // then to see if the number in the right range(inside GRID_SIZE)
    public static int inputInteger(String inputRowOrCol){
        int returnInteger =0;
        boolean isValidNumber=false;
        String inputString;

        while(!isValidNumber){
                inputString = reader.readString();
                boolean isInteger=inputString.matches("[0-9]+");

                if(isInteger){
                    returnInteger=Integer.parseInt(inputString);
                    if("Please enter new dog row:".equals(inputRowOrCol)){
                        if (returnInteger >= 1 && returnInteger <= DisplayGame.GRID_SIZE){
                            isValidNumber = true;
                        }else{
                            System.out.println("Please enter new dog row between 1 and 5:");
                        }
                    }

                    if ("Please enter new dog column (0 to quit):".equals(inputRowOrCol)){
                        if (returnInteger >= 0 && returnInteger <= DisplayGame.GRID_SIZE){
                            isValidNumber = true;
                        }else{
                            System.out.println("Please enter new dog Column(0 quit) between 1 and 5:");
                        }
                    }
                }else{
                    System.out.println("Please input Integer");
                }
        }
        return returnInteger;
    }
}
