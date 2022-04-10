package io.github.arch2be.empex.framework;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == CLIENT_ERROR ||
                response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == SERVER_ERROR) {
            throw new GithubConnectionServerException("During connect with api.github exception occur");
        } else if (response.getStatusCode().series() == CLIENT_ERROR) {
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new GithubUserNotFoundException("User not found for api.github");
            }
        }
    }
}
