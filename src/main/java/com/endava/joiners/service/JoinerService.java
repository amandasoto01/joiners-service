package com.endava.joiners.service;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.model.Joiner;
import io.vavr.control.Either;

import java.util.List;

public interface JoinerService {
    public Either<String, Joiner> addNewJoiner (JoinerDTO joinerDTO);
    public Either<String, Joiner> getJoiner(int joinerId);
    public Either<String, Joiner> updateJoiner(int joinerId, JoinerDTO joinerDTO);
    public Either<String, String>  deleteJoiner(int joinerId);
    public Either<String,List<JoinerDTO>> getJoiners(String field, String value);


}
