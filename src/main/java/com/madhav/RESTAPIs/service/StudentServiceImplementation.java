package com.madhav.RESTAPIs.service;

import com.madhav.RESTAPIs.dto.AddStudentRequestDto;
import com.madhav.RESTAPIs.dto.StudentDto;
import com.madhav.RESTAPIs.entity.Student;
import com.madhav.RESTAPIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentDto getStudentById(Long id) {
        Student student =studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id:" + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto , Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student , StudentDto.class);
    }

    @Override
    public StudentDto deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id:"+ id);
        }
        studentRepository.deleteById(id);
        return null;
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student =studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id:" + id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student =studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id:" + id));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        }
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }



}

