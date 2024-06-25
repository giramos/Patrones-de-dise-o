package Estrategia.Composite;

import java.util.Arrays;
import java.util.List;

import Estrategia.Validacion;

public class ValidacionAll implements Validacion {

	private List<Validacion> validadores;
	
	public ValidacionAll(Validacion...validacions) {
		this.validadores = Arrays.asList(validacions);
	}
	@Override
	public boolean isValid(String texto) {
		for(Validacion v: validadores)	{
			if(!v.isValid(texto)) {
				return false;
			}
		}
		return true;
	}

}
