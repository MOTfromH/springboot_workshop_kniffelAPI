package com.mot.kniffel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateGameRequest {
    private String [] playerNames;
}
