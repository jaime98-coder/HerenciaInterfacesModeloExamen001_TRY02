package domotica;

public class Termostato extends DispositivoInteligente implements EmitirAlerta {
	private int temperaturaObjetivo = 24;
	private String modoFuncionamiento = "calor";
	private boolean alertaActiva = false;
	private String mensajeAlerta = "Sin mensaje";

	public Termostato(String nombreComercial, String marca, double precio) {
		super(nombreComercial, marca, precio);
	}

	/**
	 * Método que cambia de frio a calor
	 */
	public void cambiarModoFuncionamiento() {
		if (this.modoFuncionamiento.equalsIgnoreCase("calor")) {
			this.modoFuncionamiento = "frio";
		} else {
			this.modoFuncionamiento = "calor";
		}
	}

	public void setTemperaturaObjetivo(int temperaturaObjetivo) {
		if (temperaturaObjetivo >= 16 && temperaturaObjetivo <= 32) {
			this.temperaturaObjetivo = temperaturaObjetivo;
		}
	}

	@Override
	public void activarAlerta(String mensajeAlerta) {
		if (encendido) {
			if (!alertaActiva) {
				alertaActiva = true;
				System.out.println("¡¡Alerta activada!! \nMensaje alerta: " + mensajeAlerta);
				this.mensajeAlerta = mensajeAlerta;
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void desactivarAlerta() {
		if (encendido) {
			if (alertaActiva) {
				alertaActiva = false;
				System.out.println("Alerta desactivada (mensaje de alerta eliminado)");
				this.mensajeAlerta = "";
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void informarAlertaActiva() {
		if (encendido) {
			if (alertaActiva) {

				System.out.println(
						"La alerta está activada en estos momentos.\n Mensaje de Alerta: " + this.mensajeAlerta);
			} else {
				System.out.println("No hay ninguna alerta activa");
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void encenderDispositivo() {
		if (!encendido) {
			encendido = true;
			System.out.println("Beep! Termostato encendido");
		} else {
			System.out.println("El termostato ya estaba encendido...");
		}

	}

	@Override
	public void apagarDispositivo() {
		if (encendido) {
			encendido = false;
			System.out.println("Clonk! Termostato apagado");
		} else {
			System.out.println("El termostato ya estaba apagado...");
		}

	}

	@Override
	public String toString() {
		return "Termostato [temperaturaObjetivo=" + temperaturaObjetivo + ", modoFuncionamiento=" + modoFuncionamiento
				+ ", alertaActiva=" + alertaActiva + ", mensajeAlerta=" + mensajeAlerta + ", nombreComercial="
				+ nombreComercial + ", marca=" + marca + ", precio=" + precio + ", encendido=" + encendido + "]";
	}

}
