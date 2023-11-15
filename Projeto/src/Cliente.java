public class Cliente {

	private final int codigo;
	private final String nome;
	private final String telefone;

	public Cliente(int codigo, String nome, String telefone){
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
	}
	public int getCodigo(){
		return codigo;
	}

}
