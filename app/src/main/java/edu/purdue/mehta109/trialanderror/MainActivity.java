package edu.purdue.mehta109.trialanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.totalEquation)
    EditText totalEquation;

    String equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        equation=input.getText().toString().trim();

    }

    @OnClick(R.id.btnleftbrace)
    public void leftBraceClick() {
        input.append("(");
    }

    @OnClick(R.id.btnrightbrace)
    public void rightBraceClick() {
        input.append(")");
    }

    @OnClick(R.id.btndivide)
    public void divideClick() {
        input.append("/");
    }

    @OnClick(R.id.btnmultiply)
    public void multiplyClick() {
        input.append("*");
    }

    @OnClick(R.id.btnadd)
    public void subtractClick() {
        input.append("+");
    }

    @OnClick(R.id.btnsubtract)
    public void addClick() {
        input.append("-");
    }

    @OnClick(R.id.btn1)
    public void oneClick() {
        input.append("1");
    }

    @OnClick(R.id.btn2)
    public void twoClick() {
        input.append("2");
    }

    @OnClick(R.id.btn3)
    public void threeClick() {
        input.append("3");
    }

    @OnClick(R.id.btn4)
    public void fourClick() {
        input.append("4");
    }

    @OnClick(R.id.btn5)
    public void fiveClick() {
        input.append("5");
    }

    @OnClick(R.id.btn6)
    public void sixClick() {
        input.append("6");
    }

    @OnClick(R.id.btn7)
    public void sevenClick() {
        input.append("7");
    }

    @OnClick(R.id.btn8)
    public void eightClick() {
        input.append("8");
    }

    @OnClick(R.id.btn9)
    public void nineClick() {
        input.append("9");
    }

    @OnClick(R.id.btn0)
    public void zeroClick() {
        input.append("0");
    }

    @OnClick(R.id.backspaceFab)
    public void backspaceFabClick() {
        equation=input.getText().toString().trim();
        int equationLength=equation.length();
        if(equationLength<=1){
            input.setText("");
            input.append("0");
        }else {
            if(equation.equals("0")){
                input.setText("");
                input.append("0");
            }else {
                String newEquation = equation.substring(0, equationLength - 1);
                equation = newEquation;
                input.setText("");
                input.append(equation);
            }
        }
    }

    @OnLongClick(R.id.backspaceFab)
    public boolean longBackspaceFabClick(){
        equation=input.getText().toString().trim();
        equation="";
        input.setText(equation);
        return true;
    }

    @OnClick(R.id.equalFab)
    public void equalFabClick() {
        equation=input.getText().toString().trim();
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
