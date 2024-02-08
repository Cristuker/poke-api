package com.example.demo.services.impl;

import com.example.demo.dto.PokemonDto;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.services.PokeApiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PokeApiServiceImp implements PokeApiService {

    @Autowired
    RestTemplate restTemplate;
    private final String  POKEMON_API_URL = "https://pokeapi.co/api/v2";
    @Override
    public PokemonDto getPokemonByName(String name) throws NotFoundException, BusinessException {
        try {
            String url = POKEMON_API_URL + "/pokemon/"+ name;
            PokemonDto pokemonDto = restTemplate.getForObject(url, PokemonDto.class);
            if (pokemonDto == null) {
                throw new NotFoundException("Pokemon não encontrado");
            }
            return pokemonDto;
        } catch (HttpClientErrorException ex) {
            throw new BusinessException(ex.getLocalizedMessage());
        }
    }
}
