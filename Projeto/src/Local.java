public class Local {

	private String cidade;
	private int codigo;
	private static int codigoAUX = 1;
	private String nome;

	public Local(String cidade, String nome) {
		this.cidade = cidade;
		setNome(nome);
		this.codigo = codigoAUX;
		codigoAUX++;
	}

	public String getCidade() {
		return cidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty()) {
			this.nome = nome;
		}
	}

	@Override
	public String toString() {
		return "Cidade: " + cidade + "; Codigo: " + codigo + "; Nome: " + nome + ";\n";
	}
}
