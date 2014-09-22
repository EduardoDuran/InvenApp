package tesis.invenapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Ingreso extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    finish();
    startActivity(new Intent(this, Login.class));
  }
}
