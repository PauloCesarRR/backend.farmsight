package org.farmsight.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_plantations")
@NoArgsConstructor
@AllArgsConstructor
public class Plantations {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate date;
    private String plantType;
    @ManyToOne
    private Farm farm;
}
