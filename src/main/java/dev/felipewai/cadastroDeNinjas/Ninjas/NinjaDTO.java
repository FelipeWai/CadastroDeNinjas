package dev.felipewai.cadastroDeNinjas.Ninjas;

import dev.felipewai.cadastroDeNinjas.Missoes.Models.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private MissoesModel missoes;
    private String rank;
}
