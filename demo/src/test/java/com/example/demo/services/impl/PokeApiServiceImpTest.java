package com.example.demo.services.impl;

import com.example.demo.dto.PokemonDto;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.web.client.RestTemplate;
import utils.PokemonDtoBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PokeApiServiceImpTest {

    @InjectMocks
    PokeApiServiceImp pokeApiServiceImp;
    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        pokeApiServiceImp = new PokeApiServiceImp(restTemplate);
    }

    @Test
    @DisplayName("Deve retornar um pokemon da API de pokemons")
    void getPokemonByName() throws BusinessException, NotFoundException {
        PokemonDto poke1 = PokemonDtoBuilder.withAllInfo();
        when(restTemplate.getForObject(Mockito.anyString(), any())).thenReturn(poke1);
        PokemonDto pokemonDto = pokeApiServiceImp.getPokemonByName("pikachu");
        assertEquals(poke1.getName(), pokemonDto.getName());
    }
}