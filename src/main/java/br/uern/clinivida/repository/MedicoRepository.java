package br.uern.clinivida.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.uern.clinivida.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {}
