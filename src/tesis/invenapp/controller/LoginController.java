package tesis.invenapp.controller;

import tesis.invenapp.db.DbHelper;
import tesis.invenapp.modelo.Usuario;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginController {
  DbHelper db;
  Usuario  user;
  Context  contexto;

  public LoginController(Activity login) {
    super();
    contexto = login;
    db = new DbHelper(login);
  }

  public Boolean isRegistered(Usuario almostUser) {
    user = db.verifyUser(almostUser);
    if (user == null)
      return false;
    return true;
  }

  public void Login() {
    SharedPreferences pref = contexto.getApplicationContext()
        .getSharedPreferences("InvenApp", 0);
    Editor editor = pref.edit();
    editor.putInt("userId", user.getId());
    editor.commit();
  }
}
