package br.com.aiko.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.Converter;

import br.com.aiko.converte.CursoConverte;
import br.com.aiko.converte.ProfessorConverte;
import br.com.aiko.dao.DAO;
import br.com.aiko.dao.ProfessorDAO;
import br.com.aiko.modelo.Curso;
import br.com.aiko.modelo.Professor;

@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Professor professor = new Professor();
	
	public void instanceNovoProfessor(){
		professor = new Professor();
	}

	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor){
		this.professor = professor;
	}
	
	public List<Professor> getProfessores(){
		return new DAO<Professor>(Professor.class).listaTodos();
	}
	
	public List<Curso> getCursos() {
		return new DAO<Curso>(Curso.class).listaTodos();

	}
	
	public void gravar() {
		this.professor.getNome();
		this.professor.getEmail();
		this.professor.getCpf();

		new DAO<Professor>(Professor.class).atualiza(professor);

		this.professor = new Professor();
	}
	
	public void carregar(Professor professor){
		System.out.println("Carregando professor: ");
		this.professor = professor;
	}
	
	public void remover(Professor professor){
		
		this.professor = professor;
		ProfessorDAO.remove(professor);
	}
	
	public void atualizar(){
		
		new DAO<Professor>(Professor.class).atualiza(professor);
		
	}
	
	public void iniciarEdicao(Professor professor){
		setProfessor(professor);
	}
	
	public Converter getProfessorConverte(){
		return new ProfessorConverte(getProfessores());
	}
	
	public Converter getCursoConverte() {
		return new CursoConverte(getCursos());
	}

}
