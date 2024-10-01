package com.nseva.basic_auth.controller;

import com.nseva.basic_auth.models.entities.Player;
import com.nseva.basic_auth.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Player save (@RequestBody Player player) {
        return playerService.save(player);
    }

    @GetMapping
    public Iterable<Player> getAll () {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Player getById (@PathVariable("id") Long id) {
        return playerService.findById(id);
    }
}
