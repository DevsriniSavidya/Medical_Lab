package com.lab.TestReportProducer;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;  

public class TestReportProducerIMP implements TestReportProducer {
	
	private ArrayList<TestReportModel> testrep;
	BufferedReader buffin  = new BufferedReader(new InputStreamReader(System.in));
	
	Scanner tst =new Scanner(System.in);

	//store data in string array
	private String[][] exhistingTestReports = {
			{"1","Sugar Test","Supun_Tharaka","6.8%","You have Diabetes","11/03/2022"},
			{"2","Lipid Test","Lakshan_Kavinda","150 mg/dL","Your test result is normal","15/02/2022"},
			{"3","Creatinine Test","Sahan_Peries","1.85 mg/dL","You have to take prevoius medicine","07/01/2022"},
			{"4","Urine Test","Pasindu_Mihiran","4.1 hpf","You have to drink more water","18/01/2022"},
			{"5","Antigen Test","Isuru_Chaminda","Positive","You have to self quarantine immediately","25/02/2022"}
			};
	
	//add string array data to arraylist when program run
	public TestReportProducerIMP(){
				
		
		testrep = new ArrayList<TestReportModel>();
		
		for(int i = 0; i < 5;i++) {
			TestReportModel testrepo = new TestReportModel(exhistingTestReports[i][0],exhistingTestReports[i][1],exhistingTestReports[i][2],exhistingTestReports[i][3],exhistingTestReports[i][4],exhistingTestReports[i][5]);
			testrep.add(testrepo);
		}
		
	}
	
	// add new test report 
	@Override
	public void addTestReport() {
		
		char check = 'y';
		int id = 6;
		
		System.out.println("======= Generate Test Report =======");
		
		while(check == 'y' || check == 'Y') {
			TestReportModel tstrpt = new TestReportModel();
			
			String nID = String.valueOf(id);
			
			tstrpt.setId(nID);
			
			System.out.print("Enter the name of the test that have been done : ");
			try {
				
				tstrpt.setTestName(buffin.readLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			System.out.print("Enter Patient name : ");
            try {
				
            	tstrpt.setPatientName(buffin.readLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			System.out.print("Enter the final output of the test : ");
			 try {
					
				 tstrpt.setTestStatus(buffin.readLine());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
			
			System.out.print("Enter a description about the test result: ");
			try {
				tstrpt.setDescription(buffin.readLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			tstrpt.setDate(dtf.format(now));
			
			try {
				
				testrep.add(tstrpt);
				
			}catch(Exception e) {
				
				e.printStackTrace();
				System.out.println("Error occured while generating the test report. Please try again.");
			}
			
			System.out.println("Do you want to create another test report?(Y/N)");
			try {
				
				check = (char) buffin.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// = tst.next().charAt(0);
			id = id +1;
		}
		
	}
     
	//display test reports
	@Override
	public void viewTestReports() {
		
		System.out.println("1.View selected test report");
		System.out.println("2.View all test reports");
		System.out.println("Select option : ");
		int ans = tst.nextInt();
		
		if (ans == 1) {
			
			String searchnme;
				
			System.out.println("Enter test report ID or Patient name: ");
			searchnme = tst.next();
			
			
			
			//display specific testReport details
			for(TestReportModel tstrept: testrep) {
				
				if((tstrept.getId().equalsIgnoreCase(searchnme)) || (tstrept.getPatientName().equalsIgnoreCase(searchnme))) {
					
					System.out.println("Details about the selected test report");
					System.out.println("================================");
					System.out.println("                                ");
					System.out.println("Test ID \t: " +tstrept.getId());
					System.out.println("Test Name \t: " +tstrept.getTestName());
					System.out.println("Patient Name \t: " +tstrept.getPatientName());
					System.out.println("Test Status \t: " +tstrept.getTestStatus());
					System.out.println("Description \t: " +tstrept.getDescription());
					System.out.println("Test Date \t: " +tstrept.getDate());
					System.out.println("                                ");
					System.out.println("================================");
					
				}
				
			}
		
			}
			
		else {
		
		//display all test reports
		System.out.println("All the test reports");
		System.out.println("================================");
		
		for(TestReportModel testr: testrep) {
			System.out.println("                                ");
			System.out.println("Test ID \t: " +testr.getId());
			System.out.println("Test Name \t: " +testr.getTestName());
			System.out.println("Patient Name \t: " +testr.getPatientName());
			System.out.println("Test Status \t: " +testr.getTestStatus());
			System.out.println("Description \t: " +testr.getDescription());
			System.out.println("Test Date \t: " +testr.getDate());
			
			System.out.println("================================");
			
		}
		
	}
}
}