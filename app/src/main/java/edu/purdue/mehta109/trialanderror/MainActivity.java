package edu.purdue.mehta109.trialanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.totalEquation)
    EditText totalEquation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnleftbrace)
    public void leftBraceClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"(");
    }

    @OnClick(R.id.btnrightbrace)
    public void rightBraceClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+")");
    }

    @OnClick(R.id.btndivide)
    public void divideClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"/");
    }

    @OnClick(R.id.btnmultiply)
    public void multiplyClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"*");
    }

    @OnClick(R.id.btnadd)
    public void subtractClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"+");
    }

    @OnClick(R.id.btnsubtract)
    public void addClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"-");
    }

    @OnClick(R.id.btn1)
    public void oneClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"1");
    }

    @OnClick(R.id.btn2)
    public void twoClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"2");
    }

    @OnClick(R.id.btn3)
    public void threeClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"3");
    }

    @OnClick(R.id.btn4)
    public void fourClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"4");
    }

    @OnClick(R.id.btn5)
    public void fiveClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"5");
    }

    @OnClick(R.id.btn6)
    public void sixClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"6");
    }

    @OnClick(R.id.btn7)
    public void sevenClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"7");
    }

    @OnClick(R.id.btn8)
    public void eightClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"8");
    }

    @OnClick(R.id.btn9)
    public void nineClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"9");
    }

    @OnClick(R.id.btn0)
    public void zeroClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        input.setText(equation+"0");
    }

    @OnClick(R.id.backspaceFab)
    public void backspaceFabClick() {
        Toast.makeText(getApplicationContext(), "You have entered: " + input.getText().toString(),
                Toast.LENGTH_SHORT).show();
        String equation=input.getText().toString().trim();
        int equationLength = equation.length();
        String newEquation = equation.substring(0, equationLength-1);
        input.setText(newEquation);
    }

    @OnClick(R.id.equalFab)
    public void equalFabClick() {
        String equation=input.getText().toString().trim();
        String totalEq = equation;
        equation = "";
        input.setText(equation);
        totalEquation.setText(totalEq);
    }

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
