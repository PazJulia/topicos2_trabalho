package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Assinatura;
import repository.AssinaturaRepository;

@Named
@ViewScoped
public class AssinaturaListing extends Listing<Assinatura> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Assinatura> list;
	private String filtro;
	
	public AssinaturaListing() {
		super(Assinatura.class);
	}
	
	public void open() {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 1000);
        options.put("height", 500);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");  
        // ligacao com a pagina xhtml
        PrimeFaces.current().dialog().openDynamic("assinaturalisting", options, null);
	}

	public void pesquisar() {
		AssinaturaRepository repo = new AssinaturaRepository();
		setList(repo.findByNome(getFiltro()));
	}
	
	
	public List<Assinatura> getList() {
		if (list == null)
			list = new ArrayList<Assinatura>();
		return list;
	}

	public void setList(List<Assinatura> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}