package com.necl.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.necl.model.ReportAccident;
import com.necl.model.ReportLocation;
import com.necl.model.ReportType;
import com.necl.service.HandlerFileUpload;
import com.necl.service.ReportAccidentService;
import com.necl.service.ReportLocationService;
import com.necl.service.ReportTypeService;

@Controller
public class UploadFileController {

    private static final Logger LOGGER = Logger.getLogger(UploadFileController.class);
    
    @Autowired
    ReportAccidentService reportAccidentService;
    
    @Autowired
    HandlerFileUpload fileUploadService;
    
    @Autowired
    ReportLocationService reportLocationService;
    
    @Autowired
    ReportTypeService reportTypeService;
    
    @RequestMapping(value = "/uploadFileForm", method = RequestMethod.GET)
    public String uploadFile(ModelMap model) {
        model.addAttribute("reportAccident", new ReportAccident());
        return "admin/uploadFileForm";
    }
    
    @RequestMapping(value = "/saveUploadFile", method = RequestMethod.POST)
    public String saveUploadFile(@ModelAttribute("reportAccident") @Valid ReportAccident reportAccident,BindingResult result, ModelMap model)  {
        
    	model.addAttribute("message", "UPLOAD FILE SUCCESSFUL");
    	
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "admin/uploadFileForm";
        }
		
        try {
        	String fileName = reportAccident.getFile_data().getOriginalFilename();
        	System.out.println("file name" + fileName);
        	
        	fileUploadService.handleFileUploadToPath(reportAccident.getFile_data());
        	reportAccident.setFile_name(fileName);
//        	
			reportAccidentService.save(reportAccident);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR TO SAVE");
        	System.out.println(e);
			e.printStackTrace();
		}
       
		try {
			
			//ByteArrayInputStream xx = new ByteArrayInputStream(reportAccident.getFile_data().getBytes());
			System.out.println("START READ FILE");
			File file = new File("D:\\file\\test.xlsx");
			FileInputStream fis = new FileInputStream(file);
	       
			 System.out.println("READ FILE XSSF");
		    
			XSSFWorkbook book  = new XSSFWorkbook(fis);
			Row row = book.getSheetAt(0).getRow(1);
			System.out.println("OLD VALUE"+ row.getCell(2));
			row.getCell(2).setCellValue("TC201606001");
			System.out.println("NEW VALUE"+ row.getCell(2));
			 
			FileOutputStream os = new FileOutputStream(file);
			book.write(os);
			os.flush();
			os.close();
            fis.close();
			
		} 
        catch(Exception e){
        	System.out.println("ERROR TO READ");
        	System.out.println(e);
        }
        return "admin/uploadFileForm";
    }
    
    @ModelAttribute("report_type")
    public List<ReportType> initializeReportType() throws Exception {
		return reportTypeService.findAll();
    }
    @ModelAttribute("report_location")
    public List<ReportLocation> initializeReportLocation() throws Exception {
        return reportLocationService.findAll();
    }
    
}
