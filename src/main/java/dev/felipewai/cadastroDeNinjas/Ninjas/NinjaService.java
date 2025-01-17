package dev.felipewai.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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

}
