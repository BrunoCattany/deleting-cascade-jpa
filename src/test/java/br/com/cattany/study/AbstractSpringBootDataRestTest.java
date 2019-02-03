package br.com.cattany.study;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.http.HttpMethod.GET;

/**
 * @author Bruno Cattany
 * @since 03/02/2019
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
abstract class AbstractSpringBootDataRestTest {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    protected <T> ResponseEntity<PagedResources<T>> doGetAndReturnResponseEntityPagedResources(String url, Object... urlVariables) {
        return testRestTemplate.exchange(
                url,
                GET,
                null,
                new ParameterizedTypeReference<PagedResources<T>>() {
                },
                urlVariables
        );
    }

    protected <T> ResponseEntity<Resource<T>> doGetAndReturnResponseEntityResource(String url,
                                                                                   ParameterizedTypeReference<Resource<T>> parameterizedTypeReference,
                                                                                   Object... urlVariables) {
        return testRestTemplate.exchange(
                url,
                GET,
                null,
                parameterizedTypeReference,
                urlVariables
        );
    }

}
