package excepciones;

public class ExcepcionParametrosInvalidos extends Exception {
    // Constructor que acepta un mensaje de error
    public ExcepcionParametrosInvalidos(String mensaje) {
        super(mensaje);  // Llama al constructor de la clase base Exception con el mensaje proporcionado
    }
}
