package utils;

import com.example.demo.dto.AbilitieDto;
import com.example.demo.dto.AbilityDto;
import com.example.demo.dto.PokemonDto;

import java.util.ArrayList;

public class PokemonDtoBuilder {
    public static PokemonDto withAllInfo() {
        AbilitieDto abilitieDto = new AbilitieDto();
        AbilityDto ability = new AbilityDto();
        ability.setName("ZipZapZum");
        abilitieDto.setAbility(ability);
        abilitieDto.setSlot(1);
        abilitieDto.set_hidden(false);

        AbilityDto ability1 = new AbilityDto();
        AbilitieDto abilitieDto1 = new AbilitieDto();
        ability1.setName("Choque do trovão");
        abilitieDto1.setAbility(ability1);
        abilitieDto1.setSlot(1);
        abilitieDto1.set_hidden(false);

        AbilityDto ability2 = new AbilityDto();
        AbilitieDto abilitieDto2 = new AbilitieDto();
        ability2.setName("Dormir");
        abilitieDto2.setAbility(ability2);
        abilitieDto2.setSlot(1);
        abilitieDto2.set_hidden(false);

        PokemonDto poke1 = new PokemonDto();
        poke1.setId(1);
        poke1.setName("Pikachu");
        ArrayList<AbilitieDto> abilitieDtos = new ArrayList<>();
        abilitieDtos.add(abilitieDto);
        abilitieDtos.add(abilitieDto1);
        abilitieDtos.add(abilitieDto2);
        poke1.setAbilities(abilitieDtos);
        poke1.orderAbilities();
        return poke1;
    }
}
