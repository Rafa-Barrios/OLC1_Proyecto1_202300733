package Clases.GUI;

import java.util.ArrayList;
import Clases.Abstractas.Instruccion;
import Clases.Objetos.CuerpoAFD;

public class Entorno {

    public static ArrayList<CuerpoAFD> automatas = new ArrayList<>();

    /**
     * Ejecuta una lista de instrucciones.
     */
    public static void ejecutarInstrucciones(ArrayList<Instruccion> instrucciones) {
        for (Instruccion instr : instrucciones) {
            instr.ejecutar();  // Cada instrucción maneja su propia ejecución
        }
    }
}
