package model;

public enum tipo {
	
	NORMAL("Normal"), 
	FUEGO("Fuego"), 
	AGUA("Agua"), 
	ELECTRICO("Eléctrico"), 
	PLANTA("Planta"), 
	HIELO("Hielo"),
	LUCHA("Lucha"), 
	VENENO("Veneno"), 
	TIERRA("Tierra"), 
	VOLADOR("Volador"), 
	PSIQUICO("Psíquico"), 
	BICHO("Bicho"),
	ROCA("Roca"), 
	FANTASMA("Fantasma"), 
	DRAGON("Dragón"), 
	OSCURO("Oscuro"), 
	ACERO("Acero"), 
	HADA("Hada");
	
	private final String nombre;
	
	tipo (String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public static tipo convertir (String tipoString ) {
		for (tipo tipo :tipo.values()) {
			if (tipo.getNombre().toUpperCase().equalsIgnoreCase(tipoString)) {
				return tipo;
			}
		}
		return null;
	}

}
