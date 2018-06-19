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
import edu.purdue.mehta109.trialanderror.Model.AbstractEquationModel;
import edu.purdue.mehta109.trialanderror.Model.AbstractEquationRepository;
import edu.purdue.mehta109.trialanderror.Model.HistoryListAdapter;
import edu.purdue.mehta109.trialanderror.Model.RepositoryManager;

public class ViewHistoryActivity extends AppCompatActivity {

    private AbstractEquationRepository repository;

    @BindView(R.id.recycler_view_history)
    protected RecyclerView mRecyclerViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        repository = RepositoryManager.getEquationRepository();
        fetchHistoryFromRealm();
    }

    private void setHistoryListAdapter(List<AbstractEquationModel> equationModelList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager
                .VERTICAL, false);
        mRecyclerViewHistory.setLayoutManager(linearLayoutManager);
        mRecyclerViewHistory.setAdapter(new HistoryListAdapter(equationModelList));
    }

    private void fetchHistoryFromRealm() {
        List<AbstractEquationModel> historyList = repository.getAll();
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
