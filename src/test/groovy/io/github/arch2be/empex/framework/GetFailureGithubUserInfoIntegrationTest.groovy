package io.github.arch2be.empex.framework


import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class GetFailureGithubUserInfoIntegrationTest extends Specification {

    @Autowired
    private MockMvc mvc

    @SpringBean
    RestTemplate restTemplate = Mock() {
        getForEntity(_, GithubUserInfoResponse.class) >> {
            throw new GithubUserNotFoundException(GithubUserResponseFixtures.NOT_FOUND_MSG_FROM_GITHUB)
        }
    }

    def "should return not found response for not existing login"() {
        when:
            def response = mvc.perform(get("/users/" + GithubUserResponseFixtures.OCTOCAT_LOGIN))
        then:
            response
                .andExpect(status().isNotFound())
    }
}
