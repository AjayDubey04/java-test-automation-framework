package com.vtiger.test.listners;

import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class CustomReporter  implements IReporter {

	/*
	 * IReporter in TestNG is an interface that allows you to create custom test
	 * reports based on the results of your test suite. It provides a way to
	 * generate more detailed and customized reports compared to the default TestNG
	 * reports. The IReporter interface is particularly useful when you need to
	 * tailor your test reports to specific requirements or integrate TestNG with
	 * other reporting tools.
	 */


	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for (ISuite suite : suites) {
			String suiteName = suite.getName();

			System.out.println("Suite: " + suiteName);
			
			String extentReportPath = "src\\test\\resources\\extentReport\\ExtentQA.html";
	        String pdfOutputPath = "src\\test\\resources\\extentReport\\extent-report.pdf";

			convertExtentReportToPdf(extentReportPath,pdfOutputPath);
		}  


	}

	public static void convertExtentReportToPdf(String extentReportPath, String pdfOutputPath) {
		try {
			// Read HTML content from the Extent Report file
			String extentReportContent = FileUtils.readFileToString(new File(extentReportPath), "UTF-8");

			// Create a Document
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, new FileOutputStream(pdfOutputPath));

			// Open the Document for writing
			document.open();

			// Add the HTML content to the Document
			document.addAuthor("Your Name");
			document.addTitle("Extent Report PDF");

			// Parse the HTML content and add it to the PDF
//			PdfConverter.convertToPdf(extentReportContent, document, null);

			// Close the Document
			document.close();

			System.out.println("PDF report generated successfully.");

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


