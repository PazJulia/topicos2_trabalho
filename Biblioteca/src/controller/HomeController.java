package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import model.Livro;
import repository.LivroRepository;

@Named
@ViewScoped
public class HomeController extends Controller<Livro> {

	private static final long serialVersionUID = 448739786884393045L;

	private List<Livro> listaLivro;
	
	public void obterLivroListing(SelectEvent event) {
		Livro entity = (Livro) event.getObject();
		setEntity(entity);
	}


	@Override
	public Livro getEntity() {
		if (entity == null) {
			entity = new Livro();
		}
		return entity;
	}

	public List<Livro> getListaLivro() {
		if (listaLivro == null) {
			LivroRepository repo = new LivroRepository();
			listaLivro = repo.findLastResults(10);
		}
		return listaLivro;
	}

}

/*
 * package controller;
 * 
 * import java.util.List;
 * 
 * import javax.faces.view.ViewScoped; import javax.inject.Named;
 * 
 * import model.Livro; import repository.LivroRepository;
 * 
 * @Named
 * 
 * @ViewScoped public class HomeController extends Controller<Livro> {
 * 
 * private static final long serialVersionUID = -2627567552257005986L;
 * 
 * private List<Livro> listaLivro;
 * 
 * public List<Livro> getlistaLivro() { if (listaLivro == null) {
 * LivroRepository repo = new LivroRepository(); listaLivro =
 * repo.findLastResults(10); } return listaLivro; }
 * 
 * @Override public Livro getEntity() { if (entity == null) { entity = new
 * Livro(); } return entity; } }
 */