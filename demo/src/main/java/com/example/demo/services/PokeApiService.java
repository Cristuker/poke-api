package com.example.demo.services;

import com.example.demo.dto.PokemonDto;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

public interface PokeApiService {
    PokemonDto getPokemonByName(String name) throws NotFoundException, BusinessException;
}
