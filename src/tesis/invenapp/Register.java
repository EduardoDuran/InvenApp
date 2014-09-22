package tesis.invenapp;

import java.util.ArrayList;
import java.util.List;

import tesis.invenapp.controller.LoginController;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends Activity {
	private ViewElements elements;
	private LoginController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrarse);
		elements = new ViewElements();
		addItemsOnSpinner2();
		addListenerOnSpinnerItemSelection();
	}

	public void addItemsOnSpinner2() {
		List<String> list = new ArrayList<String>();
		list.add("Servicios Computacionales");
		list.add("Repuestos");
		list.add("Retail");
		list.add("Ropa");
		list.add("Fabrica");
		list.add("Taller");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		elements.getAct2().setAdapter(dataAdapter);
	}

	public void addListenerOnSpinnerItemSelection() {
		elements.getAct().setOnItemSelectedListener(
				new CustomOnItemSelectedListener());
	}

	private class ViewElements {
		// Vista Elements
		private Spinner act, act2;

		// private TextView register;
		// private Button login;

		public ViewElements() {
			act = (Spinner) findViewById(R.id.actividad1);
	
			// register = (TextView) findViewById(R.id.registrarse);
			// login = (Button) findViewById(R.id.login);
		}

		public Spinner getAct() {
			return act;
		}

		public Spinner getAct2() {
			return act2;
		}

	}

	public class CustomOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			Toast.makeText(
					parent.getContext(),
					"OnItemSelectedListener : "
							+ parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}

	}

}
