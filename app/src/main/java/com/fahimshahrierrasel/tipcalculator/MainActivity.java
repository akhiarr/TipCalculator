package com.fahimshahrierrasel.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etSubTotal;
    private EditText etTipPercent;
    private EditText etNoPerson;
    private LinearLayout llResultLayout;
    private TextView tvTotalBill;
    private TextView tvTotalTip;
    private TextView tvBillPPerson;
    private TextView tvTipPPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Widget Initialization
        etSubTotal = findViewById(R.id.et_subtotal);
        etTipPercent = findViewById(R.id.et_tip_percent);
        etNoPerson = findViewById(R.id.et_no_person);
        llResultLayout = findViewById(R.id.ll_result_layout);
        tvTotalBill = findViewById(R.id.tv_total_bill);
        tvTotalTip = findViewById(R.id.tv_total_tip);
        tvBillPPerson = findViewById(R.id.tv_bill_pperson);
        tvTipPPerson = findViewById(R.id.tv_tip_pperson);

        llResultLayout.setVisibility(View.INVISIBLE);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double subTotal = Double.parseDouble(etSubTotal.getText().toString());
                float tipPercent = Float.parseFloat(etTipPercent.getText().toString());
                int numPerson = Integer.parseInt(etNoPerson.getText().toString());

                TipCalculation tc = new TipCalculation(subTotal, tipPercent, numPerson);

                tvTotalBill.setText(String.format("%.2f",tc.calculateTotalBill()));
                tvTotalTip.setText(String.format("%.2f",tc.calculateTip()));
                tvBillPPerson.setText(String.format("%.2f",tc.billPerPerson()));
                tvTipPPerson.setText(String.format("%.2f",tc.tipPerPerson()));

                llResultLayout.setVisibility(View.VISIBLE) ;
            }
        });
    }

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
