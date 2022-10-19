package br.ufms.cpcx.api.gamersclubv2.dtos;

import br.ufms.cpcx.api.gamersclubv2.models.ConsoleEnum;
import br.ufms.cpcx.api.gamersclubv2.models.PartnerModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GameDto {
    @NotBlank
    @Size(max = 100)
    private String name;

    private ConsoleEnum console;

}
