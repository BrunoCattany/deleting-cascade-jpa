package br.com.cattany.study.controller;

import br.com.cattany.study.AbstractAssertsSpringBootDataRestTest;
import br.com.cattany.study.model.impl.Pessoa;
import br.com.cattany.study.model.impl.Treino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

/**
 * @author Bruno Cattany
 * @since 02/12/2018
 */
class PessoaControllerIT extends AbstractAssertsSpringBootDataRestTest {

    @DisplayName("Test Delete Pessoa")
    @Nested
    class PessoaDeleteTest {

        private final Integer ID_PESSOA = 1;
        private final String URI_DELETE_PESSOA = "/pessoas/{idPessoa}";

        @DisplayName("Deve deletar pessia e seus atributos em cascata'")
        @Test
        void deve__Deletar__Pessoa__E__Seus__Atributos__Em__Cascata() {
            verificarEstadoPessoaInicial(ID_PESSOA);
        }

        private void verificarEstadoPessoaInicial(Integer idPessoa) {
            ResponseEntity<Resource<Pessoa>> response = doGetPessoa(idPessoa);

            assertStatusOkAndContentTypeHalJsonUTF8(response);
            assertContentIsNotNull(response);
        }

        private ResponseEntity<Resource<Pessoa>> doGetPessoa(Integer idPessoa) {
            return doGetAndReturnResponseEntityResource(URI_DELETE_PESSOA, new ParameterizedTypeReference<Resource<Pessoa>>() {
            }, idPessoa);
        }

    }

    @DisplayName("Test Delete Treinos Pessoa")
    @Nested
    class TreinosPessoaTest {

        private final String URI_GET_TREINOS_PESSOA = "/pessoas/{idPessoa}/treinos";
        private final String URI_DELETE_TREINOS_BY_ORHPAN_REMOVAL = "/pessoas/{idPessoa}/deletarTreinos/orphanRemovalOptionNumber/{orphanRemovalOptionNumber}";

        @DisplayName("Deve deletar treinos da pessoa usando 'Orphan Removal'")
        @ParameterizedTest(name = "Option Number: {0}")
        @ArgumentsSource(DeleteOrphanRemovalTestCustomArgumentProvider.class)
        void parameterized__Test__Deve__Deletar__Treinos__Pessoa__Usando__Orphan__Removal__Option__Number(Integer idPessoa,
                                                                                                          Integer orphanRemovalOptionNumber,
                                                                                                          Integer tamanhoListaTreinosInicialEsperado) {
            verificarListaInicialTreinosPessoa(tamanhoListaTreinosInicialEsperado, idPessoa);

            testRestTemplate.delete(
                    URI_DELETE_TREINOS_BY_ORHPAN_REMOVAL,
                    idPessoa,
                    orphanRemovalOptionNumber
            );

            verificarListaTreinosPessoaAposDelete(idPessoa);
        }

        private void verificarListaInicialTreinosPessoa(Integer tamanhoListaTreinosInicialEsperado, Integer idPessoa) {
            ResponseEntity<PagedResources<Treino>> response = doGetTreinosPessoa(idPessoa);

            assertStatusOkAndContentTypeHalJsonUTF8Paged(response);
            assertSizeListOfContent(response, tamanhoListaTreinosInicialEsperado);
        }

        private void verificarListaTreinosPessoaAposDelete(Integer idPessoa) {
            ResponseEntity<PagedResources<Treino>> response = doGetTreinosPessoa(idPessoa);

            assertStatusOkAndContentTypeHalJsonUTF8Paged(response);
            assertEmptyListOfPagedContent(response);
        }

        private ResponseEntity<PagedResources<Treino>> doGetTreinosPessoa(Integer idPessoa) {
            return doGetAndReturnResponseEntityPagedResources(URI_GET_TREINOS_PESSOA, idPessoa);
        }

    }

    private static class DeleteOrphanRemovalTestCustomArgumentProvider implements ArgumentsProvider {

        private Arguments arguments(Integer idPessoa,
                                    Integer orphanRemovalOptionNumber,
                                    Integer tamanhoListaTreinosInicialEsperado) {
            return Arguments.of(idPessoa, orphanRemovalOptionNumber, tamanhoListaTreinosInicialEsperado);
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(arguments(1, 1, 3),
                    arguments(2, 2, 2),
                    arguments(3, 3, 1),
                    arguments(4, 4, 2)
            );
        }
    }

}