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
	 * el número de vocales que contiene dicho método.
	 * 
	 * @param args Entrada de la consola por defecto. No es utilizada.
	 * 
	 */
	public static void main(String[] args) {
		String nombreCompleto=solicitarNombre();//Solicita el nombre completo al usuario
		int numeroVocales=contarVocales(nombreCompleto);//contabiliza el numero de vocales
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
		if(numeroVocales>1) {//En el caso de que tenga más de una vocal
			System.out.println("Su nombre completo tiene "+numeroVocales+" vocales");
		}
		else {
			if(numeroVocales==1) {//En el caso de que tenga una vocal
				System.out.println("Su nombre completo tiene "+numeroVocales+" vocal");
			}
			else {//En el caso de que no tenga vocales
				System.out.println("Su nombre completo no tiene vocales");
			}
		}
	}

	/**
	 * Método privado utilizado para solicitar al usuario que
	 * introduzca por la consola su nombre completo
	 * 
	 * @return 	String que contiene el nombre completo introducido por la
	 * 			consola por el usuario
	 */
	private static String solicitarNombre() {
		//Declaración de variables
		Scanner teclado=new Scanner(System.in);
		String nombreCompleto;
		//Se solicita al usuario su nombre completo
		System.out.println("indique su nombre y apellidos, por favor.");
		nombreCompleto=teclado.nextLine();//Se lee el nombre introducido por teclado
		teclado.close();//Se cierra el Scanner
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
	private static int contarVocales(String nombreCompleto) {
		//Declaración de variables
		int numeroVocales=0;//Iniciamos a cero el numero de vocales que hemos encontrado
		int longitud=nombreCompleto.length()-1;//longitud contiene el numero de caracteres
		//de nombreCompleto, teniendo en cuenta que empieza por cero, por eso -1.
		for(int i=0;i<=longitud;i++) {//Recorremos todos los caracteres de nombreCompleto,
			//empezando pro el primero
			char caracter=nombreCompleto.charAt(i);//Obtenemos el caracter que está en la posición i
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
	 * @return boolean devuelev false, si caracter no es una vocal, y true en el caso contrario.
	 */
	private static boolean esVocal(char caracter) {
			int index="AEIOUaeioáéíóú".indexOf(caracter);//Obtenemos en qué posición se encuentra
			//caracter, en el string "AEIOUaeioáéíóú". En caso de no entrarse, indexOf devuelve -1
		     return  index!= -1;//Devolvemos un boolean que será true si caracter se encontraba en la cadena
		     					//"AEIOUaeioáéíóú", false en caso contrario.
	}

}
