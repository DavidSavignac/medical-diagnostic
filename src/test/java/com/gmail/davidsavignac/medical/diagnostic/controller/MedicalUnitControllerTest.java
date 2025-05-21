package com.gmail.davidsavignac.medical.diagnostic.controller;

import com.gmail.davidsavignac.medical.diagnostic.model.MedicalUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MedicalUnitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenHealthIndexMultipleOf3_whenFindRequiredMedicalUnits_thenReturnCardiologyMedicalUnit() throws Exception {

        int healthIndex = 33;

        String jsonResponse = mockMvc.perform(get("/medical-unit/health/" + healthIndex))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[\"" + MedicalUnit.CARDIOLOGY.getName() + "\"]", jsonResponse);
    }

    @Test
    void givenHealthIndexMultipleOf5_whenFindRequiredMedicalUnits_thenReturnTraumatologyMedicalUnit() throws Exception {

        int healthIndex = 55;

        String jsonResponse = mockMvc.perform(get("/medical-unit/health/" + healthIndex))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[\"" + MedicalUnit.TRAUMATOLOGY.getName() + "\"]", jsonResponse);
    }

    @Test
    void givenHealthIndexMultipleOf3And5_whenFindRequiredMedicalUnits_thenReturnCardioAndTraumaMedicalUnit() throws Exception {

        int healthIndex = 15;

        String jsonResponse = mockMvc.perform(get("/medical-unit/health/" + healthIndex))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(jsonResponse).contains(MedicalUnit.CARDIOLOGY.getName(), MedicalUnit.TRAUMATOLOGY.getName());
    }

    @Test
    void givenHealthIndexNotMultipleOf3Or5_whenFindRequiredMedicalUnits_thenReturnEmpty() throws Exception {

        int healthIndex = 1;

        String jsonResponse = mockMvc.perform(get("/medical-unit/health/" + healthIndex))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[]", jsonResponse);
    }

    @Test
    void givenNegativeHealthIndex_whenFindRequiredMedicalUnits_thenBadRequest() throws Exception {

        int healthIndex = -14;

        mockMvc.perform(get("/medical-unit/health/" + healthIndex))
                .andExpect(status().isBadRequest());


    }





}