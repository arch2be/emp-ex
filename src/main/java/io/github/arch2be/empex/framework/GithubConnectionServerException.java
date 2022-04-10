package io.github.arch2be.empex.framework;

import org.springframework.web.client.RestClientException;

class GithubConnectionServerException extends RestClientException {

    public GithubConnectionServerException(String msg) {
        super(msg);
    }
}
