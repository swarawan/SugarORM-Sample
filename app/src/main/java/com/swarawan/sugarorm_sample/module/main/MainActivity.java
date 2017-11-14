package com.swarawan.sugarorm_sample.module.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.swarawan.sugarorm_sample.R;
import com.swarawan.sugarorm_sample.database.Book;
import com.swarawan.sugarorm_sample.database.BookImplementation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private EditText inputTitle, inputAuthor, inputGenre;
    private Button buttonSave;
    private RecyclerView recyclerBook;

    private List<Book> books;
    private BookAdapter adapter;
    private BookImplementation bookImplementation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = new ArrayList<>();
        adapter = new BookAdapter(this, books);
        bookImplementation = new BookImplementation();

        inputTitle = findViewById(R.id.input_title);
        inputAuthor = findViewById(R.id.input_author);
        inputGenre = findViewById(R.id.input_genre);
        buttonSave = findViewById(R.id.button_save);
        recyclerBook = findViewById(R.id.recycler_book);

        recyclerBook.setAdapter(adapter);
        recyclerBook.setLayoutManager(new LinearLayoutManager(this));

        buttonSave.setOnClickListener(onSaveClicked);

        loadAllData();
    }

    private View.OnClickListener onSaveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = inputTitle.getText().toString();
            String author = inputAuthor.getText().toString();
            String genre = inputGenre.getText().toString();

            save(title, author, genre);
        }
    };

    private void save(String title, String author, String genre) {
        Book book = new Book(title, author, genre);
        bookImplementation.saveOrUpdate(book);

        loadAllData();
    }

    private void loadAllData() {
        books.clear();
        books.addAll(bookImplementation.getAll());
        adapter.notifyDataSetChanged();
    }
}
