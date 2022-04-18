package com.example.demo.common;




import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 返回结果的封装
 */
@Component
@Data
public class JsonResult {

    /**
     * 状态码
     */
    private  int status;
    /**
     * 返回数据
     */
    private  Object data;
    /**
     * 返回消息
     */
    private String message;

    /**
     * 成功消息的封装
     * @param data
     * @param message
     * @return
     */
    public static JsonResult success(Object data,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(Content.SUCCESS_STATUS);
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    /**
     * 失败消息的封装
     * @param data
     * @param message
     * @return
     */
    public static JsonResult error(Object data,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(Content.ERROR_STATUS);
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        return jsonResult;
    }

}


