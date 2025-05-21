package com.gmail.davidsavignac.medical.diagnostic.model;

public enum Pathology {

    CARDIAC("Cardiaque", MedicalUnit.CARDIOLOGY),
    FRACTURE("Fracture", MedicalUnit.TRAUMATOLOGY);

    private final String name;

    private final MedicalUnit medicalUnit;

    Pathology(String name, MedicalUnit medicalUnit) {
        this.name = name;
        this.medicalUnit = medicalUnit;
    }


    public String getName() {
        return name;
    }

    public MedicalUnit getMedicalUnit() {
        return medicalUnit;
    }
}
