package domotica;

public class CamaraSeguridad extends DispositivoInteligente implements EmitirAlerta {
	private String resolucion;
	private boolean grabando = false;
	private boolean alertaActiva = false;
	private String mensajeAlerta = "Sin mensaje";

	public CamaraSeguridad(String nombreComercial, String marca, double precio, String resolucion) {
		super(nombreComercial, marca, precio);
		setResolucion(resolucion);
	}

	/**
	 * Setter de resolucion, poniendo las reglas de las 3 resoluciones en venta
	 * disponible
	 * 
	 * @param resolucion
	 */
	public void setResolucion(String resolucion) {
		if (resolucion.equalsIgnoreCase("720P") || resolucion.equalsIgnoreCase("1080P")
				|| resolucion.equalsIgnoreCase("4k")) {
			this.resolucion = resolucion;
		}
	}

	public void iniciarGrabacion() {
		if (encendido) {
			if (!grabando) {
				this.grabando = true;
				System.out.println("Comienza la grabación...");
			}
		} else {
			mostrarErrorApagado();
		}
	}

	public void detenerGrabacion() {
		if (encendido) {
			if (grabando) {
				this.grabando = false;
				System.out.println("Deteniendo y guardando grabación...");
			}
		} else {
			mostrarErrorApagado();
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
			System.out.println("Beep! Camara de Seguridad encendido");
		} else {
			System.out.println("La cámara de seguridad ya estaba encendida...");
		}

	}

	@Override
	public void apagarDispositivo() {
		if (encendido) {
			encendido = false;
			System.out.println("Clonk! Camara de Seguridad apagada");
		} else {
			System.out.println("La cámara de seguridad ya estaba apagada...");
		}

	}

	@Override
	public String toString() {
		return "CamaraSeguridad [resolucion=" + resolucion + ", grabando=" + grabando + ", alertaActiva=" + alertaActiva
				+ ", mensajeAlerta=" + mensajeAlerta + ", nombreComercial=" + nombreComercial + ", marca=" + marca
				+ ", precio=" + precio + ", encendido=" + encendido + "]";
	}

}
