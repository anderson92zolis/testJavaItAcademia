# testJavaItAcademia

Nos piden que programemos los NPCs de un juego de rol. 
Existen tres categorías de NPCs: 
    Campecino, Ladrón y Mercader. Todos ellos venden ítems. 
        El campecino tiene hasta 5 ítems para vender y al precio original le agrega un impuesto del 2%. 
        El Ladrón, hasta 3 y no cobra impuestos. 
        El mercader, hasta 7 y cobra un 4% de impuestos. Cada NPC está ubicado en una ciudad.
        
   Los ítems tienen un nombre, un tipo, un precio y porcentaje de desgaste. 
      Cuando un ladrón agrega un ítem a su inventario este se deteriora un 25%. 
      Cuando lo hace un campecino, un 15%. En cambio. 
      Un mercader conoce muy bien cómo guardar sus ítems para que no se estropeen. 
   
   La información del juego se almacenará en un fichero.

La aplicación permite:
1- Consultar los los ítems de un vendedor.
2- Consultar los vendedores que hay en una ciudad.
3- Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas
4- Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) -> lambdas
5- Simular la compra de un ítem a un NPC.
6- Simular la venta de un ítem a un NPC.*


* Si se intenta agregar más ítems de los que un NPC puede vender una excepción mostrará el MSJ:"[Inventario lleno!- El vendedor no puede comprar el ítem].".
PLUS: encriptar la información que se guarda en el fichero.(?)
