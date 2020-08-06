package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Autor;
import repository.AutorRepository;

@Named
@ViewScoped
public class AutorListing extends Listing<Autor> {

	private static final long serialVersionUID = 1099024942047033010L;
	private List<Autor> list;
	private String filtro;

	public AutorListing() {
		super(Autor.class);
	}

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("width", 1000);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		// ligacao com a pagina xhtml
		PrimeFaces.current().dialog().openDynamic("autorlisting", options, null);
	}

	public void pesquisar() {
		AutorRepository repo = new AutorRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<Autor> getList() {
		if (list == null)
			list = new ArrayList<Autor>();
		return list;
	}

	public void setList(List<Autor> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}