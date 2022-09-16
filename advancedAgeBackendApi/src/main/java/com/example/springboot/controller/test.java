package com.example.springboot.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.service.AdvancedAgeBaseService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController 
public class test { 
	
	@Autowired
	AdvancedAgeBaseService advancedAgeBaseService;
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String dealTest(@RequestBody AdvancedAgeApply apply) { 
		return "hi ,"+apply.getCompanyName(); 
	} 
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String dealTest1(@RequestParam(value="name", defaultValue="World") String name){ 
		return "hi ,"+name;
	} 
	
	@ApiOperation(value = "测试swagger3上传", notes = "测试swagger3上传")
	@ApiImplicitParams({
	        @ApiImplicitParam(name = "file", paramType="form", value = "臨時文件", dataType="file", required = true),
	        @ApiImplicitParam(name="userId", value="用户ID", dataTypeClass = Integer.class, required = true)
	})
	@RequestMapping(value = "/update_avatar", method = RequestMethod.POST)
	public String updateAvatar(Integer userId, @RequestPart("file") MultipartFile file) throws Exception {
	    // TOTO. LOGIC.
	    return file.getName();
	}
	
	// 有檔案上傳時要用@ApiParam，用法基本與@ApiImplicitParam一樣，不過@ApiParam用在引數上
    // 或者你也可以不註解，swagger會自動生成說明
    @ApiOperation(value = "上傳檔案",notes = "上傳檔案")
    @PostMapping(value = "/upload")
    public String upload(@ApiParam(value = "圖片檔案", required = true)MultipartFile uploadFile){
        String originalFilename = uploadFile.getOriginalFilename();

        return originalFilename;
    }
    

    // 多個檔案上傳時，**swagger只能測試單檔案上傳**
    @ApiOperation(value = "上傳多個檔案",notes = "上傳多個檔案")
    @PostMapping(value = "/upload2",consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public String upload2(@RequestParam("uploadFile")MultipartFile[] uploadFile){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < uploadFile.length; i++) {
            System.out.println(uploadFile[i].getOriginalFilename());
            sb.append(uploadFile[i].getOriginalFilename());
            sb.append(",");
        }
        return sb.toString();
    }
    
    // 既有檔案，又有引數
    @ApiOperation(value = "既有檔案，又有引數",notes = "既有檔案，又有引數")
    @PostMapping(value = "/upload3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",
                    value = "圖片新名字",
                    required = true
            )
    })
    public String upload3(@ApiParam(value = "圖片檔案", required = true)MultipartFile uploadFile,
                          String name){
        String originalFilename = uploadFile.getOriginalFilename();

        return originalFilename+":"+name;
    }
}
