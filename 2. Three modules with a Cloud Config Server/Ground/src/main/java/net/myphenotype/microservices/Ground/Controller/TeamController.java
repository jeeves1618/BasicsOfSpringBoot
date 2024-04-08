package net.myphenotype.microservices.Ground.Controller;

import net.myphenotype.microservices.Ground.Entity.Ground;
import net.myphenotype.microservices.Ground.Repository.GroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = {"/api","/ipl"})
public class TeamController {

    @Autowired
    GroundRepository groundRepository;

    @GetMapping(value = "/ground")
    public ResponseEntity<Ground> getTeamByParam(@RequestParam int groundId){
        try {
            Ground ground = groundRepository.findById(groundId).get();
            return ResponseEntity.status(HttpStatus.OK).body(ground);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping(value = "/ground/all")
    public ResponseEntity<List<Ground>> getTeams(){
        try {
            List<Ground> grounds = groundRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(grounds);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping(value = "/ground/{groundId}")
    public ResponseEntity<Ground> getTeamByPath(@PathVariable int groundId){
        try {
            Ground ground = groundRepository.findById(groundId).get();
            return ResponseEntity.status(HttpStatus.OK).body(ground);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PostMapping(value = "/ground")
    public ResponseEntity<Ground> addTeam(@RequestBody Ground ground){
        Ground groundAdded = groundRepository.save(ground);
        return ResponseEntity.status(HttpStatus.OK).body(groundAdded);
    }

    @PutMapping(value = "/ground")
    public ResponseEntity<Ground> updateTeam(@RequestBody Ground ground){
        Ground groundUpdated = groundRepository.save(ground);
        return ResponseEntity.status(HttpStatus.OK).body(groundUpdated);
    }

    @PutMapping(value = "/ground/addCapacity/{groundId}")
    public ResponseEntity<Ground> addMatch(@PathVariable int groundId){
        try {
            Ground groundToBeUpdated = groundRepository.findById(groundId).get();
            groundToBeUpdated.setGroundCapacity(groundToBeUpdated.getGroundCapacity()+1);
            Ground groundUpdated = groundRepository.save(groundToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(groundUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping(value = "/ground/updateAvailability/{groundId}")
    public ResponseEntity<Ground> addWin(@PathVariable int groundId){
        try {
            Ground groundToBeUpdated = groundRepository.findById(groundId).get();
            groundToBeUpdated.setAvailableSeats(groundToBeUpdated.getAvailableSeats()+1);
            Ground groundUpdated = groundRepository.save(groundToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(groundUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping(value = "/ground/addMatchWin/{groundId}")
    public ResponseEntity<Ground> addMatchesWins(@PathVariable int groundId){
        try {
            Ground groundToBeUpdated = groundRepository.findById(groundId).get();
            groundToBeUpdated.setGroundCapacity(groundToBeUpdated.getGroundCapacity()+1);
            groundToBeUpdated.setAvailableSeats(groundToBeUpdated.getAvailableSeats()+1);
            Ground groundUpdated = groundRepository.save(groundToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(groundUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @DeleteMapping(value = "/ground/{groundId}")
    public ResponseEntity<String> deletePlayer(@PathVariable int groundId){
        try {

            groundRepository.deleteById(groundId);
            return ResponseEntity.status(HttpStatus.OK).body("Team Id " + groundId + " scheduled for deletion");
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body("Team Id " + groundId + " is not available");
        }
    }
}
