package br.ufms.cpcx.api.gamersclubv2.dtos;

import br.ufms.cpcx.api.gamersclubv2.models.GameModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PartnerDto {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String phoneNumber ;

    private List<Long> games;

}
