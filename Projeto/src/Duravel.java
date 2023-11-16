public class Duravel extends TipoCarga {

	private final double fatorPeso = 1.5;
	private final String materialPrincipal;
	private final int numero = 2;
	private final String setor;

	public Duravel(String descricao, String materialPrincipal, String setor) {
		super(descricao);
		this.materialPrincipal = materialPrincipal;
		this.setor = setor;
	}

	public String getMaterialPrincipal() {
		return materialPrincipal;
	}

	public String getSetor() {
		return setor;
	}

	@Override
	public String toString() {
		return super.toString() + "Material Principal: " + materialPrincipal + "; Setor: " + setor + ";\n";
	}
}
