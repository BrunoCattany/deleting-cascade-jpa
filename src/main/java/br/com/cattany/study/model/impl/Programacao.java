package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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
class Programacao extends AbstractEntityWithIdIdentity {

    private LocalDate dataExecucao;

    @ManyToOne
    private Treino treino;

}
