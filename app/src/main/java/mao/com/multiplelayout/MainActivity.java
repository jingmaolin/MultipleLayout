package mao.com.multiplelayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listViewTypes(View v) {
        startActivity(new Intent(this, ListViewTypesActivity.class));
    }

    public void recyclerViewTypes(View v) {
        startActivity(new Intent(this, RecyclerViewTypesActivity.class));
    }
}
