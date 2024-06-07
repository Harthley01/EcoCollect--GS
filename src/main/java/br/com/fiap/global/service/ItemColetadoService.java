package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.ItemColetadoRequest;
import br.com.fiap.global.dto.response.ItemColetadoResponse;
import br.com.fiap.global.entity.ItemColetado;
import br.com.fiap.global.repository.ItemColetadoRepository;
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
public class ItemColetadoService implements ServiceDTO<ItemColetado, ItemColetadoRequest, ItemColetadoResponse> {

    @Autowired
    private ItemColetadoRepository repo;

    @Override
    public ItemColetado toEntity(ItemColetadoRequest r) {
        if (Objects.isNull(r)) return null;

        return ItemColetado.builder()
                .nomeItem(r.nomeItem())
                .tipoItem(r.tipoItem())
                .valorEmPontos(r.valorEmPontos())
                .build();
    }

    @Override
    public ItemColetadoResponse toResponse(ItemColetado e) {
        if (Objects.isNull(e)) return null;

        return ItemColetadoResponse.builder()
                .idItem(e.getIdItem())
                .nomeItem(e.getNomeItem())
                .tipoItem(e.getTipoItem())
                .valorEmPontos(e.getValorEmPontos())
                .build();
    }

    @Override
    public List<ItemColetado> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ItemColetado> findAll(Example<ItemColetado> example) {
        return repo.findAll(example);
    }

    public Page<ItemColetado> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<ItemColetado> findAll(Example<ItemColetado> example, Pageable pageable) {
        return repo.findAll(example, pageable);
    }

    @Override
    public ItemColetado findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ItemColetado save(ItemColetado e) {
        return repo.save(e);
    }
}
