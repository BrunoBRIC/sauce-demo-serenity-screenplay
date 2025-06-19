@compra_productos
Feature: Compra de productos en Magento
  Como cliente registrado
  Quiero poder comprar productos
  Para recibir mis artículos deseados

  Background:
    Given el usuario esta en la pagina de inicio

  @compra @flujo_completo @smoke
  Scenario: Compra exitosa de chaqueta para hombre
    Given el usuario inicia sesion con email "test@example.com" y contrasenia "Password123"
    When navega a la seccion "Men" y selecciona "Jackets"
    And selecciona un producto disponible
    And configura el producto con talla "M" y color "Blue"
    And agrega al carrito de compras
    And procede al checkout
    And completa el formulario de compra
    And hace clic en "Place Order"
    Then la compra se realiza de manera exitosa
    And se genera un numero de orden
    And los detalles del pedido coinciden con el producto seleccionado

  @busqueda_negativa @negative
  Scenario: Busqueda de producto inexistente
    When busca un producto "ProductoInexistente123"
    Then no se encuentran resultados
    And se muestra el mensaje "Your search returned no results"

  @edicion_perfil @profile
  Scenario: Edicion de datos de perfil
    Given el usuario inicia sesion con email "test@example.com" y contrasenia "Password123"
    When accede a su perfil de usuario
    And edita el nombre de "John" a "Jonathan"
    And edita el apellido de "Doe" a "Smith"
    And guarda los cambios en el perfil
    Then los datos del perfil se actualizan correctamente
    And se muestra el mensaje de confirmacion

  @registro_usuario @positive
  Scenario: Registro exitoso de nuevo usuario
    When selecciona el boton de registro
    And ingresa nombre "Juan" apellido "Perez" email "juan.perez@test.com" y contrasenia "Password123"
    And selecciona el boton registrar
    Then se realiza el registro de manera exitosa

  @registro_usuario @negative
  Scenario: Registro fallido con usuario existente
    When selecciona el boton de registro
    And ingresa nombre "Test" apellido "User" email "test@example.com" y contrasenia "Password123"
    And selecciona el boton registrar
    Then no se realiza el registro de manera exitosa

  @compra @multiple_productos
  Scenario Outline: Compra de multiples productos con diferentes configuraciones
    Given el usuario inicia sesion con email "test@example.com" y contrasenia "Password123"
    When navega a la seccion "<seccion>" y selecciona "<categoria>"
    And selecciona un producto disponible
    And configura el producto con talla "<talla>" y color "<color>"
    And agrega al carrito de compras
    Then se actualiza el item "1" del carrito de manera exitosa
    And ingresar Carrito
    Examples:
      | seccion | categoria | talla | color |
      | Men     | Jackets   | M     | Blue  |
      | Men     | Jackets   | L     | Black |
      | Men     | Jackets   | S     | Blue  |