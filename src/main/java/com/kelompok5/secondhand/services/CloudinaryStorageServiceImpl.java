package com.kelompok5.secondhand.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kelompok5.secondhand.result.DataResult;
import com.kelompok5.secondhand.result.ErrorDataResult;
import com.kelompok5.secondhand.result.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service @RequiredArgsConstructor
public class CloudinaryStorageServiceImpl implements CloudinaryStorageService{
    private final Cloudinary cloudinary;

    @Override
    public DataResult<?> upload(MultipartFile multipartFile) {

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>();
        }

    }

    @Override
    public DataResult<?> delete(String publicIdOfImage) {
        return null;
    }
}
