package ness.tomerbu.edu.firepractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private static final String PARAM_TITLE = "TITLE";

    //Factory Method - newInstance (*Shortcut)
    public static UserListFragment newInstance(String title){
        UserListFragment fragment = new UserListFragment();

        Bundle bundle = new Bundle();
        bundle.putString(PARAM_TITLE, title);
        fragment.setArguments(bundle);


        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String title = getArguments().getString(PARAM_TITLE);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_list, container, false);

        TextView tvTitle = (TextView) v.findViewById(R.id.title);
        tvTitle.setText(title);
        return v;
    }

}
