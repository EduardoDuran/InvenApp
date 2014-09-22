package tesis.invenapp.controller;

import tesis.invenapp.modelo.Usuario;

public class IngresoController {
  private Usuario almostUser;

  public IngresoController(Usuario almostUser) {
    super();
    this.almostUser = almostUser;
  }

  public Boolean isRegistered() {
    return almostUser.equals(new Usuario("user", "pass"));
  }
}
