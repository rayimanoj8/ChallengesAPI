package com.challenges.service;
import com.challenges.models.Challenge;
import com.challenges.repo.ChallengeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    @Autowired
    ChallengeRepo cr;
//    List<Challenge> challenges = new ArrayList<>();
    private Long id = 1L;
    public List<Challenge> getAllChallenges() {
        return cr.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        if(challenge == null)
            return false;
        challenge.setId(id++);
        cr.save(challenge);
        return true;
    }

    public Challenge getChallengeByMonth(String month) {
        Optional<Challenge> challenge = cr.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long cid,Challenge challenge) {
        Challenge c = cr.findById(cid).orElse(null);
        if(c == null)
            return false;
        c.setMonth(challenge.getMonth());
        c.setDescription(challenge.getDescription());
        cr.save(c);
        return true;
    }

    public boolean deleteChallenge(Long id) {
        Challenge c = cr.findById(id).orElse(null);
        if(c == null)
            return false;
        cr.delete(c);
        return true;
    }
}
