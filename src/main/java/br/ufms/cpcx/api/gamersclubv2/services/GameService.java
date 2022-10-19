package br.ufms.cpcx.api.gamersclubv2.services;

import br.ufms.cpcx.api.gamersclubv2.dtos.GameDto;
import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import br.ufms.cpcx.api.gamersclubv2.repositories.GameRepository;
import br.ufms.cpcx.api.gamersclubv2.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class GameService {

    final GameRepository gameRepository;
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Transactional
    public void saveGame(GameDto gameDto){
        GameModel gameModel= new GameModel();
        gameModel.setName(gameDto.getName());
        gameModel.setConsole(gameDto.getConsole());
        this.gameRepository.save(gameModel);
    }
    @Transactional
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
    @Transactional
    public boolean alterGame(Long id, GameDto gameDto){

        Optional<GameModel> gameById = this.gameRepository.findById(id);
        if(gameById.isEmpty()){
            return false;
        }
        gameById.get().setName(gameDto.getName());
        gameById.get().setConsole(gameDto.getConsole());
        return true;
    }
    public Page<GameModel> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }
    public Optional<GameModel> findById(Long id) {
        return gameRepository.findById(id);
    }
    public List<GameModel> findAll(){
        return this.gameRepository.findAll();
    }
    public List <GameModel> findAllGamebyPartnerId(Long id){
        return this.gameRepository.findAllByOwnerId(id);
    }
}
