package e.vcu.A4PT2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getInput(String input){
        return input;
    }
    public static String word = "";
    public void findButtonClick(View v) {
        if (v.getId() == R.id.findButton) {
            EditText input = (EditText)findViewById(R.id.word);
            String word = input.getText().toString();
            String result = helper.searchWord(word);
            if(word.equals("")){
                Toast temp2 = Toast.makeText(MainActivity.this, "You didn't enter a word!", Toast.LENGTH_SHORT);
                temp2.show();
            }
            else if(word.equals(result)){
                Intent i = new Intent(MainActivity.this, Results.class);
                Toast temp1 = Toast.makeText(MainActivity.this, helper.outputPair(word), Toast.LENGTH_LONG);
                startActivity(i);
                temp1.show();
            }
            else{
                Intent i = new Intent(MainActivity.this, Results.class);
                Toast temp = Toast.makeText(MainActivity.this, "Word not Found", Toast.LENGTH_SHORT);
                startActivity(i);
                temp.show();
            }
        }
    }
    public static String getInput(){
        return word;
    }
    public void enterValuesClick(View v) {
        if (v.getId() == R.id.enterValues) {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }
    }
}
