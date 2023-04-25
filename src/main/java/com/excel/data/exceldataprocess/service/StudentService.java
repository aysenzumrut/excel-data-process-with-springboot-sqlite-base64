package com.excel.data.exceldataprocess.service;

import com.excel.data.exceldataprocess.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    void saveExcelToDB(MultipartFile file) throws IOException;

    List<Student> getDataFromDB() throws IOException;


}
