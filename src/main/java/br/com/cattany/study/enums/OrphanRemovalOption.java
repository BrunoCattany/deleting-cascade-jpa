package br.com.cattany.study.enums;

import br.com.cattany.study.service.exception.NotFoundOrphanRemovalOptionException;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Repositório de {@link Consumer} responsável por realizar a limpeza/desvinculação do objeto recebido, <br>
 * simulando o caso aonde o {@link OneToMany#orphanRemoval()} tem o seu efeito.
 *
 * @author Bruno Cattany
 * @since 24/11/2018
 */
public enum OrphanRemovalOption {

    COLLECTION_CLEAR(1,
            List::clear
    ),

    SET_NULL_COLLECTION_ELEMENT_BY_ELEMENT(2,
            (l) -> {
                for (int i = 0; i < l.size(); i++) {
                    l.set(i, null);
                }
            }
    ),

    COLLECTION_REMOVE_ALL(3,
            (l) -> l.removeAll(l)
    ),

    REMOVE_ELEMENT_BY_ELEMENT(4,
            (l) -> {
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    l.remove(0);
                }
            }
    );

    private static final Map<Integer, OrphanRemovalOption> LOOKUP = Maps.uniqueIndex(
            Arrays.asList(values()),
            orphanRemovalOption -> orphanRemovalOption != null ? orphanRemovalOption.getOptionNumber() : 0
    );

    private final int optionNumber;
    private final Consumer<List<?>> consumer;

    OrphanRemovalOption(int optionNumber, Consumer<List<?>> consumer) {
        this.optionNumber = optionNumber;
        this.consumer = consumer;
    }

    public static OrphanRemovalOption getFromOption(@Nonnull Integer option) {
        OrphanRemovalOption orphanRemovalOption = LOOKUP.get(option);

        if (orphanRemovalOption != null) {
            return orphanRemovalOption;
        }

        throw new NotFoundOrphanRemovalOptionException(values());
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public Consumer<List<?>> getConsumer() {
        return consumer;
    }
}
