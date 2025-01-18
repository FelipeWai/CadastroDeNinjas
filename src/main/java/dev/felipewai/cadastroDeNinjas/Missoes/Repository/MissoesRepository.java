package dev.felipewai.cadastroDeNinjas.Missoes.Repository;

import dev.felipewai.cadastroDeNinjas.Missoes.Models.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
