package net.myphenotype.microservices.Ground.Repository;

import net.myphenotype.microservices.Ground.Entity.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundRepository extends JpaRepository<Ground, Integer> {
}
