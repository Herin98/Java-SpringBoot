package Main.Rest;

import Main.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    /*//define end ppint for /students - return list of students
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        Student theStudent1 = new Student("Aikansh","Agarwal");
        Student theStudent2 = new Student("Ashish","Awasthi");

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(theStudent1);
        theStudents.add(theStudent2);

        return theStudents;
    }*/

    private List<Student> theStudents;

    //define @PostConstruct to load the student data ... only once.
    @PostConstruct
    public void loadData()
    {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Aikansh","Agarwal"));
        theStudents.add(new Student("Ashish","Awasthi"));
    }

    //define end ppint for /students/{studentId} - return student at given index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        //check the student id against the list size

        if(studentId>= theStudents.size() || studentId <0)
        {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        //index into the list

        return theStudents.get(studentId);

    }

   /* //add an exception handler using @ExceptionHandler        //commented out here to create a generic StudentRestExceptionHandler class(otherwise working code)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        //create a StudentErrorResponse object
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return responseentity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add another exception handler to catch any exception(generic exception)   //say we have entered alphabets instead of student id and so on.

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
    {
        //create a StudentErrorResponse object
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return responseentity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }*/

}
