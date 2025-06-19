package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.ProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

public class EditProfile implements Task {

    private final String field;
    private final String value;

    public EditProfile(String field, String value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (field.equals("firstName")) {
            actor.attemptsTo(
                    Clear.field(ProfilePage.TXT_FIRST_NAME),
                    Enter.theValue(value).into(ProfilePage.TXT_FIRST_NAME)
            );
        } else if (field.equals("lastName")) {
            actor.attemptsTo(
                    Clear.field(ProfilePage.TXT_LAST_NAME),
                    Enter.theValue(value).into(ProfilePage.TXT_LAST_NAME)
            );
        }
    }

    public static Performable firstName(String value) {
        return new EditProfile("firstName", value);
    }

    public static Performable lastName(String value) {
        return new EditProfile("lastName", value);
    }
}
