import java.util.Scanner;

/**
 * Main es una clase pública que solicita al usuario
 * mediante la consola de comandos su nombre completo
 * y muestra como resultado el número de vocales que
 * contiene dicho nombre completo.
 * 
 * @author Raul Sánchez Galán
 * @version 1.0
 *
 */
public class Main {

	/**
	 * Método principal. Solicita al usuario
	 * su nombre completo, e imprime por pantalla
	 * el número de vocales que contiene dicho nombre.
	 * 
	 * @param args Entrada de la consola por defecto. No es utilizada.
	 * 
	 */
	public static void main(String[] args) {
		String nombreCompleto=solicitarNombre();//Solicita el nombre completo al usuario
		int numeroVocales=contarVocalesRecursivo(nombreCompleto);//contabiliza el numero de vocales
		imprimirResultado(numeroVocales);//Se muestra el resultado por pantalla		
	}

	/**
	 * Método privado, utilizado para mostrar el número de vocales como resultado. 
	 * El mensaje que muestra es diferente si son varias, una o ninguna.
	 * Como precondición, numeroVocales tiene que ser un número mayor o igual que cero.
	 * 
	 * @param numeroVocales parámetro de entrada que representa el numero de vocales detectadas
	 * 
	 */
	private static void imprimirResultado(int numeroVocales) {
		System.out.println( //Imprimimos el mensaje
				"Su nombre completo tiene "+numeroVocales+" vocales");//En el caso de que tenga más de una vocal
	}

	/**
	 * Método privado utilizado para solicitar al usuario que
	 * introduzca por la consola su nombre completo
	 * 
	 * @return 	String que contiene el nombre completo introducido por la
	 * 			consola por el usuario
	 */
	private static String solicitarNombre() {
		String nombreCompleto="Liu";//nombre completo
		return nombreCompleto;//Se devuelve como resultado el nombre introducido
	}

	/**
	 * Método privado que devuelve como resultado el numero de vocales
	 * que contiene nombreCompleto
	 * 
	 * @param 	nombreCompleto String, que es utilizada como un parámetro de entrada,
	 * 			de la cual se va a contabilizar el número de vocales
	 * 			que contiene.
	 * @return int número de vocales que contiene el parámetro de entrada nombreCompleto
	 */
	private static int contarVocalesRecursivo(String nombreCompleto) {
		int numeroVocales=0;
		if(nombreCompleto.length()==0)//Caso base: Caso de que la cadena esta vacia
			numeroVocales=0;
		else {
			char caracter=nombreCompleto.charAt(0);//Obtenemos el caracter que está en la posición 0
			numeroVocales=contarVocalesRecursivo(nombreCompleto.substring(2));
			if(esVocal(caracter)) {//En el caso de que sea vocal
				numeroVocales++;//Incrementamos numero vocales
			}
		}
		return numeroVocales;//Devolvemos el resultado
	}

	/**
	 * Método privado que devuelve si caracter es una vocal o no.
	 * No tiene en cuenta vocales con acentuaciones no contempladas en el 
	 * español, como por ejemplo à.
	 * 
	 * @param 	caracter parámetro de entrada, del cual se va a determinar si es una vocal o no.
	 * @return boolean devuelve false, si caracter no es una vocal, y true en el caso contrario.
	 */
	private static boolean esVocal(char caracter) {
		int index="AEIOUaeiouáéíóú".indexOf(caracter);//Obtenemos en qué posición se encuentra
		//caracter, en el string "AEIOUaeioáéíóú". En caso de no encontrarse, indexOf devuelve -1
		return  index!= -1;//Devolvemos un boolean que será true si caracter se encontraba en la cadena
		//"AEIOUaeioáéíóú", false en caso contrario.
	}

}
