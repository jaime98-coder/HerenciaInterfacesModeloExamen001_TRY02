package domotica;

public abstract class DispositivoInteligente implements Comparable<DispositivoInteligente> {
	protected String nombreComercial;
	protected String marca;
	protected double precio;
	protected boolean encendido = false;

	public DispositivoInteligente(String nombreComercial, String marca, double precio) {
		setNombreComercial(nombreComercial);
		setMarca(marca);
		setPrecio(precio);
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
	}

	public boolean isEncendido() {
		return encendido;
	}

	public abstract void encenderDispositivo();

	public abstract void apagarDispositivo();

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		if (obj instanceof DispositivoInteligente dispositivo) {
			if (nombreComercial.equalsIgnoreCase(dispositivo.nombreComercial) && marca.equalsIgnoreCase(dispositivo.marca)) {
				sonIguales = true;
			}
		}
		return sonIguales;
	}

	public void mostrarErrorApagado() {
		throw new IllegalStateException("ERROR. El dispositivo está apagado");
	}

	@Override
	public int compareTo(DispositivoInteligente otroDispositivo) {
		if (this.precio < otroDispositivo.precio) {
			return -1;
		} else if (this.precio > otroDispositivo.precio) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "DispositivoInteligente [nombreComercial=" + nombreComercial + ", marca=" + marca + ", precio=" + precio
				+ ", encendido=" + encendido + "]";
	}

}
