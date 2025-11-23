package tests;

import actions.HealthCheckActions;
import actions.NoteActions;
import actions.UserActions;
import model.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentUtils;
import utils.LoggerUtils;
import utils.PropertyUtils;


public class Hooks {

    private String testName;
    public PropertyUtils propertyUtils;
    HealthCheckActions healthCheckActions;
    UserActions userActions;
    UserRequest userRequest;
    UserResponse userResponse;
    public String userId;
    public String email;
    public String token;
    NoteActions noteActions;
    NoteRequest noteRequest;
    public String noteId;


    @BeforeSuite
    public void prepareSuite() {
        ExtentUtils.initiateReport();
    }

    @BeforeMethod
    public void prepareTest() {
        testName = this.getClass().getSimpleName();
        LoggerUtils.startTestCase(testName);
        ExtentUtils.startTest(testName);
    }

    @AfterMethod
    public void clearTest() {
        LoggerUtils.endTestCase(testName);
        ExtentUtils.endTest(testName);
    }

    @AfterSuite
    public void clearSuite() {
        ExtentUtils.generateReport();
    }

    public int healthCheck() {
        healthCheckActions = new HealthCheckActions();
        return healthCheckActions.healthCheck();
    }

    public void createUser() {
        userActions = new UserActions();
        propertyUtils = new PropertyUtils("userData");
        userRequest = new UserRequest(propertyUtils.getAllData());

        userResponse = userActions.createUser(userRequest);
        userId = userResponse.getData().getId();
        email = userResponse.getData().getEmail();
    }

    public void login() {
        userRequest.setEmail(email);
        userResponse = userActions.login(userRequest);
        token = userResponse.getData().getToken();
    }

    public void getUserDetails() {
        userResponse = userActions.getUserDetails(token);
    }

    public void updateUserDetails() {
        userResponse = userActions.updateUserDetails(userRequest, token);
    }

    public void forgotPassword() {
        userResponse = userActions.forgotPassword(userRequest, token);
    }

    public void userLogout() {
        userResponse = userActions.userLogout(token);
    }

    public void deleteAccount() {
        userResponse = userActions.deleteAccount(token);
    }

    public void createNote(NoteCategory category) {
        noteActions = new NoteActions();

        switch (category) {
            case WORK -> propertyUtils = new PropertyUtils("workNoteData");
            case PERSONAL -> propertyUtils = new PropertyUtils("personalNoteData");
            case HOME -> propertyUtils = new PropertyUtils("homeNoteData");
        }
        noteRequest = new NoteRequest(propertyUtils.getAllData());

        NoteResponse<NoteData> noteResponse = noteActions.createNote(noteRequest, token);
        noteId = noteResponse.getData().getId();
    }

    public void getAllNotes() {
        noteActions.getAllNotes(token);
    }

    public void getNoteById() {
        noteActions.getNoteById(noteId, token);
    }

    public void updateNote() {
        noteRequest.setCompleted(true);
        noteActions.updateNote(noteId, noteRequest, token);
    }

    public void deleteNoteById() {
        noteActions.deleteNote(noteId, token);
    }

}
