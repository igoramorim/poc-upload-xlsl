package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UploadService;

@RestController
@RequestMapping(value = "api")
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/upload")
	public String upload(@RequestParam(name = "file") MultipartFile file) {
		try {
			uploadService.upload(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "OK";
	}

}
