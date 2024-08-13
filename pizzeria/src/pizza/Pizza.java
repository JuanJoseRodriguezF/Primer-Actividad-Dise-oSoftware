package pizza;

import excepciones.ExcepcionParametrosInvalidos;
import operaciones.amasado.IAmasado;
import operaciones.horneado.IHorneado;
import operaciones.moldeado.IMoldeado;

public abstract class Pizza {
    abstract IAmasado crearAmasador();
    abstract IHorneado crearHorneador();
    abstract IMoldeado crearMoldeador();

    // Método abstracto para obtener el tipo de pizza
    abstract String obtenerTipoPizza();

    public void prepararPizza(Tamano tam) throws ExcepcionParametrosInvalidos {
        IAmasado amasador = crearAmasador();
        IHorneado horneador = crearHorneador();
        IMoldeado moldeador = crearMoldeador();

        // Amasado
        amasador.amasar();

        // Moldeado basado en el tamaño
        if (tam == Tamano.PEQUENA) {
            moldeador.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANA) {
            moldeador.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamano de pizza invalido: " + tam);
        }

        // Horneado
        horneador.hornear();

        // Mensaje de confirmación
        System.out.println("Se ha creado la pizza " + obtenerTipoPizza() + " de tamaño " + tam.toString().toLowerCase() + ".");
    }
}
