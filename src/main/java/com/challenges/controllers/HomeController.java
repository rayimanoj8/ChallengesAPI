package com.challenges.controllers;

import com.challenges.models.Challenge;
import com.challenges.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
    @Autowired
    private ChallengeService cs;


    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(cs.getAllChallenges(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = cs.addChallenge(challenge);
        if(isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Challenge not added successfully", HttpStatus.NOT_ACCEPTABLE);
    }


    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallengesByMonth(@PathVariable("month") String month) {
       Challenge c =  cs.getChallengeByMonth(month);
       if(c != null)
           return new ResponseEntity<>(c, HttpStatus.OK);
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable("id") Long id, @RequestBody Challenge challenge) {
        boolean isUpdated = cs.updateChallenge(id,challenge);
        if(isUpdated)
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Challenge not updated successfully", HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable("id") Long id) {
        boolean isDeleted = cs.deleteChallenge(id);
        if(isDeleted)
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Challenge not deleted successfully", HttpStatus.NOT_IMPLEMENTED);
    }
}