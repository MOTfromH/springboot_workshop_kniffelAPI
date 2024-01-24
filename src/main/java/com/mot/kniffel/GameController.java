package com.mot.kniffel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/game")
@CrossOrigin
public class GameController {

    @PostMapping("/")
    public GameResponse createGame(@RequestBody CreateGameRequest createGameRequest) {
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
