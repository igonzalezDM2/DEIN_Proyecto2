package enums;

import java.util.Arrays;

public enum EstadoLibro {
	NUEVO("Nuevo"),
	USADO_NUEVO("Usado Nuevo"),
	USADO_SEMINUEVO("Usado Seminuevo"),
	USADO_ESTROPEADO("Usado Estropeado"),
	RESTAURADO("Restaurado");
	
	private String valor;
	
	private EstadoLibro(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
	
	public static EstadoLibro getByValor(String valor) {
		return Arrays.stream(EstadoLibro.values())
		.filter(e -> e.valor.equals(valor))
		.findFirst()
		.orElse(null);
	}
}
