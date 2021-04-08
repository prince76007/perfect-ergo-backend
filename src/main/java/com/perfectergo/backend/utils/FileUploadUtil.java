package com.perfectergo.backend.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String photoName,MultipartFile photo) throws IOException {
		String pathString = "upload-photo";
		Path path = Paths.get(pathString);
		if(!Files.exists(path)) {
			Files.createDirectories(path);
		}
		
		try {
			InputStream inputStream= photo.getInputStream();
			Path photoPath = path.resolve(photoName);
			Files.copy(inputStream,photoPath,StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
