package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_ITEM_COLETADO")
public class ItemColetado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ITEM_COLETADO")
    @SequenceGenerator(name = "SQ_ITEM_COLETADO", sequenceName = "SQ_ITEM_COLETADO", allocationSize = 1)
    @Column(name = "ID_ITEM")
    private Long idItem;

    @Column(name = "NM_ITEM")
    private String nomeItem;

    @Column(name = "TP_ITEM")
    private String tipoItem;

    @Column(name = "VALOR_EM_PONTOS")
    private Integer valorEmPontos;

}
