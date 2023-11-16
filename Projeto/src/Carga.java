public class Carga {

	private final int codigo;

	private final int peso;
	private final int tempoMaximo;
	private final double valorDeclarado;

	private final Local destino;
	private final Local origem;
	private final Cliente cliente;
	private Status status;
	private final TipoCarga tipoCarga;

	private Caminhao caminhaoDesignado;

	public Carga(int codigo, int peso, int tempoMaximo, double valorDeclarado, Local destino, Local origem, Cliente cliente, TipoCarga tipoCarga) {
		this.codigo = codigo;
		this.peso = peso;
		this.tempoMaximo = tempoMaximo;
		this.valorDeclarado = valorDeclarado;
		this.destino = destino;
		this.origem = origem;
		this.cliente = cliente;
		this.status = Status.PENDENTE;
		this.tipoCarga = tipoCarga;
	}

	public void cancelar() {
		status = Status.CANCELADA;
	}

	//ISSO AQUI TA ERRADO 100%
	public double distancia() {
		double distancia = destino.getDistancia()-origem.getDistancia();
		if (distancia<50) return 50;
		return distancia;
	}

	public void finalizar() {
		status = Status.FINALIZADA;
	}

	public double frete() {
		return precoPorDistancia()+precoPorPeso();
	}

	public void locar() {
		status = Status.LOCADA;
	}

	public double precoPorDistancia() {
		return distancia()*caminhaoDesignado.getCustoPorKm();
	}
	public double precoPorPeso(){
		return peso*tipoCarga.fatorPeso;
	}

	public int getCodigo(){
		return codigo;
	}
	public Status getStatus(){
		return status;
	}

	public void setCaminhaoDesignado(Caminhao caminhaoDesignado){
		this.caminhaoDesignado = caminhaoDesignado;
	}
	@Override
	public String toString() {
		return  "Carga [" + codigo + "] "+ status + " - " + tipoCarga + "\n" +
				"Cliente: "+ cliente + "\tOrigem: " + origem + "\tDestino: " + destino + "\n" +
				peso + " t\t" + valorDeclarado + " R$\t" + tempoMaximo + " dias\n\n" +
				caminhaoDesignado.toString() + "\n\n" +
				"Valor Total do Frete: " + String.format("%.2f", frete()) + " R$";
	}

	enum Status {

		CANCELADA(-1, "Cancelada"), FINALIZADA(0, "Finalizada"),
		LOCADA(1, "Locada"), PENDENTE(2, "Pendente");

		private int id;
		private final String nome;

		Status(int id, String nome) {
			this.id = id;
			this.nome = nome;
		}

		public String getNome() {
			return this.nome;
		}
	}
}
