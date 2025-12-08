package service.api;

import io.restassured.response.Response;
import model.api.NoteRequest;

public interface NoteServiceInterface {

    Response createNote(NoteRequest body, String token);
    Response getAllNotes(String token);
    Response getNoteById(String noteId, String token);
    Response updateNote(String noteId, NoteRequest body, String token);
    Response deleteNote(String noteId, String token);
}
