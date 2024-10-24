package br.com.aiko.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.Converter;

import br.com.aiko.converte.AlunoConverte;
import br.com.aiko.converte.CursoConverte;
import br.com.aiko.dao.AlunoDAO;
import br.com.aiko.dao.DAO;
import br.com.aiko.modelo.Aluno;
import br.com.aiko.modelo.Curso;
import br.com.aiko.modelo.CursoAluno;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private CursoAluno cursoAluno;
	private List<Curso> cursos;
	private String termoPesquisa;

	public void instanceNovoAluno() {
		aluno = new Aluno();
		cursos = new ArrayList<Curso>();
	}

	@PostConstruct
	private void init() {
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return new DAO<Aluno>(Aluno.class).listaTodos();
	}

	public List<Curso> getCursos() {
		return new DAO<Curso>(Curso.class).listaTodos();

	}

	public void gravar() {
		this.aluno.getNome();
		this.aluno.getEmail();
		this.aluno.getCpf();
		this.aluno.setCursos(cursos);

		new DAO<Aluno>(Aluno.class).atualiza(aluno);

		this.aluno = new Aluno();
	}

	public void carregar(Aluno aluno) {
		System.out.println("Carregando aluno");
		this.aluno = aluno;
	}

	public void remover(Aluno aluno) {

		this.aluno = aluno;

		AlunoDAO.remove(aluno);
	}

	public void atualizar() {

		this.aluno.getNome();
		this.aluno.getEmail();
		this.aluno.getCpf();

		new DAO<Aluno>(Aluno.class).atualiza(aluno);

	}

	public Converter getAlunoConverte() {
		return new AlunoConverte(getAlunos());
	}

	public Converter getCursoConverte() {
		return new CursoConverte(getCursos());
	}

	public String redirecionaAluno() {
		return "usuarioaluno/aluno?faces-redirect=true";
	}

	public String redirecionaHome() {
		return "usuarioaluno/home?faces-redirect=true";
	}

	public String redirecionaProfessor() {
		return "usuarioaluno/professor?faces-redirect=true";
	}

	public String redirecionaCurso() {
		return "usuarioaluno/curso?faces-redirect=true";
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public void pesquisar(){
		
		AlunoDAO.pesquisa(termoPesquisa);
	}

	public CursoAluno getCursoAluno() {
		return cursoAluno;
	}

	public void setCursoAluno(CursoAluno cursoAluno) {
		this.cursoAluno = cursoAluno;
	}
	

}
