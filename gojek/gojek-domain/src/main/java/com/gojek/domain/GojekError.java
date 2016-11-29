/**
 * 
 */
package com.gojek.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abhineetkumar
 *
 */
public final class GojekError {

	private List<String> errors = new ArrayList<>();

	public GojekError(List<String> errors) {
		super();
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
