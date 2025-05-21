package com.gmail.davidsavignac.medical.diagnostic.service;

import com.gmail.davidsavignac.medical.diagnostic.model.Pathology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalUnitServiceImpl implements MedicalUnitService {


    @Override
    public List<String> findMedicalUnitsToSendPatient(int healthIndex) {

        List<Pathology> pathologies = identifyPatientPathologies(healthIndex);
        return pathologies.stream().map(pathology -> pathology.getMedicalUnit().getName()).toList();
    }


    /**
     * Identify the patient's pathologies measured by the health index
     * If health index is a multiple of 3, pathology is of type Pathology.CARDIAC
     * If health index is a multiple of 5, pathology is of type Pathology.FRACTURE
     *
     * @param healthIndex health index of the patient
     * @return the list of patient's pathologies
     */
    private List<Pathology> identifyPatientPathologies(int healthIndex) {

        List<Pathology> pathologies = new ArrayList<>();
        if (healthIndex % 3 == 0) {
            pathologies.add(Pathology.CARDIAC);
        }
        if (healthIndex % 5 == 0) {
            pathologies.add(Pathology.FRACTURE);
        }

        return pathologies;
    }


}
