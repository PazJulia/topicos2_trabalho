package converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Editora;
import repository.EditoraRepository;

@FacesConverter(forClass = Editora.class)
public class EditoraConverter implements Converter<Editora>{

	@Override
	public Editora getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty())
			return null;
		EditoraRepository repo = new EditoraRepository();
		return repo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Editora value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}
}
