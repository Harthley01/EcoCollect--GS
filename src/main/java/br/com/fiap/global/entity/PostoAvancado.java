package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_POSTO_AVANCADO")
public class PostoAvancado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_POSTO_AVANCADO")
    @SequenceGenerator(name = "SQ_POSTO_AVANCADO", sequenceName = "SQ_POSTO_AVANCADO", allocationSize = 1)
    @Column(name = "ID_POSTO")
    private Long idPosto;

    @Column(name = "NM_POSTO")
    private String nomePosto;

    @Column(name = "CIDADE_POSTO")
    private String cidadePosto;

    @Column(name = "TOTAL_ITENS")
    private Integer totalItens;

}
