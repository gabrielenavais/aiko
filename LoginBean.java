package br.com.aiko.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static String usuario;
	private String login;
	private String senha;


	public static String getUsuario() {
		return usuario;
	}

	public String setUsuario(String usuario) {
		return LoginBean.usuario = usuario;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String logar() {

		
		if(login.equals("aluno") && senha.equals("aluno")){

			usuario = setUsuario("aluno");
			return "/usuarioaluno/homealuno?faces-redirect=true";
			
		}else if(login.equals("professor") && senha.equals("professor")){

			usuario = setUsuario("professor");
			return "/usuarioprofessor/homeprofessor?faces-redirect=true";
			
		}else if(login.equals("adm") && senha.equals("adm")){

			usuario = setUsuario("adm");
			return "/usuarioadm/aluno?faces-redirect=true";
			
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e/ou senha inválidos", ""));
		
		return null;
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		setUsuario(null);
		return "/home.xhtml?faces-redirect=true";
	}
	
	public int inicializar(int usuario){
		return usuario;

		  
		}


}
