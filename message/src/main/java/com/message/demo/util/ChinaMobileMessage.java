package com.message.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.message.demo.config.MobileMsgConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Component
@Slf4j
public class ChinaMobileMessage {

    @Autowired
    private RestTemplate dataTemplate;

    /**
     * 加密方法，请不要随意更改，以免影响短信正常发送
     *
     * @param input
     * @return
     */
    public String encrypt(String input) {
        byte[] crypted = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(MobileMsgConfiguration.KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes("UTF-8"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new String(Base64.encodeBase64(crypted));
    }

    /**
     * 解密方法，请不要随意更改，以免影响短信正常发送
     *
     * @param input
     * @return
     * @throws Exception
     */
    public String decrypt(String input) throws Exception {
        byte[] output = null;
        SecretKeySpec skey = new SecretKeySpec(MobileMsgConfiguration.KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skey);
        output = cipher.doFinal(Base64.decodeBase64(input));

        return new String(output, "UTF-8");
    }

    public String sendMassage(String moblie, String msg) {
        log.info("sendMassge===>mobile: {}, msg: {}", moblie, msg);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        log.info("kafkaObj: {}", msg);
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("eid", encrypt(MobileMsgConfiguration.EID));
        params.add("userid", encrypt(MobileMsgConfiguration.USERID));
        params.add("password", encrypt(MobileMsgConfiguration.PASSWORD));
        params.add("mobile", encrypt(moblie));
        params.add("content", encrypt(msg));
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, requestHeaders);
        ResponseEntity<String> resp = dataTemplate.postForEntity(MobileMsgConfiguration.URL_SEND,
                requestEntity, String.class);

        log.info("ResponseEntity : {}" , resp);

        if(!resp.getStatusCode().is2xxSuccessful()){
            log.error("china mobile sendMassage error:{} ", resp);
        }

        String respStr;
        if (resp.getBody() != null && resp.getBody().startsWith("0,")) {
            try {
                respStr = "信息发送成功(编号" + decrypt(resp.getBody().substring(2, resp.getBody().length())) + ")";
            } catch (Exception e) {
                respStr = "decrpt error";
            }
        } else if (resp.getBody() != null) {
            respStr = "信息发送出错(返回:" + resp.getBody() + ")";
        } else {
            respStr = "信息返回空";
        }

        return respStr;

    }

    public void getReport() {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("eid", encrypt(MobileMsgConfiguration.EID));
        params.add("userid", encrypt(MobileMsgConfiguration.USERID));
        params.add("password", encrypt(MobileMsgConfiguration.PASSWORD));
        log.info("parmas: {}", params);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, requestHeaders);
        ResponseEntity<String> resp = dataTemplate.postForEntity(MobileMsgConfiguration.URL_REPORT,
                requestEntity, String.class);
        log.info("resp: {}", resp);

        if(!resp.getStatusCode().is2xxSuccessful()){
            log.error("china mobile getReport error:{} ", resp);
        }
        if (resp.getBody() != null && resp.getBody().startsWith("0,")) {
            try {
                log.info("getReport success: {}",  decrypt(resp.getBody().substring(2, resp.getBody().length())));
            } catch (Exception e) {
                log.info("getReport: decrpt error");
            }
        } else if (resp.getBody() != null) {
            log.info("getReport: {}", resp.getBody());
        } else {
            log.info("获取短信报告 为空");
        }
    }

    public void doReceive() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("eid", encrypt(MobileMsgConfiguration.EID));
        params.add("userid", encrypt(MobileMsgConfiguration.USERID));
        params.add("password", encrypt(MobileMsgConfiguration.PASSWORD));
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, requestHeaders);
        ResponseEntity<String> resp = dataTemplate.postForEntity(MobileMsgConfiguration.URL_RECEIVE,
                requestEntity, String.class);

        if(!resp.getStatusCode().is2xxSuccessful()){
            log.error("china mobile doReceive error:{} ", resp);
        }

        if (resp.getBody() != null && resp.getBody().startsWith("0,")) {
            try {
                log.info("doReceive success: {}",  decrypt(resp.getBody().substring(2, resp.getBody().length())));
            } catch (Exception e) {
                log.info("doReceive: decrpt error");
            }
        } else if (resp.getBody() != null) {
            log.info("doReceive: {}", resp.getBody());
        } else {
            log.info("获取回复信息为空");
        }

    }
}
