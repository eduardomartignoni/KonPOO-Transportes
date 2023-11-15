public class Cliente {

	private int codigo;
	private static int codigoAUX;
	private String nome;
	private String telefone;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public static int getCodigoAUX() {
		return codigoAUX;
	}
	public String getNome() {
		return nome;
	}
	public static void setCodigoAUX(int codigoAUX) {
		Cliente.codigoAUX = codigoAUX;
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
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + "]";
	}

	
}
