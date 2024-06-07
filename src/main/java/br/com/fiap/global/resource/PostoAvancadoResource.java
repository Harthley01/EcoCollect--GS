package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.PostoAvancadoRequest;
import br.com.fiap.global.dto.response.PostoAvancadoResponse;
import br.com.fiap.global.entity.PostoAvancado;
import br.com.fiap.global.service.PostoAvancadoService;
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

@Tag(name = "Postos Avançados", description = "API para gerenciamento de postos avançados")
@RestController
@RequestMapping("/postos-avancados")
public class PostoAvancadoResource {

    @Autowired
    private PostoAvancadoService postoAvancadoService;

    @Operation(summary = "Retorna todos os postos avançados")
    @GetMapping
    public ResponseEntity<List<PostoAvancadoResponse>> findAll() {
        List<PostoAvancado> postos = postoAvancadoService.findAll();
        if (postos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PostoAvancadoResponse> responses = postos.stream()
                .map(postoAvancadoService::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna um posto avançado por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PostoAvancadoResponse> findById(@Parameter(description = "ID do posto avançado") @PathVariable Long id) {
        PostoAvancado posto = postoAvancadoService.findById(id);
        if (posto == null) {
            return ResponseEntity.notFound().build();
        }
        PostoAvancadoResponse response = postoAvancadoService.toResponse(posto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo posto avançado")
    @PostMapping
    public ResponseEntity<PostoAvancadoResponse> createPostoAvancado(@RequestBody @Valid PostoAvancadoRequest request) {
        PostoAvancado posto = postoAvancadoService.toEntity(request);
        PostoAvancado savedPosto = postoAvancadoService.save(posto);
        PostoAvancadoResponse response = postoAvancadoService.toResponse(savedPosto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Exclui um posto avançado por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostoAvancado(@Parameter(description = "ID do posto avançado") @PathVariable Long id) {
        postoAvancadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
