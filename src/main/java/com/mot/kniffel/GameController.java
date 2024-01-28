package com.mot.kniffel;

import com.oglimmer.kniffel.model.BookingType;
import com.oglimmer.kniffel.model.KniffelGame;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.ShiftRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/game")
@CrossOrigin
public class GameController {

    private GameResponse mapGameRsponse(KniffelGame game) {
        GameResponse gameResponse = modelMapper.map(game, GameResponse.class);
        gameResponse.setPlayerData(game.getPlayers().values().stream().map(p -> modelMapper.map(p, PlayerData.class)).toArray(PlayerData[]::new));
        gameResponse.setUsedBookingTypes(game.getCurrentPlayer().getUsedBookingTypes().stream().map(Enum::toString).toArray(String[]::new));
        gameResponse.setAvailableBookingTypes(Arrays.stream(BookingType.values()).filter(bt -> !game.getCurrentPlayer().getUsedBookingTypes().contains(bt)).map(Enum::toString).toArray(String [] ::new));
        return gameResponse;
    }

    @Autowired
    private GameService gameService;
    @Autowired
    private ModelMapper modelMapper;

    @Operation(
            summary = "Create a new game with a specific number of players",
            description = "The number of players must be at least 2. All players names must be different",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Game created", content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = GameResponse.class)
                            )
                    )
            }
    )


    @PostMapping("/")
    public GameResponse createGame(@RequestBody CreateGameRequest createGameRequest) {
        KniffelGame game = gameService.createGame(createGameRequest.getPlayerNames());
        return new GameResponse();
    }

    @GetMapping("/{gameId}")
    public GameResponse getGameInfo(@PathVariable String gameId) {
        return new GameResponse();
    }

    @PostMapping("/{gameId}/roll")
    public GameResponse roll(@PathVariable String gameId, @RequestBody DiceRollRequest diceRollRequest) {
        return new GameResponse();
    }

    @PostMapping("/{gameId}/book")
    public GameResponse book(@PathVariable String gameId, @RequestBody BookRollRequest bookRollRequest) {
        return new GameResponse();
    }

}
