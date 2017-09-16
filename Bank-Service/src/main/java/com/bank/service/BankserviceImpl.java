/**
 * 
 */
package com.bank.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.bank.dao.BankDao;
import com.bank.entity.CustomersData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ramesh chatty
 *
 */
@Service
@Configurable
public class BankserviceImpl implements Bankservice{
	@Autowired
	private BankDao bankDao;
	
	@Transactional
	public void insertData(String json) {
		ObjectMapper ob=new ObjectMapper();
		CustomersData customersdata=null;
		try {
			customersdata=ob.readValue(json, CustomersData.class);
			bankDao.addCustomer(customersdata);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
