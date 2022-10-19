package br.ufms.cpcx.api.gamersclubv2.repositories;

import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
