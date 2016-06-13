package com.necl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necl.model.ConfigReportNo;

@Service
public class GenerateReportNo {
	
	@Autowired
	ConfigReportService configReportService;
	
	public String generateReportNo(String key) {
		String reportNo = null;
		ConfigReportNo congihReportNo  = new ConfigReportNo();
		try {
			congihReportNo = configReportService.findByKey(key);
			String configReportPrefix = congihReportNo.getReportPrefix();
			String configReportDesc = congihReportNo.getReportDesc();
			int configReportNo = Integer.parseInt(congihReportNo.getReportNo());
			System.out.println(configReportPrefix);
			System.out.println(configReportDesc);
			configReportNo++;
			System.out.println(configReportNo);
		
			
			String configReportNoStrFinal =String.format("%05d",configReportNo);
			System.out.println(configReportPrefix);
			System.out.println(configReportDesc);
			System.out.println(configReportNoStrFinal);
			reportNo = configReportDesc+configReportPrefix+configReportNoStrFinal;
			System.out.println("Generate Report No : "+reportNo);
			congihReportNo.setReportNo(configReportNoStrFinal);
			configReportService.update(congihReportNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return reportNo;
	}
	
}
