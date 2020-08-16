package model.validation;

import application.ValidationException;
import model.Editora;
import repository.EditoraRepository;

public class EditoraValidation implements Validation<Editora> {

	@Override
	public void validate(Editora entity) throws ValidationException {
		validateNome(entity);
	}
	
	private void validateNome(Editora entity) throws ValidationException{
		EditoraRepository repo = new EditoraRepository();
		if(repo.contains(entity.getId(), entity.getNome())) {
			throw new ValidationException("Esta editora já foi cadastrada.");
		}
	}

}
