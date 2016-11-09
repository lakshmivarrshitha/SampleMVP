package com.app.samplemvp1.samplemvp1.main;

import com.tinmegali.mvp.mvp.ActivityView;
import com.tinmegali.mvp.mvp.ModelOps;
import com.tinmegali.mvp.mvp.PresenterOps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Venkatesan on 11/6/2016.
 */

public interface MVP_MainActivity {

    /**
     * Required VIEW methods available to PRESENTER
     *      PRESENTER to VIEW
     */
    interface RequiredViewOps extends ActivityView{

    }

    /**
     * Operations offered to VIEW to communicate with PRESENTER
     *      VIEW to PRESENTER
     */
    interface ProvidedPresenterOps extends PresenterOps<RequiredViewOps> {
        ArrayList<HashMap<String,String >> getJsonListData();
    }

    /**
     * Required PRESENTER methods available to MODEL
     *      MODEL to PRESENTER
     */
    interface RequiredPresenterOps {
        ArrayList<HashMap<String,String >> onJsonListDataReceived();
    }

    /**
     * Operations offered to MODEL to communicate with PRESENTER
     *      PRESENTER to MODEL
     */
    interface ProvidedModelOps extends ModelOps<RequiredPresenterOps> {
        ArrayList<HashMap<String,String >> getJsonData();
    }
}
