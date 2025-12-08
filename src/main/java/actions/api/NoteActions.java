package actions.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import model.api.NoteData;
import model.api.NoteRequest;
import model.api.NoteResponse;
import service.api.NoteServiceImpl;
import utils.ResponseStatus;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NoteActions {

    Response response;
    NoteServiceImpl noteService;
    private final Gson gson = new Gson();

    public NoteActions() {
        noteService = new NoteServiceImpl();
    }

    public NoteResponse<NoteData> createNote(NoteRequest body, String token) {
        response = noteService.createNote(body, token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        NoteResponse<NoteData> noteResponse = parseResponse(response, new TypeToken<NoteResponse<NoteData>>() {
        }.getType());
        assertEquals(noteResponse.getSuccess(), true);
        assertEquals(noteResponse.getMessage(), "Note successfully created");
        return noteResponse;
    }

    public NoteResponse<List<NoteData>> getAllNotes(String token) {
        response = noteService.getAllNotes(token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        NoteResponse<List<NoteData>> notesResponse = parseResponse(response, new TypeToken<NoteResponse<List<NoteData>>>() {
        }.getType());
        assertEquals(notesResponse.getSuccess(), true);
        assertEquals(notesResponse.getMessage(), "Notes successfully retrieved");
        return notesResponse;
    }

    public NoteResponse<NoteData> getNoteById(String noteId, String token) {
        response = noteService.getNoteById(noteId, token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        NoteResponse<NoteData> noteResponse = parseResponse(response, new TypeToken<NoteResponse<NoteData>>() {
        }.getType());
        assertEquals(noteResponse.getSuccess(), true);
        assertEquals(noteResponse.getMessage(), "Note successfully retrieved");
        assertEquals(noteResponse.getData().getId(), noteId);
        return noteResponse;
    }

    public NoteResponse<NoteData> updateNote(String noteId, NoteRequest body, String token) {
        response = noteService.updateNote(noteId, body, token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        NoteResponse<NoteData> noteResponse = parseResponse(response, new TypeToken<NoteResponse<NoteData>>() {
        }.getType());
        assertEquals(noteResponse.getSuccess(), true);
        assertEquals(noteResponse.getMessage(), "Note successfully Updated");
        assertEquals(noteResponse.getData().getId(), noteId);
        assertEquals(noteResponse.getData().getCompleted(), "true");
        return noteResponse;
    }

    public NoteResponse<NoteData> deleteNote(String noteId, String token) {
        response = noteService.deleteNote(noteId, token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        NoteResponse<NoteData> noteResponse = parseResponse(response, new TypeToken<NoteResponse<NoteData>>() {
        }.getType());
        assertEquals(noteResponse.getSuccess(), true);
        assertEquals(noteResponse.getMessage(), "Note successfully deleted");
        return noteResponse;
    }

    private <T> NoteResponse<T> parseResponse(Response response, Type type) {
        String json = response.getBody().asString();
        return gson.fromJson(json, type);
    }

}
