package edu.purdue.mehta109.trialanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class ViewHistoryActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_history)
    protected RecyclerView mRecyclerViewHistory;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        realm = Realm.getDefaultInstance();
        fetchHistoryFromRealm();
    }

    private void setHistoryListAdapter(List<EquationModel> equationModelList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager
                .VERTICAL, false);
        mRecyclerViewHistory.setLayoutManager(linearLayoutManager);
        mRecyclerViewHistory.setAdapter(new HistoryListAdapter(equationModelList));
    }

    private void fetchHistoryFromRealm() {
        RealmResults<EquationModel> historyList = realm.where(EquationModel.class).findAll();
        if (historyList != null && historyList.size() > 0) {
            setHistoryListAdapter(historyList);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
