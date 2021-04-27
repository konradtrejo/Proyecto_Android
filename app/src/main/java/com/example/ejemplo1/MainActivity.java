package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextFuncion, editTextResult, editTextValA, editTextValB;
    DecimalFormat decimalFormat = new DecimalFormat("0.000");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFuncion = (EditText) findViewById(R.id.edit_text_func);
        editTextResult = (EditText) findViewById(R.id.edit_text_result);
        editTextValA = (EditText) findViewById(R.id.val_a);
        editTextValB= (EditText) findViewById(R.id.val_b);

        editTextFuncion.setInputType(InputType.TYPE_NULL);
        editTextResult.setInputType(InputType.TYPE_NULL);
        editTextValB.setInputType(InputType.TYPE_NULL);
        editTextValA.setInputType(InputType.TYPE_NULL);


    }
    public void  one(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "1");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "1");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"1");
        }
    }
    public void  two(View view){

        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "2");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "2");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"2");
        }
    }
    public void  three(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "3");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "3");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"3");
        }
    }
    public void  four(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "4");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "4");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"4");
        }
    }
    public void  five(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "5");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "5");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"5");
        }
    }
    public void  six(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "6");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "6");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"6");
        }
    }
    public void  seven(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "7");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "7");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"7");
        }
    }public void  eight(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "8");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "8");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"8");
        }
    }
    public void  nine(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "9");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "9");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"9");
        }
    }
    public void  zero(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "0");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "0");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"0");
        }
    }
    public void punto(View view) {

        if(editTextFuncion.hasFocus()) {
            if (editTextFuncion.getText().toString().contains(".")) {

            } else {
                editTextFuncion.setText(editTextFuncion.getText() + ".");


            }
        }
        if(editTextValB.hasFocus()) {
            if (editTextValB.getText().toString().contains(".")) {

            } else {
                editTextValB.setText(editTextValB.getText() + ".");
                 }
             }
            if(editTextValA.hasFocus()) {

                if (editTextValA.getText().toString().contains(".")) {

                } else {
                    editTextValA.setText(editTextValA.getText() + ".");
                }
            }
        }
    public void suma(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "+");
        }

    }

    public void resta(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "- ");
        }

    }
    public void multiplicacion(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "*");
        }

    }
    public void division(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "/");
        }
    }
    public void funcion_sin(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "sin(x)");
        }
    }
    public void funcion_cos(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "cos(x)");
        }
    }
    public void funcion_exp(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "^(x)");
        }
    }
    public void function_e(View view){
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"e");
        }

    }
    public void funcion_raiz_cuadrada(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "√");
        }
    }
    public void  val_x(View view){
        if(editTextFuncion.hasFocus()) {
            editTextFuncion.setText(editTextFuncion.getText() + "X");
        }
    }
    public void delete(View view){

        if(editTextFuncion.hasFocus()){
            Editable cap =  editTextFuncion.getText();
            editTextFuncion.setText("");
            editTextFuncion.setText(cap.toString().replaceFirst(".$",""));
        }
        if(editTextValA.hasFocus()){
            Editable cap =  editTextValA.getText();
            editTextValA.setText("");
            editTextValA.setText(cap.toString().replaceFirst(".$",""));
        }
        if(editTextValB.hasFocus()){
            Editable cap =  editTextValB.getText();
            editTextValB.setText("");
            editTextValB.setText(cap.toString().replaceFirst(".$",""));
        }

    }
    public void cerrar(View view){
        finish();
    }

    public void btnC(View view){
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText("");
        }
        if(editTextValA.hasFocus()){
            editTextValA.setText("");
        }
        if(editTextValB.hasFocus()){
            editTextValB.setText("");
        }
    }

}