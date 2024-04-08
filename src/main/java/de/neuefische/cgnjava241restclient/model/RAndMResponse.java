package de.neuefische.cgnjava241restclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RAndMResponse {

    private RandMInfo info;
    private List<RAndMChar> results;

}
