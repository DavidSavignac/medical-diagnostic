package com.gmail.davidsavignac.medical.diagnostic.controller;


import com.gmail.davidsavignac.medical.diagnostic.service.MedicalUnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-unit")
public class MedicalUnitController {

    private final MedicalUnitService medicalUnitService;


    public MedicalUnitController(MedicalUnitService medicalUnitService1) {
        this.medicalUnitService = medicalUnitService1;
    }

    @Operation(
            summary = "Diagnose a patient",
            description = "Returns the medical units to be consulted based on the patient's health index",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Diagnostic successful"),
                    @ApiResponse(responseCode = "400", description = "Invalid health index")
            }
    )
    @GetMapping("/health/{index}")
    public ResponseEntity<List<String>> findRequiredMedicalUnits(@PathVariable("index") int healthIndex) {

        if (healthIndex < 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(medicalUnitService.findMedicalUnitsToSendPatient(healthIndex));
    }
}
