package cat.udl.urbandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cat.udl.urbandapp.preferences.PreferencesProvider;

public class ChooserActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private SharedPreferences mPreferences;
    private String TAG = this.getClass().getSimpleName();

    //TODO: Hi ha un error que fa que l'applicació no acabi de funcionar bé, arreglar-lo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        this.mPreferences = PreferencesProvider.providePreferences();
        comprovarToken();
        loginButton = findViewById(R.id.butotnLogin);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(ChooserActivity.this,MainActivity.class);
                startActivity(register);

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(ChooserActivity.this,LoginActivity.class);
                startActivity(login);

            }
        });
    }
    protected void comprovarToken(){
        //TODO: Has d'assegurar que quan tornem a arrancar l'app es carregui el token correctament
        // entrant en aquesta funció, utilitzar el Log per fer-ho.

        String token = this.mPreferences.getString("token","");
        if(token != null && !token.equals("")){
            Intent da = new Intent(ChooserActivity.this,DefaultActivity.class);
            startActivity(da);
        }
    }
}
