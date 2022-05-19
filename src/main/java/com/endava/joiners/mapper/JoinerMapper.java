package com.endava.joiners.mapper;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.model.Joiner;

public class JoinerMapper {

    public static Joiner toJoiner (JoinerDTO joinerDTO) {
        Joiner joiner = new Joiner();
        joiner.setIdentificationNumber(joinerDTO.getIdentificationNumber());
        joiner.setName(joinerDTO.getName());
        joiner.setLastName(joinerDTO.getLastName());
        joiner.setStack(joinerDTO.getStack());
        joiner.setRole(joinerDTO.getRole());
        joiner.setEnglishLevel(String.valueOf(joinerDTO.getEnglishLevel()));
        joiner.setDomainExperience(joinerDTO.getDomainExperience());
        joiner.setName(joinerDTO.getName());
        return joiner;
    }

    public static Joiner toJoinerDTO (Joiner joiner) {
        JoinerDTO joinerDTO = new JoinerDTO();
        joinerDTO.setIdentificationNumber(joiner.getIdentificationNumber());
        joinerDTO.setName(joiner.getName());
        joinerDTO.setLastName(joiner.getLastName());
        joinerDTO.setStack(joiner.getStack());
        joinerDTO.setRole(joiner.getRole());
        joinerDTO.setEnglishLevel(JoinerDTO.EnglishLevel.valueOf(joiner.getEnglishLevel()));
        joinerDTO.setDomainExperience(joiner.getDomainExperience());
        joinerDTO.setName(joiner.getName());
        return joiner;
    }

}
