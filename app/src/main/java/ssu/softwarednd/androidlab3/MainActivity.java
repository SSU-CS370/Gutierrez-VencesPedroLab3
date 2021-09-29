package ssu.softwarednd.androidlab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ssu.softwarednd.androidlab3.network.RecipeCountAsyncTask;
import ssu.softwarednd.androidlab3.network.RecipeSearchApi;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText searchEditText;
    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
