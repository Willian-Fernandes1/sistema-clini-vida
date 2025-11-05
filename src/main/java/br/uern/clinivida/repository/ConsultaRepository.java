package br.uern.clinivida.repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.uern.clinivida.model.Consulta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("select c from Consulta c where c.medico.id = :medId and c.data = :data and c.hora = :hora")
    Optional<Consulta> findByMedicoDataHora(@Param("medId") Long medId, @Param("data") LocalDate data, @Param("hora") LocalTime hora);
}
