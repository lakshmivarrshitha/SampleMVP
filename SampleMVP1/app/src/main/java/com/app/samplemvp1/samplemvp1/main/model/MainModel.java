package com.app.samplemvp1.samplemvp1.main.model;

import com.tinmegali.mvp.mvp.GenericModel;
import com.app.samplemvp1.samplemvp1.main.MVP_MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Venkatesan on 11/6/2016.
 */

public class MainModel extends GenericModel<MVP_MainActivity.RequiredPresenterOps> implements MVP_MainActivity.ProvidedModelOps {

    @Override
    public void onCreate(MVP_MainActivity.RequiredPresenterOps requiredPresenterOps) {
        super.onCreate(requiredPresenterOps);
    }

    @Override
    public ArrayList<HashMap<String,String >> getJsonData() {
        return new HttpHandler().makeServiceCall();
    }

}
