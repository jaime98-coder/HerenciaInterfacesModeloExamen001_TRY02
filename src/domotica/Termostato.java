package domotica;

public class Termostato extends DispositivoInteligente implements EmitirAlerta {
	private int temperaturaObjetivo;
	private String modoFuncionamiento = "calor";
	private boolean alertaActiva = false;
	private String mensajeAlerta = "Sin mensaje";

	public Termostato(String nombreComercial, String marca, double precio, int temperaturaObjetivo) {
		super(nombreComercial, marca, precio);
		this.temperaturaObjetivo = temperaturaObjetivo;
	}

	@Override
	public void activarAlerta(String mensajeAlerta) {
		if (encendido) {
			if (!alertaActiva) {
				alertaActiva = true;
				System.out.println("¡¡Alerta activada!! Mensaje alerta: " + mensajeAlerta);
				this.mensajeAlerta = mensajeAlerta;
			}
		} else {
			mostrarErrorApagado();
		}

	}

	@Override
	public void desactivarAlerta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void informarAlertaActiva() {
		// TODO Auto-generated method stub

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

}
