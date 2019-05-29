package controller;

import dao.ScheduleDao;
import dao.StudentDao;
import dao.UniversityDao;
import dao.implement.ScheduleDaoImpl;
import dao.implement.StudentDaoImpl;
import dao.implement.TestDaoImplement;
import dao.implement.UniversityDaoImpl;
import model.Schedule;
import model.Student;
import model.Test;
import model.University;
import service.ScheduleService;
import service.StudentService;
import service.UniversityService;
import service.implement.ScheduleServiceImpl;
import service.implement.StudentServiceImpl;
import service.implement.UniversityServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "quiz-images";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;
    private static final int REQUEST_SIZE = 1024 * 1024 * 50;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        String action = null;
        String address = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);
        UniversityDao universityDao = new UniversityDaoImpl();
        UniversityService universityService = new UniversityServiceImpl(universityDao);
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        ScheduleService scheduleService = new ScheduleServiceImpl(scheduleDao);

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        try {
            if (action.equalsIgnoreCase("getStudentList")) {
                List<Student> studentList = studentDao.getStudentList();
                request.setAttribute("studentList", studentList);
                address = "WEB-INF/pages/studentList.jsp";
            } else if (action.equalsIgnoreCase("addStudent")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String date = request.getParameter("date");
                Date parsedDate = dateFormat.parse(date);
                Student student = new Student();
                student.setName(name);
                student.setSurname(surname);
                student.setEmail(email);
                student.setBirthdate(parsedDate);
                studentService.addStudent(student);
            } else if (action.equalsIgnoreCase("universityList")) {
                address = "WEB-INF/parsedViews/fillUniversity.jsp";
                List<University> universityList = universityService.getUniversityList();
                request.setAttribute("universityList", universityList);
            } else if (action.equalsIgnoreCase("getScheduleList")) {
                address = "WEB-INF/pages/scheduleList.jsp";
                List<Schedule> scheduleList = scheduleService.getScheduleList();
                request.setAttribute("scheduleList", scheduleList);
            } else if (action.equalsIgnoreCase("addSchedule")) {
                String studentName = request.getParameter("studentName");
                String studentSurname = request.getParameter("studentSurname");
                String studentEmail = request.getParameter("studentEmail");
                String studentDate = request.getParameter("studentDate");
                String universityId = request.getParameter("universityId");
                Date parsedDate = dateFormat.parse(studentDate);
                Student student = new Student();
                student.setName(studentName);
                student.setSurname(studentSurname);
                student.setEmail(studentEmail);
                student.setBirthdate(parsedDate);
                long lastStudentId = studentService.addStudent(student);
                if (lastStudentId > 0) {
                    student.setId(lastStudentId);
                } else {
                    System.out.println("Problem in student add process");
                }
                University university = new University();
                university.setId(Integer.parseInt(universityId));
                Schedule schedule = new Schedule();
                schedule.setStudent(student);
                schedule.setUniversity(university);
                scheduleService.addSchedule(schedule);
//  *-*-*-*-*-*-*-*-*-*-*-*-*   Test image *-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
            } else if (action.equalsIgnoreCase("addTest")) {
                String name = request.getParameter("testName");
                String imagePath = request.getParameter("imagePath");
                Test test = new Test();
                test.setName(name);
                test.setImage(imagePath);
                TestDaoImplement testDaoImplement = new TestDaoImplement();
                testDaoImplement.addTest(test);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (address != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    }
}
