package ness.tomerbu.edu.firepractice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import ness.tomerbu.edu.firepractice.models.Todos;

/**
 * Created by android on 18/07/2016.
 */
public class TodosFireAdapter extends FirebaseRecyclerAdapter<Todos, TodosFireAdapter.TodosViewHolder>{

    public TodosFireAdapter(DatabaseReference ref) {
        super(Todos.class, R.layout.todo_list_item,
                TodosViewHolder.class, ref);
    }

    public TodosFireAdapter(Query query) {
        super(Todos.class, R.layout.todo_list_item,
                TodosViewHolder.class, query);
    }

    @Override
    protected void populateViewHolder(TodosViewHolder viewHolder, final Todos model, final int position) {
        viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getDescription());

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid = getRef(position).getKey();
                Toast.makeText(view.getContext(), "Pressed "  + model.toString() + uid, Toast.LENGTH_SHORT).show();


            }
        });
    }

    public static class TodosViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout layout;
         TextView tvTitle;
         TextView tvDescription;

        public TodosViewHolder(View itemView) {
            super(itemView);
            layout = (RelativeLayout) itemView.findViewById(R.id.relative_item);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
