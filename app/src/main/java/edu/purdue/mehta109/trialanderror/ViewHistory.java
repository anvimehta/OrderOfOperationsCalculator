package edu.purdue.mehta109.trialanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class ViewHistory extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RealmResults<EquationID> eqAndAns = realm.where(EquationID.class).findAll();
        for(int i=0; i<eqAndAns.size(); i++){
            Log.v("output", ":"+eqAndAns.get(i).getEquation());
            Log.v("answer", ":"+eqAndAns.get(i).getAnswer());
        }
    }

}
