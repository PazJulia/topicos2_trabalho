package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Livro;
import repository.LivroRepository;

@Named
@ViewScoped
public class LivroListingClienteController implements Serializable {

	private static final long serialVersionUID = 2255083523177347774L;

	private List<Livro> list;
	
	public String detalhesLivro(Livro livro) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("livroFlash", livro);
		
		return "detalheslivro.xhtml?faces-redirect=true";
	}

	public List<Livro> getList() {
		if (list == null) {
			LivroRepository repo = new LivroRepository();
			list = repo.findByNome("");
		}
		return list;
	}

	public void setList(List<Livro> list) {
		this.list = list;
	}

}
