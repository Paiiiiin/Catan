package com.denisiuk.catan.entity;

import com.denisiuk.catan.service.BoardService;
import com.denisiuk.catan.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
public class Board {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private BoardService boardService;

    int boardDataArray[][] =
               // 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20   (1,2,3,4)= players,
           /*0*/{{0, 0, 0, 0, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 0, 0, 0, 0}, //7=road, 5=node,
           /* 1*/{0, 0, 0 ,0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 0, 0, 0}, //6=resource
           /* 2*/{0, 0, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 0, 0}, //0=ignore
           /* 3*/{0, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 0},
           /* 4*/{5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5},
           /* 5*/{7, 0, 6, 0, 7, 0 ,6, 0, 7, 0, 0, 0 ,7, 0, 6, 0, 7, 0, 6, 0, 7},
           /* 6*/{5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5},
           /* 7*/{0, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 0},
           /* 8*/{0, 0, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 0, 0},
           /* 9*/{0, 0, 0 ,0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 6, 0, 7, 0, 0, 0, 0},
           /*10*/{0, 0, 0, 0, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 0, 0, 0, 0}};

    int addressArray[][] = {{1, 1,  1,  3, 3, 3,  3,  5, 5, 5,  5,  7, 7, 7,  7,  9, 9, 9, 9},
            {6, 10, 14, 4, 8, 12, 16, 2, 6, 14, 18, 4, 8, 12, 16, 6, 10, 14}};

    Map<String, Integer> resourceMap = new HashMap<String, Integer>();



    boolean check = true;

    int address[][] = new int[2][1];

    boolean firstRound = true;

    boolean playerBuild = true;

    boolean success = false;

    boolean switcher = false;

    int whileCounter =0;

    public boolean freeCity(int column, int row){
        System.out.println("__________________________________");
        System.out.println("begin of free city");

        System.out.println(Arrays.toString(boardService.getNumberArray()));
        boardService.getPlayerList();
        System.out.println("playerList size is " + boardService.getPlayerList().size());
        System.out.println("order is:");
        System.out.println("iWhile = " + whileCounter);
        //for (int i=0; i<4; i++){
        //    System.out.println("player " + boardService.playerList.get(i).getPlayer_id());
        //}

        while (playerBuild == true) {
                System.out.println("turn of player " + boardService.playerList.get(whileCounter).getPlayer_id());
            if (checkBoardDataArray(column, row) == true) {
                boardDataArray[column][row] = boardService.playerList.get(whileCounter).getPlayer_id();
                System.out.println(column + " " + row + "| owner: player " + boardService.playerList.get(whileCounter).getPlayer_id());
                countResourcesFreeCity(column, row);
                success = true;
                //return check = true;
            }else
                System.out.println("do it again player " + boardService.playerList.get(whileCounter).getPlayer_id());
            if (success == true){

                if (switcher ==  true){
                    whileCounter = whileCounter - 1;
                }
                if (whileCounter == 3) {
                    switcher = true;
                }
                if (switcher == false && whileCounter != 3){
                    whileCounter = whileCounter + 1;
                }
                success =false;
            }
            if (switcher == true && whileCounter < 0){
                playerBuild = false;
                System.out.println("should be false | " + playerBuild);
            }else {
                break;
            }
        }
        System.out.println(whileCounter);
        System.out.println("end of free city");
        System.out.println("_____________________________________");
        return check=true;
    }

    public boolean freeBuildLoop(int column, int row){

        return true;
    }

    public boolean checkBoardDataArray(int column, int row){
        System.out.println("begin of board checking");

        if (checkOwner(column, row) == false){
            return false;
        }
        if(column != 0 && boardDataArray[colUp(column)][row] == 7){
            check = checkOwner(column - 2, row);
            System.out.println("colUp " + (column-2) + " " + row);
        }
        if(column !=10 && boardDataArray[colDown(column)][row] == 7){
            check = checkOwner(column + 2, row);
            System.out.println("colDown " + (column+2) + " " + row);
        }
        if(row != 0 && boardDataArray[column][rowLeft(row)] == 7){
            check = checkOwner(column, row - 2);
            System.out.println("rowLeft " + column + " " + (row-2));
        }
        if(row != 20 && boardDataArray[column][rowRight(row)] == 7){
            check = checkOwner(column , row + 2);
            System.out.println("rowRight " + column + " " + (row+2));
        }
        return check;
    }

    public void checkFreeResources(int column, int row){
        if (boardDataArray[column][row] == 6){
            for (int i=0; i<18; i++){
                if (column == boardDataArray[0][i] && row == boardDataArray[1][i])
                    addResources(i);
                    break;
            }
        }
    }

    public int addResources(int i){
        Player player = new Player();
        boardService.getNumberArray();
        boardService.getResourceList();
        int temp = 1;
        player.setPlayer_id(playerService.getPlayer(1).getPlayer_id());
        player.setStone(player.getStone() + temp);
        return i;
    }

    public void addStone(){
        int i = 1;
        int stone = playerService.getPlayer(i).getStone();
    }

    public int countResourcesFreeCity(int column, int row) {
        if (column != 0) {
            checkFreeResources(column-1, row);
            checkFreeResources(column-1, row - 1);
            checkFreeResources(column-1, row + 1);
            checkFreeResources(column+1, row);
            checkFreeResources(column+1, row - 1);
            checkFreeResources(column+1, row + 1);
        }else {
            checkFreeResources(column-1, row);
            checkFreeResources(column-1, row - 1);
            checkFreeResources(column-1, row + 1);
        }

        if (column != 10) {
            checkFreeResources(column-1, row);
            checkFreeResources(column-1, row - 1);
            checkFreeResources(column-1, row + 1);
            checkFreeResources(column+1, row);
            checkFreeResources(column+1, row-1);
            checkFreeResources(column+1, row+1);
        }else {
            checkFreeResources(column+1, row);
            checkFreeResources(column+1, row - 1);
            checkFreeResources(column+1, row + 1);
        }



            return 1;
        }

    public int colUp(int column){
        return column - 1;
    }
    public int colDown(int column){
        return column + 1;
    }
    public int rowLeft(int row){
        return row - 1;
    }
    public int rowRight(int row){
        return row + 1;
    }

    public boolean checkOwner(int column, int row){
        if (boardDataArray[column][row]  != 5){
            System.out.println(boardDataArray[column][row]);
            System.out.println(column + " " + row + " is occupied");
            return false;
        }
        return check;
    }

    public void setCityDataArrayValue(int column, int row) {
        playerService.getPlayer(1);
        boardDataArray[column][row] = -1;
        System.out.println(column + " " + row + "| owner: " + boardDataArray[column][row]);
    }
    public int getBoardDataArrayValue(int column, int row) {
        return boardDataArray[column][row];
    }

    public boolean isFirstRound() {
        return firstRound;
    }

    public int checkAddressArray(int column, int row){
        boolean switcher = true;
        int i=0;
        while (switcher == true){
            if (column == addressArray[i][i] && row == addressArray[i][i] ){
                switcher = false;
            }
            i++;
        }

        return 1;
    }
}