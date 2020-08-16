package model.validation;

import java.time.LocalDate;

import application.ValidationException;
import model.Usuario;
import repository.ClienteRepository;

public class ClienteValidation implements Validation<Usuario> {

	@Override
	public void validate(Usuario entity) throws ValidationException {
		validateCpf(entity);

		validateEmail(entity);
		
		validaDataAniversario(entity);
	}

	private void validateCpf(Usuario entity) throws ValidationException {
		ClienteRepository repo = new ClienteRepository();
		if (repo.containsCpf(entity.getId(), entity.getCpf())) {
			throw new ValidationException("CPF já cadastrado.");
		}
	}

	private void validateEmail(Usuario entity) throws ValidationException {
		ClienteRepository repo = new ClienteRepository();
		if (repo.containsEmail(entity.getId(), entity.getEmail())) {
			throw new ValidationException("Este e-mail já está cadastrado.");
		}
	}

	private void validaDataAniversario(Usuario entity) throws ValidationException {
		LocalDate data = new java.sql.Date(entity.getDataAniversario().getTime()).toLocalDate();
		LocalDate dataLimite = LocalDate.now().minusYears(18);
		// data = 12/05/2020
		// datalimite = 12/05/2002
		if (data.isAfter(dataLimite)) {
			throw new ValidationException("Data Inválida. O usuário não pode ser menor de idade.");
		}
	}

}
