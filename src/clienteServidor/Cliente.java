package clienteServidor;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//logica de presentación

public class Cliente {
	public static void main(String[]args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
	try {
		System.out.print("Bienvenido al cliente ");
		String nombreMaquina = "localhost";
		String numPuerto="13";
		
		boolean b =true; 
		String nombre="";
		while(b) {
			System.out.print("Cual es su nombre?");
			nombre = br.readLine();
			if(nombre.length()>0) b=false;
				
		}
		b = true;
		String edad="";
		while(b) {
			System.out.print("Cual es su edad?");
			edad =   br.readLine();
			if(edad.length()>0) b=false;
				
		}
		String edadnombre = nombre+"-"+edad;
		
		System.out.print( "Informción recibida del servidor\n"+ClienteAuxiliar1.obtenerinfo(nombreMaquina,numPuerto,edadnombre) );
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
		
		
	}

}
