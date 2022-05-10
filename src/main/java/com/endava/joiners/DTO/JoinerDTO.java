package com.endava.joiners.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class JoinerDTO {

    @Schema(description = "Identification number")
    private int identificationNumber;
    @Schema(description = "Name of the new joiner")
    private String name;
    @Schema(description = "Last name of the new joiner")
    private String lastName;
    @Schema(description = "Stack of the new joiner")
    private String stack;
    @Schema(description = "Grade of the new joiner")
    private String role;
    @Schema(description = "English level of the new joiner language", example = "B1")
    private String englishLevel;
    @Schema(description = "Domain experience", example = "java")
    private String domainExperience;

}
