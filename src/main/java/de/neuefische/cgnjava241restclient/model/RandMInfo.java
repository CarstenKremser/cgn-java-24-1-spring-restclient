package de.neuefische.cgnjava241restclient.model;

public record RandMInfo(int count, int pages, String next, String prev) {
    /*
       "info": {
        "count": 439,
        "pages": 22,
        "next": "https://rickandmortyapi.com/api/character?page=2&status=alive",
        "prev": null
    },

     */
}
