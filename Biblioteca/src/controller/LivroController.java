package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.LivroListing;
import model.Editora;
import model.Livro;
import repository.EditoraRepository;

@Named
@ViewScoped
public class LivroController extends Controller<Livro> {

	private static final long serialVersionUID = -1348113245312721328L;

	private String filtro;
	private List<Editora> listaEditora;

	@Override
	public void salvar() {
		if (getEntity().getEditora() != null && getEntity().getEditora().getId() == null)
			getEntity().setEditora(null);
		super.salvar();
	}

	public void abrirLivroListing() {
		LivroListing listing = new LivroListing();
		listing.open();
	}

	public void obterLivroListing(SelectEvent event) {
		Livro entity = (Livro) event.getObject();
		setEntity(entity);
		if (getEntity().getEditora() == null) {
			getEntity().setEditora(new Editora());

		}
	}

	@Override
	public Livro getEntity() {
		if (entity == null) {
			entity = new Livro();
			entity.setEditora(new Editora());
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Editora> getListaEditora() {
		if (listaEditora == null) {
			EditoraRepository repo = new EditoraRepository();
			listaEditora = repo.findByNome("");
		}
		return listaEditora;
	}

	public void setListaEditora(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
	}
	
	public void atualizarEditora() {
		listaEditora = null;
	}

}
