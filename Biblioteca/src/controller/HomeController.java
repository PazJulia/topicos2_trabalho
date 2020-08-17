package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import model.Livro;
import repository.LivroRepository;

@Named
@RequestScoped
public class HomeController implements Serializable{

	private static final long serialVersionUID = 6634652502903367505L;
	private List<Livro> listaLivro;


	public List<Livro> getListaLivro() {
		if (listaLivro == null) {
			LivroRepository repo = new LivroRepository();
			listaLivro = repo.findLastResults(15);
		}
		return listaLivro;
	}
	
	public String detalhesLivro(Livro livro) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("livroFlash", livro);
		
		return "detalheslivro.xhtml?faces-redirect=true";
//		Util.redirect("/detalheslivro.xhtml");
	}

}