package tesis.invenapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class listadoproductos extends Activity {
	ListView listView ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);
        
        listView = (ListView) findViewById(R.id.list);
        // Defined Array values to show in ListView
        String[] values = new String[] { "Aretes", 
                                         "Anillos",
                                         "Alligators",
                                         "Brazaletes", 
                                         "Bolsos", 
                                         "Bañador", 
                                         "Cinturon 102", 
                                         "Cinturon 103",
                                         "Cinturon 104",
                                         "Cinturon 105",
                                         "Correa",
                                         "Dige",
                                         "Estampas",
                                         "Frosting",
                                         "Guantes",
                                         "Hanger",
                                         "Indicadores",
                                         "Cinturon 105"
                                         
                                
                                        };
}
}