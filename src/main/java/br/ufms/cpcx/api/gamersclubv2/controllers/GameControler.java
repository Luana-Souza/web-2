package br.ufms.cpcx.api.gamersclubv2.controllers;

import br.ufms.cpcx.api.gamersclubv2.dtos.GameDto;
import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import br.ufms.cpcx.api.gamersclubv2.services.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/gamemodel")
public class GameControler {

    private final GameService gameService;

    public GameControler(GameService gameService) {
        this.gameService = gameService;
    }
    @PostMapping
    public ResponseEntity<Void> saveGame(@RequestBody GameDto gameDto) {
        try {
            this.gameService.saveGame(gameDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<Page<GameModel>>  findAllGames (Pageable page) {
       Page<GameModel> gameModels = this.gameService.findAll(page);
        return ResponseEntity.ok(gameModels);
    }
    @PutMapping("/{idGame}")
    public ResponseEntity<Void> alterGame(@PathVariable Long idGame,@RequestBody GameDto gameDto){
       boolean ok = this.gameService.alterGame(idGame, gameDto);
       if(ok){
           return ResponseEntity.ok().build();
       }
       return ResponseEntity.notFound().build();
    }
    @GetMapping("/owner{partnerId}")
    public ResponseEntity<List<GameModel>> findAllGameByPartnerId(@PathVariable Long partnerId){
    return ResponseEntity.ok(this.gameService.findAllGamebyPartnerId(partnerId));

    }
//    @DeleteMapping("/{idgame}")
//    public RequestEntity<Void> deleteGame (@PathVariable Long idGame){
//        try{
//            this.
//        }
//    }
}
