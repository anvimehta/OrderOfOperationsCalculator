package edu.purdue.mehta109.trialanderror.Model;

import java.util.List;

public interface AbstractEquationRepository {
    public void insert(String equation, String answer);
    public List<AbstractEquationModel> getAll();
}
