package org.example.oiltdspringsachahassan.controller;

import org.example.oiltdspringsachahassan.entity.DiceRollLog;
import org.example.oiltdspringsachahassan.service.DiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    private final DiceService diceService;

    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    @GetMapping("/rollDice")
    public List<Integer> rollOneDice() {
        return diceService.rollDices(1);
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return diceService.rollDices(count);
    }

    @GetMapping("/history")
    public List<DiceRollLog> getDiceRollHistory() {
        return diceService.getDiceLogs();
    }

}
