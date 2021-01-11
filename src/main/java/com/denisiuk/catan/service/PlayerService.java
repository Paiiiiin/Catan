package com.denisiuk.catan.service;

import com.denisiuk.catan.entity.Player;
import com.denisiuk.catan.repository.IPlayerService;
import com.denisiuk.catan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> listAll(){
        return playerRepository.findAll();
    }

    public void save(Player player){
    }

    public Player getPlayer(Integer id){
        return playerRepository.findById(id).get();
    }
}
