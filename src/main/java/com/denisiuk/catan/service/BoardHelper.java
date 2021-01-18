package com.denisiuk.catan.service;

import com.denisiuk.catan.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardHelper {

    @Autowired
    private PlayerService playerService;

    public void chooseResource(int id, String resourceName, int amount){

        switch (resourceName) {
            case "stone" -> addStone(id, amount);
            case "sheep" -> addSheep(id, amount);
            case "grain" -> addGrain(id, amount);
            case "wood" -> addWood(id, amount);
            case "ore" -> addOre(id, amount);
        }
    }

    public void addStone(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setStone(amount + player.getStone());
        saveResources(player);
    }
    public void addSheep(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setSheep(amount + player.getSheep());
        saveResources(player);
    }
    public void addGrain(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setSheep(amount + player.getGrain());
        saveResources(player);
    }
    public void addWood(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setWood(amount + player.getWood());
        saveResources(player);
    }
    public void addOre(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setOre(amount + player.getOre());
        saveResources(player);
    }

    public void saveResources(Player player){
        playerService.save(player);
    }
}