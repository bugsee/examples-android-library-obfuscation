package com.bugsee.shared.obfuscationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.without_rules_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Produces AssertionError, because class, which contains field of enum type, is serialized by gson library and the enum is defined in the library too.
                    boolean result = new com.bugsee.shared.noproguardruleslibrary.LibInterface().manipulateDataClasses();
                    Toast.makeText(MainActivity.this, "Executed successfully: " + result, Toast.LENGTH_SHORT).show();
                } catch (Throwable e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Exception was thrown: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.with_consumer_rules_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    boolean result = new com.bugsee.shared.simplelibrary.LibInterface().manipulateDataClasses();
                    Toast.makeText(MainActivity.this, "Executed successfully: " + result, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Exception was thrown: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.with_both_rule_types_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    boolean result = new com.bugsee.shared.obfuscatedlibrary.LibInterface().manipulateDataClasses();
                    Toast.makeText(MainActivity.this, "Executed successfully: " + result, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Exception was thrown: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
