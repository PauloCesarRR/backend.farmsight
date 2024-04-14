package org.farmsight.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_farm_income")
@NoArgsConstructor
@AllArgsConstructor
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false)
    private BigDecimal value;
    @ManyToOne
    @Column(nullable = false)
    private Farm farm;
}
