/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JavaConnector {
        public int year;
        public int month;
        public String quarter;
        
        private static String URL ;
	private Connection connection;

        private String dbUserName;
        private String dbPassword;
	private String studentID;
        
        public String getdbUserName(){
            return dbUserName;
        }
        public String getdbPassword(){
            return dbPassword;
        }
        public String getdbURL(){
            return URL;
        }
        public String getStudentID(){
            return studentID;
        }
        
        public void setStudentID(String studentID){
            this.studentID = studentID;
        }
	
	public JavaConnector(String dbUserName, String dbPassword, String URL){
		this.URL = URL;
                this.dbUserName = dbUserName;
                this.dbPassword = dbPassword;
	}
	
	public boolean connect(String url, String userID, String password){
		try{
			connection = DriverManager.getConnection(url,userID, password);
			System.out.println("Connection to " + URL + " has establisthed.");
			return true;
		}
		catch(SQLException except) {
			System.out.println(except.getMessage());
			return false;
		}
	}
	
	public boolean login(String UserName, String password) throws SQLException{
		String sql = "call login(?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.clearParameters();
		pstmt.setString(1, UserName);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
	
		if (!rs.next()){
			System.out.println("StudentID or Password does not match!");
			return false;
		}
		this.studentID = rs.getString(1);
                System.out.println("Student ID is" + this.studentID);
		System.out.println("You have sucessfully logged in!");
		return true;
	}
        
        public List<course> getCurrentCources(String StudentID, int year, String quarter) throws SQLException{
               String sql = "call currentCourses(?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.clearParameters();
                pstmt.setString(1,studentID);
                pstmt.setInt(2,year);
                pstmt.setString(3, quarter);
                ResultSet rs = pstmt.executeQuery();
                List<course> courses = new ArrayList<>();
                while (rs.next()){
                    courses.add(new course(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }
                return courses;
        }
        
        public List<courseGrade> getTranscript() throws SQLException{
                String sql = "call transcript(?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.clearParameters();
                pstmt.setString(1,studentID);
                ResultSet rs = pstmt.executeQuery();
                List<courseGrade> courseGrades = new ArrayList<>();
                while (rs.next()){
                    course thisCourse = new course(rs.getString(1), rs.getString(2), rs.getInt(3));
                    courseGrades.add(new courseGrade(thisCourse,rs.getString(4)==null?"Not Yet":rs.getString(4)));
                }
                return courseGrades;
        }
        
        public courseDetails getCourseDetails(String UosCode, String semester, int year) throws SQLException{
                String sql = "call courseDetail(?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.clearParameters();
                pstmt.setString(1,studentID);
                pstmt.setString(2,UosCode);
                pstmt.setString(3,semester);
                pstmt.setInt(4,year);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                return new courseDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)==null?"Not Yet":rs.getString(8), rs.getString(9));
        }
        
        public List<courseDetails> getAllCourses(int year, String thisQuarter, String nextQuarter) throws SQLException {
                String sql = "call AllCourses(?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.clearParameters();
                pstmt.setInt(1,year);
                pstmt.setString(2,thisQuarter);
                pstmt.setString(3,nextQuarter);
                pstmt.setString(4,studentID);
                ResultSet rs = pstmt.executeQuery();
                
                List<courseDetails> courses = new ArrayList<>();
                while (rs.next()){
                    courses.add( new courseDetails(null,rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),null, rs.getString(7)));
                }
                return courses;
        }
        
        public List<course> Enroll(String classNum, String requiredQuarter, int requiredYear) throws SQLException{
                String sql = "call Enroll(?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.clearParameters();
                pstmt.setString(1,studentID);
                pstmt.setString(2,classNum);
                pstmt.setString(3,requiredQuarter);
                pstmt.setInt(4,requiredYear);
                ResultSet rs = pstmt.executeQuery();
                
                List<course> courses = new ArrayList<>();
                while (rs.next()){
                    courses.add(new course(rs.getString(1),null,-1));
                }
                return courses;
        }
        
        public void logOut(){
            this.studentID =null;
        }
}
class course {
    public String UosCode;
    public String semester;
    public int year;
    public course(String UosCode, String semester, int year){
        this.UosCode = UosCode;
        this.semester = semester;
        this.year = year;
    }
}
class courseGrade {
    public course course;
    public String grade;
    
    public courseGrade(course course, String grade){
        this.course = course;
        this.grade = grade;
    }
}

class courseDetails{
    public String studentID;
    public String UosCode;
    public String semester;
    public int year;
    public int Enrollment;
    public int MaxEnrollment;
    public String Name;
    public String Grade;
    public String CourseTitle;
    
    public courseDetails(String studentID, String UosCode, String semester, int year, int Enrollment, int MaxEnrollment, String Name, String Grade, String CourseTitle){
        this.studentID = studentID;
        this.UosCode = UosCode;
        this.semester = semester;
        this.year = year;
        this.Enrollment = Enrollment;
        this.MaxEnrollment = MaxEnrollment;
        this.Name = Name;
        this.Grade = Grade;
        this.CourseTitle = CourseTitle;
    }
}