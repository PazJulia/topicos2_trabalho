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
			paginasAcesso.add("pages/assinatura.xhtml");
			paginasAcesso.add("pages/assinaturalisting.xhtml");
			paginasAcesso.add("pages/autor.xhtml");
			paginasAcesso.add("pages/autorlisting.xhtml");
			paginasAcesso.add("pages/editora.xhtml");
			paginasAcesso.add("pages/editoralisting.xhtml");
			paginasAcesso.add("pages/funcionario.xhtml");
			paginasAcesso.add("pages/funcionariolisting.xhtml");
			paginasAcesso.add("pages/livro.xhtml");
			paginasAcesso.add("pages/livrolisting.xhtml");

		} else {
			paginasAcesso.add("pages/autor.xhtml");
			paginasAcesso.add("pages/autorlisting.xhtml");
			paginasAcesso.add("pages/editora.xhtml");
			paginasAcesso.add("pages/editoralisting.xhtml");
			paginasAcesso.add("pages/livro.xhtml");
			paginasAcesso.add("pages/livrolisting.xhtml");
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

	public static TipoFuncionario valueOf(Integer valor) {
		for (TipoFuncionario tipoFuncionario : TipoFuncionario.values()) {
			if (valor == tipoFuncionario.getId())
				return tipoFuncionario;
		}
		return null;
	}

}
