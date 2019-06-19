//package com.lym.springboot.mockmvc.controller;
//
//import com.lym.springboot.service.aiface.compose.domain.req.*;
//import com.lym.springboot.service.aiface.compose.domain.vo.*;
//import com.lym.springboot.service.aiface.compose.domain.vo.api.ApplyResultVo;
//import com.lym.springboot.service.aiface.compose.domain.vo.api.DetailVo;
//import com.lym.springboot.service.aiface.compose.service.AIService;
//import com.lbx.framework.api.WebApiBase;
//import com.lbx.framework.api.util.WebApiAssert;
//import com.lbx.framework.common.domain.common.ResponseResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//
///**
// * @author: 111
// * @create: 2019/05/28 11:15
// * @description: 人脸库，对外开发的api
// */
//@Api(value = "人脸识别接口",tags = "人脸识别接口")
//@Controller
//public class ApiController {
//
//
//    @Autowired
//    private AIService aiService;
//
//    /**
//     *
//     * @param file
//     * @param userId
//     * @param userName
//     * @param appId
//     * @return
//     */
//    @ApiOperation(value = "人脸信息采集",notes = "人脸信息采集,需要采集正脸信息，提交后会检测人脸信息")
//    @PostMapping(value = "/api/v1/face/apply",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "file",value = "图片文件",required = true,dataType = "file"),
//            @ApiImplicitParam(name = "user_id",value = "员工工号",required = true),
//            @ApiImplicitParam(name = "user_name",value = "员工姓名",required = true),
//            @ApiImplicitParam(name = "app_id",value = "应用ID",required = true),
//            @ApiImplicitParam(name = "time_stamp",value = "时间戳",required = true,dataType = "long"),
//            @ApiImplicitParam(name = "nonce_str",value = "随机字符串",required = true),
//            @ApiImplicitParam(name = "sign",value = "签名",required = true)
//    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 0,message = "成功"),
//            @ApiResponse(code = 10050,message = "没有发现人脸"),
//            @ApiResponse(code = 10051,message = "请确认只有一个人脸"),
//            @ApiResponse(code = -1,message = "服务调用异常")
//    })
//    @ResponseBody
//    public ResponseResult<ApplyResultVo> applyByForm(@RequestPart("file") MultipartFile file,
//                                                     @RequestParam("user_id") String userId,
//                                                     @RequestParam("user_name")String userName,
//                                                     @RequestParam("app_id") String appId, long time_stamp, String nonce_str, String sign){
//        WebApiBase webApiBase = new WebApiBase();
//        webApiBase.setAppId(appId);
//        webApiBase.setNonceStr(nonce_str);
//        webApiBase.setSign(sign);
//        webApiBase.setTimeStamp(time_stamp);
//        WebApiAssert.validation(webApiBase);
//        FaceRegApplyReq faceRegApplyReq = new FaceRegApplyReq();
//        faceRegApplyReq.setUserId(userId);
//        faceRegApplyReq.setUserName(userName);
//        faceRegApplyReq.setAppId(appId);
//         return aiService.apply(file,faceRegApplyReq);
//    }
//
////    /**
////     * @param faceRegApplyReq
////     * @return ResponseResult
////     */
////    @ApiOperation(hidden = true,value = "人脸信息采集",notes = "人脸信息采集,需要采集正脸信息（文件上传接口和业务参数分离）")
////    @PostMapping(value = "/api/v1/face/apply",consumes =MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    @ResponseBody
////    public ResponseResult<ApplyResultVo> applyByJson(@Validated @RequestBody FaceRegApplyReq faceRegApplyReq){
////        return aiService.apply(faceRegApplyReq);
////    }
//
//    /**
//     * 判断员工人脸是否已注册过
//     * @return
//     */
//    @ApiOperation(value =  "判断员工是否已经注册",notes = "判断员工是否已经成功注册信息并且审核通过")
//    @PostMapping(value = "/api/v1/face/registered",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiResponses(value = {
//            @ApiResponse(code = 0,message = "成功"),
//            @ApiResponse(code = 10053,message = "未注册"),
//            @ApiResponse(code = -1,message = "服务调用异常")
//    })
//    @ResponseBody
//    public ResponseResult<RegisteredVo> registered(@Validated @RequestBody RegisteredReq registeredReq){
//        return aiService.registered(registeredReq);
//    }
//
//
//    /**
//     *  员工人脸认证识别
//     * @param file
//     * @param userId
//     * @return
//     */
//    @ApiOperation(value = " 员工人脸认证识别",notes = "上传一张图片和员工注册的头像比较验证")
//    @PostMapping(value = "/api/v1/face/recognition",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "unknow_face_img",value = "待检测图片文件",required = true,dataType = "file"),
//            @ApiImplicitParam(name = "user_id",value = "员工工号",required = true),
//            @ApiImplicitParam(name = "app_id",value = "应用ID",required = true),
//            @ApiImplicitParam(name = "time_stamp",value = "时间戳",required = true,dataType = "long"),
//            @ApiImplicitParam(name = "nonce_str",value = "随机字符串",required = true),
//            @ApiImplicitParam(name = "sign",value = "签名",required = true)
//    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 0,message = "成功"),
//            @ApiResponse(code = 10053,message = "未注册"),
//            @ApiResponse(code = -1,message = "服务调用异常/系统异常")
//    })
//    @ResponseBody
//    public ResponseResult<DetectFaceVo> faceRecognition(@RequestPart("unknow_face_img") MultipartFile file, @RequestParam("user_id") String userId){
//        return aiService.faceRecognition(file,userId);
//    }
//
////    /**
////     * 员工人脸认证识别
////     * @param recognitionReq
////     * @return
////     */
////    @ApiOperation(value = " 员工人脸认证识别")
////    @PostMapping("/api/v1/face/recognition")
////    @ResponseBody
////    public ResponseResult<DetectFaceVo> faceRecognition(RecognitionReq recognitionReq){
////        return aiService.faceRecognition(recognitionReq);
////    }
//
//    /**
//     *获取用户已经注册的人脸信息
//     * @param
//     * @param detailReq
//     * @return
//     */
//    @ApiOperation(value = "获取员工已经注册的人脸信息",notes = "通过员工ID 获取员工已经注册的人脸信息")
//    @PostMapping(value = "/api/v1/face/detail",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiResponses(value = {
//            @ApiResponse(code = 0,message = "成功"),
//            @ApiResponse(code = 10053,message = "未注册"),
//            @ApiResponse(code = -1,message = "服务调用异常/系统异常")
//    })
//    @ResponseBody
//    public ResponseResult<List<DetailVo>> detail(@Validated @RequestBody DetailReq detailReq){
//        return aiService.detail(detailReq);
//    }
//
//
//    /**
//     * 员工已注册人脸注销即删除
//     * @param
//     * @param faceRegRemoveReq
//     * @return
//     */
//    @ApiOperation(value = "员工已注册人脸注销")
//    @PostMapping(value = "/api/v1/face/remove",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiResponses(value = {
//            @ApiResponse(code = 0,message = "成功"),
//            @ApiResponse(code = -1,message = "服务调用异常/系统异常")
//    })
//    @ResponseBody
//    public ResponseResult remove(@Validated @RequestBody FaceRegRemoveReq faceRegRemoveReq){
//        return aiService.remove(faceRegRemoveReq);
//    }
//
//
//    @ApiOperation(hidden = true,value = "头像检测",notes = "目前只提供检测是否存在人脸信息")
//    @PostMapping("/api/v1/face/judge")
//    public ResponseResult<FaceJudgeVo> judge(@Validated @RequestBody JudgeReq judgeReq){
//        return aiService.judge(judgeReq.getImgPath());
//    }
//}
