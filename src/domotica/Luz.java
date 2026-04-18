package domotica;

public class Luz extends DispositivoInteligente implements ModificarNivel {
	private String color = "blanco";
	private int brillo = 50;
	private int CANTIDAD_BRILLO_MODIF = 10;

	public Luz(String nombreComercial, String marca, double precio) {
		super(nombreComercial, marca, precio);
	}

	@Override
	public void subirNivel() {
		if (this.encendido) {
			if (this.brillo >= 0 && this.brillo < 100 && brillo + CANTIDAD_BRILLO_MODIF <= 100) {
				brillo += CANTIDAD_BRILLO_MODIF;
				System.out.println("Brillo subido al: " + this.brillo);

			} else {
				System.out.println("Error. Fuera de rango de brillo");
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void bajarNivel() {
		if (this.encendido) {
			if (this.brillo > 0 && this.brillo <= 100 && brillo - CANTIDAD_BRILLO_MODIF >= 0) {
				brillo -= CANTIDAD_BRILLO_MODIF;
				System.out.println("Brillo subido al: " + this.brillo);
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
			System.out.println("Brillo actual: " + this.brillo);
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void encenderDispositivo() {
		if (!encendido) {
			encendido = true;
			System.out.println("Beep! Luz encendida");
		} else {
			System.out.println("La luz ya estaba encendida...");
		}

	}

	@Override
	public void apagarDispositivo() {
		if (encendido) {
			encendido = false;
			System.out.println("Clonk! Luz apagada");
		} else {
			System.out.println("La luz ya estaba apagado...");
		}

	}

	public void cambiarColor(String color) {
		this.color = color;
		System.out.println("Color cambiado a: " + this.color);
	}

	@Override
	public String toString() {
		return "Luz [color=" + color + ", brillo=" + brillo + ", nombreComercial=" + nombreComercial + ", marca="
				+ marca + ", precio=" + precio + ", encendido=" + encendido + "]";
	}

}
