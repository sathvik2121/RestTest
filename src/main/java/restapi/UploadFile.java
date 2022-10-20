package restapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class UploadFile {


    public static void main(String[] args) throws Exception {

        // Sending get request
    	//String Bearer="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiJodHRwczovL3N0b3JhZ2UuYXp1cmUuY29tIiwiaXNzIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvMzA1ZmJiZTItMWQyNS00MjI3LWFiOTQtNDhjM2MxODYyNDY1LyIsImlhdCI6MTY2NjE5NDUwOSwibmJmIjoxNjY2MTk0NTA5LCJleHAiOjE2NjYxOTg0MDksImFpbyI6IkUyWmdZUERYL3ljVzhxaCtRVWphLzd2OUduOG1BZ0E9IiwiYXBwaWQiOiJjMDAwOThjMy05YzczLTQ4YjgtOWY0ZS0zM2Y1ZjI2YzI3ODIiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8zMDVmYmJlMi0xZDI1LTQyMjctYWI5NC00OGMzYzE4NjI0NjUvIiwib2lkIjoiZTRjNmQ3NjEtNGVmYi00MmFkLTkxMWQtNzExMDczMjExODc5IiwicmgiOiIwLkFVb0E0cnRmTUNVZEowS3JsRWpEd1lZa1pZR21CdVRVODZoQ2tMYkNzQ2xKZXZHSkFBQS4iLCJzdWIiOiJlNGM2ZDc2MS00ZWZiLTQyYWQtOTExZC03MTEwNzMyMTE4NzkiLCJ0aWQiOiIzMDVmYmJlMi0xZDI1LTQyMjctYWI5NC00OGMzYzE4NjI0NjUiLCJ1dGkiOiI1STMtNDBRcS1rZUprOU1RUTAtLUFBIiwidmVyIjoiMS4wIn0.D4dOeGNzifEq6LlxfuUfnwiI4TEemZVm1Z0zqG35UPC0sF9IDwsHM6aj4yjrEFL7d2cx3ATfTK0zqBtzzIwj86jMnSAbZlCHIISGbH4BxVvOb5PeWhJE8hyr6a86OgD7YeJLurLFzQRX8o4ONRcxxw3yq5pWIi35umtx7iDxALAARtLjI5ugYxkMEbeUi_GkUJ4G5TvY0LbaWG1RTdGvWO9U4NMvMd1w3sw1KJefMbphl2IuGULNLzX83tlC7rPAylQqhxPnPBgGpuI6nsLQsEGWDCfgr3jAi0PfqKk1gBSr2rv4AYTw9fZxeeUecwaFLcFVCAC_l6ms1esKijH1CQ";
    			
    			File reqbody= new File("C:\\Users\\sathv\\eclipse-workspace\\POC\\src\\main\\java\\output\\output.pdf");
    			//String reqbody="C:\\Users\\sathv\\Desktop\\welcome1.txt";
        URL url = new URL("https://storagetestpoccsl.blob.core.windows.net/test/welcome1.txt?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2022-11-30T11:07:40Z&st=2022-10-20T03:07:40Z&spr=https&sig=OupmoQIC0kMQ6q8Obi2HNS4kS43yHwSvG6yHZ%2BKJDzQ%3D");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        //conn.setRequestProperty("Authorization","Bearer "+ Bearer);
        //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T

        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("PUT");
        //conn.setRequestProperty("x-ms-version", "2021-08-06");
        conn.setRequestProperty("x-ms-blob-type", "blockblob");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        OutputStream out = new  DataOutputStream(conn.getOutputStream());
        Files.copy(reqbody.toPath(), out);
        BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		//in.close();

		// print result
		System.out.println(response.toString());
	
        //os.close();

        in.close();
        // printing result from response
        //System.out.println("Response:-" + response.toString());

    }
}