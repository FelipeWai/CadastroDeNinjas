package dev.felipewai.cadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;
    MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoesModel){
        MissoesModel missaoNova = missoesMapper.map(missoesModel);
        return missoesMapper.map(missoesRepository.save(missaoNova));
    }

    public void excluirMissoesPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        missoesModel.ifPresent(missoesRepository::delete);
    }

    public MissoesDTO atualizarMissoesPorId(Long id, MissoesDTO missoesModelBody){
        Optional<MissoesModel> missoesModelAtual = missoesRepository.findById(id);
        if(missoesModelAtual.isPresent()){
            MissoesModel missoesModel = missoesMapper.map(missoesModelBody);
            missoesModel.setId(id);
            MissoesModel atualizado = missoesRepository.save(missoesModel);
            return missoesMapper.map(atualizado);
        }
        return null;
    }

}
