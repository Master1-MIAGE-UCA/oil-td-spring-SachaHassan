package org.example.oiltdspringsachahassan.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class DiceRollLog {

    // Getters et setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int diceCount;

    @ElementCollection
    private List<Integer> results;

    private LocalDateTime timestamp;

    public DiceRollLog(int diceCount, List<Integer> results) {
        this.diceCount = diceCount;
        this.results = results;
        this.timestamp = LocalDateTime.now();
    }

}
