package club.sigapp.safewalk;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainStudentFragment extends Fragment
{


    public MainStudentFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Button btnRequest = getView().findViewById(R.id.btnRequestSafewalk),
                btnSchedule = getView().findViewById(R.id.btnScheduleSafewalk);

        btnRequest.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainStudentFragment_to_requestNewFragment));
        // Todo: create fragment for scheduling a SafeWalk
        // btnSchedule.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.ac));
    }
}
