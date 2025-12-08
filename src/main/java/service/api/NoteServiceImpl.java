package service.api;

import io.restassured.response.Response;
import model.api.NoteRequest;
import service.api.endpoints.NoteEndpoints;

public class NoteServiceImpl implements NoteServiceInterface {

    private final CommonService service;

    public NoteServiceImpl() {
        service = new CommonService();
    }

    @Override
    public Response createNote(NoteRequest body, String token) {
        return service.post(body, token, NoteEndpoints.POST_NOTE);
    }

    @Override
    public Response getAllNotes(String token) {
        return service.get(token, NoteEndpoints.GET_NOTES);
    }

    @Override
    public Response getNoteById(String noteId, String token) {
        return service.get(token, NoteEndpoints.GET_NOTE_BY_ID + noteId);
    }

    @Override
    public Response updateNote(String noteId, NoteRequest body, String token) {
        return service.patch(body, token, NoteEndpoints.UPDATE_NOTE_BY_ID + noteId);
    }

    @Override
    public Response deleteNote(String noteId, String token) {
        return service.delete(token, NoteEndpoints.DELETE_NOTE_BY_ID + noteId);
    }

}
