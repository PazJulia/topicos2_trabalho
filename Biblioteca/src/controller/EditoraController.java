package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.EditoraListing;
import model.Editora;

@Named
@ViewScoped
public class EditoraController extends Controller<Editora> implements Serializable {

	private static final long serialVersionUID = 2102885714371800999L;

	private String filtro;
//	private Editora assinatura;

	public void abrirEditoraListing() {
		EditoraListing listing = new EditoraListing();
		listing.open();
	}

	public void obterEditoraListing(SelectEvent event) {
		Editora entity = (Editora) event.getObject();
		setEntity(entity);
	}

	@Override
	public Editora getEntity() {
		if (entity == null) {
			entity = new Editora();
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