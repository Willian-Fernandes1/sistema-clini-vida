package br.uern.clinivida.service;
import org.springframework.stereotype.Service;
import br.uern.clinivida.repository.PacienteRepository;
import br.uern.clinivida.model.Paciente;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository repo;
    public PacienteService(PacienteRepository repo){ this.repo = repo; }
    public List<Paciente> listar(){ return repo.findAll(); }
    public Paciente salvar(Paciente p){ return repo.save(p); }
    public Optional<Paciente> buscar(Long id){ return repo.findById(id); }
    public void excluir(Long id){ repo.deleteById(id); }
}
