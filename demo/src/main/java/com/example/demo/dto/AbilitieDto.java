package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.Collator;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilitieDto implements Comparable<AbilitieDto>{
    private AbilityDto ability;
    private boolean is_hidden;
    private int slot;

    @Override
    public int compareTo(AbilitieDto other) {
        return this.ability.getName().compareTo(other.ability.getName());
    }
}
