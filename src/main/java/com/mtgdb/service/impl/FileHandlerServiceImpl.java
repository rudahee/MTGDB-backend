package com.mtgdb.service.impl;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileHandlerServiceImpl {

	public Blob createBlob(MultipartFile file) {
		Blob blob = null;
		
		try {
			blob = new SerialBlob(file.getInputStream().readAllBytes());
		} catch (SQLException | IOException e) {
			System.out.println("Tengo que hacer el Logger!!");
		}
		return blob;
	}
}
