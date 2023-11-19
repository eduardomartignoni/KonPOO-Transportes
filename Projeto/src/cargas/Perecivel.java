package cargas;
public class Perecivel extends TipoCarga{

	private static final double fatorPesoS = 2;
	private String origem;
	private String validade;


	public Perecivel(String descricao, int numero, String origem, String validade) {
		super(descricao, fatorPesoS, numero);
		this.origem = origem;
		this.validade = validade;
	}

	public String getOrigem() {
		return origem;
	}

	public String getValidade() {
		return validade;
	}

	@Override
	public String toString() {
		return super.toString() + "\tOrigem: " + origem + "\tValidade: " + validade;
	}

	@Override
	public String csvString() {
		return super.csvString() + ";" + origem + ";" + validade;
	}
}
