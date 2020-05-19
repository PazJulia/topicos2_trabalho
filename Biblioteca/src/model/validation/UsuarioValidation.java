package model.validation;

import application.ValidationException;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioValidation implements Validation<Usuario> {
	
	@Override
	public void validate(Usuario entity) throws ValidationException{
		validateCpf(entity);
		
		validateEmail(entity);
	}
	
	private void validateCpf(Usuario entity) throws ValidationException{
		UsuarioRepository repo = new UsuarioRepository();
		if(repo.containsCpf(entity.getId(), entity.getCpf())) {
			throw new ValidationException("CPF inválido.");
		}
	}
	
	private void validateEmail(Usuario entity) throws ValidationException{
		UsuarioRepository repo = new UsuarioRepository();
		if(repo.containsEmail(entity.getId(), entity.getEmail())) {
			throw new ValidationException("Este e-mail já está cadastrado.");
		}
	}

}
