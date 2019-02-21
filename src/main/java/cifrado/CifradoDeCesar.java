package cifrado;

/**
 * Librerías importadas para la ejecución del programa.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Clase Cifrado de Cesar
 *
 * @author Yonathan Camilo Bohorquez
 * @author Jose Manuel Bohorquez
 * @version 1.0
 */
public class CifradoDeCesar {
    /**
     * Instancia para la entrada de datos por teclado
     */
    public static BufferedReader entradaDatos = new BufferedReader (new InputStreamReader (System.in));
    /**
     * Declaracion de la variable abecedario de tipo char donde se encuentra el abecedario.
     */
    public static char [] abecedario =
    {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    /**
     * Declaracion de la variable claveCifrado de tipo int donde se almacena la clave para cifrar o descifrar el texto.
     */
    public static int claveCifrado, claveDesCifrado;
    /**
     * Drclaración de las variables clave Temporal y Final para las respectivas operaciones.
     */
    public static int claveTemporal;
    public static int claveFinal;
    /**
     * Declaracion de la variable textoCifrado de tipo String donde se almacena el texto cifrado.
     */
    public static String textoCifrado="";
    
    /**
     * Metodo principal del Cifrado de Cesar.
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args)throws IOException {
        /**
         * Llamamos el metodo para cifrar.
         */
        Menu();
        
    }
    /**
     * Metodo para el menú de navegacion.
     * 
     * @throws IOException 
     */
    public static void Menu()throws IOException{
        /**
         * Variable que guarda la opcion que se selecciona en la entrada por teclado
         */
        String opcionMenu;
        /**
         * Ciclo repetitivo hasta que se seleccione la opcion (0) para salir.
         */
        do{
            /**
             * Mostramos en pantalla el menú de navegación.
             */
            System.out.println("+ - - - - - - - - - - - - - - - - - - - - +");
            System.out.println("|     Bienvenido al Cifrado de Cesar.     |");
            System.out.println("+ - - - - - - - - - - - - - - - - - - - - +");
            System.out.println("|                                         |");
            System.out.println("|   1. Cifrar Texto.                      |");
            System.out.println("|   2. Descifrar Texto                    |");
            System.out.println("|   0. Salir.                             |");
            System.out.println("+ - - - - - - - - - - - - - - - - - - - - +");
            
            /**
             * Recibimos la opcion seleccionada.
             */
            opcionMenu=entradaDatos.readLine();
            
            switch(opcionMenu){
                case "1":
                    /**
                     * Lamamos al metodo para cifrar en el Metodo de Cesar.
                     */
                    Cifrar();
                    break;
                case "2":
                    /**
                     * Llamamos al metodo para Descifrar en el Metodo de Cesar.
                     */
                    DesCifrar();
                    break;
                case "0":
                    /**
                     * Llamamos el metodo para finalizar el programa.
                     */
                    finPrograma();
                    break;
                default:
                    /**
                     * En caso de que la opción no sea la correcta, mostramos mensaje de advertencia.
                     */
                    System.out.println("Opcion no válida\n\n");
                    break;
            }
        }while(opcionMenu != "0");
    }
    /**
     * Metodo para Cifrar.
     * 
     * @throws IOException 
     */
    public static void Cifrar()throws IOException{
        /**
         * Solicitamos el texto a cifrar.
         */
        System.out.println("Digite la texto que desea cifrar: ");
        /**
         * Recibimos el texto digitado siendo almacenado en la variable texto de tipo String.
         */
        String texto = entradaDatos.readLine();
        /**
         * Pasamos el texto ingresado a minusculas.
         */
        texto = texto.toLowerCase();
        /**
         * Solicitamos la clave de Cifrado.
         */
        System.out.println("Digite la clave para cifrar:");
        /**
         * Parseamos a int la clave para realizar las operaciones.
         */
        claveCifrado = Integer.parseInt(entradaDatos.readLine());
        /**
         * Recorremos el texto hasta el final de la cadena de texto.
         */
        for (int i=0;i<texto.length();i++){
            /**
             * Verificamos si existe algún espacio en la cadena de caracteres.
             */
            if(texto.charAt(i) == ' '){
                /**
                 * Reemplazamos el espacio por un numeral en el texto cifrado.
                 */
                textoCifrado = textoCifrado.concat(""+"#");
            }
            /**
             * Recorremos el abecedario.
             */
            for (int j=0;j<abecedario.length;j++){
                /**
                 * Buscamos caracteres que estén en el texto y en el abecedario.
                 */
                if(texto.charAt(i) == abecedario[j]){
                    /**
                     * Si la clave es mayor a mi abecedario, inicializamos la cadena del abecedario en el primer carácter.
                     */
                    if( (j+claveCifrado) > 25){
                        /**
                         * Operamos claves temporales y finales.
                         */
                        claveTemporal =  j+claveCifrado;
                        claveFinal = claveTemporal-26;
                        /**
                         * Ciclo repetitivo que verifica que la clave se encuentre dentro del rango 0-25.
                         */
                        do{
                            /**
                             * Verificamos que la clave final no supere el rango de 25.
                             */
                            if(claveFinal>25){
                                /**
                                 * Operamos la clave final.
                                 */
                                claveFinal = claveFinal-26;
                            }
                            else{
                                /**
                                 * Si la clave final no es mayor a 25 reemplazamos el carácter.
                                 * Creamos la nueva cadena de texto cifrada concatenando cada uno de los caracteres.
                                 */
                                textoCifrado = textoCifrado.concat(""+abecedario[claveFinal]);
                            }
                        }while(claveFinal>25);
                        /**
                         * Creamos la nueva cadena de texto cifrada concatenando cada uno de los caracteres.
                         */
                        textoCifrado = textoCifrado.concat(""+abecedario[claveFinal]);
                    }else{
                        /**
                         * Creamos la cadena de texto cifrada concatenando cada uno de los caracteres.
                         */
                        textoCifrado = textoCifrado.concat(""+abecedario[j+claveCifrado]);
                    }
                }
            }
        }
        /**
         * Mostramos en pantalla la cadena de Texto cifrada.
         */
        System.out.println("Su texto cifrado es: "+textoCifrado+"\n\n");
    }
    /**
     * Metodo para Descifrar.
     * 
     * @throws IOException 
     */
    public static void DesCifrar()throws IOException{
        /**
         * Verificamos que exista un texto Cifrado.
         */
        if(textoCifrado.equals("")){
            System.out.println("No existe un texto Cifrado.\n\n");
        }
        else{
            /**
             * Variable que guarda el texto descifrado.
             */
            String textoDesCifrado="";
            /**
             * Ciclo repetitivo hasta que se haya descifrado el texto.
             */
            do{
                /**
                 * Solicitamos la clave de Cifrado.
                 */
                System.out.println("Digite la clave que usó para cifrar el texto:");
                /**
                 * Parseamos a int la clave.
                 */
                claveDesCifrado = Integer.parseInt(entradaDatos.readLine());
                /**
                 * Verificamos que las claves coincidan.
                 */
                if(claveCifrado != claveDesCifrado){
                    System.out.println("Digite una clave correcta.\n");
                }else{
                    /**
                     * Recorremos el texto hasta el final de la cadena del texto Cifrado.
                     */
                    for (int i=0;i<textoCifrado.length();i++){
                        /**
                         * Verificamos si hay un numeral en la cadena de caracteres.
                         */
                        if(textoCifrado.charAt(i) == '#'){
                            /**
                             * reemplazamos el numeral por un espacio.
                             */
                            textoDesCifrado = textoDesCifrado.concat(""+" ");
                        }
                        /**
                         * Recorremos el abecedario.
                         */
                        for (int j=0;j<abecedario.length;j++){
                            /**
                             * Buscamos caracteres que estén en el texto y en el abecedario.
                             */
                            if(textoCifrado.charAt(i) == abecedario[j]){
                                /**
                                 * Si la clave es mayor a mi abecedario, inicializamos la cadena del abecedario en el primer carácter.
                                 */
                                if( (j-claveDesCifrado) < 0){
                                    /**
                                     * Suma claves temporales.
                                     */
                                    claveTemporal =  j-claveDesCifrado;
                                    claveFinal = claveTemporal+26;
                                    /**
                                     * Ciclo repetitivo hasta que la clave final sea mayor a 0.
                                     */
                                    do{
                                        /**
                                         * Verificamos que la clave final sea mayor a 0.
                                         */
                                        if(claveFinal<0){
                                            /**
                                             * Operamos la clave final si es menor a 0.
                                             */
                                            claveFinal = claveFinal+26;
                                        }
                                        else{
                                            /**
                                             * Concatenamos las letras descifradas si la clave final es mayor a 0.
                                             */
                                            textoCifrado = textoCifrado.concat(""+abecedario[claveFinal]);
                                        }
                                    }while(claveFinal<0);
                                    /**
                                     * Creamos la nueva cadena de texto cifrada.
                                     */
                                    textoDesCifrado = textoDesCifrado.concat(""+abecedario[claveFinal]);
                                }else{
                                    /**
                                     * Creamos la cadena de texto cifrada..
                                     */
                                    textoDesCifrado = textoDesCifrado.concat(""+abecedario[j-claveDesCifrado]);
                                }
                            }
                        }
                    }
                    /**
                     * Mostramos en pantalla la cadena de Texto DesCifrada.
                     */
                    System.out.println("Su texto descifrado es: "+textoDesCifrado+"\n\n");
                }
            }while(textoDesCifrado == "");
        }
    }
    /**
     * Metodo de la finalizacion del programa.
     */
    public static void finPrograma(){
        System.out.println("*´¨) \n" +
                "¸.•´¸.•*´¨) ¸.•*¨) \n" +
                "(¸.•´ (¸.•` ¤ Gracias por usar El Cifrado de Cesar \n"
                + "*´¨) \n" +
                "¸.•´¸.•*´¨) ¸.•*¨) \n" +
                "(¸.•´ (¸.•` ¤ Yonathan Bohorquez Rincon\n"
                + "*´¨) \n" +
                "¸.•´¸.•*´¨) ¸.•*¨) \n" +
                "(¸.•´ (¸.•` ¤ Manuel Bohorquez Vega");
        System.exit(0);
    }
}
