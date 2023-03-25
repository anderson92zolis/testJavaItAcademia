public class PersonalizedException extends Exception{

    public PersonalizedException(){

        super("[Inventario lleno!- El vendedor no puede comprar el ítem].!");
    }

    public PersonalizedException(String message){
        super(message);
    }

}
