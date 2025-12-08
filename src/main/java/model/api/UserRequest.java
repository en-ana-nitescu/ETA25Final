package model.api;

import lombok.Data;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class UserRequest {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String company;

    public UserRequest(HashMap<String, String> testData) {
        prepareObject(testData);
    }

    public void prepareObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "name" -> setName(testData.get(key));
                case "email" -> setEmail(testData.get(key) + ThreadLocalRandom.current().nextInt(100000, 999999) + "@test.com");
                case "password" -> setPassword(testData.get(key));
                case "phone" -> setPhone(testData.get(key));
                case "company" -> setCompany(testData.get(key));
            }
        }
    }
}
