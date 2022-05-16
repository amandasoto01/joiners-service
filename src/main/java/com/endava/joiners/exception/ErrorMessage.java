package com.endava.joiners.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private Date timeStamp;
}
