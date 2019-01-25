package club.sigapp.safewalk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.Navigation;
import club.sigapp.safewalk.Functional.Login;


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
                btnLoginGuest = getView().findViewById(R.id.btnGuestLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                performLogin(view);
            }
        });

        btnLoginGuest.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_loginGuestFragment));
    }

    // Process login
    private void performLogin(View view)
    {
        // Get textViews
        TextView txtLogin = getView().findViewById(R.id.txtLogin),
                txtPassword = getView().findViewById(R.id.txtPassword);

        // Validate the credentials
        Integer loginType;
        try
        {
            loginType = Login.requestServerLogin(txtLogin.getText().toString(), txtPassword.getText().toString());
        } catch (Exception c)
        {
            // Display error
            txtLogin.setError(c.getMessage());
            txtPassword.setText("");

            return;
        }

        // Log in as a student
        if (0 == loginType)
        {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainStudentFragment);
        }
        // Log in as police
        else if (1 == loginType)
        {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainPoliceFragment);
        }
    }
}
