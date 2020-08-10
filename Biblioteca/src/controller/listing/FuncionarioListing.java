package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Funcionario;
import model.Usuario;
import repository.FuncionarioRepository;

@Named
@ViewScoped
public class FuncionarioListing extends Listing<Usuario> {

	public FuncionarioListing() {
		super(Funcionario.class);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -2632410076988315224L;
	private List<Funcionario> list;
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
		PrimeFaces.current().dialog().openDynamic("funcionariolisting", options, null);
	}

	public void pesquisar() {
		FuncionarioRepository repo = new FuncionarioRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<Funcionario> getList() {
		if (list == null)
			list = new ArrayList<Funcionario>();
		return list;
	}

	public void setList(List<Funcionario> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
