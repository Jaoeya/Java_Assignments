/*
 * This java class models the sheep class
 * The sheep can move according to the defined rules
 *
 *@author:Jiaxing Zhou
 *
 * Date: 10.12.2020
 *
 * */

import java.util.Random;

public class Sheep {

    private int sheepCol;
    private int sheepRow;
    private static final Random random=new Random();

    public int getSheepCol() {
        return sheepCol;
    }

    public void setSheepCol(int sheepCol) {
        this.sheepCol = sheepCol;
    }

    public int getSheepRow() {
        return sheepRow;
    }

    public void setSheepRow(int sheepRow) {
        this.sheepRow = sheepRow;
    }

    public Sheep(int sheepCol, int sheepRow) {
        this.sheepCol = sheepCol;
        this.sheepRow = sheepRow;
    }

    public void move(int dogRow, int dogCol) {
        int ranNumber;
        // if sheep and dog in the same square at the start of the run
        if (sheepRow == dogRow && sheepCol == dogCol) {
            if (sheepRow == 1 || sheepRow == DisplayGame.GRID_SIZE) {
                if(sheepCol==1||sheepCol==DisplayGame.GRID_SIZE){
                    if(sheepRow==1&&sheepCol==1){
                        ranNumber=random.nextInt(2);
                        if(ranNumber==0){
                            sheepRow++;
                        }else{
                            sheepCol++;
                        }
                    }
                    if(sheepRow==1&&sheepCol==DisplayGame.GRID_SIZE){
                        ranNumber=random.nextInt(2);
                        if(ranNumber==0){
                            sheepRow++;
                        }else{
                            sheepCol--;
                        }
                    }
                    if(sheepRow==DisplayGame.GRID_SIZE&&sheepCol==1){
                        ranNumber=random.nextInt(2);
                        if(ranNumber==0){
                            sheepRow--;
                        }else{
                            sheepCol++;
                        }
                    }
                    if(sheepRow==DisplayGame.GRID_SIZE&&sheepCol==DisplayGame.GRID_SIZE){
                        ranNumber=random.nextInt(2);
                        if(ranNumber==0){
                            sheepRow--;
                        }else{
                            sheepCol--;
                        }
                    }
                }else{
                    ranNumber=random.nextInt(3);
                    switch (ranNumber){
                        case 0:
                            sheepCol--;
                            break;
                        case 1:
                            sheepCol++;
                            break;
                        case 2:
                            if(sheepRow==1){
                                sheepRow++;
                            } else{
                                sheepRow--;
                            }
                            break;
                    }
                }
            }else {
                if(sheepCol!=1&&sheepCol!=DisplayGame.GRID_SIZE) {
                    ranNumber = random.nextInt(4);
                    switch (ranNumber) {
                        case 0:
                            sheepRow--;
                            break;
                        case 1:
                            sheepRow++;
                            break;
                        case 2:
                            sheepCol--;
                            break;
                        case 3:
                            sheepCol++;
                            break;
                    }
                }else{
                    ranNumber=random.nextInt(3);
                    switch (ranNumber){
                        case 0:
                            sheepRow--;
                            break;
                        case 1:
                            sheepRow++;
                            break;
                        case 2:
                            if(sheepCol==1) {
                                sheepCol++;
                            } else{
                                sheepCol--;
                            }
                            break;
                    }
                }
            }
            return;
        }

        ranNumber = random.nextInt(6) + 1;
        //if sheep in the range of 1-3
        if (ranNumber <= 3) {
            if (sheepRow - dogRow < 0) {
                if (sheepCol - dogCol > 0) {
                    if(sheepRow!=1){
                        if(sheepCol!=DisplayGame.GRID_SIZE){
                            ranNumber = random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepCol++;
                                    break;
                                case 1:
                                    sheepRow--;
                                    break;
                            }
                        }else{
                            sheepRow--;
                        }
                    }else{
                        if(sheepCol==DisplayGame.GRID_SIZE){
                            return;
                        }else{
                            sheepCol++;
                        }
                    }
                } else if (sheepCol - dogCol < 0) {
                    if(sheepRow!=1){
                        if(sheepCol!=1){
                            ranNumber = random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepCol--;
                                    break;
                                case 1:
                                    sheepRow--;
                                    break;
                            }
                        }else{
                            sheepRow--;
                        }
                    }else{
                        if(sheepCol==1){
                            return;
                        }else{
                            sheepCol--;
                        }
                    }
                }else {
                    if(sheepRow!=1){
                        sheepRow--;
                    }else {
                        if(sheepCol==1){
                            sheepCol++;
                        }else if(sheepCol==DisplayGame.GRID_SIZE){
                            sheepCol--;
                        } else{
                            ranNumber=random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepCol--;
                                    break;
                                case 1:
                                    sheepCol++;
                                    break;
                            }
                        }
                    }
                }
            } else if (sheepRow - dogRow > 0) {
                if (sheepCol - dogCol > 0) {
                    if(sheepRow!=DisplayGame.GRID_SIZE){
                        if(sheepCol!=DisplayGame.GRID_SIZE){
                            ranNumber = random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepCol++;
                                    break;
                                case 1:
                                    sheepRow++;
                                    break;
                            }
                        }else{
                            sheepRow++;
                        }
                    }else{
                        if(sheepCol==DisplayGame.GRID_SIZE){
                            return;
                        }else{
                            sheepCol++;
                        }
                    }
                } else if (sheepCol - dogCol < 0) {
                    if(sheepRow!=DisplayGame.GRID_SIZE){
                        if(sheepCol!=1){
                            ranNumber = random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepCol--;
                                    break;
                                case 1:
                                    sheepRow++;
                                    break;
                            }
                        }else{
                            sheepRow++;
                        }
                    }else{
                        if(sheepCol==1){
                            return;
                        }else{
                            sheepCol--;
                        }
                    }
                }else {
                    if(sheepRow!=DisplayGame.GRID_SIZE){
                        sheepRow++;
                    }else {
                        if(sheepCol==1){
                            sheepCol++;
                        }else if(sheepCol==DisplayGame.GRID_SIZE){
                            sheepCol--;
                        } else{
                            ranNumber=random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepCol--;
                                    break;
                                case 1:
                                    sheepCol++;
                                    break;
                            }
                        }
                    }
                }
            }else{
                if (sheepCol < dogCol) {
                    if(sheepCol!=1){
                        sheepCol--;
                    }else{
                        if(sheepRow==1){
                            sheepRow++;
                        }else if(sheepRow==DisplayGame.GRID_SIZE){
                            sheepRow--;
                        } else{
                            ranNumber = random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepRow--;
                                    break;
                                case 1:
                                    sheepRow++;
                                    break;
                            }
                        }
                    }
                }else{
                    if(sheepCol!=DisplayGame.GRID_SIZE){
                        sheepCol++;
                    }else{
                        if(sheepRow==1){
                            sheepRow++;
                        }else if(sheepRow==DisplayGame.GRID_SIZE){
                            sheepRow--;
                        } else{
                            ranNumber = random.nextInt(2);
                            switch (ranNumber) {
                                case 0:
                                    sheepRow--;
                                    break;
                                case 1:
                                    sheepRow++;
                                    break;
                            }
                        }
                    }
                }
            }
        }

        //if sheep get  4 or DisplayGame.GRID_SIZE
        if (ranNumber == 4 || ranNumber == DisplayGame.GRID_SIZE) {
            if (dogRow == 1) {
                if (dogCol == 1) {
                    ranNumber = random.nextInt(2);
                    if (ranNumber == 0) {
                        sheepRow = dogRow;
                        sheepRow = dogCol+1;
                    } else {
                        sheepRow = dogRow + 1;
                        sheepRow = dogCol;
                    }
                }else if (dogCol == DisplayGame.GRID_SIZE) {
                    ranNumber = random.nextInt(2);
                    if (ranNumber == 0) {
                        sheepRow = dogRow;
                        sheepRow = dogCol - 1;
                    }else{
                        sheepRow = dogRow + 1;
                        sheepRow = dogCol;
                    }
                }else{
                    ranNumber = random.nextInt(3);
                    switch (ranNumber) {
                        case 0:
                            sheepRow = dogRow;
                            sheepCol = dogCol - 1;
                            break;
                        case 1:
                            sheepRow = dogRow + 1;
                            sheepCol = dogCol;
                            break;
                        case 2:
                            sheepRow = dogRow;
                            sheepCol = dogCol + 1;
                            break;
                    }
                }
            }else if (dogRow == DisplayGame.GRID_SIZE) {
                if (dogCol == 1) {
                    ranNumber = random.nextInt(2);
                    if (ranNumber == 0) {
                        sheepRow = dogRow;
                        sheepCol = dogCol+1;
                    } else {
                        sheepRow = dogRow - 1;
                        sheepCol = dogCol;
                    }
                } else if (dogCol == DisplayGame.GRID_SIZE) {
                    ranNumber = random.nextInt(2);
                    if (ranNumber == 0) {
                        sheepRow = dogRow;
                        sheepRow = dogCol - 1;
                    }else {
                        sheepRow = dogRow - 1;
                        sheepRow = dogCol;
                    }
                }else {
                    ranNumber = random.nextInt(3);
                    switch (ranNumber) {
                        case 0:
                            sheepRow = dogRow;
                            sheepCol = dogCol - 1;
                            break;
                        case 1:
                            sheepRow = dogRow - 1;
                            sheepCol = dogCol;
                            break;
                        case 2:
                            sheepRow = dogRow;
                            sheepCol = dogCol + 1;
                            break;
                    }
                }
            }else {
                if (dogCol == 1 || dogCol == DisplayGame.GRID_SIZE) {
                    ranNumber = random.nextInt(3);
                    switch (ranNumber) {
                        case 0:
                            sheepRow = dogRow - 1;
                            sheepCol = dogCol;
                            break;
                        case 1:
                            sheepRow = dogRow;
                            if (dogCol == 1) {
                                sheepCol = dogCol + 1;
                            } else {
                                sheepCol = dogCol - 1;
                            }
                            break;
                        case 2:
                            sheepRow = dogRow + 1;
                            sheepCol = dogCol;
                            break;
                    }
                }else {
                    ranNumber = random.nextInt(4);
                    switch (ranNumber) {
                        case 0:
                            sheepRow = dogRow - 1;
                            sheepCol = dogCol;
                            break;
                        case 1:
                            sheepRow = dogRow + 1;
                            sheepCol = dogCol;
                            break;
                        case 2:
                            sheepRow = dogRow;
                            sheepCol = dogCol - 1;
                            break;
                        case 3:
                            sheepRow = dogRow;
                            sheepCol = dogCol + 1;
                            break;
                    }
                }
            }
        }
        if (ranNumber == 6) {
            setSheepRow(dogRow);
            setSheepCol(dogCol);
        }
    }
    //compare if sheep in the same square
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheep sheep = (Sheep) o;
        return this.sheepCol == sheep.sheepCol &&
                this.sheepRow == sheep.sheepRow;
    }
}
