public class Caminhao {

	private final String nome;
	private final double autonomia;
	private int codigo;
	private static int codigoAUX = 1;
	private final double velocidade;
	private double custoPorKm;

	public Caminhao(String nome, double autonomia, double velocidade, double custoPorKm){
		this.nome = nome;
		this.autonomia = autonomia;
		this.velocidade = velocidade;
		this.custoPorKm = custoPorKm;
		codigo = codigoAUX;
		codigoAUX++;
	}

	public String getNome() {
		return nome;
	}
}
