package net.myphenotype.microservices.Team.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team extends  BaseEntity {
    @Id
    private int teamId;
    private String teamCode;
    private String teamName;
    private int matchesPlayed;
    private int matchesWon;
    private String homeGroundCode;
}
