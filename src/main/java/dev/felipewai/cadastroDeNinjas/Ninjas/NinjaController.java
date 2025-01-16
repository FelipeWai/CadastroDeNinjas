package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Criado com sucesso!";
    }

    //Procurar ninja por id (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Lista de ninjas";
    }

    // Mostrar ninja (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Ninja por ID";
    }

    // Alterar dados do ninja
    @PutMapping("/alterarID")
    public String atualizarNinja(){
        return "Atualizado com sucesso!";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinja(){
        return "Deletado com sucesso!";
    }

}
