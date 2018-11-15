package br.com.cattany.study.service;

import br.com.cattany.study.model.impl.Pessoa;
import lombok.NonNull;

import javax.persistence.OneToMany;

/**
 * @author Bruno Cattany
 * @since 29/10/2018
 */
public interface PessoaService {

    Pessoa findById(Integer id);

    void delete(Pessoa pessoa);

    void update(Pessoa pessoa);

    /**
     * Realiza a deleção de uma {@link Pessoa}, <br>
     * baseado em um cenário aonde a opção {@link OneToMany#cascade()} é exercitada.
     *
     * @param pessoa a ser deletada.
     * @param orphanRemovalOption opção do cenário que envolve a desvinculação de referência entre os objetos. <br>
     *                            As possibilidades estão entre <b>1 e 4</b>.
     */
    void deleteUsingOrphanRemoval(@NonNull Integer orphanRemovalOption, @NonNull Pessoa pessoa);
}
