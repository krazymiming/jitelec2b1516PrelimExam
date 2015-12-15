package tech.sidespell.prelimexam;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mtvCounter;
    private TextView mtvNumberSb;
    private RadioButton mrbIncrement;
    private RadioButton mrbDecrement;
    private SeekBar msbCounter;
    private ToggleButton mtbCounter;
    private int num;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtvCounter = (TextView) findViewById(R.id.tvCounter);
        mtvNumberSb = (TextView) findViewById(R.id.tvNumberSb);
        mrbIncrement = (RadioButton) findViewById(R.id.rbIncrement);
        mrbDecrement = (RadioButton) findViewById(R.id.rbDecrement);
        msbCounter = (SeekBar) findViewById(R.id.sbCounter);
        mtbCounter = (ToggleButton) findViewById(R.id.tbCounter);

        msbCounter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mtvNumberSb.setText(String.valueOf(progress));
                num = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (mrbIncrement.isChecked()) {
                    int counter = Integer.parseInt(mtbCounter.getText().toString());
                    mtbCounter.setText(counter++ + "");
                    handler.postDelayed(this, num);
             }

                if (mrbIncrement.isChecked()) {
                    int counter = Integer.parseInt(mtbCounter.getText().toString());
                    mtbCounter.setText(counter-- + "");
                    handler.postDelayed(this, num);
                }
            }
        };

        handler.postDelayed(runnable, num);

        mtbCounter.setOnCheckedChangeListener(this);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://tech.sidespell.prelimexam/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://tech.sidespell.prelimexam/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            Log.d(TAG, "onCheckedChanged: START");


        } else {
            Log.d(TAG, "onCheckedChanged: STOP");
        }
    }
}
