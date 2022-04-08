package io.github.arch2be.empex.domain

import io.github.arch2be.empex.fixtures.GithubUserAuditLogFixtures
import spock.lang.Specification

class GithubUserAuditLogTest extends Specification {

    def "should return new instance with incremented requestCount when execute increment() method"() {
        given:
            GithubUserAuditLog oldRecordBeforeIncrement = GithubUserAuditLogFixtures.ARCH2BE_RECORD
        when:
            GithubUserAuditLog newRecordAfterIncrement = oldRecordBeforeIncrement.increment()
        then:
            oldRecordBeforeIncrement.requestCount == 1
            newRecordAfterIncrement.requestCount == 2
    }
}
