package org.farmsight.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_plantation")
@NoArgsConstructor
@AllArgsConstructor
public class Plantation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate date;
    private String plantType;
    @OneToMany(mappedBy = "plantation")
    private Set<PlantationStrategy> plantationStrategy;
    @ManyToOne
    private Farm farm;
}
