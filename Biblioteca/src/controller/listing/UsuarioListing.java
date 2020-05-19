package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Usuario;
import repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioListing extends Listing<Usuario> {

	public UsuarioListing() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -2632410076988315224L;
	private List<Usuario> list;
	private String filtro;

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("width", 800);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		// ligacao com a pagina xhtml
		PrimeFaces.current().dialog().openDynamic("usuariolisting", options, null);
	}

	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<Usuario> getList() {
		if (list == null)
			list = new ArrayList<Usuario>();
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
