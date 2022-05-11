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
        joiner.setEnglishLevel(joinerDTO.getEnglishLevel());
        joiner.setDomainExperience(joinerDTO.getDomainExperience());
        joiner.setName(joinerDTO.getName());
        return joiner;
    }

    public static Joiner toJoiner (Joiner joiner, JoinerDTO joinerDTO) {
        joiner.setIdentificationNumber(joinerDTO.getIdentificationNumber());
        joiner.setName(joinerDTO.getName());
        joiner.setLastName(joinerDTO.getLastName());
        joiner.setStack(joinerDTO.getStack());
        joiner.setRole(joinerDTO.getRole());
        joiner.setEnglishLevel(joinerDTO.getEnglishLevel());
        joiner.setDomainExperience(joinerDTO.getDomainExperience());
        joiner.setName(joinerDTO.getName());
        return joiner;
    }

}
