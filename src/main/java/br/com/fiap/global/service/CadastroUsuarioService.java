package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.CadastroUsuarioRequest;
import br.com.fiap.global.dto.response.CadastroUsuarioResponse;
import br.com.fiap.global.entity.CadastroUsuario;
import br.com.fiap.global.repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CadastroUsuarioService implements ServiceDTO<CadastroUsuario, CadastroUsuarioRequest, CadastroUsuarioResponse> {

    @Autowired
    private CadastroUsuarioRepository repo;

    @Override
    public CadastroUsuario toEntity(CadastroUsuarioRequest r) {
        if (Objects.isNull(r)) return null;

        return CadastroUsuario.builder()
                .email(r.email())
                .login(r.login())
                .senha(r.senha())
                .build();
    }

    @Override
    public CadastroUsuarioResponse toResponse(CadastroUsuario e) {
        if (Objects.isNull(e)) return null;

        return CadastroUsuarioResponse.builder()
                .idCadastroUsuario(e.getIdCadastroUsuario())
                .email(e.getEmail())
                .login(e.getLogin())
                .senha(e.getSenha())
                .build();
    }

    @Override
    public List<CadastroUsuario> findAll() {
        return repo.findAll();
    }

    @Override
    public List<CadastroUsuario> findAll(Example<CadastroUsuario> example) {
        return repo.findAll(example);
    }

    public Page<CadastroUsuario> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<CadastroUsuario> findAll(Example<CadastroUsuario> example, Pageable pageable) {
        return repo.findAll(example, pageable);
    }

    @Override
    public CadastroUsuario findById(Long id) {
        return repo.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public CadastroUsuario save(CadastroUsuario e) {
        return repo.save(e);
    }
}
