/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necl.service;

import com.necl.model.ConfigSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author C13.207
 */
@Service
public class HandlerFileUpload {

	@Autowired
	ConfigSystemService configSystemService;

	public void handleFileUploadToPath(CommonsMultipartFile fileUpload) throws Exception {

		String saveDirectory = "D://file";

		if (fileUpload != null && fileUpload.getSize() > 0) {

			String newFileName = "";
			newFileName = convertNameAndTypeFile(fileUpload.getOriginalFilename());

			File files = new File(saveDirectory + File.separator + newFileName);
			if (!files.exists()) {
				files.mkdirs();
			}
			fileUpload.transferTo(files);

		}
		System.out.println("SYSTEM ALEART UPLOAD FILE SUCCESSFUL");
	}

	public void handleFileUploadToPathForm(CommonsMultipartFile fileUpload) throws Exception {

		String saveDirectory = "D://file/test";

		if (fileUpload != null && fileUpload.getSize() > 0) {

			String newFileName = "";
			newFileName = convertNameAndTypeFile(fileUpload.getOriginalFilename());

			File files = new File(saveDirectory + File.separator + newFileName);
			if (!files.exists()) {
				files.mkdirs();
			}
			fileUpload.transferTo(files);
			System.out.println("save file at ");
		}
		System.out.println("SYSTEM ALEART UPLOAD FILE SUCCESSFUL");
	}
	//Function copy file in Java
	public void handleFileToCopy(String source,String target,String fileName) throws Exception {
        
//		source = "D:/file/New.xlsx";
//      target ="D:/file/test/";
      
        //name of source file
        File sourceFile = new File(source);
        //String name = sourceFile.getName();
      
        File targetFile = new File(target+fileName);
        //System.out.println("Copying file : " + sourceFile.getName() +" from Java Program");
      
        //copy file from one location to other
        FileUtils.copyFile(sourceFile, targetFile);
      
        System.out.println("copying of file from Java program is completed");
	}
	
	//Function move file in Java
		public void handleFileToMove(String source,String target) throws Exception {
	
			source = "D:/file/New.xlsx";
	        target ="D:/file/test/";
	        
			File afile = new File("D:\\file\\test.xlsx");

			if (afile.renameTo(new File("D:\\file\\test\\" + afile.getName()))) {
				System.out.println("File is moved successful!");
			} else {
				System.out.println("File is failed to move!");
			}
		}
		
	
	
	private String convertNameAndTypeFile(String originName) {

		String newName = originName.replace("/", "_");
		System.out.println(" newName : "+newName);
		return newName;
	}

	
	

}
