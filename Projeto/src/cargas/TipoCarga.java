package cargas;
public abstract class TipoCarga{

	protected String descricao;
	protected final double fatorPeso;
	protected final int numero;

	protected TipoCarga(String descricao, double fatorPeso, int numero){
		this.descricao = descricao;
		this.fatorPeso=fatorPeso;
		this.numero = numero;
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

	public String csvString(){
		return fatorPeso + ";" + descricao + ";" + numero;
	}

}