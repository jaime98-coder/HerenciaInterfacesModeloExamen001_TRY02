package domotica;

public class Altavoz extends DispositivoInteligente implements ModificarNivel {
	private String nombreAsistente;
	private int volumen = 30;
	private static final int CANTIDAD_VOLUMEN_MODIF = 5;

	public Altavoz(String nombreComercial, String marca, double precio, String nombreAsistente) {
		super(nombreComercial, marca, precio);
		this.nombreAsistente = nombreAsistente;
	}

	public String getNombreAsistente() {
		return "Asistente: " + nombreAsistente;
	}

	@Override
	public void subirNivel() {
		if (this.encendido) {
			if (this.volumen >= 0 && this.volumen < 100 && volumen + CANTIDAD_VOLUMEN_MODIF <= 100) {
				volumen += CANTIDAD_VOLUMEN_MODIF;
				System.out.println("Volumen subido al: " + this.volumen);
			} else {
				System.out.println("Error. Fuera de rango de volumen");
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void bajarNivel() {
		if (this.encendido) {
			if (this.volumen > 0 && this.volumen <= 100 && volumen - CANTIDAD_VOLUMEN_MODIF >= 0) {
				volumen -= CANTIDAD_VOLUMEN_MODIF;
				System.out.println("Volumen subido al: " + this.volumen);
			} else {
				System.out.println("Error. Fuera de rango de volumen");
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void mostrarNivelActual() {
		if (encendido) {
			System.out.println("Volumen actual: " + this.volumen);
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void encenderDispositivo() {
		if (!encendido) {
			encendido = true;
			System.out.println("Beep! Altavoz encendido");
		} else {
			System.out.println("El altavoz ya estaba encendido...");
		}

	}

	@Override
	public void apagarDispositivo() {
		if (encendido) {
			encendido = false;
			System.out.println("Clonk! Altavoz apagado");
		} else {
			System.out.println("El altavoz ya estaba apagado...");
		}

	}

	@Override
	public String toString() {
		return "Altavoz [nombreAsistente=" + nombreAsistente + ", volumen=" + volumen + ", nombreComercial="
				+ nombreComercial + ", marca=" + marca + ", precio=" + precio + "]";
	}

}
