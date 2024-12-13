package org.example.oiltdspringsachahassan.service;

import org.example.oiltdspringsachahassan.entity.DiceRollLog;
import org.example.oiltdspringsachahassan.repository.DiceRollLogRepository;
import org.example.oiltdspringsachahassan.component.Dice;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DiceServiceTest {

    @Test
    public void testRollDices() {
        Dice dice = mock(Dice.class);
        DiceRollLogRepository repository = mock(DiceRollLogRepository.class);
        DiceService service = new DiceService(dice, repository);

        when(dice.rollMultiple(2)).thenReturn(new int[]{3, 5});

        List<Integer> results = service.rollDices(2);

        assertEquals(2, results.size());
        assertEquals(3, results.get(0));
        assertEquals(5, results.get(1));

        verify(repository, times(1)).save(Mockito.any(DiceRollLog.class));
    }
}
