package partTwo.restLessonHamcrest13;

import lombok.Data;
import api.pojo.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
public class User {

    private String login;
    private String password;
    private String email;
    private List<Note> notes;
    private List<Role> roles;

    public void setDefaultRole() {
        Role defaultRole = new Role();
        defaultRole.setId(2);
        defaultRole.setName("ROLE_USER");

        List<Role> defaultListRole = new ArrayList<>();
        defaultListRole.add(defaultRole);

        this.roles = defaultListRole;
    }

    public void setRole(int id, String name) {
        Role role = new Role();
        role.setId(id);
        role.setName(name);

        if (Objects.isNull(this.roles)) {
            List<Role> listRole = new ArrayList<>();
            listRole.add(role);
            this.roles = listRole;
        } else {
            this.roles.add(role);
        }
    }

    public void setDefaultNote() {
        Note defaultNote = new Note();
        defaultNote.setId(1000 + (int)(Math.random() * 500));
        defaultNote.setName("NoteName");
        defaultNote.setContent("NoteCont");
        defaultNote.setColor("#d7aefb");
        defaultNote.setPriority(0);

        List<Note> defaultListNote = new ArrayList<>();
        defaultListNote.add(defaultNote);

        this.notes = defaultListNote;
    }

    public void setNote(int id, String noteName, String noteContent, String color, int priority) {
        Note note = new Note();
        note.setId(id);
        note.setName(noteName);
        note.setContent(noteContent);
        note.setColor(color);
        note.setPriority(priority);

        if (Objects.isNull(this.notes)) {
            List<Note> listNote = new ArrayList<>();
            listNote.add(note);
            this.notes = listNote;
        } else {
            this.notes.add(note);
        }

    }
}
