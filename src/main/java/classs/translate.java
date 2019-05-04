package classs;

// main
//                    String fromLang = "th";
//                    String toLang = "en";
//String tex = "Let's have some fun!";

//                    translate(fromLang, toLang, msgText, payload.events[0].replyToken);

//replyToUser(payload.events[0].replyToken, msgText);
                    /*try {
                        getMessageData(msgText, idTarget);
                    } catch (IOException e) {
                        System.out.println("Exception is raised ");
                        e.printStackTrace();
                    }
                    */
//                    **end**
//public class translate {
//    private void translate(String fromLang, String toLang, String text, String payload) throws IOException {
//        // TODO: Should have used a 3rd party library to make a JSON string from an object
//        String jsonPayload = new StringBuilder()
//                .append("{")
//                .append("\"fromLang\":\"")
//                .append(fromLang)
//                .append("\",")
//                .append("\"toLang\":\"")
//                .append(toLang)
//                .append("\",")
//                .append("\"text\":\"")
//                .append(text)
//                .append("\"")
//                .append("}")
//                .toString();
//
//        URL url = new URL(ENDPOINT);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setDoOutput(true);
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
//        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
//        conn.setRequestProperty("Content-Type", "application/json");
//
//        OutputStream os = conn.getOutputStream();
//        os.write(jsonPayload.getBytes());
//        os.flush();
//        os.close();
//
//        int statusCode = conn.getResponseCode();
//        System.out.println("Status Code: " + statusCode);
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
//        ));
//        String output;
//        while ((output = br.readLine()) != null) {
//            replyToUser(payload, output);
//            //System.out.println(output);
//        }
//        conn.disconnect();
//    }
//}
