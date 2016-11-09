package com.app.samplemvp1.samplemvp1.main.presenter;

import com.app.samplemvp1.samplemvp1.main.MVP_MainActivity.ProvidedPresenterOps;
import com.app.samplemvp1.samplemvp1.main.model.MainModel;
import com.tinmegali.mvp.mvp.GenericPresenter;
import com.app.samplemvp1.samplemvp1.main.MVP_MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Venkatesan on 11/6/2016.
 */

public class MainPresenter extends GenericPresenter<MVP_MainActivity.RequiredPresenterOps,
        MVP_MainActivity.ProvidedModelOps, MVP_MainActivity.RequiredViewOps, MainModel>
        implements MVP_MainActivity.RequiredPresenterOps,ProvidedPresenterOps {


    @Override
    public void onCreate(MVP_MainActivity.RequiredViewOps view) {
        super.onCreate(MainModel.class, this);
        // super.onCreate(<Model.class>, <RequiredPresenterOps>);
        setView( view );
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onConfigurationChanged(MVP_MainActivity.RequiredViewOps view) {

    }

    @Override
    public ArrayList<HashMap<String,String >> getJsonListData() {
        return onJsonListDataReceived();
    }

    @Override
    public ArrayList<HashMap<String,String >> onJsonListDataReceived() {
        return getModel().getJsonData();
    }
}

