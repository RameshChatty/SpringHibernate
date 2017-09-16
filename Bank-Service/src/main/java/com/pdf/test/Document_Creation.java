package com.pdf.test;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Document_Creation {
public static void main(String[] args) {
	//Creating PDF document object 
     
    //Saving the document
    try {
    	File file = new File("E:/PdfBox_Examples/sample.pdf"); 
        PDDocument document = PDDocument.load(file); 
          
        System.out.println("PDF loaded"); 
          
        //Adding a blank page to the document 
        document.addPage(new PDPage());  

        //Saving the document 
        document.save("E:/PdfBox_Examples/sample.pdf");

          
	    //Closing the document  
	    document.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
    

}
}
