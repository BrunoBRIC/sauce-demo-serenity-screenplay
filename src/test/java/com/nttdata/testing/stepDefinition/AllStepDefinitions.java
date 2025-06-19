package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.*;
import com.nttdata.testing.Tasks.*;
import com.nttdata.testing.questions.RegisterQuestion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class AllStepDefinitions {

    // ========== STEPS COMUNES (SOLO UNA VEZ) ==========

    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @Given("el {actor} inicia sesion con email {string} y contrasenia {string}")
    public void elUsuarioIniciaSesionConEmailYContrasenia(Actor actor, String email, String contrasenia) {
        actor.attemptsTo(NavigateTo.theHomePage());
        theActorInTheSpotlight().attemptsTo(LoginTask.withData(email, contrasenia));
    }

    // ========== REGISTRO DE USUARIO ==========

    @When("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_UP));
    }

    @And("ingresa nombre {string} apellido {string} email {string} y contrasenia {string}")
    public void ingresaNombreApellidoEmailYContrasenia(String nombre, String apellido, String email, String contrasenia) {
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.withData(nombre, apellido, email, contrasenia));
    }

    @When("selecciona el boton registrar")
    public void seleccionaElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(Click.on(RegisterPage.BTN_CREATE));
    }

    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        System.out.println("Registro exitoso");
        try {
            theActorInTheSpotlight().should(seeThat("El mensaje de registro correcto",
                    RegisterQuestion.visibleEn(AccountPage.LBL_MY_ACCOUNT), equalTo("My Account")));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("no se realiza el registro de manera exitosa")
    public void noSeRealizaElRegistroDeManeraExitosa() {
        theActorInTheSpotlight().should(seeThat("Error al crear usuario existente",
                RegisterQuestion.visibleEn(RegisterPage.LBL_ERROR_MESSAGE)));
    }

    // ========== FLUJO DE COMPRA ==========

    @When("navega a la seccion {string} y selecciona {string}")
    public void navegaALaSeccionYSelecciona(String seccion, String categoria) {
        theActorInTheSpotlight().attemptsTo(
                NavigateToSection.withData(seccion, categoria)
        );
    }

    @And("selecciona un producto disponible")
    public void seleccionaUnProductoDisponible() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ProductsPage.FIRST_PRODUCT)
        );
    }


    @And("configura el producto con talla {string} y color {string}")
    public void configuraElProductoConTallaYColor(String talla, String color) {
        theActorInTheSpotlight().attemptsTo(
                // Esperar que la página del producto cargue
                WaitUntil.the(ProductDetailPage.SIZE_SELECTOR, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),

                // Seleccionar talla
                SelectProductOption.size(talla),

                // Seleccionar color
                SelectProductOption.color(color)
        );

        System.out.println("✅ Producto configurado - Talla: " + talla + ", Color: " + color);
    }

    @And("agrega al carrito de compras")
    public void agregaAlCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ProductDetailPage.BTN_ADD_TO_CART, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.BTN_ADD_TO_CART)
        );

        // Esperar confirmación
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("✅ Producto agregado al carrito");
    }
    @And("limpia el carrito para la siguiente prueba")
    public void limpiaElCarritoParaLaSiguientePrueba() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    ClearCart.now()
            );
            Thread.sleep(2000);
            System.out.println("🧹 Carrito limpiado para siguiente iteración");
        } catch (Exception e) {
            System.out.println("⚠️ No fue necesario limpiar el carrito: " + e.getMessage());
        }
    }
    @And("procede al checkout")
    public void procedeAlCheckout() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @And("completa el formulario de compra")
    public void completaElFormularioDeCompra() {
        theActorInTheSpotlight().attemptsTo(
                FillCheckoutForm.withDefaultData()
        );
    }

    @And("hace clic en {string}")
    public void haceClicEn(String boton) {
        if (boton.equals("Place Order")) {
            theActorInTheSpotlight().attemptsTo(
                    Click.on(CheckoutPage.BTN_PLACE_ORDER)
            );
        }
    }

    @Then("la compra se realiza de manera exitosa")
    public void laCompraSeRealizaDeManeraExitosa() {
        theActorInTheSpotlight().should(
                seeThat("La compra fue exitosa",
                        RegisterQuestion.visibleEn(CheckoutPage.SUCCESS_MESSAGE),
                        containsString("Thank you for your purchase"))
        );
    }

    @And("se genera un numero de orden")
    public void seGeneraUnNumeroDeOrden() {
        theActorInTheSpotlight().should(
                seeThat("Se genero numero de orden",
                        RegisterQuestion.visibleEn(CheckoutPage.ORDER_NUMBER))
        );
    }

    @And("los detalles del pedido coinciden con el producto seleccionado")
    public void losDetallesDelPedidoCoinciden() {
        theActorInTheSpotlight().attemptsTo(
                ValidateOrderDetails.now()
        );
    }

    // ========== BUSQUEDA DE PRODUCTOS ==========

    @And("busca un producto {string}")
    public void buscaUnProducto(String nombreProducto) {
        theActorInTheSpotlight().attemptsTo(SearchProductTask.withData(nombreProducto));
    }

    @Then("no se encuentran resultados")
    public void noSeEncuentranResultados() {
        theActorInTheSpotlight().should(
                seeThat("No hay resultados",
                        RegisterQuestion.visibleEn(SearchPage.NO_RESULTS_MESSAGE))
        );
    }

    @And("se muestra el mensaje {string}")
    public void seMuestraElMensaje(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("Mensaje mostrado",
                        RegisterQuestion.visibleEn(SearchPage.SEARCH_MESSAGE),
                        containsString(mensaje))
        );
    }

    // ========== EDICION DE PERFIL ==========

    @When("accede a su perfil de usuario")
    public void accedeASuPerfilDeUsuario() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AccountPage.BTN_ACCOUNT_DROPDOWN),
                Click.on(AccountPage.LNK_ACCOUNT_INFORMATION)
        );
    }

    @And("edita el nombre de {string} a {string}")
    public void editaElNombreDeA(String nombreAnterior, String nombreNuevo) {
        theActorInTheSpotlight().attemptsTo(
                EditProfile.firstName(nombreNuevo)
        );
    }

    @And("edita el apellido de {string} a {string}")
    public void editaElApellidoDeA(String apellidoAnterior, String apellidoNuevo) {
        theActorInTheSpotlight().attemptsTo(
                EditProfile.lastName(apellidoNuevo)
        );
    }

    @And("guarda los cambios en el perfil")
    public void guardaLosCambiosEnElPerfil() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.BTN_SAVE)
        );
    }

    @Then("los datos del perfil se actualizan correctamente")
    public void losDatosDelPerfilSeActualizan() {
        theActorInTheSpotlight().should(
                seeThat("Perfil actualizado",
                        RegisterQuestion.visibleEn(ProfilePage.SUCCESS_MESSAGE),
                        containsString("You saved the account information"))
        );
    }

    @And("se muestra el mensaje de confirmacion")
    public void seMuestraElMensajeDeConfirmacion() {
        theActorInTheSpotlight().should(
                seeThat("Mensaje de confirmacion",
                        RegisterQuestion.visibleEn(ProfilePage.CONFIRMATION_MESSAGE))
        );
    }

    // ========== PRODUCTOS ESPECÍFICOS (MEN CLOTHES) ==========

    @And("selecciona la talla {string} y color {string}")
    public void seleccionaLaTallaYColor(String talla, String color) {
        theActorInTheSpotlight().attemptsTo(
                MoveMouse.to(MenClothesPage.ITM_SHIRT),
                Click.on(MenClothesPage.ITM_SHIRT),
                Click.on(MenClothesPage.ITM_TALLA),
                Click.on(MenClothesPage.ITM_COLOR_PRENDA)
        );
    }

    @When("agrega al carrito")
    public void agregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MenClothesPage.BTN_AGREGAR_CARRITO)
        );
    }

    @Then("se actualiza el item {string} del carrito de manera exitosa")
    public void seActualizaElItemDelCarritoDeManeraExitosa(String cantidad) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theActorInTheSpotlight().should(seeThat("El carrito se actualizo correctamente",
                RegisterQuestion.visibleEn(MenClothesPage.ITM_CARRITO), equalTo(cantidad)));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("ingresar Carrito")
    public void ingresarCarrito() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    Click.on(MenClothesPage.IRCARRITO)
            );
            Thread.sleep(2000); // Esperar que cargue el carrito

            theActorInTheSpotlight().attemptsTo(
                    Click.on(MenClothesPage.PROCESO)
            );
            Thread.sleep(3000); // Esperar que cargue checkout

            theActorInTheSpotlight().attemptsTo(
                    Click.on(MenClothesPage.CHECK)
            );
            Thread.sleep(1000); // Esperar selección método pago

            theActorInTheSpotlight().attemptsTo(
                    Click.on(MenClothesPage.BRNNEXT)
            );
            Thread.sleep(2000); // Esperar que avance al siguiente paso

            theActorInTheSpotlight().attemptsTo(
                    Click.on(MenClothesPage.CONFIRMAR)
            );
            Thread.sleep(5000); // Esperar que procese la compra

            // Validar el mensaje
            theActorInTheSpotlight().should(
                    seeThat("Mensaje de compra exitosa",
                            RegisterQuestion.visibleEn(MenClothesPage.TEXTO),
                            containsString("Thank you for your purchase!"))
            );

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}