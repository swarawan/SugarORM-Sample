package com.swarawan.sugarorm_sample.module.main;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.swarawan.sugarorm_sample.R;
import com.swarawan.sugarorm_sample.database.Book;

import java.util.List;

/**
 * Created by rioswarawan on 11/14/17.
 */

public class BookAdapter extends RecyclerView.Adapter {

    private List<Book> books;
    private LayoutInflater layoutInflater;

    public BookAdapter(Context context, List<Book> books) {
        this.books = books;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BookViewHolder viewHolder = (BookViewHolder) holder;
        Book book = books.get(position);

        viewHolder.textTitle.setText(book.title);
        viewHolder.textAuthorGenre.setText(book.author + " / " + book.genre);
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    private class BookViewHolder extends RecyclerView.ViewHolder {

        private CardView card;
        private TextView textTitle, textAuthorGenre;

        public BookViewHolder(View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            textTitle = itemView.findViewById(R.id.text_title);
            textAuthorGenre = itemView.findViewById(R.id.text_author_genre);
        }
    }
}
