package servicio;

import entidad.Jugador;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Métodos: • llenarJuego(ArrayList <Jugador> jugadores, Revolver r): este
 * método recibe los jugadores y el revolver para guardarlos en los atributos
 * del juego.
 *
 * 10 • ronda(): cada ronda consiste en un jugador que se apunta con el revolver
 * de agua y aprieta el gatillo. Sí el revolver tira el agua el jugador se moja
 * y se termina el juego, sino se moja, se pasa al siguiente jugador hasta que
 * uno se moje. Si o si alguien se tiene que mojar. Al final del juego, se debe
 * mostrar que jugador se mojó. Pensar la lógica necesaria para realizar esto,
 * usando los atributos de la clase Juego.
 *
 * @author elias
 */
public class servicioJuego {

    ArrayList<Jugador> integrantes;
    Jugador sj = new Jugador();
    servicioRevolver servRev = new servicioRevolver();
    servicioJugador servJug = new servicioJugador();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void llenarJugadores() {
        integrantes = new ArrayList();

        System.out.println("Cuantos jugadores juega? ");
        int resp = leer.nextInt();
        if (resp > 6 && resp < 1) {
            resp = 6;
        }
        int cont = 0;
        do {
            Jugador auxju = new Jugador();
            System.out.println("Ingrese su nombre");
            auxju.setNombre(leer.next());
            auxju.setId((cont + 1));
            System.out.println("Su ID: " + auxju.getId());
            cont++;
            integrantes.add(auxju);
        } while (resp != cont);

    }

    public void ronda() {
        servRev.llenarRevolver();

       // for (Jugador auxJugador : integrantes) {
            //   do {
            for (int i = 0; i < integrantes.size(); i++) {
            
        
            servRev.mostrarPosiciones();
            servJug.disparo(servRev);
            System.out.println(integrantes.get(i));

            if (integrantes.get(i).isMojado()) {
                integrantes.get(i).setMojado(true);
                break;
            }
            // System.out.println(auxJugador);
            //  } while (!auxJugador.isMojado());
        }
        imprimirLista();

    }

    public void imprimirLista() {
        for (Jugador integrante : integrantes) {
            System.out.println(integrante.toString());
        }

    }
}
