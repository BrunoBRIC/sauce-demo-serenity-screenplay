package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfilePage extends PageObject {

    public static final Target TXT_FIRST_NAME = Target.the("Campo nombre del perfil")
            .located(By.id("firstname"));

    public static final Target TXT_LAST_NAME = Target.the("Campo apellido del perfil")
            .located(By.id("lastname"));

    public static final Target BTN_SAVE = Target.the("Boton guardar")
            .located(By.xpath("//button[@title='Save']"));

    public static final Target SUCCESS_MESSAGE = Target.the("Mensaje de exito del perfil")
            .located(By.xpath("//div[@class='message-success success message']"));

    public static final Target CONFIRMATION_MESSAGE = Target.the("Mensaje de confirmacion")
            .located(By.xpath("//div[@class='page messages']"));
}
