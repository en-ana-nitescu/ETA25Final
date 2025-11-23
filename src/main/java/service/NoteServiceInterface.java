package service;

import io.restassured.response.Response;
import model.NoteRequest;

public interface NoteServiceInterface {

    Response createNote(NoteRequest body, String token);
    Response getAllNotes(String token);
    Response getNoteById(String noteId, String token);
    Response updateNote(String noteId, NoteRequest body, String token);
    Response deleteNote(String noteId, String token);
}
