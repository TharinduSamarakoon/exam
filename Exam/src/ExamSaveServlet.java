import java.io.IOException;  



import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ExamSaveServlet")  
public class ExamSaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String egrade=request.getParameter("egrade");  
        String esubject=request.getParameter("esubject");  
        String elink=request.getParameter("elink");  
          
        Exam e=new Exam();  
        e.setEgrade(egrade);  
        e.setEsubject(esubject);  
        e.setElink(elink);  

        int status=ExamDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("exam.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}