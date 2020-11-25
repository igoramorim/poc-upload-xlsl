package com.example.demo.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Aluno;

@Service
public class UploadService {

	public void upload(MultipartFile file) throws IOException {
		InputStream inputStream = new BufferedInputStream(file.getInputStream());

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();

		List<Aluno> listaAlunos = new ArrayList<>();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			Aluno aluno = new Aluno();
			listaAlunos.add(aluno);
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					aluno.setNome(cell.getStringCellValue());
					break;
				case 1:
					aluno.setRA(String.valueOf(cell.getNumericCellValue()));
					break;
				case 2:
					aluno.setNota1(cell.getNumericCellValue());
					break;
				case 3:
					aluno.setNota2(cell.getNumericCellValue());
					break;
				case 4:
					aluno.setMedia(cell.getNumericCellValue());
					break;
				}
			}
		}
		inputStream.close();
		
		for (Aluno aluno : listaAlunos) {
			System.out.println(aluno);
		}
	}

}
