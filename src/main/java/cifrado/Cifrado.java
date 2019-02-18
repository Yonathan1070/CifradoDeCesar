/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cifrado;

//Librerías importadas para la ejecución del programa.
import java.io.*;

/**
 *
 * @author Yonathan Camilo Bohorquez
 * @author Jose Manuel Bohorquez
 */
public class Cifrado {
    // Instancia para la entrada de datos por teclado
    public static BufferedReader entradaDatos = new BufferedReader (new InputStreamReader (System.in));
    
    public static void main(String[] args)throws IOException {
        
        Cifrar(); // Llamamos el metodo para cifrar.
        
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
            for (int j=0;j<abecedario.length-1;j++){  //Recorremos el abecedario.
                if(texto.charAt(i) == abecedario[j]){  //Buscamos caracteres que estén en el texto y en el abecedario.
                    if( (j+claveCifrado) >= 26){     //Si la clave es mayor a mi abecedario, inicializamos la cadena del abecedario en el primer carácter.
                        int temp =  j+claveCifrado; //Suma claves temporales.
                        int tmp = temp-26;
                        textoCifrado = textoCifrado.concat(""+abecedario[tmp]);//Creamos la nueva cadena de texto cifrada.
                    }else{
                        textoCifrado = textoCifrado.concat(""+abecedario[j+claveCifrado]); //Creamos ña cadena de texto cifrada.
                    }
                }
            }
        }
        System.out.println("Su texto cifrada es: "+textoCifrado);//Mostramos en pantalla la cadena de Texto cifrada.
    }
}
