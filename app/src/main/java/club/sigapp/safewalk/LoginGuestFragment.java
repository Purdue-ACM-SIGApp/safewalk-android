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
import android.widget.Toast;

import club.sigapp.safewalk.Functional.Login;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginGuestFragment extends Fragment
{


    public LoginGuestFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_guest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Login buttons clicks
        Button btnLoginGuest = getView().findViewById(R.id.btnGuestLogin);

        btnLoginGuest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                performLogin(view);
            }
        });
    }

    // Process login
    private void performLogin(View view)
    {
        // Get textViews
        TextView txtLastName = getView().findViewById(R.id.txtLastName),
                txtFirstName = getView().findViewById(R.id.txtFirstName),
                txtPhoneNumber = getView().findViewById(R.id.txtPhoneNumber);

        // Validate the credentials
        try
        {
            Login.requestGuestLogin(txtLastName.getText().toString(), txtFirstName.getText().toString(), txtPhoneNumber.getText().toString());
        } catch (Exception c)
        {
            // Display error
            Toast.makeText(getContext(), c.getMessage(), Toast.LENGTH_LONG).show();

            return;
        }

        // Todo: Log in as a guest
        Toast.makeText(getContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
    }
}
