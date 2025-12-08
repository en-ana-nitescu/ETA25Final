package model.api;

import lombok.Data;

import java.util.HashMap;

@Data
public class NoteRequest {

    private String id;
    private String title;
    private String description;
    private String category;
    private Boolean completed;

    public NoteRequest(HashMap<String, String> testData) {
        prepareObject(testData);
    }

    public void prepareObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "title" -> setTitle(testData.get(key));
                case "description" -> setDescription(testData.get(key));
                case "category" -> setCategory(testData.get(key));
            }
        }
    }
}
