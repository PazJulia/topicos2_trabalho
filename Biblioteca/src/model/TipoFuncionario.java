package model;

import java.util.ArrayList;
import java.util.List;

public enum TipoFuncionario {

	ADMINISTRADOR(0, "Adminstrador"), FUNCIONARIO(1, "Gerente"), OPERACIONAL(2, "Operacional");

	private int id;
	private String label;
	private List<String> paginasAcesso = null;

	private TipoFuncionario(int id, String label) {
		this.id = id;
		this.label = label;
		paginasAcesso = new ArrayList<String>();
		if (id == 0) {
			paginasAcesso.add("aluno.xhtml");
			paginasAcesso.add("alunolisting.xhtml");
			paginasAcesso.add("professor.xhtml");
			paginasAcesso.add("professorlisting.xhtml");
			paginasAcesso.add("professorlistingsql.xhtml");
			paginasAcesso.add("estado.xhtml");
			paginasAcesso.add("estadolisting.xhtml");
			paginasAcesso.add("cidade.xhtml");
			paginasAcesso.add("cidadelisting.xhtml");
			paginasAcesso.add("img-professor");
		} else {
			paginasAcesso.add("aluno.xhtml");
			paginasAcesso.add("estado.xhtml");
			paginasAcesso.add("cidade.xhtml");
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
		for (TipoFuncionario tipoUsuario : TipoFuncionario.values()) {
			if (valor == tipoUsuario.getId())
				return tipoUsuario;
		}
		return null;
	}

}
