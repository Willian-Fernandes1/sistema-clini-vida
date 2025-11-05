package br.uern.clinivida.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import br.uern.clinivida.model.Usuario;
import br.uern.clinivida.repository.UsuarioRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.count() == 0) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("123")); // cria o hash automaticamente
                admin.setRole("ROLE_ADMIN");
                repo.save(admin);
                System.out.println("✅ Usuário admin criado automaticamente (senha: 123)");
            } else {
                System.out.println("🟢 Usuário já existente no banco, não precisa criar novamente");
            }
        };
    }
}
