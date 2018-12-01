package br.com.cattany.study.service;

import br.com.cattany.study.enums.OrphanRemovalOption;
import br.com.cattany.study.model.impl.Pessoa;
import br.com.cattany.study.model.impl.Treino;

import javax.persistence.OneToMany;
import javax.annotation.Nonnull;

/**
 * @author Bruno Cattany
 * @since 29/10/2018
 */
public interface PessoaService {

    Pessoa findById(Integer id);

    void update(Pessoa pessoa);

    /**
     * Realiza a deleção de um ou vários {@link Treino}s, <br>
     * utilizando-se do recurso {@link OneToMany#orphanRemoval()}.
     *
     * @param pessoa a ter os treinos deletados.
     * @param orphanRemovalOption opção do cenário de desvinculação de referência entre o pai e filho. <br>
     */
    void deleteTreinosUsingOrphanRemoval(@Nonnull OrphanRemovalOption orphanRemovalOption, @Nonnull Pessoa pessoa);
}
