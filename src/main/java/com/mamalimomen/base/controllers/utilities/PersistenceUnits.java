package com.mamalimomen.base.controllers.utilities;

public enum PersistenceUnits {
    UNIT_ONE("orm-unit"),
    UNIT_TWO("ogm-unit");

    private final String unitName;

    PersistenceUnits(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return this.unitName;
    }
}
