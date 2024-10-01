package com.nseva.basic_auth.services;

import com.nseva.basic_auth.models.entities.Player;
import com.nseva.basic_auth.repos.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo repo;


    public Player save (Player player) {
        if (player.getId() != null) {
            player.setUsername(player.getUsername());
            player.setEmail(player.getEmail());
            player.setPassword(player.getPassword());
        }
        return repo.save(player);
    }

    public Player findById (Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Iterable<Player> findAll () {
        return repo.findAll();
    }
}
