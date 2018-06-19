package edu.purdue.mehta109.trialanderror.Model;

import edu.purdue.mehta109.trialanderror.Model.Realm.RealmEquationRepository;

public class RepositoryManager {
    public static AbstractEquationRepository getEquationRepository()
    {
        return new RealmEquationRepository();
    }
}
