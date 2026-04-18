package principal;

import java.util.Arrays;

import domotica.*;

public class Main {
	public static void main(String[] args) {
		DispositivoInteligente[] tablaDispositivos = new DispositivoInteligente[4];
		DispositivoInteligente altavoz = new Altavoz("Partybox", "JBL", 120, "Alexa");
		DispositivoInteligente luz = new Luz("Color Your Life", "Google", 18);
		DispositivoInteligente termostato = new Termostato("Cold & Hot", "Fagor", 75);
		DispositivoInteligente camara = new CamaraSeguridad("Seguridad Plus", "Acer", 55, "4K");
		tablaDispositivos[0] = altavoz;
		tablaDispositivos[1] = luz;
		tablaDispositivos[2] = termostato;
		tablaDispositivos[3] = camara;

		System.out.println("Antes de ordenar tabla: ");
		mostrarTabla(tablaDispositivos);
		
		System.out.println("Después de ordenar tabla por precio: ");
		Arrays.sort(tablaDispositivos);
		mostrarTabla(tablaDispositivos);

		// ALTAVOZ
		altavoz.encenderDispositivo();
		((Altavoz) altavoz).subirNivel();
		((Altavoz) altavoz).subirNivel();
		System.out.println(((Altavoz) altavoz).getNombreAsistente());

		// LUZ
		luz.encenderDispositivo();
		((Luz) luz).subirNivel();
		((Luz) luz).cambiarColor("Rojo");

		// TERMOSTATO
		termostato.encenderDispositivo();
		((Termostato) termostato).cambiarModoFuncionamiento();
		((Termostato) termostato).activarAlerta("Temperatura excesiva, baje la temperatura");

		// CAMARA
		camara.encenderDispositivo();
		((CamaraSeguridad) camara).iniciarGrabacion();
		((CamaraSeguridad) camara).activarAlerta("¡Intrusos en el domicilio!");

		// TRY CATCH DE ERROR
		try {
			altavoz.apagarDispositivo();
			((Altavoz) altavoz).subirNivel();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void mostrarTabla(DispositivoInteligente[] tablaDispositivos) {
		for (DispositivoInteligente dispositivo : tablaDispositivos) {
			System.out.println(dispositivo);
		}
	}

}
