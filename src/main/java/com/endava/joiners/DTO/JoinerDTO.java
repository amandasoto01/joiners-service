package com.endava.joiners.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class JoinerDTO {
    public enum EnglishLevel {
        A1,
        A2,
        B1,
        B2,
        C1,
        C2;
    }

    @Schema(description = "Identification number")
    @NotNull
    @Positive
    private int identificationNumber;
    @Schema(description = "Name of the new joiner")
    private String name;
    @Schema(description = "Last name of the new joiner")
    private String lastName;
    @Schema(description = "Stack of the new joiner")
    @NotBlank(message = "Stack is mandatory")
    private String stack;
    @Schema(description = "Grade of the new joiner")
    private String role;
    @Schema(description = "English level of the new joiner language", example = "B1")
    private EnglishLevel englishLevel;
    @Schema(description = "Domain experience", example = "java")
    private String domainExperience;

}
