package com.app.samplemvp1.samplemvp1.main.view;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.app.samplemvp1.samplemvp1.R;
import com.app.samplemvp1.samplemvp1.main.MVP_MainActivity;
import com.app.samplemvp1.samplemvp1.main.presenter.MainPresenter;
import com.tinmegali.mvp.mvp.GenericMVPActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends GenericMVPActivity<MVP_MainActivity.RequiredViewOps,
        MVP_MainActivity.ProvidedPresenterOps, MainPresenter>
        implements MVP_MainActivity.RequiredViewOps {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    ArrayList<HashMap<String, String>> listCol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(MainPresenter.class,this);
        setContentView(R.layout.activity_main);
        listCol = new ArrayList<>();
        lv = (ListView) findViewById(R.id.mobile_list);
        new GetJsonData().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetJsonData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0){
            listCol = getPresenter().getJsonListData();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
           ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, listCol,
                    R.layout.list_item, new String[]{"name", "email",
                    "mobile"}, new int[]{R.id.name,
                    R.id.email, R.id.mobile});

            lv.setAdapter(adapter);
        }

    }
}
