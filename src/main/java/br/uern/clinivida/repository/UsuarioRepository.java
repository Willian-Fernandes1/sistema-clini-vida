package br.uern.clinivida.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.uern.clinivida.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
