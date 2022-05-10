package com.endava.joiners.service;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.mapper.JoinerMapper;
import com.endava.joiners.model.Joiner;
import com.endava.joiners.repository.JoinerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JoinerService {

    @Autowired
    JoinerRepository joinerRepository;

    public ResponseEntity<Joiner> addNewJoiner (JoinerDTO joinerDTO) {
        System.out.println("JoinerDTO " + joinerDTO);
        System.out.println(JoinerMapper.toJoiner(joinerDTO));
        Joiner joiner = joinerRepository.save(JoinerMapper.toJoiner(joinerDTO));
        System.out.println("Joiner "+joiner);
        return new ResponseEntity<>(joiner, HttpStatus.OK);
    }

    public ResponseEntity<Joiner> getJoiner(int joinerId){
        System.out.print(joinerId);
        Optional<Joiner> joiner = joinerRepository.findById(joinerId);
        if( joiner.isEmpty() ){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(joiner.get(), HttpStatus.OK);
    }

    public ResponseEntity<Joiner> updateJoiner(int joinerId, JoinerDTO joinerDTO){;
        Optional<Joiner> joiner = joinerRepository.findById(joinerDTO.getIdentificationNumber());
        if( joiner.isEmpty() ){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(joiner.get(), HttpStatus.OK);
    }
}
