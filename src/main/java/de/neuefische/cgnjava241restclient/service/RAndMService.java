package de.neuefische.cgnjava241restclient.service;

import de.neuefische.cgnjava241restclient.model.RAndMChar;
import de.neuefische.cgnjava241restclient.model.RAndMResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RAndMService {

    private RestClient currywurst = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();

    public List<RAndMChar> getAllRickAndMortyChars() {
       return currywurst.get()
                .uri("/character")
                .retrieve()
                .body(RAndMResponse.class)
               .getResults();
    }
}
