package br.com.aiko.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.Converter;

import br.com.aiko.converte.CursoConverte;
import br.com.aiko.converte.ProfessorConverte;
import br.com.aiko.dao.CursoDAO;
import br.com.aiko.dao.DAO;
import br.com.aiko.modelo.Aluno;
import br.com.aiko.modelo.Curso;
import br.com.aiko.modelo.CursoAluno;
import br.com.aiko.modelo.Professor;

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Curso curso;
	private CursoAluno cursoAluno;
	private List<Aluno> alunos;


	private Professor professorSelecionado;

	public void instanceNovoCurso() {
		curso = new Curso();

	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return new DAO<Curso>(Curso.class).listaTodos();

	}

	public List<Professor> getProfessores() {

		return new DAO<Professor>(Professor.class).listaTodos();
	}

	public Converter getProfessorConverte() {
		return new ProfessorConverte(getProfessores());
	}

	public Converter getCursoConverte() {
		return new CursoConverte(getCursos());
	}

	public void removerAlunos(Curso curso) {
		this.curso = curso;

		CursoDAO.remove(curso);
	}

	public void gravar() {

		new DAO<Curso>(Curso.class).adiciona(curso);

		this.curso = new Curso();
	}

	public void atualizar(Curso curso) {

		new DAO<Curso>(Curso.class).atualiza(curso);

	}

	public void iniciarEdicao(Curso curso) {
		setCurso(curso);

	}

	public void remover(Curso curso) {
		this.curso = curso;

		new DAO<Curso>(Curso.class).remove(curso);
	}

	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public CursoAluno getCursoAluno() {
		return cursoAluno;
	}

	public void setCursoAluno(CursoAluno cursoAluno) {
		this.cursoAluno = cursoAluno;
	}

}
