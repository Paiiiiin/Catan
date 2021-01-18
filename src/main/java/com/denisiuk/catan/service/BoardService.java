package com.denisiuk.catan.service;

import com.denisiuk.catan.entity.Board;
import com.denisiuk.catan.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BoardService {


    @Autowired
    private PlayerService playerService;

    @Autowired
    private Board board;

    @Autowired
    private BoardHelper boardHelper;

    int playerCount;

    int dice;

    String endl="\n";

    String[] resourceArray = {"stone", "stone", "stone", "ore", "ore", "ore", "grain", "grain", "grain", "grain",
            "wood", "wood", "wood", "wood", "sheep", "sheep", "sheep", "sheep"};

    List<String> resourceList = new ArrayList<>();

    public List<Player> playerList = new LinkedList<>();

    int[][] mapArray = {{5, 2,  6,  3, 8, 10, 9, 12, 11,4,  8, 10, 9, 4,  5,  6, 11, 3},
                        {1, 1,  1,  3, 3, 3,  3,  5, 5, 5,  5,  7, 7, 7,  7,  9, 9,  9},
                        {6, 10, 14, 4, 8, 12, 16, 2, 6, 14, 18, 4, 8, 12, 16, 6, 10, 14}};

    public List initializeBoard(){
        for (int i=0; i<resourceArray.length; i++){
            resourceList.add(resourceArray[i]);
        }
        Collections.shuffle(resourceList);

        return resourceList;
    }

    public void countResources(){
        int column;
        int row;
        for (int i=0; i<18; i++)
            if (getDice() == mapArray[0][i]){
                column = mapArray[1][i];
                row = mapArray[2][i];
                if (board.checkOwner(column - 1, row)){
                    boardHelper.chooseResource(board.getBoardDataArrayValue(column -1, row), resourceList.get(i), 1);
                }
                if (board.checkOwner(column - 1, row - 2)){
                    boardHelper.chooseResource(board.getBoardDataArrayValue(column -1, row), resourceList.get(i), 1);
                }
                if (board.checkOwner(column - 1, row + 2)){
                    boardHelper.chooseResource(board.getBoardDataArrayValue(column -1, row +2), resourceList.get(i), 1);
                }
                if (board.checkOwner(column + 1, row)){
                    boardHelper.chooseResource(board.getBoardDataArrayValue(column +1, row), resourceList.get(i), 1);
                }
                if (board.checkOwner(column + 1, row - 2)){
                    boardHelper.chooseResource(board.getBoardDataArrayValue(column +1, row -2), resourceList.get(i), 1);
                }
                if (board.checkOwner(column + 1, row + 2)){
                    boardHelper.chooseResource(board.getBoardDataArrayValue(column +1, row +2), resourceList.get(i), 1);
                }

            }else {
                thief();
            }
    }

    public List<Player> checkOrder(){
        System.out.println("________________________________");
        System.out.println("hello from checkOrder");
        boolean switcher = false;
        int counter = 0;
        setPlayerCount(4);
            int[][] order = {{0, 0, 0, 0}, {1, 2, 3, 4}};
            for (int i=1; i<5; i++){
            diceRoll();
            order[0][i-1]=getDice();
            System.out.println("player " + i + " rolled " + getDice());
        }
        while (!switcher) {
            for (int i = 0; i < 4; i++) {
                for (int j = i +1; j < 4; j++) {
                    System.out.println(order[0][i] + " | " + order[0][j] + " ||| " + (i+1) + " | " + (j+1));
                    if (order[0][i] == order[0][j]) {
                        System.out.println("___________________________________");
                        System.out.println("reroll for player "+ (i+1) +" and " +(j+1));
                        counter = 1;
                        diceRoll();
                        order[0][i] = getDice();
                        System.out.println("player " + (i+1) + " rolled " + getDice());
                        diceRoll();
                        order[0][j] = getDice();
                        System.out.println("player " + (j+1) + " rolled " + getDice());
                        System.out.println("____________________________________");
                    }
                }
            }
            System.out.println("counter= " + counter);
            System.out.println();
            if (counter == 0)
                switcher = true;
            if (counter == 1)
                counter = 0;
        }
        System.out.println("______________________________________");
        for (int i=0; i<4; i++){
            System.out.println("player " + (i+1) + " rolled " + order[0][i]);
        }
        System.out.println("end of loop");
        System.out.println("______________________________________");
        for(int i=0; i<4; i++){
            int temp1;
            int temp2;
            int temp3;
            int temp4;
            for (int j=1; j<4-i; j++){
                if (order[0][j-1]<order[0][j]) {
                    temp1 = order[0][j];
                    temp2 = order[0][j-1];
                    temp3 = order[1][j];
                    temp4 = order[1][j-1];
                    order[0][j-1] = temp1;
                    order[1][j-1] = temp3;
                    order[0][j] = temp2;
                    order[1][j] = temp4;
                }
            }
        }
        System.out.println("order is:");
        for (int i=0; i<4; i++){
            playerList.add(playerService.getPlayer(order[1][i]));
            System.out.println("player " + playerList.get(i).getPlayer_id()  + " rolled " + order[0][i]);
        }
        System.out.println("goodbye from checkOrder");
        System.out.println("____________________________");
        setPlayerList(playerList);

        return playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void diceRoll(){
        Random random = new Random();
        setDice(dice=random.nextInt(11)+2);
    }

    public void thief(){

    }
    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDice() {
        return dice;
    }

    public List<String> getResourceList() {

        return resourceList;
    }

    public String getResourceListValue(int i){

        return resourceList.get(i);
    }

    public String getEndl() {
        return endl;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int[][] getMapArray() {
        return mapArray;
    }
}