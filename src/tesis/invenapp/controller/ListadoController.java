package tesis.invenapp.controller;

import tesis.invenapp.modelo.Usuario;

public class ListadoController {
  private Usuario almostUser;

  public ListadoController(Usuario almostUser) {
    super();
    this.almostUser = almostUser;
  }

  public Boolean isRegistered() {
    return almostUser.equals(new Usuario("user", "pass"));
  }
}
