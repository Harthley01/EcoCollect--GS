package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.AutenticaRequest;
import br.com.fiap.global.dto.response.AutenticaResponse;
import br.com.fiap.global.entity.Autentica;
import br.com.fiap.global.repository.AutenticaRepository;
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
public class AutenticaService implements ServiceDTO<Autentica, AutenticaRequest, AutenticaResponse> {

    @Autowired
    private AutenticaRepository repo;

    @Override
    public Autentica toEntity(AutenticaRequest request) {
        if (Objects.isNull(request)) return null;

        return Autentica.builder()
                .login(request.login())
                .senha(request.senha())
                .statusLogin(request.statusLogin())
                .build();
    }

    @Override
    public AutenticaResponse toResponse(Autentica entity) {
        if (Objects.isNull(entity)) return null;

        return new AutenticaResponse(
                entity.getIdAutentica(),
                entity.getLogin(),
                entity.getSenha(),
                entity.getStatusLogin()
        );
    }

    @Override
    public List<Autentica> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Autentica> findAll(Example<Autentica> example) {
        return repo.findAll(example);
    }

    public Page<Autentica> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<Autentica> findAll(Example<Autentica> example, Pageable pageable) {
        return repo.findAll(example, pageable);
    }

    @Override
    public Autentica findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Autentica save(Autentica entity) {
        return repo.save(entity);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
