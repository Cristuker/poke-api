package com.example.demo.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import utils.PokemonDtoBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonDtoTest {

    @Test
    @DisplayName("Deve ordenar as habilidades do pokemon")
    void orderAbilities() {
        PokemonDto poke1 = PokemonDtoBuilder.withAllInfo();
        assertEquals(poke1.getAbilities().get(0).getAbility().getName(), "Choque do trovão");
        assertEquals(poke1.getAbilities().get(1).getAbility().getName(), "Dormir");
        assertEquals(poke1.getAbilities().get(2).getAbility().getName(), "ZipZapZum");
    }
}