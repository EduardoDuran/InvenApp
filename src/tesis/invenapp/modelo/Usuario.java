package tesis.invenapp.modelo;

public class Usuario {
  String user, pass;

  public Usuario(String user, String pass) {
    super();
    this.user = user;
    this.pass = pass;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  @Override
  public boolean equals(Object o) {
    return ((Usuario) o).getPass().equals(getPass())
        && ((Usuario) o).getUser().equals(getUser());
  }
}