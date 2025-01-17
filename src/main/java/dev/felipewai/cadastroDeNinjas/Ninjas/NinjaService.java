package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar meu ninja
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar ninjas por ID
    public NinjaModel buscarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar ninja por id
    public void deletarNinja(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        ninjaPorId.ifPresent(ninjaModel -> ninjaRepository.delete(ninjaModel));
    }
}
