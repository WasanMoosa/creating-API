package com.ttt.api.TicTacToeAPI.controller;

import model.Board;
import model.Bot;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class MainController {
    @PostMapping
    public HashMap<String, Object> GetBoard(@RequestBody Board inputBoard) {
        // Create hashmap to represent response
        HashMap<String, Object> response = new HashMap<>();

        // Take board from body of URL, then put it in the board
        Board board = inputBoard;
        response.put("board", board.getGrid());
        board.setSymbol('O');
        // Check if there is already a winner
        if (!board.win()) {

            // Create bot
            Bot bot = new Bot('X');

            // Set symbol of bot in board object
            board.setSymbol(bot.getSymbol());

            int[] position = new int[2];

            // Choose random position for Bot
            position = bot.makeMove(board);

            // Change position
            board.changePosition(position[0], position[1]);

            // State status
            if (board.win()) {
                response.put("status", "Bot won");
            } else {
                if (board.isGridFull()) {
                    response.put("status", "It's Draw!");
                } else {
                    response.put("status", "Bot has played");
                }
            }

            response.put("board", board.getGrid());
        } else {
            response.put("status", "Player 1 is already won");
        }

        return response;

    }


}
