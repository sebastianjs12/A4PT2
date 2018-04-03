package e.vcu.A4PT2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Judah Sebastian on 3/22/2018.
 */

public class Results extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);
    }

    //Back to MainPage
    public void clickTeacherBackToMain(View v) {
        if (v.getId() == R.id.teacherBackButton) {
            Intent i = new Intent(Results.this, MainActivity.class);
            startActivity(i);
        }
    }

}