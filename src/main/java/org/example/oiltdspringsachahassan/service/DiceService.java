package org.example.oiltdspringsachahassan.service;

import org.example.oiltdspringsachahassan.entity.DiceRollLog;
import org.example.oiltdspringsachahassan.repository.DiceRollLogRepository;
import org.example.oiltdspringsachahassan.component.Dice;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository repository;

    public DiceService(Dice dice, DiceRollLogRepository repository) {
        this.dice = dice;
        this.repository = repository;
    }

    public List<Integer> rollDices(int diceCount) {
        int[] resultsArray = dice.rollMultiple(diceCount);
        try{
            List<Integer> results = Arrays.stream(resultsArray)
                    .boxed()
                    .collect(Collectors.toList());
            DiceRollLog log = new DiceRollLog(diceCount, results);
            repository.save(log);
            return results;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<DiceRollLog> getDiceLogs() {
        return repository.findAll();
    }
}
