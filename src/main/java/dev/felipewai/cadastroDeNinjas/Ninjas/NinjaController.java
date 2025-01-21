package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado om sucesso: " + ninjaDTO.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas(){
        List<NinjaDTO> listaNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaNinjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaDTO> mostrarTodosOsNinjasPorId(@PathVariable Long id){
        if(ninjaService.buscarNinjaPorId(id) != null){
            return ResponseEntity.ok(ninjaService.buscarNinjaPorId(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaDTO> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        NinjaDTO novoNinja = ninjaService.atualizarNinja(id, ninjaDTO);
        if(novoNinja != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(novoNinja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.buscarNinjaPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Ninja deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ninja não encontrado");
        }
    }

}
