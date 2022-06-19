package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.result.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryStorageService {
    DataResult<?> upload(MultipartFile multipartFile);
    DataResult<?>delete(String publicIdOfImage);
}
