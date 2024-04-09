package de.neuefische.cgnjava241restclient.service;

import de.neuefische.cgnjava241restclient.model.RAndMChar;
import de.neuefische.cgnjava241restclient.model.RAndMResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RAndMService {

    private final RestClient client;

    public RAndMService(@Value("${RICKANDMORTYAPI_URL}") String baseUrl) {
        client = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<RAndMChar> getAllRickAndMortyChars() {
        return client.get()
                .uri("/character")
                .retrieve()
                .body(RAndMResponse.class)
                .getResults();
    }

    public RAndMChar getRickAndMortyCharById(String id) {
        return client.get()
                .uri("/character/" + id)
                .retrieve()
                .body(RAndMChar.class);
    }

    public List<RAndMChar> getRickAndMortyCharsByStatus(String status) {
        return client.get()
                .uri("/character/?status=" + status)
                .retrieve()
                .body(RAndMResponse.class)
                .getResults();
    }

    public Integer getRickAndMortyCharCountByStatus(String status) {
        return client.get()
                .uri("/character/?status=" + status)
                .retrieve()
                .body(RAndMResponse.class)
                .getInfo().count();
    }

    public Integer getRickAndMortyAliveCharacterCountBySpecies(String species) {
        return client.get()
                .uri("/character/?status=alive&species=" + species)
                .retrieve()
                .body(RAndMResponse.class)
                .getInfo().count();
    }
}
