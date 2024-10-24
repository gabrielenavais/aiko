package br.com.aiko.converte;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.aiko.modelo.Curso;

public class CursoConverte implements Converter{
	
	private List<Curso> listaCurso;
	
	public CursoConverte(List<Curso> listaCurso){
		this.listaCurso = listaCurso;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty() || !value.matches("\\d+")){
			return null;
		}
		try {
			int id = Integer.valueOf(value);
			for (Curso curso: listaCurso){
				if (id == curso.getId()){
					return curso;
				}
			}
		}catch(Exception e){}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null){
		return null;
		}
		Curso curso = (Curso) value;
		
		return Integer.toString(curso.getId());
	}

}
