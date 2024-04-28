package api.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import objects.Note;
import objects.NoteCreationDTO;
import objects.User;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка заметок API")
public class NoteTests extends BaseTests{
    private User newUser;
    private NoteCreationDTO noteCreationDTO;
    private Note newNote;
    private String token;

    @BeforeEach
    public void before(){
        newUser = new User().generateUser();
        newNote = new Note().generateNote();
        dbSteps.createUserWithStandardPassword(newUser.getLogin());
    }

    @AfterEach
    public void after(){
        dbSteps.fullDeleteUser(newUser.getLogin());
    }

    @Test
    @DisplayName(value = "Проверка создания заметки")
    public void createNoteWithAllFields() {
        noteCreationDTO = NoteCreationDTO.builder()
                .name(newNote.getName())
                .content(newNote.getContent())
                .color(newNote.getColor())
                .priority(newNote.getPriority())
                .build();
        ArrayList<NoteCreationDTO> notes = new ArrayList<>();
        notes.add(noteCreationDTO);
        token = steps.getToken(newUser.getLogin(), newUser.getPassword());

        requestSpecification = steps.createRequestSpecificationCreateNote(token, newUser.getLogin(), notes);
        responseSpecification = steps.createResponseSpecificationRegistration(201);
        steps.postRegistration(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка редактирования заметки")
    public void editNote() {
        int userId = dbSteps.getUserId(newUser.getLogin());
        dbSteps.addRandomNote(userId);
        int noteId = dbSteps.getLastNoteId(userId);
        int random = 100 + (int) (Math.random() * 1000);
        noteCreationDTO = NoteCreationDTO.builder()
                .id(noteId)
                .name("editName" + random)
                .content(newNote.getContent())
                .color(newNote.getColor())
                .priority(newNote.getPriority())
                .build();

        token = steps.getToken(newUser.getLogin(), newUser.getPassword());

        ArrayList<NoteCreationDTO> notes = new ArrayList<>();
        notes.add(noteCreationDTO);

        requestSpecification = steps.createRequestSpecificationEditNote(token, newUser.getLogin(), notes);
        responseSpecification = steps.createResponseSpecificationRegistration(204);
        steps.putEditNote(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка архивирования заметки")
    public void archiveNote() {

        int userId = dbSteps.getUserId(newUser.getLogin());
        dbSteps.addRandomNote(userId);
        int noteId = dbSteps.getLastNoteId(userId);
        List<Object> fields = dbSteps.getNoteFields(noteId);

        noteCreationDTO = NoteCreationDTO.builder()
                .id(noteId)
                .name((String) fields.get(0))
                .content((String) fields.get(1))
                .color((String) fields.get(2))
                .priority((Integer) fields.get(3))
                .archiveFlag(true)
                .build();

        token = steps.getToken(newUser.getLogin(), newUser.getPassword());

        ArrayList<NoteCreationDTO> notes = new ArrayList<>();
        notes.add(noteCreationDTO);

        requestSpecification = steps.createRequestSpecificationEditNote(token, newUser.getLogin(), notes);
        responseSpecification = steps.createResponseSpecificationRegistration(204);
        steps.putEditNote(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка удаления заметки")
    public void deleteNote() {
        int userId = dbSteps.getUserId(newUser.getLogin());
        dbSteps.addRandomNote(userId);
        int noteId = dbSteps.getLastNoteId(userId);

        token = steps.getToken(newUser.getLogin(), newUser.getPassword());

        requestSpecification = steps.createRequestSpecificationDeleteNote(noteId, token, newUser.getLogin());
        responseSpecification = steps.createResponseSpecificationRegistration(204);
        steps.delete(requestSpecification, responseSpecification);
    }
}
