package com.necl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.necl.model.ReportAccident;
import com.necl.model.ReportLocation;
import com.necl.model.ReportType;
import com.necl.service.GenerateReportNo;
import com.necl.service.HandlerFileUpload;
import com.necl.service.ReportAccidentService;
import com.necl.service.ReportLocationService;
import com.necl.service.ReportTypeService;

@Controller
public class DownloadFileFormController {

	private static final Logger LOGGER = Logger.getLogger(DownloadFileFormController.class);

	@Autowired
	ReportAccidentService reportAccidentService;

	@Autowired
	ReportLocationService reportLocationService;

	@Autowired
	ReportTypeService reportTypeService;

	@Autowired
	HandlerFileUpload fileUploadService;
	
	@Autowired
	GenerateReportNo generateReportNo;
	
	@RequestMapping(value = "/downloadFileForm", method = RequestMethod.GET)
	public String downloadFileFrom(ModelMap model) {
		model.addAttribute("reportAccident", new ReportAccident());
		return "admin/downloadFileForm";
	}

	@RequestMapping(value = "/downloadFileForm1", method = RequestMethod.GET)
	public void downloadFileFrom(ModelMap model,HttpServletResponse response,@RequestParam String partFile) {
		System.out.println(partFile);
		File file = new File("D:\\file\\test\\"+partFile);	
		System.out.println("file.getName() " + file.getName());
	    if(!file.exists()){
	        String errorMessage = "Sorry. The file you are looking for does not exist";
	        System.out.println(errorMessage);
	        OutputStream outputStream;
			try {
				outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				 outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	       
	        return;
	    }
	     
	    String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	    System.out.println("mimeType " + mimeType);
	    if(mimeType==null){
	        System.out.println("mimetype is not detectable, will take default");
	        mimeType = "application/octet-stream";
	    }
	     
	    System.out.println("mimetype : "+mimeType);
	     
	    response.setContentType(mimeType);
	     
	    /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
	        while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
	    //response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

	     
	    /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
	    response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	     
	    response.setContentLength((int)file.length());

	    InputStream inputStream;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	@RequestMapping(value = "/saveDownloadFileForm",method = RequestMethod.POST)
	@ResponseBody 
	public Map<String, Object> saveDownloadFileForm(@ModelAttribute("reportAccident") ReportAccident reportAccident,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value = "reportName") String reportName,
			@RequestParam(value = "reportType") String reportType,
			@RequestParam(value = "reportLocation") String reportLocation) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
		}

		
		// Insert Report Number in to Excel File
		System.out.println("---Start Insert Report Number in to Excel File---");
		String directoryFile = "D:\\file\\New.xlsx";
		File files = new File(directoryFile);
		
		String fileName ="";
		try {
			String reportNo = generateReportNo.generateReportNo(reportLocation);
			
			Calendar calendar = Calendar.getInstance(Locale.getDefault());
			String strYear = Integer.toString(calendar.YEAR);
			String strMonth = Integer.toString(calendar.MONTH);
			String strDate = Integer.toString(calendar.DATE);
			reportAccident.setFile_name(reportNo+".xlsx");
			reportAccident.setReport_date(strDate);
			reportAccident.setReport_month(strMonth);
			reportAccident.setReport_year(strYear);
			reportAccident.setReport_no(reportNo);
			reportAccident.setReport_name("Flat Report");
			reportAccident.setReport_name(reportName);
			reportAccident.setReportType(reportType);
			reportAccident.setReportLocation(reportLocation);
								
			reportAccidentService.save(reportAccident);
			
			System.out.println("START READ FILE");

			FileInputStream fis = new FileInputStream(files);

			System.out.println("READ FILE XSSF");

			XSSFWorkbook book = new XSSFWorkbook(fis);
			Row row = book.getSheetAt(0).getRow(1);
			System.out.println("OLD VALUE" + row.getCell(2));
			row.getCell(2).setCellValue(reportNo);
			System.out.println("NEW VALUE" + row.getCell(2));

			FileOutputStream os = new FileOutputStream(files);
			
			book.write(os);
			os.flush();
			os.close();
			fis.close();
			
			String source = "D:/file/New.xlsx";
			String target ="D:/file/test/";
			fileName = reportNo+".xlsx";
			fileUploadService.handleFileToCopy(source, target, fileName);
			
		} catch (Exception e) {
			System.out.println("ERROR TO READ");
			System.out.println(e);
		}

		System.out.println("---End Insert Report Number in to Excel File---");

	
	
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("map_fileName", fileName);
	
		System.out.println("SUCCESSFUL FUCTION");
		
		return map;
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
