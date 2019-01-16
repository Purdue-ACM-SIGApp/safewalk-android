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
public class MainPoliceFragment extends Fragment
{
    public MainPoliceFragment()
    {
        // Required empty public constructorw
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_police, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Todo: change placeholder onClick actions
        Button btnLogin = getView().findViewById(R.id.btnOldest),
                btnClosest = getView().findViewById(R.id.btnClosest);

        btnLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainPoliceFragment_to_requestActiveFragment));
        btnClosest.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainPoliceFragment_to_requestActiveFragment));
    }

}
