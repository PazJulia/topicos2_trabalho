package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import controller.listing.AssinaturaListing;
import model.Assinatura;
import model.Livro;
import repository.LivroRepository;

@Named
@ViewScoped
public class AssinaturaController extends Controller<Assinatura> {

	private static final long serialVersionUID = 8186658504743489919L;

	private String filtro;

	private List<Livro> listaLivro;

	public void abrirAssinaturaListing() {
		AssinaturaListing listing = new AssinaturaListing();
		listing.open();
	}

	public void obterAssinaturaListing(SelectEvent event) {
		Assinatura entity = (Assinatura) event.getObject();
		setEntity(entity);

	}

	@Override
	public Assinatura getEntity() {
		if (entity == null) {
			entity = new Assinatura();
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setListaEditora(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}

	public List<Livro> getListaLivro() {
		if (listaLivro == null) {
			LivroRepository repo = new LivroRepository();
			listaLivro = repo.findByNome("");
		}
		return listaLivro;
	}

	public void onItemUnselect(UnselectEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage();
		msg.setSummary("Item unselected: " + event.getObject().toString());
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		context.addMessage(null, msg);
	}

}
