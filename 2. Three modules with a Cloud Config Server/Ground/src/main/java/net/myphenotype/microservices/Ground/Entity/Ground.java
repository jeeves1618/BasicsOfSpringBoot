package net.myphenotype.microservices.Ground.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ground extends  BaseEntity {
    @Id
    private int groundId;
    private String homeGroundCode;
    private String groundName;
    private int groundCapacity;
    private int availableSeats;
    private String nearestAirport;
}
