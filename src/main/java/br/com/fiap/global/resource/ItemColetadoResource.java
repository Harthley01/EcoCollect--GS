package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.ItemColetadoRequest;
import br.com.fiap.global.dto.response.ItemColetadoResponse;
import br.com.fiap.global.entity.ItemColetado;
import br.com.fiap.global.service.ItemColetadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Tag(name = "Itens Coletados", description = "API para gerenciamento de itens coletados")
@RestController
@RequestMapping("/itens-coletados")
public class ItemColetadoResource {

    @Autowired
    private ItemColetadoService itemColetadoService;

    @Operation(summary = "Retorna todos os itens coletados com paginação")
    @GetMapping
    public ResponseEntity<Page<ItemColetadoResponse>> findAll(Pageable pageable) {
        Page<ItemColetado> itensColetados = itemColetadoService.findAll(pageable);
        if (itensColetados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<ItemColetadoResponse> responses = itensColetados.map(itemColetadoService::toResponse);
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna um item coletado por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ItemColetadoResponse> findById(@Parameter(description = "ID do item coletado") @PathVariable Long id) {
        ItemColetado itemColetado = itemColetadoService.findById(id);
        if (itemColetado == null) {
            return ResponseEntity.notFound().build();
        }
        ItemColetadoResponse response = itemColetadoService.toResponse(itemColetado);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo item coletado")
    @PostMapping
    public ResponseEntity<ItemColetadoResponse> createItemColetado(@RequestBody @Valid ItemColetadoRequest request) {
        ItemColetado itemColetado = itemColetadoService.toEntity(request);
        ItemColetado savedItemColetado = itemColetadoService.save(itemColetado);
        ItemColetadoResponse response = itemColetadoService.toResponse(savedItemColetado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualiza um item coletado existente")
    @PutMapping("/{id}")
    public ResponseEntity<ItemColetadoResponse> updateItemColetado(@Parameter(description = "ID do item coletado") @PathVariable Long id, @RequestBody @Valid ItemColetadoRequest request) {
        ItemColetado itemColetado = itemColetadoService.findById(id);
        if (itemColetado == null) {
            return ResponseEntity.notFound().build();
        }
        itemColetado.setNomeItem(request.nomeItem());
        itemColetado.setTipoItem(request.tipoItem());
        itemColetado.setValorEmPontos(request.valorEmPontos());
        ItemColetado updatedItemColetado = itemColetadoService.save(itemColetado);
        ItemColetadoResponse response = itemColetadoService.toResponse(updatedItemColetado);
        return ResponseEntity.ok(response);
    }
}
