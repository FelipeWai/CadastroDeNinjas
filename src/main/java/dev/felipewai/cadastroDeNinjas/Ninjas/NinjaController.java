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

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.criarNinja(ninjaDTO);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarTodosOsNinjasPorId(@PathVariable Long id){
        return ninjaService.buscarNinjaPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        return ninjaService.atualizarNinja(id, ninjaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

}
