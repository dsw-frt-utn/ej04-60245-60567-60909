package domain;

public class VehiculoElectrico extends Vehiculo {
    private double kwhBase;

    public VehiculoElectrico(String patente, Marca marca, String modelo, int anio, double capacidadCarga,
                             Sucursal sucursal, double kwhBase) {
        super(VehiculoTipo.ELECTRICO, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kwhBase = kwhBase;
    }
    @Override
    public double calcularConsumo(double kilometros) 
    //Aqui lo que hacemos es sobreescribir la funcion de CalcularConsumo asi cuando
    //lo calculeen carros electricos, llame  aesta y no a la del contructor
    //vehiculo, que no lleva nada
    {
        double total = (kilometros/100.0)*kwhBase;

        if (capacidadCarga > 1200) {
            total = total * 1.15;
        }

        return total;
    }
    //Al final lo terminamos resolviendo con gimini, que corrigio la logica
}
