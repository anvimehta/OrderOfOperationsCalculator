package edu.purdue.mehta109.trialanderror.Model.Realm;

import java.util.ArrayList;
import java.util.List;

import edu.purdue.mehta109.trialanderror.Model.AbstractEquationModel;
import edu.purdue.mehta109.trialanderror.Model.AbstractEquationRepository;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmEquationRepository implements AbstractEquationRepository
{
    private Realm realm;
    public RealmEquationRepository() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void insert(final String equation, final String answer) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                AbstractEquationModel equationModel = realm.createObject(RealmEquationModel.class);
                equationModel.setEquation(equation);
                equationModel.setAnswer(answer);
                equationModel.setNumberID(getLastId() + 1);
            }
        });
    }

    @Override
    public List<AbstractEquationModel> getAll() {
        RealmResults<RealmEquationModel> historyList = realm.where(RealmEquationModel.class).findAll();
        List<AbstractEquationModel> list = new ArrayList<>();
        list.addAll(historyList);
        return list;
    }

    public int getLastId()
    {
        //If there are no entries in realm return 0
        //else return the id of the last added object
        return 0;
    }
}
