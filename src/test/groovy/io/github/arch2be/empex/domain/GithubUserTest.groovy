package io.github.arch2be.empex.domain

import io.github.arch2be.empex.fixtures.GithubUserFixtures
import spock.lang.Specification

class GithubUserTest extends Specification {

    def "should calculate proper calculation during create new GithubUser instance"() {
        when:
            GithubUser result = GithubUser.of(null, null, null, null, null, null, 8, 6)
        then:
            result.calculations == GithubUserFixtures.CORRECT_CALCULATION_ARCH2BE
    }
}
