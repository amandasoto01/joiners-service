package com.endava.joiners.controller;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.exception.JoinerNotFoundException;
import com.endava.joiners.model.Joiner;
import com.endava.joiners.service.JoinerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/joiner")
public class JoinerController {
    @Autowired
    JoinerService joinerServiceImpl;

    @Operation(summary = "Create a joiner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Joiner",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class))})
                    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = "application/json")
    public ResponseEntity<Object> addNewJoiner(@Valid @RequestBody JoinerDTO joinerDTO) {
        Either<String, Joiner> eitherJoiner = joinerServiceImpl.addNewJoiner(joinerDTO);
        if (eitherJoiner.isLeft()) {
            return new ResponseEntity<>("Could not add new joiner", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(eitherJoiner.get(), HttpStatus.OK);
    }

    @Operation(summary = "Update a Joiner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the joiner",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Joiner not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error`",
                    content = @Content)})
    @PutMapping(value = "/{joiner_id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Joiner> updateJoiner(@PathVariable("joiner_id") int joinerId, @Valid @RequestBody JoinerDTO joinerDTO) {
        Either<String, Joiner> eitherJoiner = joinerServiceImpl.updateJoiner(joinerId,joinerDTO);
        if (eitherJoiner.isLeft()) {
            throw new JoinerNotFoundException(eitherJoiner.getLeft());
        }
        return new ResponseEntity<>(eitherJoiner.get(), HttpStatus.OK);
    }

    @Operation(summary = "Get joiner information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the joiner",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Joiner not found",
                    content = @Content) })
    @GetMapping(value = "/{joiner_id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Joiner> getJoiner(@PathVariable("joiner_id") int joinerId) {
        Either<String, Joiner> eitherJoiner = joinerServiceImpl.getJoiner(joinerId);
        if (eitherJoiner.isLeft()) {
            throw new JoinerNotFoundException(eitherJoiner.getLeft());
        }
        return new ResponseEntity<>(eitherJoiner.get(), HttpStatus.OK);
    }

    @Operation(summary = "Delete joiner information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the joiner",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Joiner not found",
                    content = @Content) })
    @DeleteMapping(value = "/{joiner_id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteJoiner(@PathVariable("joiner_id") int joinerId) {
        Either<String, String> eitherJoiner = joinerServiceImpl.deleteJoiner(joinerId);
        if (eitherJoiner.isLeft()) {
            throw new JoinerNotFoundException(eitherJoiner.getLeft());
        }
        return new ResponseEntity<>(eitherJoiner.get(), HttpStatus.OK);
    }

    @Operation(summary = "Get a list of joiners")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the joiner",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Joiner not found",
                    content = @Content) })
    @GetMapping(value = "/list", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<JoinerDTO>> getJoiners(@RequestParam("field") String field, @RequestParam("value") String value) {
        Either<String,List<JoinerDTO>> joiners = joinerServiceImpl.getJoiners(field, value);

        if (joiners.isLeft()) {
            throw new JoinerNotFoundException(joiners.getLeft());
        }
        
        return new ResponseEntity<>(joiners.get(), HttpStatus.OK);
    }

}
