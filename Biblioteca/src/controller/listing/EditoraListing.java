package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Editora;
import repository.EditoraRepository;

@Named
@ViewScoped
public class EditoraListing extends Listing<Editora> {

	private static final long serialVersionUID = 1099024942047033010L;
	private List<Editora> list;
	private String filtro;

	public EditoraListing() {
		super(Editora.class);
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
		PrimeFaces.current().dialog().openDynamic("editoralisting", options, null);
	}

	public void pesquisar() {
		EditoraRepository repo = new EditoraRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<Editora> getList() {
		if (list == null)
			list = new ArrayList<Editora>();
		return list;
	}

	public void setList(List<Editora> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}