/*
 * This java class displays the window
 * It  can display a 5*5 grid with 4 sheep randomly initially and one dog
 * and can update the position of sheep and dog in the grid
 * white ellipse represents sheep and black ellipse represents dog in the grid
 * sheep can move according to some rules and the position of dog at each run
 * the dog's position can be given by user
 *
 * @author: Jiaxing Zhou
 *
 * Date: 10.12.2020
 *
 * */
import sheffield.*;
import java.util.Random;

public class DisplayGame {
    private final Sheep[] sheeps=new Sheep[4];
    private final EasyGraphics easyGraphics=new EasyGraphics(600,600);
    private static Random random=new Random();
    public static final int GRID_SIZE=5;

    public DisplayGame(){
        initialDisplay();
        //initiate the sheep randomly
        for(int sheepNumber=0;sheepNumber<=3;sheepNumber++){
            sheeps[sheepNumber]=new Sheep(random.nextInt(GRID_SIZE)+1,random.nextInt(GRID_SIZE)+1);
        }
        drawSheep();
    }

    public void initialDisplay(){
        easyGraphics.setColor(0,200,0);
        // Set the grid size 400*400;
        easyGraphics.fillRectangle(100,100,400,400);
        easyGraphics.setColor(0,0,0);
        //draw line for gird
        for (int lineNumber=0;lineNumber<=GRID_SIZE;lineNumber++) {
            easyGraphics.moveTo(100+400/GRID_SIZE * lineNumber,100);
            easyGraphics.lineTo(100+400/GRID_SIZE * lineNumber,500);
            easyGraphics.moveTo(100,100+400/GRID_SIZE * lineNumber);
            easyGraphics.lineTo(500 ,100+400/GRID_SIZE * lineNumber);
            // draw row and column number
            if(lineNumber>=1) {
                easyGraphics.drawString(String.valueOf(lineNumber), 140 + (lineNumber - 1) * 400/GRID_SIZE, 70, 15);
                easyGraphics.drawString(String.valueOf(lineNumber), 70, 140 + (lineNumber - 1) * 400/GRID_SIZE, 15);
            }

        }
        easyGraphics.drawString("Column",530,70,15);
        easyGraphics.drawString("Row",70,530,15);
        easyGraphics.drawString("SheepHerding",250,530,15);
    }

    public void drawSheep(){
        easyGraphics.setColor(255,255,255);
        for (int sheepsNumber = 0; sheepsNumber <= sheeps.length; sheepsNumber++) {
            // each sheep is placed in one corner of one square
            switch (sheepsNumber) {
                case 0:
                    easyGraphics.fillEllipse(110 + (sheeps[sheepsNumber].getSheepCol() - 1) * 400/GRID_SIZE,
                            155 + (sheeps[sheepsNumber].getSheepRow() - 1) * 400/GRID_SIZE, 20, 20);
                    break;
                case 1:
                    easyGraphics.fillEllipse(150 + (sheeps[sheepsNumber].getSheepCol() - 1) * 400/GRID_SIZE,
                            155 + (sheeps[sheepsNumber].getSheepRow() - 1) * 400/GRID_SIZE, 20, 20);
                    break;
                case 2:
                    easyGraphics.fillEllipse(110 + (sheeps[sheepsNumber].getSheepCol() - 1) * 400/GRID_SIZE,
                            110 + (sheeps[sheepsNumber].getSheepRow() - 1) * 400/GRID_SIZE, 20, 20);
                    break;
                case 3:
                    easyGraphics.fillEllipse(150 + (sheeps[sheepsNumber].getSheepCol() - 1) * 400/GRID_SIZE,
                            110 + (sheeps[sheepsNumber].getSheepRow() - 1) * 400/GRID_SIZE, 20, 20);
                    break;
                default:
                    return;
            }
        }
    }

    public void drawDog(int dogRow,int dogCol){
        //dog is placed in the center of one square
        easyGraphics.setColor(0,0,0);
        easyGraphics.fillEllipse(130+(dogCol-1)*400/GRID_SIZE, 130+(dogRow-1)*400/GRID_SIZE,20,20);
    }

    // update the position of sheep and dog
    public void redrawDisplay(int dogRow,int dogCol){
        easyGraphics.clear();
        initialDisplay();
        drawSheep();
        drawDog(dogRow,dogCol);
    }

    public boolean isInOneSquare(){
        return sheeps[0].equals(sheeps[1])&&sheeps[2].equals(sheeps[3])&&sheeps[1].equals(sheeps[2]);
    }

    public Sheep[] getSheeps(){
        return sheeps;
    }

    public int getGridSize(){return GRID_SIZE;}
}
