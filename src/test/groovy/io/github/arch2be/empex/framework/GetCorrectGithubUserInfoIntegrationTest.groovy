package io.github.arch2be.empex.framework

import io.github.arch2be.empex.application.ports.out.GithubUserAuditLogRepository
import io.github.arch2be.empex.domain.GithubUserAuditLog
import io.github.arch2be.empex.fixtures.GithubUserResponseFixtures
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetCorrectGithubUserInfoIntegrationTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    private GithubUserAuditLogRepository githubUserAuditLogRepository;

    @SpringBean
    RestTemplate restTemplate = Mock() {
        getForEntity(_, GithubUserInfoResponse.class) >> ResponseEntity.ok(GithubUserResponseFixtures.OCTOCAT_CORRECT_RESPONSE_FROM_GITHUB)
    }

    def "should return correct response for existing login and store data in database"() {
        when:
            def response = mvc.perform(get("/users/" + GithubUserResponseFixtures.OCTOCAT_LOGIN))
            Optional<GithubUserAuditLog> expectedEntity = githubUserAuditLogRepository
                    .findGithubUserAuditLogByLogin(GithubUserResponseFixtures.OCTOCAT_LOGIN)
        then:
            response
                    .andExpect(status().isOk())
                    .andReturn()
                    .response
                    .contentAsString

            expectedEntity.isPresent()
            expectedEntity.get().requestCount == 1
            expectedEntity.get().login == GithubUserResponseFixtures.OCTOCAT_LOGIN
    }
}
