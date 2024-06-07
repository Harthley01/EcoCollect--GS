package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.ProfissionalPostoRequest;
import br.com.fiap.global.dto.response.ProfissionalPostoResponse;
import br.com.fiap.global.entity.ProfissionalPosto;
import br.com.fiap.global.service.ProfissionalPostoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Profissionais de Posto", description = "API para gerenciamento de profissionais de posto")
@RestController
@RequestMapping("/profissionais-posto")
public class ProfissionalPostoResource {

    @Autowired
    private ProfissionalPostoService profissionalPostoService;

    @Operation(summary = "Retorna todos os profissionais de posto")
    @GetMapping
    public ResponseEntity<List<ProfissionalPostoResponse>> findAll() {
        List<ProfissionalPosto> profissionais = profissionalPostoService.findAll();
        if (profissionais.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ProfissionalPostoResponse> responses = profissionais.stream()
                .map(profissionalPostoService::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna um profissional de posto por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalPostoResponse> findById(@Parameter(description = "ID do profissional de posto") @PathVariable Long id) {
        ProfissionalPosto profissional = profissionalPostoService.findById(id);
        if (profissional == null) {
            return ResponseEntity.notFound().build();
        }
        ProfissionalPostoResponse response = profissionalPostoService.toResponse(profissional);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo profissional de posto")
    @PostMapping
    public ResponseEntity<ProfissionalPostoResponse> createProfissionalPosto(@RequestBody @Valid ProfissionalPostoRequest request) {
        ProfissionalPosto profissional = profissionalPostoService.toEntity(request);
        ProfissionalPosto savedProfissional = profissionalPostoService.save(profissional);
        ProfissionalPostoResponse response = profissionalPostoService.toResponse(savedProfissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Exclui um profissional de posto por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissionalPosto(@Parameter(description = "ID do profissional de posto") @PathVariable Long id) {
        profissionalPostoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
