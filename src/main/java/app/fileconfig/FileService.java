package app.fileconfig;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void upladFile(MultipartFile file) throws IOException;

    Resource loadFileAsResource(String fileName);

    String storeFile(MultipartFile file);

}
