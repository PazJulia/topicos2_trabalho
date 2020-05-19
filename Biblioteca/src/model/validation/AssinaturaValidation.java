package model.validation;

import application.ValidationException;
import model.Assinatura;
import repository.AssinaturaRepository;

public class AssinaturaValidation implements Validation<Assinatura> {

	@Override
	public void validate(Assinatura entity) throws ValidationException {
		validateNome(entity);
	}
	
	private void validateNome(Assinatura entity) throws ValidationException{
		AssinaturaRepository repo = new AssinaturaRepository();
		if(repo.contains(entity.getId(), entity.getNome())) {
			throw new ValidationException("Este nome já está sendo utilizado em outro plano de assinatura.");
		}
	}

}
