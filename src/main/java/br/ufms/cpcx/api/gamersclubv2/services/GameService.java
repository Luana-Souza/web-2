package br.ufms.cpcx.api.gamersclubv2.services;

import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import br.ufms.cpcx.api.gamersclubv2.repositories.GameRepository;
import br.ufms.cpcx.api.gamersclubv2.repositories.PartnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Optional;

public class GameService {
    final GameRepository gameRepository;
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Transactional
    public GameModel save(GameModel gameModel){
        return gameRepository.save(gameModel);
    }
    @Transactional
    public void delete(GameModel gameModel) {
        gameRepository.delete(gameModel);
    }
    public Page<GameModel> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }
    public Optional<GameModel> findById(Long id) {
        return gameRepository.findById(id);
    }

}
