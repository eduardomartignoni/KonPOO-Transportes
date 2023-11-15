public abstract class TipoCarga{

	protected String descricao;
	protected double fatorPeso;
	protected int numero;

	public TipoCarga(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getFatorPeso() {
		return fatorPeso;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Numero: " + numero + ";\nDescricao: " + descricao + ";\n";
	}

}
