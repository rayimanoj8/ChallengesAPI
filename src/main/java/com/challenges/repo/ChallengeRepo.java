package com.challenges.repo;

import com.challenges.models.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepo extends JpaRepository<Challenge,Long> {

    public Optional<Challenge> findByMonthIgnoreCase(String month);
}
