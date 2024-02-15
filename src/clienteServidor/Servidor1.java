package clienteServidor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Servidor1 {
	public static void main(String[] args) {
		int puertoServidor =13; 
		if(args.length==1) 
			puertoServidor= Integer.parseInt(args[0]);
		try {
			MiSocketDatagramaServidor miSocket = new MiSocketDatagramaServidor(puertoServidor);
			System.out.println("El servidor esta listo");
			String mensaje ="";
			while(true) {
				MensajeDatagrama peticion = miSocket.recibeMensajeYEmisor();
				System.out.println("Peticion recibida");
				
				String[] n = peticion.obtieneMensaje().split("-");
				List<String> lista = new ArrayList<>(Arrays.asList(n));
				System.out.println(lista.get(1));
				
				if(Integer.parseInt(lista.get(1).trim()) >= 18) {
					mensaje = lista.get(0)+ " es mayor de edad";
				}else {
					mensaje = lista.get(0)+ " es menor de edad";
				}
				
				
				System.out.println("info enviada "+mensaje);
				
				miSocket.enviaMensaje(peticion.obtieneDireccion(),peticion.obtienePuerto(),mensaje);
				miSocket.close();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
