package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class NoteResponse<T> {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;;
}
