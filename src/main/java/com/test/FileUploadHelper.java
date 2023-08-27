package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadHelper {
	public final String UPLOAD_DIR="C:\\Users\\furqan\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\RestApii\\src\\main\\resources\\static\\image";
     public boolean uploadFile(MultipartFile multipartFile) {
    	 boolean f = false;
    	 try {
			InputStream id = multipartFile.getInputStream();
			byte data[] = new byte[id.available()];
			id.read(data);
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
     }
}
