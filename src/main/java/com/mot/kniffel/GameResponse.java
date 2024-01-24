package com.mot.kniffel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameResponse {
    private String gameID;
    private PlayerData[] playerData;
    private String currentPlayerName;

    private String state;
    private String[] usedBookingTypes;

    private String[] availableBookingTypes;
    private int[] diceRolls;
    private int rollRound;
}
