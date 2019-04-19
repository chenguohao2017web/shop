package net.shop.common.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.shop.result.JsonResult;

@RestController
public class UploadFileContraoller {

	@Value("${web.upload-path}")
	private String dest;

	@PostMapping("/upload/file")
	public Object uploadFile(@RequestParam("file") MultipartFile file){
		String newName = null;
		try {
		long currentTimeMillis = System.currentTimeMillis();
		newName = UUID.randomUUID().toString() + String.valueOf(currentTimeMillis) + ".jpg";
		File newFile = new File(dest, newName);
			file.transferTo(newFile);
			
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JsonResult.success("/upload/" + newName);
	}

}
