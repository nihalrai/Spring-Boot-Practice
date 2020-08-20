package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.dto.CustomerDto;
import com.lti.dto.LoginDto;
import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;
import com.lti.service.CustomerService;
import com.lti.utility.LoginStatus;
import com.lti.utility.Status;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customeService;

	@PostMapping(path = "/register", consumes = "multipart/form-data", produces = "application/json")
	public Status register(@RequestPart("file") MultipartFile file, @RequestPart("obj") CustomerDto customerDto) {
		try {
			Customer customer = new Customer();
			
			BeanUtils.copyProperties(customerDto, customer);
			
			String ROOT_DIR = "/home/rai/Desktop/";
			String fileName = file.getOriginalFilename();
			String targetFile = ROOT_DIR + fileName;
			
			try {
				FileCopyUtils.copy(
						file.getInputStream(),
						new FileOutputStream(targetFile));
			} catch (IOException e) {
				e.printStackTrace();
				Status status = new Status();
				status.setMessage("Upload error occured!");
				status.setStatus(Status.StatusType.FAILURE);
				System.out.println("Hi");
				return status;
			}
			
			customer.setProfilePicPath(fileName);
			customeService.register(customer);

			Status status = new Status();
			status.setMessage("Registered successfully!");
			status.setStatus(Status.StatusType.SUCCESS);
			return status;

		} catch (Exception e) {
			e.printStackTrace();
			Status status = new Status();

			if (e instanceof CustomerServiceException) {
				status.setMessage(e.getMessage());
			} else {
				status.setMessage(e.getMessage());
			}

			status.setStatus(Status.StatusType.FAILURE);
			return status;
		}

	}

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginStatus login(@RequestBody LoginDto loginDto) {

		try {
			Customer customer = customeService.login(loginDto.getEmail(), loginDto.getPassword());
			LoginStatus status = new LoginStatus();
			status.setMessage("Login successfull!");
			status.setStatus(Status.StatusType.SUCCESS);
			status.setCustomerId(customer.getId());
			status.setName(customer.getName());
			return status;

		} catch (Exception e) {
			LoginStatus status = new LoginStatus();

			if (e instanceof CustomerServiceException) {
				e.printStackTrace();
				status.setMessage(e.getMessage());
			} else {
				e.printStackTrace();
				status.setMessage(e.getMessage());
			}

			status.setStatus(Status.StatusType.FAILURE);

			return status;
		}

	}

}
