package br.com.aiko.converte;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.aiko.modelo.Aluno;

public class AlunoConverte implements Converter {

	private List<Aluno> listaAlunos;

	public AlunoConverte(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty() || !value.matches("\\d+")){
			return null;
		}
		try {
			int id = Integer.valueOf(value);
			for (Aluno aluno: listaAlunos){
				if (id == (aluno.getId())){
					return aluno;
				}
			}
		} catch(Exception e){}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null){
			return null;
		}
		Aluno aluno = (Aluno) value;
		
		return Integer.toString(aluno.getId());
	}

}
