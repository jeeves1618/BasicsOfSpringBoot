package net.myphenotype.microservices.Player.Controller;

import net.myphenotype.microservices.Player.Entity.Player;
import net.myphenotype.microservices.Player.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = {"/api","/ipl"})
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping(value = "/player")
    public ResponseEntity<Player> getPlayerByParam(@RequestParam int playerId){
        try {
            Player player = playerRepository.findById(playerId).get();
            return ResponseEntity.status(HttpStatus.OK).body(player);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping(value = "/player/all")
    public ResponseEntity<List<Player>> getPlayers(){
        try {
            List<Player> players = playerRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(players);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping(value = "/player/{playerId}")
    public ResponseEntity<Player> getPlayerByPath(@PathVariable int playerId){
        try {
            Player player = playerRepository.findById(playerId).get();
            return ResponseEntity.status(HttpStatus.OK).body(player);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PostMapping(value = "/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player playerAdded = playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.OK).body(playerAdded);
    }

    @PutMapping(value = "/player")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player playerUpdated = playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.OK).body(playerUpdated);
    }

    @PutMapping(value = "/player/addRun/{playerId}")
    public ResponseEntity<Player> addRun(@PathVariable int playerId){
        try {
            Player playerToBeUpdated = playerRepository.findById(playerId).get();
            playerToBeUpdated.setRunsScored(playerToBeUpdated.getRunsScored()+1);
            Player playerUpdated = playerRepository.save(playerToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(playerUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping(value = "/player/addWicket/{playerId}")
    public ResponseEntity<Player> addWicket(@PathVariable int playerId){
        try {
            Player playerToBeUpdated = playerRepository.findById(playerId).get();
            playerToBeUpdated.setWicketsTaken(playerToBeUpdated.getWicketsTaken()+1);
            Player playerUpdated = playerRepository.save(playerToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(playerUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping(value = "/player/addRun/{playerId}/{runScored}")
    public ResponseEntity<Player> addRuns(@PathVariable int playerId, @PathVariable int runScored){
        try {
            Player playerToBeUpdated = playerRepository.findById(playerId).get();
            playerToBeUpdated.setRunsScored(playerToBeUpdated.getRunsScored()+runScored);
            Player playerUpdated = playerRepository.save(playerToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(playerUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @DeleteMapping(value = "/player/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable int playerId){
        try {

            playerRepository.deleteById(playerId);
            return ResponseEntity.status(HttpStatus.OK).body("Player Id " + playerId + " scheduled for deletion");
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body("Player Id " + playerId + " is not available");
        }
    }
}
