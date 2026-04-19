package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.MenuPrincipalView;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        //ListarVehiculosView view = new ListarVehiculosView();
        //view.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalView().setVisible(true);
            }
        });
    }
    }
