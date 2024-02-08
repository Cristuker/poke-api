package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto  {
   private List<AbilitieDto> abilities;
   private String name;
   private int id;
   private SpritesDto sprites;
   public void orderAbilities() {
      Collections.sort(this.abilities);
   }

}
