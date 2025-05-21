package com.gmail.davidsavignac.medical.diagnostic.service;

import java.util.List;

public interface MedicalUnitService {

    /**
     * Find the medical units required to cure the patient
     *
     * @param healthIndex health index of the patient
     * @return The list of medical units to send the patient to
     */
    List<String> findMedicalUnitsToSendPatient(int healthIndex);

}
