package com.example.demo.controllers;


import com.example.demo.dto.PokemonDto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.services.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    private PokeApiService pokeApiService;
    @GetMapping("/search")
    public ResponseEntity<PokemonDto> getPokemon(@RequestParam("name") String name) throws NotFoundException, BadRequestException, BusinessException {
        if (name.isEmpty()) {
            throw new BadRequestException("O nome deve ser enviado");
        }
        PokemonDto pokemonDto = pokeApiService.getPokemonByName(name);
        pokemonDto.orderAbilities();
        return ResponseEntity.status(HttpStatus.OK).body(pokemonDto);
    }
}
// Front com input e botão pra chamar o backend