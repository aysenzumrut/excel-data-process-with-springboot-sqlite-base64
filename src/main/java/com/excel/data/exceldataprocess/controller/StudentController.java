package com.excel.data.exceldataprocess.controller;

import com.excel.data.exceldataprocess.entity.Student;
import com.excel.data.exceldataprocess.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/save") //EXCEL DOSYASINNI SQLITE DB YE KAYDET
    public ResponseEntity<String> saveExcel(@RequestParam ("file") MultipartFile file) {

        try {
            studentService.saveExcelToDB(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Excel saved successfully...");
    }

    @GetMapping("/getdata") //SQLITE A KAYDEDİLEN VERİLERİ GETİR
    public ResponseEntity<List<Student>> getDataFromDb() throws IOException{
        List<Student> students= studentService.getDataFromDB();
        return ResponseEntity.ok(students);
    }
}
