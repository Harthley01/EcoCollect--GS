package br.com.fiap.global.repository;

import br.com.fiap.global.entity.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, String> {
}
