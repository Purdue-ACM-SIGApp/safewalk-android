package club.sigapp.safewalk;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SafeWalkInfoFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_safe_walk_info, container, false);
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
