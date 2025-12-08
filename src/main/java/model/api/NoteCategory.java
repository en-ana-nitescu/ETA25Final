package model.api;

import lombok.Getter;

@Getter
public enum NoteCategory {

    WORK("Work"),

    PERSONAL("Personal"),

    HOME("Home");

    private final String value;

    NoteCategory(String value) {
        this.value = value;
    }

}
