package net.myphenotype.microservices.Team.Repository;

import net.myphenotype.microservices.Team.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
