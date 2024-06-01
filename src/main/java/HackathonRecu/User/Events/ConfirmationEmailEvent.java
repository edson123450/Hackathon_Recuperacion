package HackathonRecu.User.Events;

import org.springframework.context.ApplicationEvent;

public class ConfirmationEmailEvent extends ApplicationEvent {
    private final String email;

    public ConfirmationEmailEvent(String email) {
        super(email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
