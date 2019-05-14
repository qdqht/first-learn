import net.sf.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ZhTest {

    private static  RestTemplate template = new RestTemplate();
//	 private static String url = "http://127.0.0.1:18131/v1/getData";
//    private static String url = "http://openapi.100credit.cn/api/zh-serialization/v1/getData";  //预发
    private static String url = "http://openapi2.100credit.cn/api/zh-serialization/v1/getData";
//      private static String url = "http://127.0.0.1:18005/api/zh-service/v1/getData";
      private static String apiCode =  "4000101";
    public static String send(String json) {
        try {
            System.out.println("the json "+json);
            HttpHeaders headers = new HttpHeaders();
            //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
            MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
            params.add("jsonData", json);
            params.add("apiCode",apiCode);
           // params.add("customerId",apiCode);
//            params.add("swiftNumber","1111-2222-222222");
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
            ResponseEntity<String> responseEntity = template.postForEntity(url, requestEntity, String.class);

            System.out.println(responseEntity.getStatusCode());
            return  responseEntity.getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {

        String res_str = send(Location());
        System.out.println("the result is :"+res_str);

    }





    public static String Location(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cell", "13963508366");
        jsonObject.put("coordinate","116.731918,39.826542");
        jsonObject.put("coordinateType","1");
        jsonObject.put("addrType", "1");
        jsonObject.put("meal", "Location");
        return jsonObject.toString();
    }

    public static String Location_r(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cell", "15973592159");
        jsonObject.put("coordinate","-114.718323,39.345459");
        jsonObject.put("coordinateType","0");
        jsonObject.put("addrType", "1");
        jsonObject.put("meal", "Location_r");
        return jsonObject.toString();
    }



}
