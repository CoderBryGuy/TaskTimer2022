package com.example.tasktimer2022;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.tasktimer2022.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class
MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

//        AppDatabase appDatabase = AppDatabase.getInstance(this);
//        final SQLiteDatabase db = appDatabase.getReadableDatabase();

        String[] projection = {
                TasksContract.Columns._ID,
                TasksContract.Columns.TASKS_NAME,
                TasksContract.Columns.TASKS_DESCRIPTION,
                TasksContract.Columns.TASKS_SORT_ORDER};

        ContentResolver contentResolver = getContentResolver();

        ContentValues values = new ContentValues();
//        values.put(TasksContract.Columns.TASKS_SORT_ORDER, "99");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "Completed");
//        String selection = TasksContract.Columns.TASKS_SORT_ORDER + " = " + 2;
//        int count = contentResolver.update(TasksContract.CONTENT_URI, values, selection, null);
//        Log.d(TAG, "onCreate: " + count + " record(s) updated");


//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "for deletion");
//        String selection = TasksContract.Columns.TASKS_SORT_ORDER + " = ?";
//        String[] args = {"99"};
//        int count = contentResolver.update(TasksContract.CONTENT_URI, values, selection, args);
//        Log.d(TAG, "onCreate: " + count + " record(s) updated");

//        int count = contentResolver.delete(TasksContract.buildTaskUri(3), null, null);
//        Log.d(TAG, "onCreate: " + count + " record(s) deleted");

//        String selection = TasksContract.Columns.TASKS_DESCRIPTION + " = ?";
//        String[] args = {"for deletion"};
//        int count = contentResolver.delete(TasksContract.CONTENT_URI, selection, args);

//        values.put(TasksContract.Columns.TASKS_NAME, "Content Provider");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "record content provider video");
//        int count = contentResolver.update(TasksContract.buildTaskUri(4), values, null, null);
//        Log.d(TAG, "onCreate: " + count + "record(s) updated");


//        values.put(TasksContract.Columns.TASKS_NAME, "new tasks 2");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "description 2");
//        values.put(TasksContract.Columns.TASKS_SORT_ORDER, 2);
//        Uri uri = contentResolver.insert(TasksContract.CONTENT_URI, values);
//
//        values.put(TasksContract.Columns.TASKS_NAME, "new tasks 3");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "description 3");
//        values.put(TasksContract.Columns.TASKS_SORT_ORDER, 3);
//        uri = contentResolver.insert(TasksContract.CONTENT_URI, values);
//
//        values.put(TasksContract.Columns.TASKS_NAME, "new tasks 4");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "description 4");
//        values.put(TasksContract.Columns.TASKS_SORT_ORDER, 3);
//        uri = contentResolver.insert(TasksContract.CONTENT_URI, values);
//
//        values.put(TasksContract.Columns.TASKS_NAME, "new tasks 5");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "description 5");
//        values.put(TasksContract.Columns.TASKS_SORT_ORDER, 2);
//        uri = contentResolver.insert(TasksContract.CONTENT_URI, values);
//
//        values.put(TasksContract.Columns.TASKS_NAME, "new tasks 6");
//        values.put(TasksContract.Columns.TASKS_DESCRIPTION, "description 6");
//        values.put(TasksContract.Columns.TASKS_SORT_ORDER, 5);
//        uri = contentResolver.insert(TasksContract.CONTENT_URI, values);

        Cursor cursor = contentResolver.query(TasksContract.CONTENT_URI,
                projection,
                null,
                null,
                TasksContract.Columns.TASKS_SORT_ORDER);

        if(cursor != null){
            Log.d(TAG, "onCreate: number of rows: " + cursor.getCount());
            while(cursor.moveToNext()){
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    Log.d(TAG, "onCreate: " + cursor.getColumnName(i) + ": " + cursor.getString(i));
                }
                Log.d(TAG, "onCreate: ========================");
            }
            cursor.close();
        }

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}