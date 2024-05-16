package org.farmsight.app.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_plantation_strategy")
@NoArgsConstructor
@AllArgsConstructor
public class PlantationStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @MapsId("plantationId")
    @JoinColumn(name = "plantation_id")
    Plantation plantation;

    @ManyToOne
    @MapsId("strategyID")
    @JoinColumn(name = "strategy_id")
    Strategy strategy;

}
