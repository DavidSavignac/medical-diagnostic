package com.gmail.davidsavignac.medical.diagnostic.model;

public enum MedicalUnit {


    CARDIOLOGY("Cardiologie"),
    TRAUMATOLOGY("Traumatologie");

    private final String name;

    MedicalUnit(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
