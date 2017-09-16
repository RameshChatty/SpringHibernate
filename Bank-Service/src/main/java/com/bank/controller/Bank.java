/**
 * 
 */
package com.bank.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bank.service.Bankservice;

/**
 * 
 *
 */
@RestController
@RequestMapping(value="/bankcontroller")//RegisterCustomers
public class Bank {
	@Autowired
	private Bankservice bankservice;
	@RequestMapping(value="/RegisterCustomers",method=RequestMethod.POST)
	public @ResponseBody String RegisterCustomers(@RequestBody String data){
		System.out.println("data====="+data);
		bankservice.insertData(data);
		return "";
	}
	
	//uploadFiles
	@RequestMapping(value={"/uploadFiles"}, method = RequestMethod.POST)
	 @ResponseBody
	 public String upload(MultipartHttpServletRequest request /*@RequestBody MultipartFile file*/){
	    String responseMessage = "OK";
	    MultipartFile file = request.getFile("file");
	    System.out.println(request.getFiles("file"));
	    String param = request.getParameter("param");
	    try {
	        System.out.println(file.getOriginalFilename());
	        System.out.println(file.getInputStream());
	        System.out.println(file.getContentType());
	        System.out.println("some param = "+param);
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
	        // read filedfhdsjkghdkj
	        FileUtils.writeByteArrayToFile(new File("C:\\Users\\Rakesh Chatty\\Desktop\\temp."+FilenameUtils.getExtension(file.getOriginalFilename())), file.getBytes());
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	        responseMessage = "fail";
	    }
	     return responseMessage;
	}
}
