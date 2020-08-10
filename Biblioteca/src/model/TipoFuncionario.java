package model;

import java.util.ArrayList;
import java.util.List;

public enum TipoFuncionario {

	ADMINISTRADOR(0, "Adminstrador"), GENRENTE(1, "Gerente"), OPERACIONAL(2, "Operacional");

	private int id;
	private String label;
	private List<String> paginasAcesso = null;

	private TipoFuncionario(int id, String label) {
		this.id = id;
		this.label = label;

		paginasAcesso = new ArrayList<String>();
		if (id == 0 || id == 1) {
			paginasAcesso.add("assinatura.xhtml");
			paginasAcesso.add("assinaturalisting.xhtml");
			paginasAcesso.add("autor.xhtml");
			paginasAcesso.add("autorlisting.xhtml");
			paginasAcesso.add("editora.xhtml");
			paginasAcesso.add("editoralisting.xhtml");
			paginasAcesso.add("funcionario.xhtml");
			paginasAcesso.add("funcionariolisting.xhtml");
			paginasAcesso.add("livro.xhtml");
			paginasAcesso.add("livrolisting.xhtml");		
			
		} else {
			paginasAcesso.add("autor.xhtml");
			paginasAcesso.add("autorlisting.xhtml");
			paginasAcesso.add("editora.xhtml");
			paginasAcesso.add("editoralisting.xhtml");
			paginasAcesso.add("livro.xhtml");
			paginasAcesso.add("livrolisting.xhtml");	
			paginasAcesso.add("acessonegado.xhtml");
		}

	}

	public List<String> getPaginasAcesso() {
		return paginasAcesso;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static TipoFuncionario valueOf(int valor) {
		for (TipoFuncionario tipoFuncionario : TipoFuncionario.values()) {
			if (valor == tipoFuncionario.getId())
				return tipoFuncionario;
		}
		return null;
	}

}
