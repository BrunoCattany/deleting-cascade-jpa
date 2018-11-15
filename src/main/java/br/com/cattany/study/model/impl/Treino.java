package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bruno Cattany
 * @since 28/10/2018
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treino extends AbstractEntityWithIdIdentity {

    @Column(length = 30)
    private String nome;

    @ManyToOne
    private Academia academiaOrigem;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(
            name = "treino_exercicio",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private List<Exercicio> exercicios;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.REMOVE)
    private List<Programacao> programacoes;
}
