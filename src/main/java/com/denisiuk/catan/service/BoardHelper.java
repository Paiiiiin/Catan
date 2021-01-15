package com.denisiuk.catan.service;

import com.denisiuk.catan.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardHelper {

    @Autowired
    private PlayerService playerService;

    public String addStone(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setStone(amount + player.getStone());
        return saveResources(player);
    }
    public String addSheep(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setSheep(amount + player.getSheep());
        return saveResources(player);
    }
    public String addGrain(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setSheep(amount + player.getGrain());
        return saveResources(player);
    }
    public String addWood(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setWood(amount + player.getWood());
        return saveResources(player);
    }
    public String addOre(int id, int amount){
        Player player = playerService.getPlayer(id);
        player.setOre(amount + player.getOre());
        return saveResources(player);
    }

    public String saveResources(Player player){
        playerService.save(player);
        return "resources added";
    }
}