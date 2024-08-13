package pizza;

import operaciones.amasado.AmasarPizzaGruesa;
import operaciones.amasado.IAmasado;
import operaciones.horneado.HornearPizzaGruesa;
import operaciones.horneado.IHorneado;
import operaciones.moldeado.IMoldeado;
import operaciones.moldeado.MoldearPizzaGruesa;

public class PizzaGruesa extends Pizza{
    IAmasado crearAmasador() { return new AmasarPizzaGruesa(); }
    IHorneado crearHorneador() { return new HornearPizzaGruesa(); }
    IMoldeado crearMoldeador() { return new MoldearPizzaGruesa(); }

    @Override
    String obtenerTipoPizza() {
        return "gruesa";
    }
}
