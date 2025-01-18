package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninja) {
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        return ninjaMapper.map(ninjaRepository.save(ninjaModel));
    }

    // Deletar ninja por id
    public void deletarNinja(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        ninjaPorId.ifPresent(ninjaModel -> ninjaRepository.delete(ninjaModel));
    }
}
