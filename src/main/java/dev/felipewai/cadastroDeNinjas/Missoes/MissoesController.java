package dev.felipewai.cadastroDeNinjas.Missoes;

//LOCALHOST:8080/


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Lista de missoes";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso!";
    }

    @PutMapping("/atualizar")
    public String atualizarMissao(){
        return "Missao atualizado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletado com sucesso!";
    }

}
