package br.uern.clinivida.service;
import org.springframework.stereotype.Service;
import br.uern.clinivida.repository.ConsultaRepository;
import br.uern.clinivida.model.Consulta;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ConsultaService {
    private final ConsultaRepository repo;
    public ConsultaService(ConsultaRepository repo){ this.repo = repo; }
    public List<Consulta> listar(){ return repo.findAll(); }
    public Optional<Consulta> buscar(Long id){ return repo.findById(id); }
    public Consulta salvar(Consulta c){ return repo.save(c); }
    public void excluir(Long id){ repo.deleteById(id); }

    public boolean existeConflito(Long medId, LocalDate data, LocalTime hora){
        return repo.findByMedicoDataHora(medId, data, hora).isPresent();
    }
}
