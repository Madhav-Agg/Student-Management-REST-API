package com.madhav.RESTAPIs.service;

import com.madhav.RESTAPIs.dto.AddStudentRequestDto;
import com.madhav.RESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {


    public StudentDto getStudentById(Long id);
    public StudentDto deleteStudentById(Long id);
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
    List<StudentDto> getAllStudents();


    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
}
