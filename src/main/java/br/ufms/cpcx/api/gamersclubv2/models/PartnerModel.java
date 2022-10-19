package br.ufms.cpcx.api.gamersclubv2.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "TB_PARTNER"
)
@Data
@NoArgsConstructor
public class PartnerModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. AUTO)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @OneToMany
    private List<GameModel> gameModel;
}
