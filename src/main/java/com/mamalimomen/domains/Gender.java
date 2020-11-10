package com.mamalimomen.domains;

public enum Gender {
    MALE(1),
    FEMALE(2);

    private final int genderCode;

    Gender(int genderCode) {
        this.genderCode = genderCode;
    }

    public static Gender getGender(int genderCode) {
        for (Gender gender : values()) {
            if (gender.genderCode == genderCode) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid Gender code: " + genderCode);
    }
}
