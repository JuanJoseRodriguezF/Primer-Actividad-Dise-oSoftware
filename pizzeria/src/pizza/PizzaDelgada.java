package pizza;

import operaciones.amasado.AmasarPizzaDelgada;
import operaciones.amasado.IAmasado;
import operaciones.horneado.HornearPizzaDelgada;
import operaciones.horneado.IHorneado;
import operaciones.moldeado.IMoldeado;
import operaciones.moldeado.MoldearPizzaDelgada;

public class PizzaDelgada extends Pizza{
    IAmasado crearAmasador() { return new AmasarPizzaDelgada(); }
    IHorneado crearHorneador() { return new HornearPizzaDelgada(); }
    IMoldeado crearMoldeador() { return new MoldearPizzaDelgada(); }

    @Override
    String obtenerTipoPizza() {
        return "delgada";
    }
}
