package com.livvy.Rxjava;

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class LoadApp {
    public static void main(String[] args) {
        Student student = new Student("livvy", 23);
        Student student1 = new Student("livvy", 24);
        Student student2 = new Student("livvy", 25);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);

        printStudent(student, student1, student2);
    }


    public static void printStudent(Student one, Student two, Student three) {
        Observable.just(one, two, three).repeat(3).subscribe(new Observer<Student>() {
            @Override
            public void onCompleted() {
                System.out.println("end of student");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.toString());
            }

            @Override
            public void onNext(Student student) {
                System.out.println(student.toString());
            }
        });
    }


}
