package testng.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApachePDFBox {


	
	@Test
	public  void pdfReader() throws IOException {

		File file=new File("C:\\Users\\hp\\Downloads\\SQL.pdf");
		FileInputStream pdfFile=new FileInputStream(file);  

		PDDocument pdfDocument= PDDocument.load(pdfFile);
		System.out.println("Pdf Page Count--> "+pdfDocument.getNumberOfPages()+"\n");
		
		PDFTextStripper pdfTextStripper=new PDFTextStripper();
		pdfTextStripper.setStartPage(2);
		pdfTextStripper.setEndPage(2);
	    String docText=	pdfTextStripper.getText(pdfDocument);
		System.out.println(docText);
		
//		Assert.assertTrue(docText.startsWith("Lorem ipsum"));
	    
		pdfDocument.close();
		pdfFile.close();
		
		
	}

}
