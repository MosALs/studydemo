package app.fileconfig;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImp implements FileService {


	private final Path fileStorageLocation;



	@Autowired
	public FileServiceImp(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
				.toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}

    @Value("${file.upload-dir}")
    private String uploadDir;

	@Override
	public void upladFile(MultipartFile file) throws IOException {

		 Path copyLoaction = Paths.get(uploadDir +  File.separator + StringUtils.cleanPath(
	                file.getOriginalFilename()
	        ));
	        Files.copy(file.getInputStream(),copyLoaction, StandardCopyOption.REPLACE_EXISTING);
	        System.out.println("uploaded ...");
	        
	}

	@Override
	public Resource loadFileAsResource(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

//	public Resource loadFileAsResource(String fileName) {
//		try {
//			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
//			Resource resource = (Resource) new UrlResource(filePath.toUri());
//			if(resource.exists()) {
//				return resource;
//			} else {
//				throw new MyFileNotFoundException("File not found " + fileName);
//			}
//		} catch (MalformedURLException ex) {
//			throw new MyFileNotFoundException("File not found " + fileName, ex);
//		}
//	}
	
}
