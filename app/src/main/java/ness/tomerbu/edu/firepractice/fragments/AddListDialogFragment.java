package ness.tomerbu.edu.firepractice.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ness.tomerbu.edu.firepractice.R;
import ness.tomerbu.edu.firepractice.models.Todos;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddListDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_add_list_dialog, container, false);

        final EditText etTitle = (EditText) v.findViewById(R.id.etTitle);
        final EditText etDescription = (EditText) v.findViewById(R.id.etDescription);
        Button btnSave = (Button) v.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();

                Todos todos = new Todos(title, description);
                DatabaseReference ref = FirebaseDatabase.
                        getInstance().
                        getReference().
                        child("todos").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid());

                ref.push().setValue(todos);
                dismiss();
            }
        });
        return v;
    }

}
