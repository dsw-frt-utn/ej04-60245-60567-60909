package views;

import data.Persistencia;
import domain.Vehiculo;
import domain.VehiculoTipo;
import domain.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Controlador {
    
    public static ArrayList<VehiculoViewModel> getVehiculos(){
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : Persistencia.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }
    
    
    public static void registrarNuevoVehiculo(domain.VehiculoTipo tipo, String patente, domain.Marca marca, 
                                          String modelo, int anio, double capacidadCarga, 
                                          domain.Sucursal sucursal, double p1, double p2) {
    
    domain.Vehiculo nuevo;
    
    if (tipo == domain.VehiculoTipo.ELECTRICO) {
        // p1 es kwhBase
        nuevo = new domain.VehiculoElectrico(patente, marca, modelo, anio, capacidadCarga, sucursal, p1);
    } else {
        // p1 es kmPorLitro, p2 es litrosExtra
        nuevo = new domain.VehiculoCombustible(patente, marca, modelo, anio, capacidadCarga, sucursal, p1, p2);
    }
    
    data.Persistencia.agregarVehiculo(nuevo);
}
    
}
