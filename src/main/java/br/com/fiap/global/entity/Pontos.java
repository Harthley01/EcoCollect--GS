package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PONTOS")
public class Pontos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PONTOS")
    @SequenceGenerator(name = "SQ_PONTOS", sequenceName = "SQ_PONTOS", allocationSize = 1)
    @Column(name = "ID_PONTOS")
    private Long idPontos;

    @Column(name = "QT_PONTOS")
    private Integer qtPontos;

    @Column(name = "ATTRIBUTE_2")
    private String atributo2;
}
