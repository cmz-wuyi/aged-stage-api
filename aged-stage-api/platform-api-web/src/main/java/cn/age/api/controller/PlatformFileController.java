//package cn.age.api.controller;
//
//import cn.age.common.utils.alibaba.AliOssService;
//import cn.age.interaction.req.common.MultipleFileAccessUrlReq;
//import cn.age.interaction.resp.base.ApiResponse;
//import cn.age.interaction.resp.upload.AppFileUrlResp;
//import cn.age.interaction.resp.upload.MultipartFileUrlResp;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author Singer create by singer email:singer-coder@qq.com
// * @projectName aged-stage-api
// * @Description: 系统文件相关前端控制器
// * @date 2019-09-19
// */
//@RestController
//@RequestMapping("api/systemFile")
//public class PlatformFileController extends BaseApiController {
//
//
//    @Resource
//    private AliOssService aliOssService;
//
//
//
//    /**
//     * 拿到文件直接访问路径
//     * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-09-18
//     * @param fileNames
//     * @return ApiResponse
//     */
//    @GetMapping("/appFileAccessUrl")
//    @RequiresPermissions("file:accessUrl")
//    public ApiResponse<List<AppFileUrlResp>> appFileAccessUrl(@RequestParam(name = "fileNames") String fileNames){
//        return apiResponse(aliOssService.getObjectAccessUrlList(Arrays.asList(fileNames.split(","))));
//    }
//
//
//    /**
//     * 拿到单个文件名称的地址
//     * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-11-20
//     * @param fileName 文件名称
//     * @return String
//     */
//    @GetMapping("/singleFileAccessUrl")
//    public ApiResponse<String> singleFileAccessUrl(@RequestParam(name = "fileName")String fileName){
//        return apiResponse(aliOssService.getObjectAccessUrl(fileName));
//    }
//
//    /**
//     * 拿到多个文件名称的地址
//     * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-11-20
//     * @param multipleFileAccessUrlReq 文件名称集合
//     * @return String
//     */
//    @PostMapping("/multipleFileAccessUrl")
//    public ApiResponse<List<String>> multipleFileAccessUrl(@RequestBody @Valid MultipleFileAccessUrlReq multipleFileAccessUrlReq){
//        return apiResponse(aliOssService.getObjectAccessUrlList(multipleFileAccessUrlReq.getFileNameList()));
//    }
//
//    /**
//     * 拿到多个文件名称的地址
//     * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-11-20
//     * @param multipleFileAccessUrlReq 文件名称集合
//     * @return List
//     */
//    @PostMapping("/queryMultipleFileAccessUrl")
//    public ApiResponse<List<MultipartFileUrlResp>> queryMultipleFileAccessUrl(@RequestBody @Valid MultipleFileAccessUrlReq multipleFileAccessUrlReq){
//        return apiResponse(aliOssService.getObjectAccessUrlList(multipleFileAccessUrlReq.getFileNameList()));
//    }
//
//    /**
//     * 删除OSS的文件
//     * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-10-24
//     * @param name 删除OSS的文件
//     */
//    @DeleteMapping("/deleteFileByFileName")
//    public ApiResponse deleteFileByFileName(@RequestParam(name = "name") String name){
//        aliOssService.deleteObject(name);
//        return apiResponse();
//    }
//
//    /**
//     * 上传文件
//     * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-09-18
//     * @param file
//    //     * @return String
//
//     @PostMapping(value = "/uploadFile")
//     public ApiResponse<String> uploadFile(@RequestParam(name = "file") MultipartFile file){
//     return apiResponse(aliOssService.multipartFileToOss(file,false));
//     }
//
//     /**
//      * 上传文件
//      * @author: create by singer - Singer email:singer-coder@qq.com
//     * @date 2019-09-18
//     * @param file
//     * @return String
//     */
//    @PostMapping(value = "/uploadFileMixed")
//    public ApiResponse<String> uploadFileMixed(@RequestParam(name = "file") MultipartFile file){
//        return apiResponse(aliOssService.mixFileToOss(file,true));
//    }
//
//}
