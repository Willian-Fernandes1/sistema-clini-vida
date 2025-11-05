package br.uern.clinivida.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.uern.clinivida.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}
