package br.uern.clinivida.service;
import org.springframework.stereotype.Service;
import br.uern.clinivida.repository.MedicoRepository;
import br.uern.clinivida.model.Medico;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    private final MedicoRepository repo;
    public MedicoService(MedicoRepository repo){ this.repo = repo; }
    public List<Medico> listar(){ return repo.findAll(); }
    public Medico salvar(Medico m){ return repo.save(m); }
    public Optional<Medico> buscar(Long id){ return repo.findById(id); }
    public void excluir(Long id){ repo.deleteById(id); }
}
