package com.endava.joiners.controller;

import com.endava.joiners.DTO.JoinerDTO;
import com.endava.joiners.model.Joiner;
import com.endava.joiners.service.JoinerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/joiner")
public class JoinerController {
    @Autowired
    JoinerService joinerService;

    @Operation(summary = "Create a joiner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Joiner",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class))})
                    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ResponseEntity<Joiner> postJoiner(@RequestBody JoinerDTO joinerDTO) {
        return joinerService.addNewJoiner(joinerDTO);
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
    @PutMapping("/{joiner_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Joiner> updateJoiner(@PathVariable int joinerId, JoinerDTO joinerDTO) {
        return joinerService.updateJoiner(joinerId, joinerDTO);
    }

    @Operation(summary = "Get joiner information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the joiner",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JoinerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Joiner not found",
                    content = @Content) })
    @GetMapping("/{joiner_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Joiner> getJoiner(@PathVariable int joinerId) {
        return joinerService.getJoiner(joinerId);
    }

}
