package entidades;
public class Cliente {

	private final int codigo;
	private String nome;
	private String telefone;	

	public Cliente(String nome, String telefone, int codigo) {
		this.nome = nome;
		this.telefone = telefone;
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return String.format("Codigo: %d\tNome: %s\tTelefone: %s", codigo, nome, telefone);
	}

	public String csvString() {
		return codigo + ";" + nome + ";" + telefone;
	}
}