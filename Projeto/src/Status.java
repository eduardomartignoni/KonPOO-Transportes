public enum Status {

	CANCELADA(-1, "Cancelada"), FINALIZADA(0, "Finalizada"), 
	LOCADA(1, "Locada"), PENDENTE(2, "Pendente");
	
	private int id;
	private String nome;

	private Status(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
