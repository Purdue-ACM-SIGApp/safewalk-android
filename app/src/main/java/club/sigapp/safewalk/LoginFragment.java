package club.sigapp.safewalk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import androidx.navigation.Navigation;


public class LoginFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        // Swipe left to view info
        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener()
                {
                    @Override
                    public boolean onDown(MotionEvent e)
                    {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY)
                    {
                        final int SWIPE_MIN_DISTANCE = 100;
                        final int SWIPE_MAX_OFF_PATH = 250;
                        final int SWIPE_THRESHOLD_VELOCITY = 100;
                        try
                        {
                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                            {
                                return false;
                            }
                            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                            {
                                Navigation.findNavController(rootView).navigate(R.id.action_loginFragment_to_safeWalkInfoFragment);
                            }
                        } catch (Exception ignored)
                        {
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        // Detect the touch
        rootView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return gesture.onTouchEvent(event);
            }
        });
        //

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

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

    // Main function for login
    private void performLogin(View view)
    {
        // Get textViews
        TextView txtLogin = getView().findViewById(R.id.txtLogin),
                txtPassword = getView().findViewById(R.id.txtPassword);

        // Validate the credentials
        Integer loginType;
        try
        {
            loginType = validateLogin(txtLogin.getText().toString(), txtPassword.getText().toString());
        } catch (Exception c)
        {
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

    // Validate login by sending a request to the server
    // Return the type of login, if successful
    // Throw an error if the login was not found
    private Integer validateLogin(String xLogin, String xPassword) throws Exception
    {
        // Todo: replace with server login request
        String[] mockLogins = {"student", "police"};
        HashMap<String, Integer> mockTypes = new HashMap<>();
        mockTypes.put("student", 0);
        mockTypes.put("police", 1);

        for (String login : mockLogins)
        {
            if (xLogin.equals(login))
                return mockTypes.get(login);
        }

        throw new Exception("Login not found");
    }
}
