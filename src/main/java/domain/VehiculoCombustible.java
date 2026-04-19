
package domain;

import java.time.Year;

import java.time.Year;

public class VehiculoCombustible extends Vehiculo {
    private double kilometrosPorLitro;
    private double litrosExtra;

    public VehiculoCombustible(String patente, String marca, String modelo, int anio, double capacidadCarga,
                               Sucursal sucursal, double kilometrosPorLitro, double litrosExtra) {
        super(VehiculoTipo.COMBUSTIBLE, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kilometrosPorLitro = kilometrosPorLitro;
        this.litrosExtra = litrosExtra;
    }
    
     public double getKilometrosPorLitro() {
        return kilometrosPorLitro;
    }

    public double getLitrosExtra() {
        return litrosExtra;
    }

    @Override
    public double calcularConsumo(double kilometros) {
     // Consumo base: Kilómetros recorridos dividido por el rendimiento (km/l)
    double totalLitros = kilometros / kilometrosPorLitro;

    // Cálculo de antigüedad (puedes ajustarlo si tu cátedra usa un año fijo en lugar de Year.now())
    int antiguedad = Year.now().getValue() - this.anio;

    if (antiguedad > 5) {
        // Se suma la penalidad: (tramos de 15 km) * litros extra
        totalLitros += (kilometros / 15.0) * litrosExtra;
    }

    return totalLitros;
    }
}
