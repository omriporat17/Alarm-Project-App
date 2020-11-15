package mazpen.rockettar.alarmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button etLogin;
    private String Username="Admin";
    private String Password="12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.username_button);
        etPassword = findViewById(R.id.password_button);
        etLogin = findViewById(R.id.login_button);

        etLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = etUsername.getText().toString();
                String inputPassword = etPassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "please enter all the details correctly", LENGTH_SHORT).show();
                }
                else
                {
                    boolean is_valid;
                    is_valid = validate(inputName,inputPassword);
                    if (!is_valid){

                        Toast.makeText(MainActivity.this, "Incorrect password!", LENGTH_SHORT).show(); //goren
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login successful!", LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String name, String password)
    {
        if(name.equals(Username) && password.equals(Password))
        {
            return true;
        }
        return false;
    }
}
