package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.AutorListing;
import model.Autor;

@Named
@ViewScoped
public class AutorController extends Controller<Autor> implements Serializable {

	private static final long serialVersionUID = 2102885714371800999L;

	private String filtro;

	public void abrirAutorListing() {
		AutorListing listing = new AutorListing();
		listing.open();
	}

	public void obterAutorListing(SelectEvent event) {
		Autor entity = (Autor) event.getObject();
		setEntity(entity);
	}

	@Override
	public Autor getEntity() {
		if (entity == null) {
			entity = new Autor();
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}