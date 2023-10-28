package com.example.group13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.group13.adapter.FoodsAdapter;
import com.example.group13.database.Database;
import com.example.group13.model.Foods;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listFoods;
    ArrayList<Foods> arrayFoods;
    FoodsAdapter adapter;
    private Button btOut;

    Database database;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product_foods);
        btOut = (Button) findViewById(R.id.button);

        listFoods = (ListView) findViewById(R.id.listFood);
        arrayFoods = new ArrayList<>();
        adapter = new FoodsAdapter(this,R.layout.item, arrayFoods);
        listFoods.setAdapter(adapter);

        // Initialize the database helper
        database = new Database(this, "User.db", null, 1);
        // Drop the Foods table if it exists
        database.QueryData("DROP TABLE IF EXISTS Foods");
//
        database.QueryData("DROP TABLE IF EXISTS Cart");


        database.QueryData("CREATE TABLE IF NOT EXISTS Foods (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name NVARCHAR(200), Details NVARCHAR(200), Image NVARCHAR(200), Quantity INTEGER, Price REAL ) ");

        database.QueryData("CREATE TABLE IF NOT EXISTS Cart (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name NVARCHAR(200), Price REAL,  Quantity INTEGER, Image NVARCHAR(200) ) ");

        database.QueryData("CREATE TABLE IF NOT EXISTS Orders (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "PriceTotal REAL, DateBill NVARCHAR(200), NameUser NVARCHAR(200), IdMasterCard NVARCHAR(200)  ) ");

// Thực hiện truy vấn để kiểm tra dữ liệu trong bảng "Cart"
        String cartQuery = "SELECT * FROM Cart";
        Cursor cartData = database.GetData(cartQuery);

// Kiểm tra xem có dữ liệu trong bảng "Cart" hay không
        if (cartData.getCount() > 0) {
            // Có dữ liệu trong giỏ hàng
            // Hiển thị thông báo hoặc thực hiện các thao tác cần thiết
            // Ví dụ: Hiển thị thông báo
            Toast.makeText(MainActivity.this, "Có đồ trong giỏ", Toast.LENGTH_SHORT).show();
        } else {
            // Không có dữ liệu trong giỏ hàng
            // Thực hiện các thao tác khác (nếu cần)
            // Ví dụ: Không hiển thị thông báo
        }


        //inset
        database.QueryData("Insert into Foods values(null, 'Salad', 'Delicious Salad', " + R.drawable.salad +  ", 12, 10.2)");
        database.QueryData("Insert into Foods values(null, 'Hamburger', 'Hamburger Siuu ngonn!!!', " + R.drawable.hamburger +  ", 15, 15.0)");
        database.QueryData("Insert into Foods values(null, 'Spaghetti', 'Spaghetti đẳng cấp số 1 VN!!', " + R.drawable.spaghetti +  ", 20, 20.0)");
        database.QueryData("Insert into Foods values(null, 'Chicken', 'Ở đây có gà siêu ngon nè!!!', " + R.drawable.chicken +  ", 5, 30.4)");
        database.QueryData("Insert into Foods values(null, 'Fish', 'Cá quá trời nè mua điiiI!!!', " + R.drawable.fish +  ", 40, 10.0)");
        database.QueryData("Insert into Foods values(null, 'Breakfast', 'Breakfast - Bữa sáng năng lượng <3', " + R.drawable.breakfast +  ", 22, 33.33)");
        database.QueryData("Insert into Foods values(null, 'Sandwich', 'Sandwich - làm tý sandwich nào ae <3', " + R.drawable.sandwich +  ", 25, 50.0)");
        //

        String query = "SELECT * FROM Foods ";
        Cursor dataFoods = database.GetData(query);
        while (dataFoods.moveToNext()){
            int id = dataFoods.getInt(0);
            String name = dataFoods.getString(1);
            String details = dataFoods.getString(2);
            int image = dataFoods.getInt(3);
            int quantity = dataFoods.getInt(4);
            double price = dataFoods.getDouble(5);
            arrayFoods.add(new Foods(id,name,details,image,quantity,price ));
        }
        adapter.notifyDataSetChanged();

        btOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                //finish();
            }
        });


//        ImageView homeListFoods = findViewById(R.id.home);
        ImageView cartFoods = findViewById(R.id.cart);

//        homeListFoods.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Xử lý sự kiện khi nhấp vào biểu tượng imageFoods (quay lại trang trước)
//                onBackPressed(); // Quay lại trang trước
//            }
//        });

        cartFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nhấp vào biểu tượng shoppingCartIcon (chuyển đến trang Cart)
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        ImageView mapView = findViewById(R.id.map);

        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nhấp vào biểu tượng shoppingCartIcon (chuyển đến trang Cart)
                Intent intent = new Intent(MainActivity.this, ThongTinActivity.class);
                startActivity(intent);
            }
        });

    }
}