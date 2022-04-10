package io.github.arch2be.empex.framework;

import org.springframework.web.client.RestClientException;

class GithubUserNotFoundException extends RestClientException {
    public GithubUserNotFoundException(String msg) {
        super(msg);
    }
}
