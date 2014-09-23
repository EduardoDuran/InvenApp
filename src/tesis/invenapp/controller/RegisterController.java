package tesis.invenapp.controller;

import tesis.invenapp.Register.ViewElements;
import tesis.invenapp.db.DbHelper;
import tesis.invenapp.modelo.Usuario;
import android.app.Activity;

public class RegisterController {
  DbHelper db;

  public RegisterController(Activity register) {
    super();
    db = new DbHelper(register);
  }

  public void saveUser(Usuario almostUser) {
    db.registerUser(almostUser);
  }

  public boolean isValidForm(ViewElements elements) {
    if (elements.getPassword().equals(elements.getConfirmPassword()))
      return true;
    return false;
  }
}
