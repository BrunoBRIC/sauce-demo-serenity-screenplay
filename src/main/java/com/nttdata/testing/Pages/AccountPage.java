package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AccountPage extends PageObject {

    public static final Target LBL_MY_ACCOUNT = Target.the("Label My Account")
            .located(By.xpath("//span[text()='My Account']"));

    // ========== ELEMENTOS PARA NAVEGACION DE PERFIL ==========

    // Dropdown de cuenta del usuario logueado
    public static final Target BTN_ACCOUNT_DROPDOWN = Target.the("Dropdown de cuenta")
            .located(By.xpath("//button[@data-action='customer-menu-toggle']"));

    // Alternativas para el dropdown si el anterior no funciona
    public static final Target BTN_ACCOUNT_DROPDOWN_ALT1 = Target.the("Dropdown alternativo 1")
            .located(By.xpath("//span[@class='customer-name']/button"));

    public static final Target BTN_ACCOUNT_DROPDOWN_ALT2 = Target.the("Dropdown alternativo 2")
            .located(By.xpath("//div[@class='customer-menu']//button"));

    public static final Target BTN_ACCOUNT_DROPDOWN_ALT3 = Target.the("Dropdown alternativo 3")
            .located(By.xpath("//span[contains(text(),'Welcome')]/parent::button"));

    // Links dentro del dropdown de cuenta
    public static final Target LNK_MY_ACCOUNT = Target.the("Link Mi Cuenta")
            .located(By.xpath("//a[text()='My Account']"));

    public static final Target LNK_ACCOUNT_INFORMATION = Target.the("Link Informacion de cuenta")
            .located(By.xpath("//a[text()='Account Information']"));

    // Alternativas para Account Information
    public static final Target LNK_ACCOUNT_INFORMATION_ALT1 = Target.the("Account Info alternativo 1")
            .located(By.xpath("//a[contains(@href,'customer/account/edit')]"));

    public static final Target LNK_ACCOUNT_INFORMATION_ALT2 = Target.the("Account Info alternativo 2")
            .located(By.xpath("//a[contains(text(),'Edit')]"));

    // ========== ELEMENTOS DE LA PAGINA DE CUENTA ==========

    public static final Target WELCOME_MESSAGE = Target.the("Mensaje de bienvenida")
            .located(By.xpath("//span[@class='logged-in']"));

    public static final Target CUSTOMER_NAME = Target.the("Nombre del cliente")
            .located(By.xpath("//span[@class='customer-name']"));

    // Menu lateral de la cuenta
    public static final Target SIDEBAR_ACCOUNT_INFO = Target.the("Account Information en sidebar")
            .located(By.xpath("//div[@class='block-content']//a[text()='Account Information']"));

    public static final Target SIDEBAR_ADDRESS_BOOK = Target.the("Address Book en sidebar")
            .located(By.xpath("//div[@class='block-content']//a[text()='Address Book']"));

    public static final Target SIDEBAR_MY_ORDERS = Target.the("My Orders en sidebar")
            .located(By.xpath("//div[@class='block-content']//a[text()='My Orders']"));

    // ========== INDICADORES DE ESTADO ==========

    public static final Target LOGIN_SUCCESS_INDICATOR = Target.the("Indicador de login exitoso")
            .located(By.xpath("//div[@class='panel header']//span[contains(@class,'logged-in')]"));

    public static final Target ACCOUNT_DASHBOARD = Target.the("Dashboard de cuenta")
            .located(By.xpath("//div[@class='column main']//h1[text()='My Account']"));
}