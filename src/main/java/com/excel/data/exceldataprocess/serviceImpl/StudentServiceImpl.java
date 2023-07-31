package com.excel.data.exceldataprocess.serviceImpl;

import com.excel.data.exceldataprocess.base64.Base64Util;
import com.excel.data.exceldataprocess.entity.Student;
import com.excel.data.exceldataprocess.repository.StudentRepository;
import com.excel.data.exceldataprocess.service.StudentService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    List<Student> studentList = new ArrayList<>();

    @Override
    public void saveExcelToDB(MultipartFile file) throws IOException {

        Workbook workbook = new XSSFWorkbook(file.getInputStream()); //POI ILE EXCEL DOSYASINI OKUYORUZ
        Sheet sheet = workbook.getSheetAt(0);//EXCEL DOSYASINDAKI ILK SAYFAYI ALIYORUZ


        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; //ILK SATIRDA BASLIKLAR OLDUGU ICIN BU SATIRI ATLIYORUZ
            }

            Long id = (long) row.getCell(0).getNumericCellValue();

            String name = row.getCell(1).getStringCellValue();

            Long no = (long) row.getCell(2).getNumericCellValue();

            String gender = row.getCell(3).getStringCellValue();

            String tc = row.getCell(4).getStringCellValue();
            String encodedTc = Base64Util.encode(String.valueOf(tc));
            System.out.println(encodedTc);

            Student student = new Student(id, name, no, gender, encodedTc); //YENI OBJE OLUSTURDUK OKUDUGUMUZ VERILERI ICINE ATMAK ICIN
            studentList.add(student);
        }
        studentRepository.saveAll(studentList);
        workbook.close();
    }


    @Override
    public List<Student> getDataFromDB() throws IOException {

        List<Student> students1 = studentRepository.findAll();

        for (Student student : students1) {
            //DB YE ŞİFRELİ KAYDEDİLEN VERİYİ ÇÖZMEK İÇİN
            String encodedTc = student.getTc();
            String decodedTcs = Base64Util.decode(encodedTc);
            student.setTc(decodedTcs);
        }

        return studentRepository.findAll();

        //return studentRepository.findAll(); //ŞİFRELİ ŞEKLİYLE GÖRÜNTÜLEMEK İSTERSEK
    }


}
