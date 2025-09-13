package Clases.GUI;

import java.io.StringReader;
import java.util.ArrayList;
import Lenguaje.Lexer;
import Lenguaje.Parser;
import Clases.Abstractas.Instruccion;
import Clases.Errores.ErrorSintactico;

public class Analizador {

    /**
     * Analiza un código de autómatas y devuelve la lista de instrucciones parseadas.
     * Además llena la lista de errores sintácticos encontrados.
     */
    public static ArrayList<Instruccion> analizar(String codigo, ArrayList<ErrorSintactico> erroresSintacticos) {
        try {
            // Crear lexer con el código ingresado
            Lexer lexer = new Lexer(new StringReader(codigo));
            
            // Crear parser usando el lexer
            Parser parser = new Parser(lexer);
            
            // Ejecutar parseo
            parser.parse();
            
            // Agregar los errores sintácticos encontrados
            erroresSintacticos.addAll(parser.erroresSintacticos);
            
            // Devolver las instrucciones parseadas
            return Parser.instrucciones;
            
        } catch (Exception e) {
            System.out.println("Error en análisis: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
