package dev.felipewai.cadastroDeNinjas.Missoes.Services;

import dev.felipewai.cadastroDeNinjas.Missoes.Models.MissoesModel;
import dev.felipewai.cadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    public MissoesModel criarMissao(@RequestBody MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public void excluirMissoesPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        missoesModel.ifPresent(missoesRepository::delete);
    }

    public MissoesModel atualizarMissoesPorId(Long id,MissoesModel missoesModel){
        Optional<MissoesModel> missoesModelAtual = missoesRepository.findById(id);
        if(missoesModelAtual.isPresent()){
            missoesModel.setId(id);
            return missoesRepository.save(missoesModel);
        }
        return null;
    }

}
