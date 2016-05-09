import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created by Fornia.fu on 2015/12/16.
 */
public class ProxyIdCard {



    /*public static void main(String[] args){
        String httpUrl = "http://apis.baidu.com/apistore/idservice/id";
        String httpArg = "id=420984198704207896";
        String jsonResult = request(httpUrl, httpArg);
        jsonResult = decodeUnicode(jsonResult);
        System.out.println(jsonResult);
    }*/


    public static void main(String[] args){
        ProxyIdCard parseIdCard = new ProxyIdCard();
        parseIdCard.request("410882199112087012");
        System.out.println(parseIdCard.getGender());
        System.out.println(parseIdCard.getPayerBirthDay());
        System.out.println(parseIdCard.getPayerBirthMonth());
        System.out.println(parseIdCard.getPayerBirthYear());
        System.out.println(parseIdCard.getPayerAge());
    }

    /**
     * @param urlAll
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    private Short gender = null;
    private Short payerAge = null;
    private Short payerBirthYear = null;
    private Short payerBirthMonth = null;
    private Short payerBirthDay = null;
    public void request(String httpArg) {
        BufferedReader reader = null;
        String result = null;
        String httpUrl = "http://apis.baidu.com/apistore/idservice/id?id=";//(String) PropertiesUtil.getProperty(IDCARD_API);
        String apiKey = "24ab0b1bc0f99639d5d26307f2db557d";//(String) PropertiesUtil.getProperty(PHONE_APIKEY);
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl+ httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",apiKey);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            result = decodeUnicode(result);
            if(StringUtil.isNotEmpty(result)){
                result =  ProxyPhoneNum.decodeUnicode(result);
            }
            JSONObject retData = getRetData(result);
            if(retData!=null){
                String sex = retData.getString("sex");
                if(StringUtil.isNotEmpty(sex)){
                    if("M".equals(sex)){
                        gender=1;
                    }else{
                        gender=0;
                    }
                }
                String birthDay = retData.getString("birthday");
                if(StringUtil.isNotEmpty(birthDay)){
                    if(birthDay.length()==10){
                        Date birthDate = DateUtil.str2Date(birthDay, "yyyy-mm-dd");
                        payerAge = (short)DateUtil.getAgeByBirthday(birthDate);
                        payerBirthDay = Short.parseShort(birthDay.substring(0,4));
                        payerBirthMonth = Short.parseShort(birthDay.substring(5,7));
                        payerBirthYear = Short.parseShort(birthDay.substring(8,10));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Short getGender() {
        return gender;
    }

    public Short getPayerAge() {
        return payerAge;
    }

    public Short getPayerBirthYear() {
        return payerBirthYear;
    }

    public Short getPayerBirthMonth() {
        return payerBirthMonth;
    }

    public Short getPayerBirthDay() {
        return payerBirthDay;
    }

    public JSONObject getRetData(String phoneResult)
    {
        JSONObject retDataObject = null;

        try
        {
            JSONObject jsonObject = JSONObject.fromObject(phoneResult);

            String status = jsonObject.getString("retMsg");

            if (StringUtil.isNotEmpty(status)&&"success".equalsIgnoreCase(status))
            {
                retDataObject = jsonObject.getJSONObject("retData");
            }

        }catch(Exception e){
            //Ignore this exception when failed obtain phone province info
           // log.error("Exception Occurred when get the phone location message :" +e);
        }
        return retDataObject;
    }

    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

}
