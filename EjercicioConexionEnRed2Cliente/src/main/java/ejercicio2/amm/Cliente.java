package ejercicio2.amm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Cliente {

	public static void main(String[] args) {
		
		String host = "localhost";
		int puerto = 6000;
		
		try {
			Socket cliente = new Socket(host, puerto);
			System.out.println("Iniciando conexi�n.");
			
			//creo flujo de salida con la petici�n:
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());//establezco el flujo, el cable
			
			//guardo la petici�n en una var para poder usarla despu�s:
		
			String peticion = mandarPeticion();
			
//			System.out.println("Env�o la petici�n " + mandarPeticion());
			flujoSalida.writeUTF(peticion);
//			
//			//creo flujo de entrada para recibir respuesta del servidor:
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			
			double media = flujoEntrada.readDouble();
			System.err.println(media);
//			System.out.println("He recibido como respuesta del servidor " + flujoEntrada.readDouble());
//			
			flujoSalida.close();
			flujoEntrada.close();
			cliente.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String mandarPeticion() {
		Scanner scanner = new Scanner(System.in);
		String numerosATransformar = "";
		int numero = 0;
		for(int i = 0; i < 5; i++) {
			System.out.println("Introduce un n�mero: ");
			numero = scanner.nextInt();
			System.out.println("El n�mero es: " + numero);
			numerosATransformar += numero;
		}
		
		return numerosATransformar;
	}

}
