package principal;

import java.util.Arrays;

import domotica.*;

public class Main {
	public static void main(String[] args) {
		DispositivoInteligente[] tablaDispositivos = new DispositivoInteligente[4];
		DispositivoInteligente altavozObjeto = new Altavoz("Partybox", "JBL", 120, "Alexa");
		DispositivoInteligente luzObjeto = new Luz("Color Your Life", "Google", 18);
		DispositivoInteligente termostatoObjeto = new Termostato("Cold & Hot", "Fagor", 75);
		DispositivoInteligente camaraObjeto = new CamaraSeguridad("Seguridad Plus", "Acer", 55, "4K");
		tablaDispositivos[0] = altavozObjeto;
		tablaDispositivos[1] = luzObjeto;
		tablaDispositivos[2] = termostatoObjeto;
		tablaDispositivos[3] = camaraObjeto;

		System.out.println("Antes de ordenar tabla: ");
		mostrarTabla(tablaDispositivos);
		
		System.out.println("Después de ordenar tabla por precio: ");
		Arrays.sort(tablaDispositivos);
		mostrarTabla(tablaDispositivos);

		for (DispositivoInteligente dispositivo : tablaDispositivos) {
			dispositivo.encenderDispositivo();
			if (dispositivo instanceof Altavoz altavoz) {
				// ALTAVOZ
				altavoz.subirNivel();
				altavoz.subirNivel();
				System.out.println(altavoz.getNombreAsistente());
			}else if (dispositivo instanceof Luz luz) {
				// LUZ
				luz.subirNivel();
				luz.cambiarColor("Azul");
			} else if (dispositivo instanceof Termostato termostato) {
				// TERMOSTATO
				termostato.cambiarModoFuncionamiento();
				termostato.activarAlerta("Temperatura excesiva, baje la temperatura");
			} else if (dispositivo instanceof CamaraSeguridad camara) {
				// CAMARA DE SEGURIDAD
				camara.iniciarGrabacion();
				camara.activarAlerta("¡Intrusos en el domicilio!");
			}
			System.out.println(dispositivo);
		}
		


		// TRY CATCH DE ERROR
		try {
			altavozObjeto.apagarDispositivo();
			((Altavoz) altavozObjeto).subirNivel();
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
