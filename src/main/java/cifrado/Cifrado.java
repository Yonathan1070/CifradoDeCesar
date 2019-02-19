/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cifrado;

//Librerías importadas para la ejecución del programa.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Yonathan Camilo Bohorquez
 * @author Jose Manuel Bohorquez
 */
public class Cifrado {
    // Instancia para la entrada de datos por teclado
    public static BufferedReader entradaDatos = new BufferedReader (new InputStreamReader (System.in));
    
    public static void main(String[] args)throws IOException {
        
        Menu(); // Llamamos el metodo para cifrar.
        
    }
    public static void Menu()throws IOException{
        String opcionMenu;
        do{
            System.out.println("+ - - - - - - - - - - - - - - - - - - - - +");
            System.out.println("|     Bienvenido al Cifrado de Cesar.     |");
            System.out.println("+ - - - - - - - - - - - - - - - - - - - - +");
            System.out.println("|                                         |");
            System.out.println("|   1. Cifrar Texto.                      |");
            System.out.println("|   2. Descifrar Texto                    |");
            System.out.println("|   0. Salir.                             |");
            System.out.println("+ - - - - - - - - - - - - - - - - - - - - +");
            
            opcionMenu=entradaDatos.readLine();
            
            switch(opcionMenu){
                case "1":
                    Cifrar();
                    break;
                case "2":
                    DesCifrar();
                    break;
                case "0":
                    finPrograma();
                    break;
                default:
                    System.out.println("Opcion no válida\n\n");
                    break;
            }
        }while(opcionMenu != "0");
    }
    public static void Cifrar()throws IOException{
        
        char [] abecedario =
        {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String textoCifrado="";
        int claveCifrado=0;
        
        System.out.println("Digite la texto que desea cifrar: ");
        String texto = entradaDatos.readLine();  // Recibimos el texto.
        texto = texto.toLowerCase();    // Pasamos el texto a minusculas.
        System.out.println("Digite la clave para cifrar:");  // Solicitamos la clave de Cifrado.
        claveCifrado = Integer.parseInt(entradaDatos.readLine());  // Parseamos a int la clave.
        
        for (int i=0;i<texto.length();i++){   //Recorremos el texto hasta el final de la cadena de texto.
            if(texto.charAt(i) == ' '){ // Verificamos si existe algún espacio en la cadena de caracteres.
                textoCifrado = textoCifrado.concat(""+"#"); //Reemplazamos el espacio por un numeral.
            }
            for (int j=0;j<abecedario.length;j++){  //Recorremos el abecedario.
                if(texto.charAt(i) == abecedario[j]){  //Buscamos caracteres que estén en el texto y en el abecedario.
                    if( (j+claveCifrado) > 25){     //Si la clave es mayor a mi abecedario, inicializamos la cadena del abecedario en el primer carácter.
                        int claveTemporal =  j+claveCifrado; //Suma claves temporales.
                        int claveFinal = claveTemporal-26;
                        textoCifrado = textoCifrado.concat(""+abecedario[claveFinal]);//Creamos la nueva cadena de texto cifrada.
                    }else{
                        textoCifrado = textoCifrado.concat(""+abecedario[j+claveCifrado]); //Creamos la cadena de texto cifrada.
                    }
                }
            }
        }
        System.out.println("Su texto cifrado es: "+textoCifrado+"\n\n");//Mostramos en pantalla la cadena de Texto cifrada.
    }
    
    public static void DesCifrar()throws IOException{
        char [] abecedario =
        {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String textoDesCifrado="";
        int claveDesCifrado=0;
        
        System.out.println("Digite el texto cifrado: ");
        String textoCifrado = entradaDatos.readLine();  // Recibimos el texto.
        textoCifrado = textoCifrado.toLowerCase();    // Pasamos el texto a minusculas.
        System.out.println("Digite la clave que usó para cifrar el texto:");  // Solicitamos la clave de Cifrado.
        claveDesCifrado = Integer.parseInt(entradaDatos.readLine());  // Parseamos a int la clave.
        
        for (int i=0;i<textoCifrado.length();i++){   //Recorremos el texto hasta el final de la cadena del texto Cifrado.
            if(textoCifrado.charAt(i) == '#'){ // verificamos si hay un numeral en la cadena de caracteres.
                textoDesCifrado = textoDesCifrado.concat(""+" "); //reemplazamos el numeral por un espacio.
            }
            for (int j=0;j<abecedario.length;j++){  //Recorremos el abecedario.
                if(textoCifrado.charAt(i) == abecedario[j]){  //Buscamos caracteres que estén en el texto y en el abecedario.
                    if( (j-claveDesCifrado) < 0){     //Si la clave es mayor a mi abecedario, inicializamos la cadena del abecedario en el primer carácter.
                        int claveTemporal =  j-claveDesCifrado; //Suma claves temporales.
                        int claveFinal = claveTemporal+26;
                        textoDesCifrado = textoDesCifrado.concat(""+abecedario[claveFinal]);//Creamos la nueva cadena de texto cifrada.
                    }else{
                        textoDesCifrado = textoDesCifrado.concat(""+abecedario[j-claveDesCifrado]); //Creamos la cadena de texto cifrada.
                    }
                }
            }
        }
        System.out.println("Su texto descifrado es: "+textoDesCifrado+"\n\n");//Mostramos en pantalla la cadena de Texto DesCifrada.
    }
    
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
