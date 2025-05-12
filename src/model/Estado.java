package model;

public enum Estado {
	
	QUEMADO("QUEMADO"), 
	DORMIDO("DORMIDO"), 
	CONGELADO("CONGELADO"), 
	PARALIZADO("PARALIZADO"), 
	HELADO("HELADO"), 
	SOMNOLIENTO("SOMNOLIENTO"), 
	POKERUS("POKERUS"), 
	DEBILITADO("DEBILITADO"), 
	CONFUSO("CONFUSO"), 
	ENAMORADO("ENAMORADO"), 
	ATRAPADO("ATRAPADO"), 
	MALDITO("MALDITO"), 
	GRAVEMENTE_ENVENENADO("GRAVEMENTE_ENVENENADO"),
	DRENADORAS("DRENADORAS"), 
	CANTO_MORTAL("CANTO_MORTAL"), 
	CENTRO_DE_ATENCION("CENTRO_DE_ATENCION"), 
	AMEDRENTADO("AMEDRENTADO"),
	NORMAL("NORMAL"),
	ENVENENADO("ENVENENADO");

	private final String nombre;

	Estado (String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public static Estado convertirEstado(String tipoString) {
		for (Estado est : Estado.values()) {
			if (est.getNombre().toUpperCase().equalsIgnoreCase(tipoString)) {
				return est;
			}
		}
		return null;
	}

}
