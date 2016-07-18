package ness.tomerbu.edu.firepractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private static final String PARAM_REF = "users/...";

    //Factory Method - newInstance (*Shortcut)
    public static UserListFragment newInstance(String title){
        UserListFragment fragment = new UserListFragment();

        Bundle bundle = new Bundle();
        bundle.putString(PARAM_REF, title);
        fragment.setArguments(bundle);


        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String title = getArguments().getString(PARAM_REF);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_list, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("todos").child(uid);

        Query query = ref.orderByChild("title");

        recyclerView.setAdapter(new TodosFireAdapter(ref));
        return v;
    }

}
