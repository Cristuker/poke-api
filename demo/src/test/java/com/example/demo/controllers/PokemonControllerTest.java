package com.example.demo.controllers;

import com.example.demo.dto.PokemonDto;
import com.example.demo.services.PokeApiService;
import com.example.demo.services.impl.PokeApiServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import utils.PokemonDtoBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PokeApiService pokeApiService;

    @Test
    @DisplayName("Deve retornar um pokemon")
    void getPokemon() throws Exception {
        PokemonDto poke1 = PokemonDtoBuilder.withAllInfo();
        when(pokeApiService.getPokemonByName(Mockito.anyString())).thenReturn(poke1);
        mockMvc.perform(get("/api/pokemon/search?name=pikachu"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve retornar 400 quando o nome estiver vazio")
    void searchEmpty() throws Exception {
        PokemonDto poke1 = PokemonDtoBuilder.withAllInfo();
        when(pokeApiService.getPokemonByName(Mockito.anyString())).thenReturn(poke1);
        mockMvc.perform(get("/api/pokemon/search?name="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}