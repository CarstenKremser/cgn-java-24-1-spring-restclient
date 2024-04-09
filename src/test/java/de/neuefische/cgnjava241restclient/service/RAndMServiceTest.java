package de.neuefische.cgnjava241restclient.service;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
class RAndMServiceTest {

    @Autowired
    private MockMvc mockMvc;

    private static MockWebServer mockWebServer;

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @DynamicPropertySource
    static void setDynamicPropertys(DynamicPropertyRegistry registry) {
        registry.add("RICKANDMORTYAPI_URL", () -> mockWebServer.url("/").toString());
    }


    @Test
    void getAllRickAndMortyCharById_whenCalledWithId1_shouldReturnCharacterRick() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                //.setResponseCode(200)
                .setBody("""
                        {
                            "id": 1,
                            "name": "Rick Sanchez",
                            "status": "Alive",
                            "species": "Human",
                            "type": "",
                            "gender": "Male",
                            "origin": {
                                "name": "Earth (C-137)",
                                "url": "https://rickandmortyapi.com/api/location/1"
                            },
                            "location": {
                                "name": "Citadel of Ricks",
                                "url": "https://rickandmortyapi.com/api/location/3"
                            },
                            "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                            "episode": [
                                "https://rickandmortyapi.com/api/episode/1",
                                "https://rickandmortyapi.com/api/episode/2",
                                "https://rickandmortyapi.com/api/episode/3",
                                "https://rickandmortyapi.com/api/episode/4",
                                "https://rickandmortyapi.com/api/episode/5"
                            ],
                            "url": "https://rickandmortyapi.com/api/character/1",
                            "created": "2017-11-04T18:48:46.250Z"
                        }""")
        );

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/character/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "id" : 1,
                            "name" : "Rick Sanchez"
                        }
                """));
    }
}