package com.endava.joiners.service;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.mapper.JoinerMapper;
import com.endava.joiners.model.Joiner;
import com.endava.joiners.repository.JoinerRepository;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JoinerServiceImpl implements JoinerService{

    @Autowired
    JoinerRepository joinerRepository;

    public Either<String, Joiner> addNewJoiner (JoinerDTO joinerDTO) {
        Joiner joiner = joinerRepository.save(JoinerMapper.toJoiner(joinerDTO));
        if(joiner == null){
            return Either.left("Joiner not created");
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

        Joiner joinerToUpdate = JoinerMapper.toJoinerDTO(joiner.get());
        Joiner joinerUpdated = joinerRepository.save(joinerToUpdate);

        if( joinerUpdated == null) {
            return Either.left("Joiner not updated");
        }
        return Either.right(joinerUpdated);
    }

    public Either<String, String>  deleteJoiner(int joinerId){
        try {
            joinerRepository.deleteById(joinerId);
            return Either.right("Joiner with id " + joinerId + " deleted");

        } catch (EmptyResultDataAccessException ex) {
            return Either.left("Joiner not found");
        }
    }

    public Either<String,List<JoinerDTO>> getJoiners(String field, String value) {
        List<Joiner> joiners = getJoinersByField(field,value);

        if(joiners.isEmpty()) {
            return Either.left("Joiners by field " + field + " with value " + value + " not found");
        }

        List joinersDto = joiners
                .stream()
                .map( joiner -> JoinerMapper.toJoinerDTO(joiner))
                .collect(Collectors.toList());

        return Either.right(joinersDto);
    }

    private List<Joiner> getJoinersByField (String field, String value){
        List<Joiner> joiners;

        if (field.equals("stack")) {
            return joinerRepository.findByStack(value);
        } else if(field.equals("role")) {
            return joinerRepository.findByRole(value);
        } else if(field.equals("englishLevel")) {
            return joinerRepository.findByEnglishLevel(value);
        } else if(field.equals("domainExperience")){
           return joinerRepository.findByDomainExperience(value);
        } else {
            return new ArrayList<Joiner>();
        }
    }
}
