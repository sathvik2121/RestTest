package restapi;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;

//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import org.apache.commons.codec.binary.Base64;

public class AzureApi {

    public static final String TOKEN_REQUEST_URL = "https://login.microsoftonline.com/305fbbe2-1d25-4227-ab94-48c3c1862465/oauth2/token";
    public static final String CLIENT_ID = "1153d836-a961-4b5e-a705-efc34cceb713";
    public static final String CLIENT_SECRET = "tAD8Q~xPozIvQL4mXOB5TflZp8bxvsjowNKR1bBe";

    public static void main(String[] args) {
        try {
            OAuthClient client = new OAuthClient(new URLConnectionClient());

            OAuthClientRequest request =
                    OAuthClientRequest.tokenLocation(TOKEN_REQUEST_URL)
                    .setGrantType(GrantType.CLIENT_CREDENTIALS)
                    .setClientId(CLIENT_ID)
                    .setClientSecret(CLIENT_SECRET)
                    // .setScope() here if you want to set the token scope
                    .buildBodyMessage();
            

            String token = client.accessToken(request, OAuth.HttpMethod.POST, OAuthJSONAccessTokenResponse.class).getAccessToken();
            System.out.println(token.toString());

        } catch (Exception exn) {
            exn.printStackTrace();
        }
    }

    private static String base64EncodedBasicAuthentication() {
        // TODO Auto-generated method stub
        return null;
    }
}