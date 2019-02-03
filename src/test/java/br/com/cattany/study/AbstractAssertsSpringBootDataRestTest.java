package br.com.cattany.study;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.hateoas.MediaTypes.HAL_JSON_UTF8;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Bruno Cattany
 * @since 03/02/2019
 */
public abstract class AbstractAssertsSpringBootDataRestTest extends AbstractSpringBootDataRestTest {

    protected <T> void assertSizeListOfContent(ResponseEntity<PagedResources<T>> response, int expectedListSize) {
        assertEquals(expectedListSize, Objects.requireNonNull(response.getBody()).getContent().size());
    }

    protected <T> void assertEmptyListOfPagedContent(ResponseEntity<PagedResources<T>> response) {
        assertTrue(Objects.requireNonNull(response.getBody()).getContent().isEmpty());
    }

    protected <T> void assertContentIsNotNull(ResponseEntity<Resource<T>> response) {
        assertNotNull(Objects.requireNonNull(response.getBody()).getContent());
    }

    protected <T> void assertStatusOkAndContentTypeHalJsonUTF8Paged(ResponseEntity<PagedResources<T>> response) {
        assertStatusOkPaged(response);
        assertContentTypeHalJsonUTF8Paged(response);
    }

    protected <T> void assertStatusOkAndContentTypeHalJsonUTF8(ResponseEntity<Resource<T>> response) {
        assertStatusOk(response);
        assertContentTypeHalJsonUTF8(response);
    }

    protected <T> void assertStatusOkPaged(ResponseEntity<PagedResources<T>> response) {
        assertEquals(OK, response.getStatusCode());
    }

    protected <T> void assertStatusOk(ResponseEntity<Resource<T>> response) {
        assertEquals(OK, response.getStatusCode());
    }

    protected <T> void assertContentTypeHalJsonUTF8Paged(ResponseEntity<PagedResources<T>> response) {
        assertEquals(HAL_JSON_UTF8, response.getHeaders().getContentType());
    }

    protected <T> void assertContentTypeHalJsonUTF8(ResponseEntity<Resource<T>> response) {
        assertEquals(HAL_JSON_UTF8, response.getHeaders().getContentType());
    }

}
