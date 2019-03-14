//Develop 2 applications:
//        App 1:
//        Have the user enter the following information:
//        ProductName
//        ProductIDNumber
//        ProductInventoryCount
//        ProductDescription
//        Have a button that will send the above info to App2 using a broadcast reciever
//        Restrict broadcast so only the two apps can use that broadcast

package com.example.week5day3part1;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String RIGHT_INTENTIONS = "com.example.week5day3part1.intent";
    EditText productName;
    EditText productID;
    EditText productInventoryCount;
    EditText productDescription;
    MyBroadcastReceiver myBroadcastReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productName = findViewById(R.id.etProductName);
        productID = findViewById(R.id.etProductNumber);
        productInventoryCount = findViewById(R.id.etProductInventoryCount);
        productDescription = findViewById(R.id.etProductDescription);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.week5day3part1.intent");
        myBroadcastReceiver = new MyBroadcastReceiver();
    }

    public void onClick(View view){
        Intent intent = new Intent(RIGHT_INTENTIONS);
        Bundle bundle = new Bundle();
        String name = productName.getText().toString();
        String ID = productID.getText().toString();
        String inv = productInventoryCount.getText().toString();
        String description = productDescription.getText().toString();

        Product newProduct = new Product(name, ID, inv, description);
        bundle.putParcelable("product_key", newProduct);
        intent.putExtras(bundle);
        sendBroadcast(intent, "permission.5");

    }

    @Override
    protected void onStart() {
        super.onStart();
registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReceiver);
    }
}
