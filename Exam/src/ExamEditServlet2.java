import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class ExamEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String egrade=request.getParameter("egradee");  
        String esubject=request.getParameter("esubject");  
        String elink=request.getParameter("elink");  
          
        Exam e=new Exam();  
        e.setId(id);  
        e.setEgrade(egrade);  
        e.setEsubject(esubject);  
        e.setElink(elink);  
          
        int status=ExamDao.update(e);  
        if(status>0){  
            response.sendRedirect("ExamViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}