package tests;

import model.NoteCategory;
import org.testng.annotations.Test;
import utils.LoggerUtils;

public class NoteTests extends Hooks {

    @Test
    public void testMethod() {
        LoggerUtils.infoTest("Health check step");

        if (healthCheck() == 200) {
            LoggerUtils.infoTest("Step1: create new user");
            createUser();

            LoggerUtils.infoTest("Step2: login with created user");
            login();

            LoggerUtils.infoTest("Step3: create work note for user");
            createNote(NoteCategory.WORK);

            LoggerUtils.infoTest("Step4: create personal note for user");
            createNote(NoteCategory.PERSONAL);

            LoggerUtils.infoTest("Step5: get all notes for user");
            getAllNotes();

            LoggerUtils.infoTest("Step6: get note by ID");
            getNoteById();

            LoggerUtils.infoTest("Step7: update note by ID");
            updateNote();

            LoggerUtils.infoTest("Step7: delete note by ID");
            deleteNoteById();

            LoggerUtils.infoTest("Step8: get all notes for user");
            getAllNotes();

        } else {
            LoggerUtils.infoTest("Health check failed. Skipping further steps.");
        }
    }

}
