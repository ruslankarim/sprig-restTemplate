package web.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class CustomRestTemplate {
    RestTemplate restTemplate;

    @Autowired
    public CustomRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
