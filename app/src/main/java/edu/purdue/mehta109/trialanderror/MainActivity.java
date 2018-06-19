package edu.purdue.mehta109.trialanderror;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import edu.purdue.mehta109.trialanderror.Model.AbstractEquationRepository;
import edu.purdue.mehta109.trialanderror.Model.Calculator;
import edu.purdue.mehta109.trialanderror.Model.Realm.RealmEquationModel;
import edu.purdue.mehta109.trialanderror.Model.RepositoryManager;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input)
    protected EditText input;

    @BindView(R.id.totalEquation)
    protected EditText totalEquation;

    private String equation;

    private int flagVariable = 0;

    private Realm realm;

    private AbstractEquationRepository repository;
    List<RealmEquationModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        equation = input.getText().toString().trim();
        realm = Realm.getDefaultInstance();
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        repository = RepositoryManager.getEquationRepository();
    }

    @OnClick(R.id.btnleftbrace)
    public void leftBraceClick() {
        if (flagVariable == 1) {
            flagVariable = 0;
        }
        if (input.getText().toString().trim().equals("0")) {
            input.setText("");
            equation = input.getText().toString().trim();
        }
        input.append("(");
    }

    @OnClick(R.id.btnrightbrace)
    public void rightBraceClick() {
        if (flagVariable == 1) {
            flagVariable = 0;
        }
        if (input.getText().toString().trim().equals("0")) {
            input.setText("");
            equation = input.getText().toString().trim();
        }
        input.append(")");
    }

    @OnClick(R.id.btndivide)
    public void divideClick() {
        if (flagVariable == 1) {
            flagVariable = 0;
        }
        input.append("/");
    }

    @OnClick(R.id.btnmultiply)
    public void multiplyClick() {
        if (flagVariable == 1) {
            flagVariable = 0;
        }
        if (input.getText().toString().trim().equals("0")) {
            input.setText("");
            equation = input.getText().toString().trim();
        }
        input.append("*");
    }

    @OnClick(R.id.btnadd)
    public void subtractClick() {
        if (flagVariable == 1) {
            flagVariable = 0;
        }
        if (input.getText().toString().trim().equals("0")) {
            input.setText("");
            equation = input.getText().toString().trim();
        }
        input.append("+");
    }

    @OnClick(R.id.btnsubtract)
    public void addClick() {
        if (flagVariable == 1) {
            flagVariable = 0;
        }
        if (input.getText().toString().trim().equals("0")) {
            input.setText("");
            equation = input.getText().toString().trim();
        }
        input.append("-");
    }

    @OnClick({R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9})
    public void oneClick(View view) {
        int number = -1;
        int[] numberIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        for (int i = 0; i < numberIds.length; i++) {
            if (view.getId() == numberIds[i]) {
                number = i;
            }
        }
        if (number == -1) {
            throw new RuntimeException("Something went horribly wrong!");
        }
        if (flagVariable == 1) {
            equation = input.getText().toString().trim();
            equation = "";
            input.setText(equation);
            flagVariable = 0;
        }
        if (input.getText().toString().trim().equals("0")) {
            input.setText("");
            equation = input.getText().toString().trim();
        }
        input.append(String.valueOf(number));
    }

    @OnClick(R.id.btnbackspace)
    public void backspaceClick() {
        equation = input.getText().toString().trim();
        int equationLength = equation.length();
        if (equationLength <= 1 || equation.equals("0")) {
            input.setText("");
            input.append("0");
        } else {
            if (flagVariable == 1) {
                equation = input.getText().toString().trim();
                equation = "";
                input.setText(equation);
            } else {
                String newEquation = equation.substring(0, equationLength - 1);
                equation = newEquation;
                input.setText("");
                input.append(equation);
            }

        }
    }

    @OnLongClick(R.id.btnbackspace)
    public boolean longBackspaceClick() {
        equation = input.getText().toString().trim();
        equation = "";
        input.setText(equation);
        input.append("0");
        return true;
    }

    public boolean closeBraces() {
        equation = input.getText().toString().trim();
        int counterLeftBrace = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                counterLeftBrace++;
            }
        }
        int counterRightBrace = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == ')') {
                counterRightBrace++;
            }
        }
        if (counterRightBrace != counterLeftBrace) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter correct brace formatting.", Toast.LENGTH_LONG);
            toast.show();
            return true;
        } else {
            return false;
        }
    }

    public void noEquation() {
        if (equation.equals("")) {
            input.append("0");
        }
    }

    public boolean endWithSymbol() {
        if (equation.endsWith("+") || equation.endsWith("-") || equation.endsWith("*") || equation.endsWith("/")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please add a value after the symbol.", Toast.LENGTH_LONG);
            toast.show();
            return true;
        } else {
            return false;
        }
    }

    @OnClick(R.id.equalFab)
    public void equalFabClick() {
        noEquation();
        if (closeBraces() == false && endWithSymbol() == false) {
            final String totalEq = equation;
            equation = Calculator.total(equation);
            repository.insert(totalEq, equation);
            RealmEquationModel equationModel = new RealmEquationModel();
            flagVariable = 1;
            input.setText("");
            input.append(equation);
            totalEquation.setText(totalEq);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_view_history) {
            startActivity(new Intent(MainActivity.this, ViewHistoryActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
