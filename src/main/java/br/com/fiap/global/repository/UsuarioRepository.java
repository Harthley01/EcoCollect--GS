package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByIdUsuario(Long id);
}
