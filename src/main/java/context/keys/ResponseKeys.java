package context.keys;

import lombok.Getter;

@Getter
public enum ResponseKeys {

    RESPONSE_OBJECT("responseObject"),
    RESPONSE_USERID("userId"),
    RESPONSE_EMAIL("email"),
    RESPONSE_TOKEN("token"),
    RESPONSE_NOTE("noteId");

    private final String key;

    ResponseKeys(String key) {
        this.key = key;
    }
}
