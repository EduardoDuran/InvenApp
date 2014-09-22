package tesis.invenapp.controller;

import tesis.invenapp.db.DbHelper;
import tesis.invenapp.modelo.Usuario;
import android.app.Activity;

public class LoginController {
  DbHelper db;

  public LoginController(Activity login) {
    super();
    db = new DbHelper(login);
  }

  public Boolean isRegistered(Usuario almostUser) {
    if (db.verifyUser(almostUser) == null)
      return false;
    return true;
  }
}
