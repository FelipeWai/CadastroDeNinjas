package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
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
