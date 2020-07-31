package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.AssinaturaListing;
import model.Assinatura;

@Named
@ViewScoped
public class AssinaturaController extends Controller<Assinatura> implements Serializable {

	private static final long serialVersionUID = 2102885714371800999L;

	private String filtro;

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

//	----------------------------------------------------------------
//	private List<Assinatura> listaAssinatura;
//
//	public void pesquisar() {
//		AssinaturaRepository repo = new AssinaturaRepository();
//		listaAssinatura = repo.findByNome(getFiltro());
//	}
//
//	@Override
//	public Assinatura getEntity() {
//		if (entity == null)
//			entity = new Assinatura();
//		return entity;
//	}
//
//	public void abrirAssinaturaListing() {
//		AssinaturaListing listing = new AssinaturaListing();
//		listing.open();
//	}
//
//	public void obterAssinaturaListing(SelectEvent event) {
//		Assinatura entity = (Assinatura) event.getObject();
//		setEntity(entity);
//	}
//
//	public String getFiltro() {
//		return filtro;
//	}
//
//	public void setFiltro(String filtro) {
//		this.filtro = filtro;
//	}
//
//	public List<Assinatura> getListaAssinatura() {
//		if (listaAssinatura == null)
//			listaAssinatura = new ArrayList<Assinatura>();
//		return listaAssinatura;
//	}
//
//	/*
//	 * @Override public void salvar() { EntityManager em =
//	 * JPAFactory.getEntityManager(); Query query =
//	 * em.createQuery("Select a From Assinatura a Where a.nome = :nome");
//	 * query.setParameter("nome", getEntity().getNome()); try { assinatura =
//	 * (Assinatura) query.getSingleResult(); } catch (NoResultException e) {
//	 * assinatura = null; }
//	 * 
//	 * if (assinatura == null) super.salvar(); else
//	 * Util.addMessageError("Já existe uma assinatura com este nome"); }
//	 */

}