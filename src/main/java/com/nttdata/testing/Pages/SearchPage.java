package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {

    public static final Target SEARCH_BOX = Target.the("Caja de busqueda")
            .located(By.id("search"));

    public static final Target BTN_SEARCH = Target.the("Boton buscar")
            .located(By.xpath("//button[@title='Search']"));

    public static final Target NO_RESULTS_MESSAGE = Target.the("Mensaje sin resultados")
            .located(By.xpath("//div[@class='message notice']"));

    public static final Target SEARCH_MESSAGE = Target.the("Mensaje de busqueda")
            .located(By.xpath("//div[@class='message notice']/div"));
}