package io.github.arch2be.empex.application

import io.github.arch2be.empex.application.dto.GithubUserDto
import io.github.arch2be.empex.application.ports.in.GetGithubUserInfoService
import io.github.arch2be.empex.application.ports.out.LoadGithubUser
import io.github.arch2be.empex.fixtures.GithubUserFixtures
import spock.lang.Specification

class GetGithubUserInfo extends Specification {

    LoadGithubUser loadGithubUser = Stub(LoadGithubUser)
    GetGithubUserInfoService getGithubUserInfoService = new GetGithubUserInfoService(loadGithubUser)

    def "should found a github user when provided existing login"() {
        given:
            thereIsGithubUserWith(GithubUserFixtures.ARCH2BE_LOGIN)
        when:
            Optional<GithubUserDto> result = getGithubUserInfoService.findGithubUserByLogin(GithubUserFixtures.ARCH2BE_LOGIN)
        then:
            result.isPresent()
            compareGithubUserDto(GithubUserFixtures.CORRECT_RESPONSE_ARCH2BE, result.get())
    }

    def "should not found a github user when provided not existing login"() {
        given:
            thereIsNoGithubUserWith(GithubUserFixtures.ARCH2BE_LOGIN)
        when:
            Optional<GithubUserDto> result = getGithubUserInfoService.findGithubUserByLogin(GithubUserFixtures.ARCH2BE_LOGIN)
        then:
            result.isEmpty()
    }

    void thereIsGithubUserWith(String login) {
        loadGithubUser.loadByLogin(login) >> Optional.of(GithubUserFixtures.ARCH2BE)
    }

    void thereIsNoGithubUserWith(String login) {
        loadGithubUser.loadByLogin(login) >> Optional.empty()
    }

    void compareGithubUserDto(GithubUserDto expected, GithubUserDto result) {
        expected.calculations == result.calculations
        expected.avatarUrl == result.avatarUrl
        expected.createdAt == result.createdAt
        expected.login == result.login
        expected.name == result.name
        expected.type == result.type
        expected.id == result.id
    }
}
