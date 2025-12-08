package steps;

import actions.api.HealthCheckActions;
import actions.api.NoteActions;
import actions.api.UserActions;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import model.api.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import service.ui.SharedData;
import utils.ExtentUtils;
import utils.LoggerUtils;
import utils.PropertyUtils;


public class Hooks extends BaseSteps{

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

    public Hooks(SharedData sharedData) {
        super(sharedData);
    }

    @BeforeSuite
    public void prepareSuite() {
        ExtentUtils.initiateReport();
    }

    @Before(order = 1)
    public void beforeHook(Scenario scenario) {
        LoggerUtils.startTestCase(scenario.getName(), scenario);
    }

    @BeforeMethod
    public void prepareTest(Scenario scenario) {
        testName = this.getClass().getSimpleName();
        //LoggerUtils.startTestCase(testName);
        //LoggerUtils.startTestCase(scenario.getName(), scenario);
        ExtentUtils.startTest(testName);
    }

    @AfterMethod
    public void clearTest(Scenario scenario) {
        //LoggerUtils.endTestCase(testName);
        LoggerUtils.endTestCase(scenario.getName());
        ExtentUtils.endTest(testName);
    }

    @AfterSuite
    public void clearSuite() {
        ExtentUtils.generateReport();
    }

    @Before("@UI")
    public void beforeUi(){
        sharedData.initializeDriver();
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
