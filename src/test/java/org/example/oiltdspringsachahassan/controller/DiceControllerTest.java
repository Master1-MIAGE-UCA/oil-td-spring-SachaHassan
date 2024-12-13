package org.example.oiltdspringsachahassan.controller;

import org.example.oiltdspringsachahassan.service.DiceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DiceController.class)
public class DiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDiceRollHistory() throws Exception {
        DiceService service = Mockito.mock(DiceService.class);
        Mockito.when(service.getDiceLogs()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/api/history"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
    }
}
