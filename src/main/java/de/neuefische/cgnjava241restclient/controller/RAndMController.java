package de.neuefische.cgnjava241restclient.controller;

import de.neuefische.cgnjava241restclient.model.RAndMChar;
import de.neuefische.cgnjava241restclient.service.RAndMService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RAndMController {

    private final RAndMService service;

    @GetMapping("/rick")
    public List<RAndMChar> getAllRickAndMortyChars(){
        return service.getAllRickAndMortyChars();
    }

    @GetMapping("/character")
    public List<RAndMChar> getRickAndMortyCharsByStatus(@RequestParam("status") String status){
        return service.getRickAndMortyCharsByStatus(status);
    }

    @GetMapping("/character/{id}")
    public RAndMChar getRickAndMortyCharsById(@PathVariable("id") String id){
        return service.getRickAndMortyCharById(id);
    }

    @GetMapping("/species-statistic")
    public Integer getRickAndMortyAliveCharacterCountByStatus(@RequestParam("species") String species){
        return service.getRickAndMortyAliveCharacterCountBySpecies(species);
    }

}
