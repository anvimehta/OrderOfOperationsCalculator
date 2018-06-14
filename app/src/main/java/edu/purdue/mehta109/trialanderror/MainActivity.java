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

    public static String equation;

    public static int flagVariable=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        equation = input.getText().toString().trim();
    }

    @OnClick(R.id.btnleftbrace)
    public void leftBraceClick() {
        if(flagVariable==1){
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("(");
    }

    @OnClick(R.id.btnrightbrace)
    public void rightBraceClick() {
        if(flagVariable==1){
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append(")");
    }

    @OnClick(R.id.btndivide)
    public void divideClick() {
        if(flagVariable==1){
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("/");
    }

    @OnClick(R.id.btnmultiply)
    public void multiplyClick() {
        if(flagVariable==1){
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("*");
    }

    @OnClick(R.id.btnadd)
    public void subtractClick() {
        if(flagVariable==1){
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("+");
    }

    @OnClick(R.id.btnsubtract)
    public void addClick() {
        if(flagVariable==1){
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("-");
    }

    @OnClick(R.id.btn1)
    public void oneClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("1");
    }

    @OnClick(R.id.btn2)
    public void twoClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("2");
    }

    @OnClick(R.id.btn3)
    public void threeClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("3");
    }

    @OnClick(R.id.btn4)
    public void fourClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("4");
    }

    @OnClick(R.id.btn5)
    public void fiveClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("5");
    }

    @OnClick(R.id.btn6)
    public void sixClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("6");
    }

    @OnClick(R.id.btn7)
    public void sevenClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("7");
    }

    @OnClick(R.id.btn8)
    public void eightClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("8");
    }

    @OnClick(R.id.btn9)
    public void nineClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
        input.append("9");
    }

    @OnClick(R.id.btn0)
    public void zeroClick() {
        if(flagVariable==1){
            equation=input.getText().toString().trim();
            equation="";
            input.setText(equation);
            flagVariable=0;
        }
        if(input.getText().toString().trim().equals("0")){
            input.setText("");
            equation=input.getText().toString().trim();
        }
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
        equation = Calculator.total();
        flagVariable=1;
        input.setText("");
        input.append(equation);
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
