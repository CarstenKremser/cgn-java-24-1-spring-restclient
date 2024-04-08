package de.neuefische.cgnjava241restclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RAndMResponse {


    private List<RAndMChar> results;

}
