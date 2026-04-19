package data;

import domain.*;
import java.util.ArrayList;
import java.util.Optional;

public class Persistencia {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Responsable> responsables = new ArrayList<>();
    private static ArrayList<Sucursal> sucursales = new ArrayList<>();
    private static ArrayList<Marca> marcas = new ArrayList<>();
    
    private static void inicializarResponsables(){
        Responsable r1 = new Responsable("Carlos Gómez", "25444111", "3815551111");
        Responsable r2 = new Responsable("Laura Pérez", "30111222", "3815552222");
        responsables.add(r1);
        responsables.add(r2);
    }
    private static void inicializarMarcas() {
        marcas.add(new Marca("Renault"));
        marcas.add(new Marca("Ford"));
        marcas.add(new Marca("Iveco"));
        marcas.add(new Marca("Mercedes"));
        marcas.add(new Marca("Toyota"));
        marcas.add(new Marca("Volkswagen"));
    }
    public static ArrayList<Marca> getMarcas() {
        return marcas;
    }
    
    private static void inicializarSucursales(){
        Sucursal s1 = new Sucursal("SUC01", "Av. Belgrano 1200", "Tucumán", responsables.get(0));
        Sucursal s2 = new Sucursal("SUC02", "San Martín 450", "Yerba Buena", responsables.get(1));
        
        sucursales.add(s1);
        sucursales.add(s2);
    }
    
    public static ArrayList<Sucursal> getSucursales() { //Getter nuevo de ventana
        return sucursales;
    }
    
    private static void inicializarMarcas() { //Teniendo clase Marca ya incluida
        marcas.add(new Marca("Renault"));
        marcas.add(new Marca("Ford"));
        marcas.add(new Marca("Iveco"));
        marcas.add(new Marca("Mercedes"));
        marcas.add(new Marca("Toyota"));
        marcas.add(new Marca("Volkswagen"));
    }
    public static ArrayList<Marca> getMarcas() {
        return marcas;
    }
    
    public static void agregarVehiculo(Vehiculo vehiculo) { //Nuevo para guardarr
        vehiculos.add(vehiculo);
    }
    
    public static ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    public static void agregarVehiculo(Vehiculo vehiculo) { //Nuevo para guardarr
        vehiculos.add(vehiculo);
    }
    
    public static Optional<Vehiculo> getVehiculo(String patente){
        return vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst();
    }
    
     public static ArrayList<Sucursal> getSucursales() { //Getter nuevo de ventana
        return sucursales;
    }
    public static void inicializar(){
        inicializarResponsables();
        inicializarSucursales();
        inicializarVehiculos();
        inicializarMarcas();
    }
    
    private static void inicializarVehiculos(){
        /*Sucursal s1 = sucursales.get(0);
        Sucursal s2 = sucursales.get(1);
        VehiculoElectrico v1 = new VehiculoElectrico("AE123FG", "Renault", "Kangoo E-Tech", 2020, 1000, s1, 16);
        VehiculoElectrico v2 = new VehiculoElectrico("AF456HI", "Ford", "E-Transit", 2021, 1300, s2, 16);
        VehiculoCombustible v3 = new VehiculoCombustible("AC789JK", "Iveco", "Daily", 2023, 1200, s1, 8, 1.5);
        VehiculoCombustible v4 = new VehiculoCombustible("AD321LM", "Mercedes", "Sprinter", 2020, 1200, s2, 7, 1);
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);*/
    }
    
}
