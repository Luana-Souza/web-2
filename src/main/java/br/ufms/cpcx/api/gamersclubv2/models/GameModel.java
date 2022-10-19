package br.ufms.cpcx.api.gamersclubv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "TB_GAME"
)
@Data
@NoArgsConstructor
public class GameModel implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType. IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated (EnumType.STRING)
    @Column(nullable = false, length = 50)
    private ConsoleEnum console;

    @ManyToOne
    @JsonIgnore
    private PartnerModel owner;

}
