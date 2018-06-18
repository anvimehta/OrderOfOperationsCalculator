package edu.purdue.mehta109.trialanderror;

import edu.purdue.mehta109.trialanderror.Model.AbstractEquationRepository;
import edu.purdue.mehta109.trialanderror.Model.Realm.RealmEquationRepository;

public class RepositoryManager {
    public static AbstractEquationRepository getEquationRepository()
    {
        return new RealmEquationRepository();
    }
}
