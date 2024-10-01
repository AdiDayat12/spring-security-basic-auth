package com.nseva.basic_auth.repos;

import com.nseva.basic_auth.models.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<Player, Long> {

}
