package com.tienda.mintic.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.io.IOException;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UpLoadController {

	
	private String filename;
	
	private static String UPLOADED_FOLDER = "/Users/javierenriquecharrismolina/Documents";
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		
		if(file.isEmpty())	{
			redirectAttributes.addFlashAttribute("message", "El archivo esta vacio!, Seleccione uno con información");
			return "redirect:/uploadStatus";
			
		}
		
		try {
			
			byte[] bytes = file.getBytes();
			
			filename = file.getOriginalFilename();
			
			Path path = Paths.get(UPLOADED_FOLDER+filename);
			
			Files.write(path, bytes);
			
			redirectAttributes.addFlashAttribute("message", "Archivo cargado exitosamente");
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		return "redirect:/uploadStatus";
				
	}
	
	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
	
	@GetMapping("/review")
	public String review(Map<String, Object> map) {
		
		map.put("filename", filename);
		String filetype = filename.split("\\.")[1];
		map.put("filetype", filetype);
		System.out.println(filename);
		
		if(filetype.equals("csv")) {
			readCSV read_csv = new readCSV(UPLOADED_FOLDER + filename);
			
			List<String> result = read_csv.read();
			
			
		}
		
		return "review";
		
	}
	
	
}
