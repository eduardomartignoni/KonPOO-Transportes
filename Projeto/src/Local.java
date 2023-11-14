public class Local {

	private String cidade;
	private int codigo;
	private static int codigoAUX = 1;
	private String nome;

	public Local(String cidade, String nome) {
		this.cidade = cidade;
		this.nome = nome;
		this.codigo = codigoAUX;
		codigoAUX++;
	}

	@Override
	public String toString() {
		return "Cidade: " + cidade + "; Codigo: " + codigo + "; Nome: " + nome + ";\n";
	}

	public String getCidade() {
		return cidade;
	}
}
