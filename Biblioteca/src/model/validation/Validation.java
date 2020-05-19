package model.validation;

import application.ValidationException;

public interface Validation<T> {

	public void validate(T entity) throws ValidationException;

}