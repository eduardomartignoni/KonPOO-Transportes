public class Local {

	private final String cidade;
	private final int codigo;
	private static int codigoAUX = 1;
	private final String nome;
	private final double distancia;

	public Local(String cidade, String nome, double distancia) {
		this.nome = nome;
		this.cidade = cidade;
		this.distancia = distancia;

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

	@Override
	public String toString() {
		return "[" + codigo + "] "+ cidade + " - " + nome + distancia+ "\n";
	}
}
