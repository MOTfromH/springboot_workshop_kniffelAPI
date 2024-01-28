package com.mot.kniffel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Schema(description = "Game creation request")
@Getter
@Setter
@ToString
public class CreateGameRequest {
    @Schema(description = "Defines the participating players. Each player name must be different ans at least 2 players ahve to be provided",
        example = "[\"john doe\", \"jane doe\"]")
    private String [] playerNames;
}
