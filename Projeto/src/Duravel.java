public class Duravel extends TipoCarga {

	private static final double fatorPesoS = 1.5;
	private final String materialPrincipal;
	private final String setor;

	public Duravel(String descricao, int numero, String materialPrincipal, String setor) {
		super(descricao, fatorPesoS, numero);
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

	@Override
	public String csvString() {
		return super.csvString() + ";" + materialPrincipal + ";" + setor;
	}
}
