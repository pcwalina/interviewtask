package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDoesNotExistException extends RuntimeException  {

    public UserDoesNotExistException() {
        super("User does not exist");
    }
}
