package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import controller.listing.LivroListing;
import model.Autor;
import model.Editora;
import model.Livro;
import repository.AutorRepository;
import repository.EditoraRepository;

@Named
@ViewScoped
public class LivroController extends Controller<Livro> {

	private static final long serialVersionUID = -1348113245312721328L;

	private String filtro;
	private List<Editora> listaEditora;
	
	private List<Autor> listaAutor;
	/*
	 * private InputStream fotoInputStream = null; private String nomeFoto = null;
	 * 
	 * public void upload(FileUploadEvent event) {
	 * 
	 * UploadedFile uploadFile = event.getFile();
	 * System.out.println("nome arquivo: " + uploadFile.getFileName());
	 * System.out.println("tipo: " + uploadFile.getContentType());
	 * System.out.println("tamanho: " + uploadFile.getSize());
	 * 
	 * if (uploadFile.getContentType().equals("image/png")) { try { fotoInputStream
	 * = uploadFile.getInputStream(); nomeFoto = uploadFile.getFileName();
	 * System.out.println("inputStream: " + uploadFile.getInputStream().toString());
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } Util.addMessageInfo("Upload realizado com sucesso.");
	 * } else { Util.addMessageError("O tipo da image deve ser png."); }
	 * 
	 * }
	 * 
	 * public String getNomeFoto() { if (nomeFoto == null) return
	 * "Selecione uma foto ..."; return "Arquivo: " + nomeFoto +
	 * " (Clique para alterar a foto...)"; }
	 */



	/*
	 * @Override public void salvar() { if (getEntity().getEditora() != null &&
	 * getEntity().getEditora().getId() == null) getEntity().setEditora(null);
	 * super.salvar(); }
	 */

	public void abrirLivroListing() {
		LivroListing listing = new LivroListing();
		listing.open();
	}

	public void obterLivroListing(SelectEvent event) {
		Livro entity = (Livro) event.getObject();
		setEntity(entity);
		if (getEntity().getEditora() == null) {
			getEntity().setEditora(new Editora());

		}
	}

	@Override
	public Livro getEntity() {
		if (entity == null) {
			entity = new Livro();
			entity.setEditora(new Editora());
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Editora> getListaEditora() {
		if (listaEditora == null) {
			EditoraRepository repo = new EditoraRepository();
			listaEditora = repo.findByNome("");
		}
		return listaEditora;
	}

	public void setListaEditora(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}
	
	public List<Autor> getListaAutor() {
		if (listaAutor == null) {
			AutorRepository repo = new AutorRepository();
			listaAutor = repo.findByNome("");
		}
		return listaAutor;
	}

	public void setListaAutor(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
	}

	public void atualizarEditora() {
		listaEditora = null;
	}
	
    public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
         
		FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
         
        context.addMessage(null, msg);
    }

}
