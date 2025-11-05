package br.uern.clinivida.config;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import br.uern.clinivida.repository.UsuarioRepository;
import br.uern.clinivida.model.Usuario;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repo;

    public UserDetailsServiceImpl(UsuarioRepository repo){
        this.repo = repo;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {

        Usuario u = repo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // ✅ Garante que a role tenha sempre prefixo ROLE_
        String role = u.getRole();
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        return User.withUsername(u.getUsername())
                .password(u.getPassword())
                .roles(role.replace("ROLE_", "")) // Spring exige apenas o sufixo aqui
                .build();
    }
}
