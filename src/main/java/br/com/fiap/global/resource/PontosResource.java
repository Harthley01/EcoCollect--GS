package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.PontosRequest;
import br.com.fiap.global.dto.response.PontosResponse;
import br.com.fiap.global.entity.Pontos;
import br.com.fiap.global.service.PontosService;
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
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Pontos", description = "API para gerenciamento de pontos")
@RestController
@RequestMapping("/pontos")
public class PontosResource {

    @Autowired
    private PontosService pontosService;

    @Operation(summary = "Retorna todos os pontos")
    @GetMapping
    public ResponseEntity<List<PontosResponse>> findAll() {
        List<Pontos> pontosList = pontosService.findAll();
        if (pontosList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PontosResponse> responseList = pontosList.stream()
                .map(pontosService::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Retorna um ponto por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PontosResponse> findById(@Parameter(description = "ID do ponto") @PathVariable Long id) {
        Pontos pontos = pontosService.findById(id);
        if (pontos == null) {
            return ResponseEntity.notFound().build();
        }
        PontosResponse response = pontosService.toResponse(pontos);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo ponto")
    @PostMapping
    public ResponseEntity<PontosResponse> createPontos(@RequestBody @Valid PontosRequest request) {
        Pontos pontos = pontosService.toEntity(request);
        Pontos savedPontos = pontosService.save(pontos);
        PontosResponse response = pontosService.toResponse(savedPontos);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualiza um ponto existente")
    @PutMapping("/{id}")
    public ResponseEntity<PontosResponse> updatePontos(@Parameter(description = "ID do ponto") @PathVariable Long id, @RequestBody @Valid PontosRequest request) {
        Pontos existingPontos = pontosService.findById(id);
        if (existingPontos == null) {
            return ResponseEntity.notFound().build();
        }
        Pontos pontos = pontosService.toEntity(request);
        pontos.setIdPontos(existingPontos.getIdPontos());
        Pontos updatedPontos = pontosService.save(pontos);
        PontosResponse response = pontosService.toResponse(updatedPontos);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Retorna todos os pontos com paginação")
    @GetMapping("/page")
    public ResponseEntity<Page<PontosResponse>> findAll(Pageable pageable) {
        Page<Pontos> pontosPage = pontosService.findAll(pageable);
        if (pontosPage.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Page<PontosResponse> responsePage = pontosPage.map(pontosService::toResponse);
        return ResponseEntity.ok(responsePage);
    }
}
