package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.ProfissionalPostoRequest;
import br.com.fiap.global.dto.response.ProfissionalPostoResponse;
import br.com.fiap.global.entity.ProfissionalPosto;
import br.com.fiap.global.repository.ProfissionalPostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfissionalPostoService implements ServiceDTO<ProfissionalPosto, ProfissionalPostoRequest, ProfissionalPostoResponse> {

    @Autowired
    private ProfissionalPostoRepository repo;

    @Override
    public ProfissionalPosto toEntity(ProfissionalPostoRequest request) {
        if (Objects.isNull(request)) return null;

        return ProfissionalPosto.builder()
                .nomeProfissional(request.nomeProfissional())
                .tipoProfissional(request.tipoProfissional())
                .flSexo(request.flSexo())
                .build();
    }

    @Override
    public ProfissionalPostoResponse toResponse(ProfissionalPosto entity) {
        if (Objects.isNull(entity)) return null;

        return ProfissionalPostoResponse.builder()
                .idProfissional(entity.getIdProfissional())
                .nomeProfissional(entity.getNomeProfissional())
                .tipoProfissional(entity.getTipoProfissional())
                .flSexo(entity.getFlSexo())
                .build();
    }

    @Override
    public List<ProfissionalPosto> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ProfissionalPosto> findAll(Example<ProfissionalPosto> example) {
        return repo.findAll(example);
    }

    @Override
    public ProfissionalPosto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ProfissionalPosto save(ProfissionalPosto entity) {
        return repo.save(entity);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
