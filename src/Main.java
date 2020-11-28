import java.util.Scanner;

/**
 * Main es una clase p�blica que solicita al usuario
 * mediante la consola de comandos su nombre completo
 * y muestra como resultado el n�mero de vocales que
 * contiene dicho nombre completo.
 * 
 * @author Raul S�nchez Gal�n
 * @version 1.0
 *
 */
public class Main {

	/**
	 * M�todo principal. Solicita al usuario
	 * su nombre completo, e imprime por pantalla
	 * el n�mero de vocales que contiene dicho m�todo.
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
	 * M�todo privado, utilizado para mostrar el n�mero de vocales como resultado. 
	 * El mensaje que muestra es diferente si son varias, una o ninguna.
	 * Como precondici�n, numeroVocales tiene que ser un n�mero mayor o igual que cero.
	 * 
	 * @param numeroVocales par�metro de entrada que representa el numero de vocales detectadas
	 * 
	 */
	private static void imprimirResultado(int numeroVocales) {
		if(numeroVocales>1) {//En el caso de que tenga m�s de una vocal
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
	 * M�todo privado utilizado para solicitar al usuario que
	 * introduzca por la consola su nombre completo
	 * 
	 * @return 	String que contiene el nombre completo introducido por la
	 * 			consola por el usuario
	 */
	private static String solicitarNombre() {
		//Declaraci�n de variables
		Scanner teclado=new Scanner(System.in);
		String nombreCompleto;
		//Se solicita al usuario su nombre completo
		System.out.println("indique su nombre y apellidos, por favor.");
		nombreCompleto=teclado.nextLine();//Se lee el nombre introducido por teclado
		teclado.close();//Se cierra el Scanner
		return nombreCompleto;//Se devuelve como resultado el nombre introducido
	}

	/**
	 * M�todo privado que devuelve como resultado el numero de vocales
	 * que contiene nombreCompleto
	 * 
	 * @param 	nombreCompleto String, que es utilizada como un par�metro de entrada,
	 * 			de la cual se va a contabilizar el n�mero de vocales
	 * 			que contiene.
	 * @return int n�mero de vocales que contiene el par�metro de entrada nombreCompleto
	 */
	private static int contarVocales(String nombreCompleto) {
		//Declaraci�n de variables
		int numeroVocales=0;//Iniciamos a cero el numero de vocales que hemos encontrado
		int longitud=nombreCompleto.length()-1;//longitud contiene el numero de caracteres
		//de nombreCompleto, teniendo en cuenta que empieza por cero, por eso -1.
		for(int i=0;i<=longitud;i++) {//Recorremos todos los caracteres de nombreCompleto,
			//empezando pro el primero
			char caracter=nombreCompleto.charAt(i);//Obtenemos el caracter que est� en la posici�n i
			if(esVocal(caracter)) {//En el caso de que sea vocal
				numeroVocales++;//Incrementamos numero vocales
			}
		}
		return numeroVocales;//Devolvemos el resultado
	}

	/**
	 * M�todo privado que devuelve si caracter es una vocal o no.
	 * No tiene en cuenta vocales con acentuaciones no contempladas en el 
	 * espa�ol, como por ejemplo �.
	 * 
	 * @param 	caracter par�metro de entrada, del cual se va a determinar si es una vocal o no.
	 * @return boolean devuelev false, si caracter no es una vocal, y true en el caso contrario.
	 */
	private static boolean esVocal(char caracter) {
			int index="AEIOUaeio�����".indexOf(caracter);//Obtenemos en qu� posici�n se encuentra
			//caracter, en el string "AEIOUaeio�����". En caso de no entrarse, indexOf devuelve -1
		     return  index!= -1;//Devolvemos un boolean que ser� true si caracter se encontraba en la cadena
		     					//"AEIOUaeio�����", false en caso contrario.
	}

}
