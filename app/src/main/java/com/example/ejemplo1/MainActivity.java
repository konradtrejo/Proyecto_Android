package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.logging.Logger;

import metodos.Metodos;

public class MainActivity extends AppCompatActivity {

    EditText editTextFuncion, editTextResult, editTextValA, editTextValB, editTextValN;
    DecimalFormat decimalFormat = new DecimalFormat("0.000");
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFuncion = (EditText) findViewById(R.id.edit_text_func);
        editTextResult = (EditText) findViewById(R.id.edit_text_result);
        editTextValA = (EditText) findViewById(R.id.val_a);
        editTextValB= (EditText) findViewById(R.id.val_b);
        editTextValN = (EditText) findViewById(R.id.val_n);
        calcular = (Button) findViewById(R.id.calcular);

        editTextFuncion.setInputType(InputType.TYPE_NULL);
        editTextResult.setInputType(InputType.TYPE_NULL);
        editTextValB.setInputType(InputType.TYPE_NULL);
        editTextValA.setInputType(InputType.TYPE_NULL);
        editTextValN.setInputType(InputType.TYPE_NULL);

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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"1");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"2");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"3");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"4");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"5");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"6");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"7");
        }
    }
    public void  eight(View view){
        if(editTextValA.hasFocus()){

            editTextValA.setText(editTextValA.getText()+ "8");
        }
        if(editTextValB.hasFocus()){

            editTextValB.setText(editTextValB.getText()+ "8");
        }
        if(editTextFuncion.hasFocus()){
            editTextFuncion.setText(editTextFuncion.getText()+"8");
        }
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"8");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"9");
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
        if(editTextValN.hasFocus()){
            editTextValN.setText(editTextValN.getText()+"0");
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
        if(editTextValN.hasFocus()) {

            if (editTextValN.getText().toString().contains(".")) {

            } else {
                editTextValN.setText(editTextValN.getText() + ".");
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
        if(editTextValN.hasFocus()){
            Editable cap =  editTextValN.getText();
            editTextValN.setText("");
            editTextValN.setText(cap.toString().replaceFirst(".$",""));
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
        if(editTextValN.hasFocus()){
            editTextValN.setText("");
        }
    }
    public void setCalcular(View view) {
        Metodos m = new Metodos();
        String stringFunction = editTextFuncion.getText().toString();
        String a = editTextValA.getText().toString();
        String b = editTextValB.getText().toString();
        String subintervalosS = editTextValN.getText().toString();

        String  res = m.sendParams(stringFunction, a, b, subintervalosS);

        editTextResult.setText(res);
    }

}