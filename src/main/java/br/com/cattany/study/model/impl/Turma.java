package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Bruno Cattany
 * @since 29/10/2018
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Turma extends AbstractEntityWithIdIdentity {

    private String nome;

    @OneToMany(mappedBy = "turma")
    private List<Pessoa> pessoas;
}
