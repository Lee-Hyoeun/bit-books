package kr.books.bitbooks.common.utils;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Component
public class HttpUtils {

    private static final  Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 기본 post 방식
     * @param targetUrl
     * @param dataMap
     * @return
     * @throws Exception
     */
    public   String sendPostJson(String targetUrl,  HashMap<String, Object> dataMap)  throws  Exception{

        BufferedReader in = null;

        StringBuilder sb = new StringBuilder();
        JSONObject obj = new JSONObject(dataMap);

        String body = obj.toString();

        URL url = new URL(targetUrl); // 호출할 url

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoInput(true);
        conn.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정
        conn.setUseCaches(false);
        conn.setDefaultUseCaches(false);
        conn.setConnectTimeout(3000); //연결대기시간 3초
        conn.setReadTimeout(3000);  //응답받는시간 3초.


        BufferedOutputStream wr = new BufferedOutputStream(conn.getOutputStream());
        // Request Body에 Data 셋팅.
        wr.write(body.getBytes("UTF-8"));
        // Request Body에 Data 입력.
        wr.flush();
        // OutputStream 종료.
        wr.close();
        StringBuilder str = new StringBuilder();

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));


            String inputLine ="";
            while ((inputLine = in.readLine()) != null) { // response 출력
                str.append(inputLine + "\n");
                logger.debug(inputLine);
            }
            in.close();

        }else {
            logger.error("error sendData, {}" , conn.getResponseMessage());
           throw new Exception(conn.getResponseMessage());
        }
        return str.toString();
    }


    /**
     * post 인데 
     * application/x-www-form-urlencoded 방식
     * @param targetUrl
     * @param dataMap
     * @return
     * @throws Exception
     */
    public  String sendPostQuery(String targetUrl,  HashMap<String, Object> dataMap)  throws  Exception{

        BufferedReader in = null;
        StringBuilder sb = new StringBuilder();

        URL url = new URL(targetUrl); // 호출할 url

        StringBuilder postData = new StringBuilder();

        //데이터 만들기
        for (Map.Entry<String, Object>  param :  dataMap.entrySet()) {

            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        //데이터를 바이트 배열로 만든다.
        byte[] postDataBytes = postData.toString().getBytes("utf-8");

        try{

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  // x-form쓰는게 한글때문이라는데.....
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true); //POST 데이터를 OuatputStream으로 넘겨 주겠다는 설정
            conn.setUseCaches(false);
            conn.setDefaultUseCaches(false);
            conn.setConnectTimeout(3000); //연결대기시간 3초
            conn.setReadTimeout(3000);  //응답받는시간 3초.

            BufferedOutputStream wr = new BufferedOutputStream(conn.getOutputStream());

            wr.write(postDataBytes, 0, postDataBytes.length);
            wr.flush();


            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                String inputLine;
                while ((inputLine = in.readLine()) != null) { // response 출력
                    sb.append(inputLine);
                }
                in.close();

            }else {
                System.out.println(conn.getResponseMessage());
            }
        }catch(Exception e ) {
            logger.error("[Rest] Error Push, {}",  e.getMessage());
        }

        return sb.toString();
    }


    /**
     *
     * @param targetUrl
     * @param dataMap
     * @param token
     * @return
     * @throws Exception
     */
    public  String get(String targetUrl,  HashMap<String, Object> dataMap, String token)  throws  Exception{

        BufferedReader in = null;
        StringBuilder sb = new StringBuilder();
        StringBuilder postData = new StringBuilder();

        if(dataMap != null) {

            for (Map.Entry<String, Object> param : dataMap.entrySet()) {

                if (postData.length() != 0) {
                    postData.append('&');
                } else {
                    postData.append('?');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            targetUrl = targetUrl+ postData.toString();
        }



        URL url = new URL(targetUrl); // 호출할 url


        try{

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setUseCaches(false);
            conn.setDefaultUseCaches(false);
            conn.setConnectTimeout(3000); //연결대기시간 3초
            conn.setReadTimeout(3000);  //응답받는시간 3초.

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            Charset charset = Charset.forName("UTF-8");

            if(responseCode != 200) {
                in = new BufferedReader(new InputStreamReader(conn.getErrorStream(),charset));
            }else {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(),charset));
            }

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

        }catch(Exception e ) {
            logger.error("[Rest] Error Push, {}",  e.getMessage());
        }

        return sb.toString();
    }




}
