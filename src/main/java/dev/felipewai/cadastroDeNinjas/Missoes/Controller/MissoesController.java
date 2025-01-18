package dev.felipewai.cadastroDeNinjas.Missoes.Controller;

//LOCALHOST:8080/


import dev.felipewai.cadastroDeNinjas.Missoes.Models.MissoesModel;
import dev.felipewai.cadastroDeNinjas.Missoes.Services.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarPorId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    @PutMapping("/atualizar/{id}")
    public MissoesModel atualizarMissao(@PathVariable Long id, @RequestBody MissoesModel missao){
        return missoesService.atualizarMissoesPorId(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.excluirMissoesPorId(id);
    }

}
