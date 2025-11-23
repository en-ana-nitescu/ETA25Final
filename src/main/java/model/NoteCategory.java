package model;

public enum NoteCategory {

    WORK("Work"),

    PERSONAL("Personal"),

    HOME("Home");

    private final String value;

    NoteCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
