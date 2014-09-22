package tesis.invenapp.controller;

import tesis.invenapp.modelo.Usuario;

public class LoginController {
  private Usuario almostUser;

  public LoginController(Usuario almostUser) {
    super();
    this.almostUser = almostUser;
  }

  public Boolean isRegistered() {
    return almostUser.equals(new Usuario("user", "pass"));
  }
}
