package com.example.demo.service.Student;

import com.example.demo.model.dto.dtoRequest.StudentRequest;
import com.example.demo.model.dto.dtoResponse.StudentResponse;
import com.example.demo.model.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<StudentResponse> findAll(Pageable pageable) {
        Page<Student> students= studentRepository.findAll(pageable);
        return students.map(new Function<Student, StudentResponse>() {
            @Override
            public StudentResponse apply(Student student) {
                return modelMapper.map(student,StudentResponse.class);
            }
        });
    }

    @Override
    public StudentResponse findById(Long id) {
        if (studentRepository.findById(id).isPresent()){
            Student student = studentRepository.findById(id).get();
            return modelMapper.map(student,StudentResponse.class);
        }
        return null;
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = modelMapper.map(studentRequest,Student.class);
        try{
            studentRepository.save(student);
            return modelMapper.map(student,StudentResponse.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StudentResponse removeById(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return modelMapper.map(student,StudentResponse.class);
    }

    @Override
    public List<StudentResponse> searchByName(String name) {
        List<Student> students = studentRepository.findAllByNameContaining(name);
        List<StudentResponse> studentResponses = null;
        for (Student student: students) {
            StudentResponse studentResponse = modelMapper.map(student,StudentResponse.class);
            studentResponses.add(studentResponse);
        }
        return studentResponses;
    }
}
