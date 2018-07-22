package apps4Society.model;

public class User {
	
	
	private long id;
	private String nome;
	private String email;
	private String codigo;
	private String login;
	private String pass;
	private String data_cadastro;
	
	public void setData_acesso(String data) {
		this.data_cadastro=data;
	}
	public String getData_acesso() {
		return data_cadastro;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public User(String nome , String login , String email , String senha ,String codigo, String datacad) {
		setNome(nome);
		setLogin(login);
		setEmail(email);
		setPass(senha);
		setCodigo(codigo);
		setData_acesso(datacad);

	}
	

}
