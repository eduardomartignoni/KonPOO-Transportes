public class Perecivel extends TipoCarga{

	private final double fatorPeso = 2;
	private final int numero = 1;
	private String origem;
	private int validade;


	public Perecivel(String descricao, String origem, int validade) {
		super(descricao);
		this.origem = origem;
		this.validade = validade;
	}

	public String getOrigem() {
		return origem;
	}

	public int getValidade() {
		return validade;
	}

	@Override
	public String toString() {
		return super.toString() + "Origem: " + origem + "; Validade: " + validade + ";\n";
	}
}
