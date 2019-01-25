package club.sigapp.safewalk.Functional;

import android.telephony.PhoneNumberUtils;

import java.util.HashMap;

public class Login
{
    private static final Login ourInstance = new Login();

    private Login()
    {
    }

    // Validate login by sending a request to the server
    // Return the type of login, if successful
    // Throw an error if the login was not found
    public static Integer requestServerLogin(String xLogin, String xPassword) throws Exception
    {
        // Todo: replace with a server login request
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

    public static void validatePhoneNumber(String xPhoneNumber) throws Exception
    {
       if(xPhoneNumber.isEmpty() || !PhoneNumberUtils.isGlobalPhoneNumber(xPhoneNumber))
           throw new Exception("Invalid phone number");
    }
}
