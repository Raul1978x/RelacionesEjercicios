package servicio;

import entidad.Jugador;
import java.util.Scanner;

/**
 * Métodos: • disparo(Revolver r): el método,
 * recibe el revolver de agua y llama a los métodos de mojar() y
 * siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si
 * el revolver tira el agua, el jugador se moja. El atributo mojado pasa a false
 * y el método devuelve true, sino false.
 *
 * @author elias
 */
public class servicioJugador {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Jugador cargarJug = new Jugador();
//    public Jugador cargarJugador() {
//        
//        System.out.println("Introdusca el ID del Jugador");
//        cargarJug.setId(leer.nextInt());
//        System.out.println("Introdusca el nombre del Jugador");
//        cargarJug.setNombre(leer.next());
//        return cargarJug;
//    }

    public void disparo(servicioRevolver r) {
        System.out.println("El revolver ya esta listo, desea Apretar el gatillo");
        String resp = leer.next();
        if (resp.equalsIgnoreCase("si")) {
            if (r.mojar()) {
                cargarJug.setMojado(true);
                System.out.println("Te mojaste");
            } else {
                r.siguienteChorro();
                System.out.println("Safaste");
            }
        }else{
            System.out.println("Sos un Cagon");
        }
    }
}
