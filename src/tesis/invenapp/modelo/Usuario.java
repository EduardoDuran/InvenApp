package tesis.invenapp.modelo;

import tesis.invenapp.Register.ViewElements;

public class Usuario {
  private int id;
  private String username, password, company, email, activity, ruc;

  public Usuario(String user, String pass) {
    super();
    setUsername(user);
    setPassword(pass);
  }

  public Usuario(String username, String password, String company,
      String email, String activity, String ruc) {
    super();
    this.username = username;
    this.password = password;
    this.company = company;
    this.email = email;
    this.activity = activity;
    this.ruc = ruc;
  }

  public Usuario(int id, String username) {
    super();
    this.id = id;
    this.username = username;
  }

  public Usuario(ViewElements elements) {
    this(elements.getUsername(), elements.getPassword(), elements.getCompany(),
        elements.getEmail(), elements.getActivity(), elements.getRuc());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  @Override
  public boolean equals(Object o) {
    return ((Usuario) o).getPassword().equals(getPassword())
        && ((Usuario) o).getUsername().equals(getUsername());
  }
}
