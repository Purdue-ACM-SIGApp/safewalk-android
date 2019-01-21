package club.sigapp.safewalk;


import android.content.Intent;
import android.net.Uri;
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

import androidx.navigation.Navigation;

public class SafeWalkInfoFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_safe_walk_info, container, false);

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
                            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                            {
                                Navigation.findNavController(rootView).navigate(R.id.action_safeWalkInfoFragment_to_loginFragment);
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

        Button btnSafeWalkNumber = getView().findViewById(R.id.btnSafeWalkNumber),
                btnEmergency = getView().findViewById(R.id.btnEmergency);

        btnSafeWalkNumber.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Get a string resource
                String number = "tel:" + getResources().getString(R.string.safewalk_number);

                // Make an implicit intent and launch the dialer app
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                getActivity().startActivity(callIntent);
            }
        });

        btnEmergency.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String number = "tel:" + getResources().getString(R.string.emergency_number);

                // Make an implicit intent and launch the dialer app
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));;
                getActivity().startActivity(callIntent);
            }
        });
    }
}
