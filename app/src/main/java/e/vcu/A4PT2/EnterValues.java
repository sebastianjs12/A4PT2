package e.vcu.A4PT2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Judah Sebastian on 3/22/2018.
 */

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);
    }


    //Back To Main
    public void clickSubmit(View v) {
        if (v.getId() == R.id.submit) {
            EditText synonym = (EditText)findViewById(R.id.synonym);
            String synonymStr = synonym.getText().toString();
            EditText antonym = (EditText)findViewById(R.id.antonym);
            String antonymStr = antonym.getText().toString();
            String userinput = MainActivity.getInput();
            if(synonymStr.equals("") || antonymStr.equals("")){
                Toast temp3 = Toast.makeText(EnterValues.this, "One or more fields is blank", Toast.LENGTH_SHORT);
                temp3.show();
            }
            else {
                Contact c = new Contact();
                c.setWord(userinput);
                c.setSynonym(synonymStr);
                c.setAntonym(antonymStr);
                helper.insertContact(c);

                Intent i = new Intent(EnterValues.this, MainActivity.class);
                startActivity(i);
            }
        }
    }
}
