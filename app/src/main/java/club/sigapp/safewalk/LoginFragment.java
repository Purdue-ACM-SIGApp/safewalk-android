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


public class LoginFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Todo: remove login for police
        Button btnLogin = getView().findViewById(R.id.btnLogin),
        btnLoginGuest = getView().findViewById(R.id.btnGuestLogin),
        btnLoginPolice = getView().findViewById(R.id.btnLogin2);

        btnLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_mainStudentFragment));
        btnLoginGuest.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_loginGuestFragment));
        btnLoginPolice.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_mainPoliceFragment));
    }
}
