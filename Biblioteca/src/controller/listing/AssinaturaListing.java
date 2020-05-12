package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import factory.JPAFactory;
import model.Assinatura;
import repository.AssinaturaRepository;

public class AssinaturaListing extends Listing<Assinatura>{

	private static final long serialVersionUID = -6353803701165725807L;
	
	private List<Assinatura> list;
	private String filtro;
	
	@Override
	public Assinatura getEntity() {
		if (entity == null)
			entity = new Assinatura();
		return entity;
	}
	
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
		PrimeFaces.current().dialog().openDynamic("assinaturalisting", options, null);
	}
	
	public void pesquisar() {
		AssinaturaRepository repo = new AssinaturaRepository();
		setList(repo.findByNome(getFiltro()));
	}
	
	public void select(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		setEntity((Assinatura) em.find(Assinatura.class, id));

		// retorna o objeto via dialogreturn e finaliza o dialog
		PrimeFaces.current().dialog().closeDynamic(getEntity());
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
