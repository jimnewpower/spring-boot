package com.example.demo.services;

import com.example.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {
    private static final String BASE_URL = "http://api.open-notify.org";

    private final RestTemplate template;
    private final WebClient client;

    @Autowired
    public AstroService(RestTemplateBuilder restBuilder, WebClient.Builder webClientBuilder) {
        template = restBuilder.build();
        client = webClientBuilder.baseUrl(BASE_URL).build();

    }

    public AstroResult getAstronautsRT() {
        String url = BASE_URL + "/astros.json";
        return template.getForObject(url, AstroResult.class);
    }

    public AstroResult getAstronautsWC() {
        return client.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}
