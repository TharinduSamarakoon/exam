    import java.util.*;  

    import java.sql.*;  
      
    public class ExamDao {  
      
        public static Connection getConnection(){  
            Connection con=null;  
            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_management","root","Money$$1234");  
            }catch(Exception e){System.out.println(e);}  
            return con;  
        }  
        public static int save(Exam e){  
            int status=0;  
            try{  
                Connection con=ExamDao.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into exams(egrade,esubject,elink) values (?,?,?,?)");  
                ps.setString(1,e.getEgrade());  
                ps.setString(2,e.getEsubject());  
                ps.setString(3,e.getElink());    
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(Exam e){  
            int status=0;  
            try{  
                Connection con=ExamDao.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update exams set egrade=?,esubject=?,elink=? where id=?");  
                ps.setString(1,e.getEgrade());  
                ps.setString(2,e.getEsubject());  
                ps.setString(3,e.getElink());  
                ps.setInt(4,e.getId());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int id){  
            int status=0;  
            try{  
                Connection con=ExamDao.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from exams where id=?");  
                ps.setInt(1,id);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static Exam getExamById(int id){  
            Exam e=new Exam();  
              
            try{  
                Connection con=ExamDao.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from exams where id=?");  
                ps.setInt(1,id);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    e.setId(rs.getInt(1));  
                    e.setEgrade(rs.getString(2));  
                    e.setEsubject(rs.getString(3));  
                    e.setElink(rs.getString(4));
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return e;  
        }  
        public static List<Exam> getAllExams(){  
            List<Exam> list=new ArrayList<Exam>();  
              
            try{  
                Connection con=ExamDao.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from exams");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    Exam e=new Exam();  
                    e.setId(rs.getInt(1));  
                    e.setEgrade(rs.getString(2));  
                    e.setEsubject(rs.getString(3));  
                    e.setElink(rs.getString(4));   
                    list.add(e);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  