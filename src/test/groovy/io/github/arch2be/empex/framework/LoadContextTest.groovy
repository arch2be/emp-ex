package io.github.arch2be.empex.framework

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired
    private GetGithubUserInfoController getGithubUserInfoController

    def "when context is loaded then all expected beans are created"() {
        expect: "the GetGithubUserInfoController is created"
        getGithubUserInfoController
    }
}