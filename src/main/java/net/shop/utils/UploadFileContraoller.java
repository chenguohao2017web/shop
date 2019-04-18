package net.shop.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileContraoller {
	
	
	  @Value("${web.upload-path}") 
	  private String dest;
	 
	
	
	  @PostMapping("/upload/file") public Object uploadFile(@RequestParam("file")
	  MultipartFile file) throws FileNotFoundException {
	  
	  String fileName = String.valueOf(new Date().getTime()); File file1 = new
	  File(dest,fileName + ".jpg"); try { file.transferTo(file1); } catch
	  (IllegalStateException | IOException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return null; }
	 
	
}
