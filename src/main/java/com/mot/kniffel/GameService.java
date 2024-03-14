package com.mot.kniffel;

import com.oglimmer.kniffel.model.BookingType;
import com.oglimmer.kniffel.model.KniffelGame;
import com.oglimmer.kniffel.model.KniffelPlayer;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class GameService {

    private final Map<String, KniffelGame> games = new HashMap<>();
    public KniffelGame createGame(String[] playerNames) {
        List<KniffelPlayer> players = Arrays.stream(playerNames).map(KniffelPlayer::new).collect(Collectors.toList());
        KniffelGame kniffelGame = new KniffelGame(players);
        games.put(kniffelGame.getGameId(), kniffelGame);
        return kniffelGame;
    }
    public KniffelGame getGamesInfo(String gameID){
        return games.get(gameID);
    }
    public void roll(KniffelGame kniffelGame, int[] diceToKeep){
        kniffelGame.reRollDice(diceToKeep);
    }
    public void bookRoll(KniffelGame kniffelGame, BookingType enumBookingType){
        kniffelGame.bookDiceRoll(enumBookingType);
    }

}
