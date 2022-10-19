package br.ufms.cpcx.api.gamersclubv2.controllers;

import br.ufms.cpcx.api.gamersclubv2.dtos.PartnerDto;
import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import br.ufms.cpcx.api.gamersclubv2.models.PartnerModel;
import br.ufms.cpcx.api.gamersclubv2.services.PartnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/partnemodel")
public class partnerControler {
   final private PartnerService partnerService;

    public partnerControler(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping
    public ResponseEntity<Void> savepartner(@RequestBody PartnerDto partnerDto){
        try{
            this.partnerService.savePartner(partnerDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<Page<PartnerModel>> findallPartner (Pageable page){
        return ResponseEntity.ok(this.partnerService.findAllPartner(page));
    }

}
