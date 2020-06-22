package com.codegym.student.controller;

import com.codegym.student.model.Student;
import com.codegym.student.service.IStudentService;
import com.codegym.student.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                showDeleteForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "create":
                showCreateStudent(request, response);
                break;
            case "view":
                viewStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateStudent(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.studentService.remove(id);
            try {
                response.sendRedirect("/students");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            student.setName(name);
            student.setEmail(email);
            student.setAddress(address);
            this.studentService.update(id, student);
            request.setAttribute("student", student);
            request.setAttribute("message", "Student information was updated");
            dispatcher = request.getRequestDispatcher("student/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        //lấy dữ liêu
        List<Student> students = this.studentService.findAll();
        request.setAttribute("studentList", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int) (Math.random() * 10000);

        Student student = new Student(id, name, email, address);
        this.studentService.save(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
