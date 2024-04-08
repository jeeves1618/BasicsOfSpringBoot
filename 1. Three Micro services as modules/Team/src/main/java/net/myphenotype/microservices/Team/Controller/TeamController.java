package net.myphenotype.microservices.Team.Controller;

import net.myphenotype.microservices.Team.Entity.Team;
import net.myphenotype.microservices.Team.Repository.TeamRepository;
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
    TeamRepository teamRepository;

    @GetMapping(value = "/team")
    public ResponseEntity<Team> getTeamByParam(@RequestParam int teamId){
        try {
            Team team = teamRepository.findById(teamId).get();
            return ResponseEntity.status(HttpStatus.OK).body(team);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping(value = "/team/all")
    public ResponseEntity<List<Team>> getTeams(){
        try {
            List<Team> teams = teamRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(teams);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping(value = "/team/{teamId}")
    public ResponseEntity<Team> getTeamByPath(@PathVariable int teamId){
        try {
            Team team = teamRepository.findById(teamId).get();
            return ResponseEntity.status(HttpStatus.OK).body(team);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PostMapping(value = "/team")
    public ResponseEntity<Team> addTeam(@RequestBody Team team){
        Team teamAdded = teamRepository.save(team);
        return ResponseEntity.status(HttpStatus.OK).body(teamAdded);
    }

    @PutMapping(value = "/team")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team){
        Team teamUpdated = teamRepository.save(team);
        return ResponseEntity.status(HttpStatus.OK).body(teamUpdated);
    }

    @PutMapping(value = "/team/addMatch/{teamId}")
    public ResponseEntity<Team> addMatch(@PathVariable int teamId){
        try {
            Team teamToBeUpdated = teamRepository.findById(teamId).get();
            teamToBeUpdated.setMatchesPlayed(teamToBeUpdated.getMatchesPlayed()+1);
            Team teamUpdated = teamRepository.save(teamToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(teamUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping(value = "/team/addWin/{teamId}")
    public ResponseEntity<Team> addWin(@PathVariable int teamId){
        try {
            Team teamToBeUpdated = teamRepository.findById(teamId).get();
            teamToBeUpdated.setMatchesWon(teamToBeUpdated.getMatchesWon()+1);
            Team teamUpdated = teamRepository.save(teamToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(teamUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping(value = "/team/addMatchWin/{teamId}")
    public ResponseEntity<Team> addMatchesWins(@PathVariable int teamId){
        try {
            Team teamToBeUpdated = teamRepository.findById(teamId).get();
            teamToBeUpdated.setMatchesWon(teamToBeUpdated.getMatchesWon()+1);
            teamToBeUpdated.setMatchesPlayed(teamToBeUpdated.getMatchesPlayed()+1);
            Team teamUpdated = teamRepository.save(teamToBeUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(teamUpdated);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @DeleteMapping(value = "/team/{teamId}")
    public ResponseEntity<String> deletePlayer(@PathVariable int teamId){
        try {

            teamRepository.deleteById(teamId);
            return ResponseEntity.status(HttpStatus.OK).body("Team Id " + teamId + " scheduled for deletion");
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body("Team Id " + teamId + " is not available");
        }
    }
}
