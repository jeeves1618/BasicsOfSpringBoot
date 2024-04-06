package net.myphenotype.microservices.Player.Controller;

import net.myphenotype.microservices.Player.Entity.Player;
import net.myphenotype.microservices.Player.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api","/ipl"})
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
    }

    @GetMapping(value = "/player")
    public ResponseEntity<Player> getPlayer(){
        Player player = playerRepository.findById(1).get();
        player.setPlayerId(1);
        player.setPlayerName("Devon Conway");
        player.setPlayerType("Batsmen");
        player.setRunsScored(4857);
        player.setWicketsTaken(23);
        player.setTeamCode("CSK");

        return ResponseEntity.status(HttpStatus.OK).body(player);
    }
}
