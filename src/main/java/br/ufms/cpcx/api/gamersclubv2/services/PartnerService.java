package br.ufms.cpcx.api.gamersclubv2.services;

import br.ufms.cpcx.api.gamersclubv2.dtos.PartnerDto;
import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import br.ufms.cpcx.api.gamersclubv2.models.PartnerModel;
import br.ufms.cpcx.api.gamersclubv2.repositories.PartnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;
    private final GameService gameService;
    public PartnerService(PartnerRepository partnerRepository, GameService gameService) {
        this.partnerRepository = partnerRepository;
        this.gameService = gameService;
    }
    public void savePartner(PartnerDto partnerDto){
        PartnerModel partner = new PartnerModel();
        partner.setName(partnerDto.getName());
        partner.setPhoneNumber(partnerDto.getPhoneNumber());

        List<GameModel> allGames = new ArrayList<>();

        for(Long gameId : partnerDto.getGames()){
            this.gameService.findById(gameId).ifPresent(gameModel -> allGames.add(gameModel));
        }
        PartnerModel partnerAux = this.partnerRepository.save(partner);
        allGames.forEach(gameModel -> gameModel.setOwner(partnerAux));
        partner.setGameModel(allGames);
    }
    public Page<PartnerModel> findAllPartner(Pageable page){
        return this.partnerRepository.findAll(page);
    }

}
