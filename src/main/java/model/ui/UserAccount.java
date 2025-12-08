package model.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import model.GeneralObject;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class UserAccount extends GeneralObject {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public UserAccount(String dataPath) {
        fromJsonFileToObject(dataPath);
        adjustProperties();
    }

    public void adjustProperties() {
        userName += ThreadLocalRandom.current().nextInt(10000, 99999);
    }

}
