package controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Livro;

@Named
@ViewScoped
public class DetalhesLivroController implements Serializable{

	private static final long serialVersionUID = 4508336239754915469L;
	private Livro livro;
	
	public DetalhesLivroController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		livro = (Livro) flash.get("livroFlash");
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}