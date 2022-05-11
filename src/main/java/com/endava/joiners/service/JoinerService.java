package com.endava.joiners.service;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.mapper.JoinerMapper;
import com.endava.joiners.model.Joiner;
import com.endava.joiners.repository.JoinerRepository;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JoinerService {

    @Autowired
    JoinerRepository joinerRepository;

    public Either<String, Joiner> addNewJoiner (JoinerDTO joinerDTO) {
        Joiner joiner = joinerRepository.save(JoinerMapper.toJoiner(joinerDTO));
        if(joiner == null){
            return Either.left("Joiner not found");
        }
        return Either.right(joiner);
    }

    public Either<String, Joiner> getJoiner(int joinerId){
        Optional<Joiner> joiner = joinerRepository.findById(joinerId);
        if( joiner.isEmpty()){
            return Either.left("Joiner not found");
        }
        return Either.right(joiner.get());
    }

    public Either<String, Joiner> updateJoiner(int joinerId, JoinerDTO joinerDTO){;
        Optional<Joiner> joiner = joinerRepository.findById(joinerId);

        if( joiner.isEmpty()){
            return Either.left("Joiner not found");
        }

        Joiner joinerToUpdate = JoinerMapper.toJoiner(joiner.get(),joinerDTO);
        Joiner joinerUpdated = joinerRepository.save(joinerToUpdate);

        if( joinerUpdated == null) {
            return Either.left("Joiner not updated");
        }
        return Either.right(joinerUpdated);
    }
}
