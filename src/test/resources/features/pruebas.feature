// Feature File: compra_productos.feature
Feature: Compra de productos en Magento
  Como cliente registrado
  Quiero poder comprar productos
  Para recibir mis artículos deseados

  Background:
    Given el usuario esta en la pagina de inicio

  @compra @flujo_completo
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

  @busqueda_negativa
  Scenario: Busqueda de producto inexistente
    When busca un producto "ProductoInexistente123"
    Then no se encuentran resultados
    And se muestra el mensaje "Your search returned no results"

  @edicion_perfil
  Scenario: Edicion de datos de perfil
    Given el usuario inicia sesion con email "test@example.com" y contrasenia "Password123"
    When accede a su perfil de usuario
    And edita el nombre de "John" a "Jonathan"
    And edita el apellido de "Doe" a "Smith"
    And guarda los cambios en el perfil
    Then los datos del perfil se actualizan correctamente
    And se muestra el mensaje de confirmacion
