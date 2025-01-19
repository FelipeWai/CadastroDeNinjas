package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar meu ninja
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninjas por ID
    public NinjaDTO buscarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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

    public NinjaDTO atualizarNinja(Long id,NinjaDTO ninja) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if(ninjaPorId.isPresent()) {
            NinjaModel ninjaModel = ninjaMapper.map(ninja);
            ninjaModel.setId(id);
            NinjaModel atualizado = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(atualizado);
        }
        return null;
    }
}