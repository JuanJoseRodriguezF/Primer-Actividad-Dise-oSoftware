package pizza;

import operaciones.amasado.AmasarPizzaIntegral;
import operaciones.amasado.IAmasado;
import operaciones.horneado.HornearPizzaIntegral;
import operaciones.horneado.IHorneado;
import operaciones.moldeado.IMoldeado;
import operaciones.moldeado.MoldearPizzaIntegral;

public class PizzaIntegral extends Pizza{
    IAmasado crearAmasador() { return new AmasarPizzaIntegral(); }
    IHorneado crearHorneador() { return new HornearPizzaIntegral(); }
    IMoldeado crearMoldeador() { return new MoldearPizzaIntegral(); }

    @Override
    String obtenerTipoPizza() {
        return "integral";
    }
}
