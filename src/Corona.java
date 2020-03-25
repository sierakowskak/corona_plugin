import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Corona {

    public Corona() {
    }

    public String fajnaMetoda() {
        try {
            URL url = new URL("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
            con.setRequestProperty("x-rapidapi-key", "42ca1f9359mshc12df993fb0daa2p10dceejsna7311da99347");
            con.setRequestProperty("country", "Canada");
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStr = con.getInputStream();
                Scanner s = new Scanner(inputStr).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";
                String[] fields = result.split("\\{");
                ArrayList<String> poland = Arrays.stream(fields)
                        .filter(field -> field.contains("Poland"))
                        .collect(Collectors.toCollection(ArrayList::new));
                String[] fields1 = poland.get(0).split("\"");
                String res = fields1[11] + ": " + fields1[15] + "\n" +
                        fields1[21]+fields1[22] + "\n" +
                        fields1[23]+fields1[24] + "\n" +
                        fields1[25]+fields1[26];
                return res.substring(0, res.length() - 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
