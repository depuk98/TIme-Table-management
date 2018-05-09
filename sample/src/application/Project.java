package application;

import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

class Database implements Serializable{

	private static ArrayList<course> courses = new ArrayList<course>();

	//public ArrayList<student> students = new ArrayList<student>();

	public ArrayList<course> readCourseFile(){

	ArrayList<course> courses = new ArrayList<course>();

	String file = "C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\course.txt";

        Scanner scan = null;

        try {
        	try {
	scan = new Scanner(new File(file));
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
        	scan.useDelimiter(Pattern.compile("%"));

        	while (scan.hasNext()) {

        	String startTime = null; String venue= null; String endTime=null; String day= null;

        	String logicalLine = scan.next();
        	if(logicalLine.length()>2){
        	java.util.List<String> result = Arrays.asList(logicalLine.split("\\s*,\\s*"));
        	ArrayList<Object> res = new ArrayList(result);

        	for(int k=6;k<=10;k++) {

            	String mon = (String) res.get(k);
            	String[] monArray = mon.split("\\&");

            	for(int i=0;i<monArray.length;i++) {

            	if(i==0) {
            	String time = monArray[i];
            	String[] timeArray = time.split("\\-");
            	for(int j=0;j<timeArray.length;j++) {
            	if(j==0) {
            	startTime = timeArray[j];
            	}
            	else if(j==1) {
            	endTime = timeArray[j];
            	}
            	}
            	}
            	else if(i==1) {
            	venue = monArray[i];
            	}
            	}

            	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
            	res.set(k, tv);
        	}

                for(int k=11; k<=12; k++){

        	    String var = (String) res.get(k);
        	    String[] varArray = var.split("\\&");

        	    for(int i=0;i<varArray.length;i++) {

        	if(i==0) {
        	String dayTime = varArray[i];
        	String[] dayTimeArray = dayTime.split("\\-");
        	for(int j=0;j<dayTimeArray.length;j++) {
        	if(j==0) {
        	String dayStartTime = dayTimeArray[j];
        	String[] dayStartTimeArray = dayStartTime.split("\\$");
        	for(int z=0; z<dayStartTimeArray.length;z++){
        	    if(z==0){
        	        day = dayStartTimeArray[z];

        	    }
        	    else if(z==1){
        	        startTime = dayStartTimeArray[z];
        	    }
        	}
        	}
        	else if(j==1) {
        	endTime = dayTimeArray[j];
        	}
        	}
        	}
        	else if(i==1) {
        	venue = varArray[i];
        	}
        	}
        	DayTimeVenue dtv = new DayTimeVenue(startTime, endTime, venue, day);
        	res.set(k, dtv);
        	}

        	course crs = createCourse(res);
        	courses.add(crs);
        	}
        	}

        }

        finally {
            if(scan != null) {
                scan.close();
            }
        }
	return courses;

        //Print the contents from here
	//System.out.println(courses.get(0).getTutDayTimeVenue().getVenue());
        //System.out.println(courses.get(2).getTutDayTimeVenue().getVenue());


	}

	private static course createCourse(java.util.List<Object> result) {
	//StringProperty status = new StringProperty();
	//status.setValue((String) result.get(0));
	StringProperty status = new SimpleStringProperty((String) result.get(0));

	StringProperty courseName = new SimpleStringProperty((String) result.get(1));
	StringProperty courseCode = new SimpleStringProperty((String) result.get(2));
	String instructor = (String) result.get(3);
	StringProperty credits = new SimpleStringProperty((String) result.get(4));
	String acronym = (String) result.get(5);
	TimeVenue monTimeVenue = (TimeVenue) result.get(6);
	TimeVenue tuesTimeVenue = (TimeVenue) result.get(7);
	TimeVenue wedTimeVenue = (TimeVenue) result.get(8);
	TimeVenue thrusTimeVenue = (TimeVenue) result.get(9);
	TimeVenue friTimeVenue = (TimeVenue) result.get(10);
	DayTimeVenue tutDayTimeVenue = (DayTimeVenue) result.get(11);
	DayTimeVenue labDayTimeVenue = (DayTimeVenue) result.get(12);
	String preCondition = (String)result.get(13);
	String postCondition = (String)result.get(14);

	return new course(status, courseName, courseCode, instructor, credits, acronym, monTimeVenue, tuesTimeVenue, wedTimeVenue, thrusTimeVenue, friTimeVenue, tutDayTimeVenue, labDayTimeVenue, preCondition, postCondition);

	}

}


class course implements Serializable{

	private StringProperty status;
	private StringProperty courseName;
	private StringProperty courseCode;
	private String instructor;
	private StringProperty credits;
	private String acronym;
	private TimeVenue monTimeVenue;
	private TimeVenue tuesTimeVenue;
	private TimeVenue wedTimeVenue;
	private TimeVenue thrusTimeVenue;
	private TimeVenue friTimeVenue;
	private DayTimeVenue tutDayTimeVenue;
	private DayTimeVenue labDayTimeVenue;
	private String preCondition;
	private String postCondition;

	public course(StringProperty status, StringProperty courseName, StringProperty courseCode, String instructor, StringProperty credits, String acronym, TimeVenue monTimeVenue, TimeVenue tuesTimeVenue, TimeVenue wedTimeVenue, TimeVenue thrusTimeVenue, TimeVenue friTimeVenue, DayTimeVenue tutDayTimeVenue, DayTimeVenue labDayTimeVenue, String preCondition, String postCondition) {
	this.status = status;
	this.courseName = courseName;
	this.courseCode = courseCode;
	this.instructor = instructor;
	this.credits = credits;
	this.acronym = acronym;
	this.monTimeVenue = monTimeVenue;
	this.tuesTimeVenue = tuesTimeVenue;
	this.wedTimeVenue = wedTimeVenue;
	this.thrusTimeVenue = thrusTimeVenue;
	this.friTimeVenue = friTimeVenue;
	this.tutDayTimeVenue = tutDayTimeVenue;
	this.labDayTimeVenue = labDayTimeVenue;
	this.preCondition = preCondition;
	this.postCondition = postCondition;
	}

	public TimeVenue getMonTimeVenue() {
	return this.monTimeVenue;
	}

	public TimeVenue getTuesTimeVenue() {
	return this.tuesTimeVenue;
	}

	public TimeVenue getWedTimeVenue() {
	return this.wedTimeVenue;
	}

	public TimeVenue getThrusTimeVenue() {
	return this.thrusTimeVenue;
	}

	public TimeVenue getFriTimeVenue() {
	return this.friTimeVenue;
	}


	public DayTimeVenue getTutDayTimeVenue() {
	return this.tutDayTimeVenue;
	}

	public DayTimeVenue getLabDayTimeVenue() {
	return this.labDayTimeVenue;
	}

	public String getPreCondition() {
	return this.preCondition;
	}

	public String getPostCondition() {
	return this.postCondition;
	}

	public String getStatus() {
	return this.status.get();
	}

	public String getCourseName() {
	return this.courseName.get();
	}

	public String getCourseCode() {
	return this.courseCode.get();
	}

	public String getInstructor() {
	return this.instructor;
	}

	public String getCredits() {
	return this.credits.get();
	}

	public String getAcronym() {
	return this.acronym;
	}
	/*@Override
	public String toString() {
	return status + " " + courseName;
	}*/

}


class DayTimeVenue extends TimeVenue implements Serializable{

    String day;

    public DayTimeVenue(String startTime, String endTime, String venue, String day){
        super(startTime, endTime, venue);
        this.day = day;
    }

    public String getDay(){
        return this.day = day;
    }
}

class RoomBook implements Serializable {

	private String date, day, purpose, type;
	private int priority;
	private TimeVenue tv;

	RoomBook(String date, String day, TimeVenue tv, String purpose, String type){

	this.date = date;
	this.day = day;
	this.tv = tv;
	this.purpose = purpose;
	this.type = type;
	}

	public String getDate() {

	return this.date;

	}

	public String getDay() {

	return this.day;

	}

	public TimeVenue getTimeVenue() {

	return this.tv;

	}

	public String getPurpose() {

	return this.purpose;

	}

	public String getType() {
	return this.type;
	}

	/*public void setPriority(String priority) {
	this.priority = priority;

	} */

	public int getPriority(String type) {

	String prioirty = null ;
	if(type.equals("Admin") || type.equals("Faculty")) {
	priority = 1;
	}
	else if(type.equals("Student")) {
	priority = 2;
	}
	return priority;
	}

}

class TimeVenue implements Serializable{

	String startTime;
	String endTime;
	String venue;

	public TimeVenue(String startTime, String endTime, String venue) {
	this.startTime = startTime;
	this.endTime = endTime;
	this.venue = venue;
	}

	public String getVenue() {
	return this.venue;
	}

	public String getStartTime() {
	return this.startTime;
	}

	public String getEndTime() {
	return this.endTime;
	}

}

class user implements Serializable{
	/**
	 *
	 */
	//private static final long serialVersionUID = 1L;
	String email;
	String password;
	String type; //question, answer;

	static Database db = new Database();
	private static ArrayList<course> courses = db.readCourseFile();

	static ArrayList<RoomBook> roomBooked = new ArrayList<RoomBook>();
	static ArrayList<RoomBook> roomBookingRequest = new ArrayList<RoomBook>();

	static ArrayList<TimeVenue> MondayAvailability = new ArrayList<TimeVenue>();
	static ArrayList<TimeVenue> TuesdayAvailability = new ArrayList<TimeVenue>();
	static ArrayList<TimeVenue> WednesdayAvailability = new ArrayList<TimeVenue>();
	static ArrayList<TimeVenue> ThrusdayAvailability = new ArrayList<TimeVenue>();
	static ArrayList<TimeVenue> FridayAvailability = new ArrayList<TimeVenue>();

	user(String _mail,String _type,String _pass){
	this.email=_mail;
	this.type=_type;
	this.password=_pass;

	for(int i=0;i<courses.size();i++) {

	MondayAvailability.add(courses.get(i).getMonTimeVenue());
	TuesdayAvailability.add(courses.get(i).getTuesTimeVenue());
	WednesdayAvailability.add(courses.get(i).getWedTimeVenue());
	ThrusdayAvailability.add(courses.get(i).getThrusTimeVenue());
	FridayAvailability.add(courses.get(i).getFriTimeVenue());

	}

	}

	public String getEmail() {

	return this.email;

	}

	public String getType() {
	return this.type;
	}

}


class admin extends user {

	//static ArrayList<TimeVenue> roomBooked = new ArrayList<TimeVenue>();
	//static ArrayList<RoomBook> roomBookingRequest = new ArrayList<RoomBook>();

	private String email, type, password, question, answer, priority;

	public admin(String email, String type, String password, String question, String answer){

	super(email, type, password);
	this.question = question;
	this.answer = answer;

	}

	@Override
	public String getType() {
	return "Admin";
	}

	/*private void setPriority(String s) {
	s = "1";
	this.priority = s;

	}*/

	public String getPriority() {
	return this.priority;
	}

	public String getQuestion() {
	return this.question;
	}

	public void setPassword(String password) {

	this.password = password;

	}

	public void forgetPassword(String answer) {

	System.out.println(this.question);

	if(answer.equals(this.answer)) {

	String s = ""; //textfield
	setPassword(s);

	}
	else {

	System.out.println("Answer is wrong");
	}
	}


	public static void cancelRoomBookingAdmin(String date, String day, String venue, String startTime, String endTime, String type) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, " ", type);
	int index = 0;

	for(int i=0;i<roomBooked.size();i++) {

	if(roomBooked.get(i).getDate().equals(date) && roomBooked.get(i).getDay().equals(day) && roomBooked.get(i).getTimeVenue().getVenue().equals(venue) && roomBooked.get(i).getTimeVenue().getStartTime().equals(startTime)) {

	index = i;

	}
	}

	if(day.equals("Monday")) { int flag = 0;
	//System.out.println(MondayAvailability.size());
	for(int i=0;i<MondayAvailability.size();i++) {
	//System.out.println(MondayAvailability.get(i).getVenue() + " " + venue);
	if(MondayAvailability.get(i).getVenue().equals(venue) && MondayAvailability.get(i).getStartTime().equals(startTime)) {

	flag = 1;
	MondayAvailability.remove(MondayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index)); break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Tuesday")) { int flag = 0;

	for(int i=0;i<TuesdayAvailability.size();i++) {
	//System.out.println(TuesdayAvailability.size());	System.out.println("A");
	if(TuesdayAvailability.get(i).getVenue().equals(venue) && TuesdayAvailability.get(i).getStartTime().equals(startTime)) {

	flag = 1;
	TuesdayAvailability.remove(TuesdayAvailability.get(i));
	//System.out.println(roomBooked.size());
	roomBooked.remove(roomBooked.get(index));
	//System.out.println(roomBooked.size());
	break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Wednesday")) { int flag = 0;

	for(int i=0;i<WednesdayAvailability.size();i++) {

	if(WednesdayAvailability.get(i).getVenue().equals(venue) && WednesdayAvailability.get(i).getStartTime().equals(startTime)) {

	flag = 1;
	WednesdayAvailability.remove(WednesdayAvailability.get(i));
	//System.out.println(roomBooked.size());
	roomBooked.remove(roomBooked.get(index));
	//System.out.println(roomBooked.size());
	break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Thrusday")) { int flag = 0;

	for(int i=0;i<ThrusdayAvailability.size();i++) {

	if(ThrusdayAvailability.get(i).getVenue().equals(venue) && ThrusdayAvailability.get(i).getStartTime().equals(startTime)) {


	flag = 1;
	ThrusdayAvailability.remove(ThrusdayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index));
	break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Friday")) { int flag = 0;

	for(int i=0;i<FridayAvailability.size();i++) {

	if(FridayAvailability.get(i).getVenue().equals(venue) && FridayAvailability.get(i).getStartTime().equals(startTime)) {
	flag = 1;
	FridayAvailability.remove(FridayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index));
	break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}
	else {

	System.out.println("Mentioned data is wrong");

	}
	}

	public static void bookRoomAdmin(String date, String day, String venue, String startTime, String endTime, String purpose, String type) {

	String message = roomAvailability(day, venue, startTime, endTime);

	if(message.equals("Room is not available")) {

	System.out.println("Sorry! Room is already booked.");

	}

	else if(message.equals("Room is available")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, " ", type);

	if(day.equals("Monday")) {

	    MondayAvailability.add(tv);
	    roomBooked.add(rb);
	    System.out.println("Room is booked :)");

	}

	if(day.equals("Tuesday")) {

	    TuesdayAvailability.add(tv);
	    roomBooked.add(rb);
	    System.out.println("Room is booked :)");

	}
	if(day.equals("Wednesday")) {

	WednesdayAvailability.add(tv);
	roomBooked.add(rb);
	System.out.println("Room is booked :)");

	}
	if(day.equals("Thrusday")) {

	ThrusdayAvailability.add(tv);
	roomBooked.add(rb);
	System.out.println("Room is booked :)");

	}
	if(day.equals("Friday")) {

	FridayAvailability.add(tv);
	roomBooked.add(rb);
	System.out.println("Room is booked :)");
	}
	}

	}

	public static String roomAvailability(String day, String venue, String startTime, String endTime) {

	String message = null;

	if(day.equals("Monday")) {

	int flag = 0;
	for(int i=0;i<MondayAvailability.size();i++) {

	if(MondayAvailability.get(i).getStartTime().equals(startTime) && MondayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1;
	break;

	}
	else {
	flag = 0;
	}

	}
	if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}

	else if(day.equals("Tuesday")) { int flag = 0;

	for(int i=0;i<TuesdayAvailability.size();i++) {

	if(TuesdayAvailability.get(i).getStartTime().equals(startTime) && TuesdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}

	else if(day.equals("Wednesday")) { int flag = 0;

	for(int i=0;i<WednesdayAvailability.size();i++) {

	if(WednesdayAvailability.get(i).getStartTime().equals(startTime) && WednesdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;
	}
	else {
	flag = 0;
	}

	}if(flag == 0) return ("Room is available");
	else return ("Room is not available");

	}
	else if(day.equals("Thrusday")) { int flag = 0;

	for(int i=0;i<ThrusdayAvailability.size();i++) {

	if(ThrusdayAvailability.get(i).getStartTime().equals(startTime) && ThrusdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}
	else if(day.equals("Friday")) { int flag = 0;

	for(int i=0;i<FridayAvailability.size();i++) {

	if(FridayAvailability.get(i).getStartTime().equals(startTime) && FridayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0) message =  ("Room is available");
	else message = ("Room is not available");

	}
	else {
	message = "Invalid Data";

	}
	return message;

	}

	public void processRequest(String date, String day, String venue, String startTime, String endTime, String purpose, String type, String status) {

	if(status.equals("Accept")) {
	for(int i=0;i<roomBookingRequest.size();i++) {

	if(day.equals("Monday")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	    MondayAvailability.add(tv);
	    roomBooked.add(rb);
	    roomBookingRequest.remove(roomBookingRequest.get(i));
	    System.out.println("Room is booked :)");

	}

	if(day.equals("Tuesday")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	    TuesdayAvailability.add(tv);
	    roomBooked.add(rb);
	    roomBookingRequest.remove(roomBookingRequest.get(i));
	    System.out.println("Request is successfully accepted");

	}
	if(day.equals("Wednesday")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	WednesdayAvailability.add(tv);
	roomBooked.add(rb);
	roomBookingRequest.remove(roomBookingRequest.get(i));
	System.out.println("Request is successfully accepted");

	}
	if(day.equals("Thrusday")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	ThrusdayAvailability.add(tv);
	roomBooked.add(rb);
	roomBookingRequest.remove(roomBookingRequest.get(i));
	System.out.println("Request is successfully accepted");

	}
	if(day.equals("Friday")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	FridayAvailability.add(tv);
	roomBooked.add(rb);
	roomBookingRequest.remove(roomBookingRequest.get(i));
	System.out.println("Request is successfully accepted");
	}
	}
	}else if(status.equals("Reject")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	roomBookingRequest.remove(rb);
	System.out.println("Request is rejected");
	}

	}

}

class faculty extends user {

	private String email, type, password, question, answer, priority;

	faculty(String email, String type, String password, String question, String answer){

	super(email, type, password);
	this.question = question;
	this.answer = answer;

	}

	@Override
	public String getType() {
	return "Faculty";
	}

	private void setPriority(String s) {
	s = "1";
	this.priority = s;

	}

	public String getPriority() {
	return this.priority;
	}

	public String getQuestion() {
	return this.question;
	}

	public static void cancelRoomBookingFaculty(String date, String day, String venue, String startTime, String endTime, String type) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, " ", type);

	int index = 0;

	for(int i=0;i<roomBooked.size();i++) {

	if(roomBooked.get(i).getType().equals("Faculty") && roomBooked.get(i).getDate().equals(date) && roomBooked.get(i).getDay().equals(day) && roomBooked.get(i).getTimeVenue().getVenue().equals(venue) && roomBooked.get(i).getTimeVenue().getStartTime().equals(startTime)) {

	index = i;

	}
	}

	if(day.equals("Monday") && type.equals("Faculty")) { int flag = 0;

	for(int i=0;i<MondayAvailability.size();i++) {

	if(MondayAvailability.get(i).getVenue().equals(venue) && MondayAvailability.get(i).getStartTime().equals(startTime)) {

	flag = 1;
	MondayAvailability.remove(MondayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index)); break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Tuesday") && type.equals("Faculty")) { int flag = 0;

	for(int i=0;i<TuesdayAvailability.size();i++) {

	if(TuesdayAvailability.get(i).getVenue().equals(venue) && TuesdayAvailability.get(i).getStartTime().equals(startTime)) {

	flag = 1;
	TuesdayAvailability.remove(TuesdayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index)); break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Wednesday") && type.equals("Faculty")) { int flag = 0;

	for(int i=0;i<WednesdayAvailability.size();i++) {

	if(WednesdayAvailability.get(i).getVenue().equals(venue) && WednesdayAvailability.get(i).getStartTime().equals(startTime)) {

	flag = 1;
	WednesdayAvailability.remove(WednesdayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index)); break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Thrusday") && type.equals("Faculty")) { int flag = 0;

	for(int i=0;i<ThrusdayAvailability.size();i++) {

	if(ThrusdayAvailability.get(i).getVenue().equals(venue) && ThrusdayAvailability.get(i).getStartTime().equals(startTime)) {


	flag = 1;
	ThrusdayAvailability.remove(ThrusdayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index));
	break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}

	else if(day.equals("Friday") && type.equals("Faculty")) { int flag = 0;

	for(int i=0;i<FridayAvailability.size();i++) {

	if(FridayAvailability.get(i).getVenue().equals(venue) && FridayAvailability.get(i).getStartTime().equals(startTime)) {
	flag = 1;
	FridayAvailability.remove(FridayAvailability.get(i));
	roomBooked.remove(roomBooked.get(index));
	break;

	}
	}if(flag == 1) System.out.println("Your Booked room stands cancelled");
	else System.out.println("Mentioned data is wrong");
	}
	else {

	System.out.println("Mentioned data is wrong");

	}

	}

	public static void bookRoomFaculty(String date, String day, String venue, String startTime, String endTime, String purpose, String type) {

	String message = roomAvailability(day, venue, startTime, endTime);

	if(message.equals("Room is not available")) {

	System.out.println("Sorry! Room is already booked.");

	}

	else if(message.equals("Room is available")) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, " ", type);

	if(day.equals("Monday")) {

	    MondayAvailability.add(tv);
	    roomBooked.add(rb);
	    System.out.println("Room is booked :)");

	}

	if(day.equals("Tuesday")) {

	    TuesdayAvailability.add(tv);
	    roomBooked.add(rb);
	    System.out.println("Room is booked :)");

	}
	if(day.equals("Wednesday")) {

	WednesdayAvailability.add(tv);
	roomBooked.add(rb);
	System.out.println("Room is booked :)");

	}
	if(day.equals("Thrusday")) {

	ThrusdayAvailability.add(tv);
	roomBooked.add(rb);
	System.out.println("Room is booked :)");

	}
	if(day.equals("Friday")) {

	FridayAvailability.add(tv);
	roomBooked.add(rb);
	System.out.println("Room is booked :)");
	}
	}

	}

	public static String roomAvailability(String day, String venue, String startTime, String endTime) {

	String message = null;

	if(day.equals("Monday")) {

	int flag = 0;
	for(int i=0;i<MondayAvailability.size();i++) {

	if(MondayAvailability.get(i).getStartTime().equals(startTime) && MondayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1;
	break;

	}
	else {
	flag = 0;
	}

	}
	if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}

	else if(day.equals("Tuesday")) {

	int flag = 0;

	for(int i=0;i<TuesdayAvailability.size();i++) {

	if(TuesdayAvailability.get(i).getStartTime().equals(startTime) && TuesdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}

	else if(day.equals("Wednesday")) { int flag = 0;

	for(int i=0;i<WednesdayAvailability.size();i++) {

	if(WednesdayAvailability.get(i).getStartTime().equals(startTime) && WednesdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;
	}
	else {
	flag = 0;
	}

	}if(flag == 0) return ("Room is available");
	else return ("Room is not available");

	}
	else if(day.equals("Thrusday")) { int flag = 0;

	for(int i=0;i<ThrusdayAvailability.size();i++) {

	if(ThrusdayAvailability.get(i).getStartTime().equals(startTime) && ThrusdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}
	else if(day.equals("Friday")) { int flag = 0;

	for(int i=0;i<FridayAvailability.size();i++) {

	if(FridayAvailability.get(i).getStartTime().equals(startTime) && FridayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0) message =  ("Room is available");
	else message = ("Room is not available");

	}
	else {
	message = "Invalid Data";

	}
	return message;

	}

}

class student extends user {

	static Database db = new Database();
	private static ArrayList<course> courses = db.readCourseFile();

	private ArrayList<course> studentCourses;
	private String email, type, password, question, answer, priority;

	student(String email, String type, String password, String question, String answer, ArrayList<course> studentCourses){

	super(email, type, password);
	this.question = question;
	this.answer = answer;
	this.studentCourses = studentCourses;

	}

	@Override
	public String getType() {

	return "Student";

	}

	public String getQuestion() {


	return this.question;
	}

	public void setPriority(String s) {
	s = "2";
	this.priority = s;

	}


	public ArrayList<course> getStudentCourses() {

	return this.studentCourses;

	}

	public static void requestRoomBooking(String date, String day, String venue, String startTime, String endTime, String purpose, String type) {

	TimeVenue tv = new TimeVenue(startTime, endTime, venue);
	RoomBook rb = new RoomBook(date, day, tv, purpose, type);
	roomBookingRequest.add(rb);
	System.out.println("Request is being processed");

	}
	public void personalisedTimeTable(ArrayList<course> studentCourses) {

	/*for(int i=0;i<studentCourses.size();i++) {

	System.out.println(studentCourses.get(i).getCourseName());
	//System.out.println("Tuesday: " + studentCourses.get(i).getTuesTimeVenue().getStartTime()+ "-" + studentCourses.get(i).getTuesTimeVenue().getEndTime()  +"   Friday" + studentCourses.get(i).getFriTimeVenue().getStartTime() +"-"+ studentCourses.get(i).getFriTimeVenue().getEndTime());

	}*/

	}
	public static String roomAvailability(String day, String venue, String startTime, String endTime) {

	String message = null;

	if(day.equals("Monday")) {

	int flag = 0;
	for(int i=0;i<MondayAvailability.size();i++) {

	if(MondayAvailability.get(i).getStartTime().equals(startTime) && MondayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1;
	break;

	}
	else {
	flag = 0;
	}

	}
	if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}

	else if(day.equals("Tuesday")) {

	int flag = 0;

	for(int i=0;i<TuesdayAvailability.size();i++) {

	if(TuesdayAvailability.get(i).getStartTime().equals(startTime) && TuesdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}

	else if(day.equals("Wednesday")) { int flag = 0;

	for(int i=0;i<WednesdayAvailability.size();i++) {

	if(WednesdayAvailability.get(i).getStartTime().equals(startTime) && WednesdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;
	}
	else {
	flag = 0;
	}

	}if(flag == 0) return ("Room is available");
	else return ("Room is not available");

	}
	else if(day.equals("Thrusday")) { int flag = 0;

	for(int i=0;i<ThrusdayAvailability.size();i++) {

	if(ThrusdayAvailability.get(i).getStartTime().equals(startTime) && ThrusdayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0)  message = ("Room is available");
	else  message = ("Room is not available");

	}
	else if(day.equals("Friday")) { int flag = 0;

	for(int i=0;i<FridayAvailability.size();i++) {

	if(FridayAvailability.get(i).getStartTime().equals(startTime) && FridayAvailability.get(i).getVenue().equals(venue)) {

	flag = 1; break;

	}
	else {
	flag = 0;
	}

	}if(flag == 0) message =  ("Room is available");
	else message = ("Room is not available");

	}
	else {
	message = "Invalid Data";

	}
	return message;
	}

	public static String search(String s,ArrayList<course> studentCourses) {
		String str="";
	//Addition of courses
	//addCourse("CSE201");

	ArrayList<course> remainingCourses = new ArrayList<course>(courses);
	remainingCourses.removeAll(studentCourses);

	for(int i=0;i<studentCourses.size();i++) {

	for(int j=0;j<remainingCourses.size();j++) {

	if(studentCourses.get(i).getMonTimeVenue().getStartTime().equals(remainingCourses.get(j).getMonTimeVenue().getStartTime())){
	remainingCourses.remove(remainingCourses.get(j));
	//System.out.println("A");
	break;
	}
	if(studentCourses.get(i).getTuesTimeVenue().getStartTime().equals(remainingCourses.get(j).getTuesTimeVenue().getStartTime())){
	remainingCourses.remove(remainingCourses.get(j));
	break;
	}
	if(studentCourses.get(i).getWedTimeVenue().getStartTime().equals(remainingCourses.get(j).getWedTimeVenue().getStartTime())){
	remainingCourses.remove(remainingCourses.get(j));
	break;
	}
	if(studentCourses.get(i).getThrusTimeVenue().getStartTime().equals(remainingCourses.get(j).getThrusTimeVenue().getStartTime())){
	remainingCourses.remove(remainingCourses.get(j));
	break;
	}
	if(studentCourses.get(i).getFriTimeVenue().getStartTime().equals(remainingCourses.get(j).getFriTimeVenue().getStartTime())){
	remainingCourses.remove(remainingCourses.get(j));
	break;
	}


	}

	}
	//System.out.println(remainingCourses);

	//filter

	for(int i=0;i<remainingCourses.size();i++) {

	String[] postCondition = remainingCourses.get(i).getPostCondition().split("\\s+");
	int length = postCondition.length;

	for(int j=0;j<length;j++) {

	if(s.equals(postCondition[j])) {
	 str = str+remainingCourses.get(i).getCourseName()+" "+remainingCourses.get(i).getCourseCode()+"\n";
	break;
	}
	}
	}
	return str;
	//System.out.println(str);
	}

	public static void addCourse(String courseCode,ArrayList<course> studentCourses) {

	int flag = 0;

	for(int i=0;i<courses.size();i++) {
	//System.out.println(courses.get(i).getCourseCode().get());
	if(courses.get(i).getCourseCode().equals(courseCode)) {
	studentCourses.add(courses.get(i)); flag = 1;

	}

	}if(flag==1) System.out.println("Course is successfully added");
	else System.out.println("Oops! try again later");

	}

}



public class Project {

	public static void serialize() throws IOException{

	admin a1 = new admin("akansha@iiitd.ac.in","admin","akansha","Which is you favourite novel?","Till the last breathe");
	admin a2 = new admin("deepak@iiitd.ac.in","admin","deepak","Which is you favourite novel?","Harry Potter");

	faculty f1 = new faculty("akansha@iiitd.ac.in","student","akansha","Which is you favourite novel?","Till the last breathe");
	faculty f2 = new faculty("deepak@iiitd.ac.in","student","deepak","Which is you favourite novel?","Harry Potter");

	ArrayList<course> sc1 = new ArrayList<course>() ;
	student s1 = new student("akansha16221@iiitd.ac.in","student","akansha","Which is you favourite novel?","Till the last breathe",sc1);
	//System.out.println(sc1.get(0).getCourseCode());

	ArrayList<course> sc2 = new ArrayList<course>() ;
	student s2 = new student("deepak16032@iiitd.ac.in","student","deepak","Which is you favourite novel?","Harry Potter",sc2);

	ArrayList<RoomBook> roomBooked = new ArrayList<RoomBook>();
	ArrayList<RoomBook> roomBookingRequest = new ArrayList<RoomBook>();


	ObjectOutputStream outAdmin = null;
	ObjectOutputStream outFaculty = null;
	ObjectOutputStream outStudent = null;
	ObjectOutputStream outRoomBooked = null;
	ObjectOutputStream outRoomBookingRequest = null;

	try {

		outAdmin = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\outAdmin.txt"));
		outRoomBooked = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\roomBooked.txt"));
		outRoomBookingRequest = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\roomBookingRequest.txt"));
		outFaculty = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\outFaculty.txt"));
		outStudent = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\outStudent.txt"));
		outFaculty.writeObject(f1);
		outFaculty.writeObject(f2);

		outAdmin.writeObject(a1);
		outAdmin.writeObject(a2);

		outStudent.writeObject(s1);
		outStudent.writeObject(s2);

		outRoomBooked.writeObject(roomBooked);
		outRoomBookingRequest.writeObject(roomBookingRequest);

		}
		finally {
		outAdmin.close();
		}

		}

		public static void deserialize() throws IOException, ClassNotFoundException{

		ObjectInputStream inAdmin = null;
		ObjectInputStream inFaculty = null;
		ObjectInputStream inStudent = null;
		ObjectInputStream inRoomBooked = null;
		ObjectInputStream inRoomBookingRequest = null;

		try {

		inAdmin = new ObjectInputStream(new FileInputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\outAdmin.txt"));
		inFaculty = new ObjectInputStream(new FileInputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\outFaculty.txt"));
		inStudent = new ObjectInputStream(new FileInputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\outStudent.txt"));
		inRoomBooked = new ObjectInputStream(new FileInputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\roomBooked.txt"));
		inRoomBookingRequest = new ObjectInputStream(new FileInputStream("C:\\Users\\Deepak Singh\\workspace\\sample\\src\\application\\roomBookingRequest.txt"));

	admin a1 = (admin) inAdmin.readObject();
	admin a2 = (admin) inAdmin.readObject();

	faculty f1 = (faculty) inFaculty.readObject();
	faculty f2 = (faculty) inFaculty.readObject();

	student s1 = (student) inStudent.readObject();
	student s2 = (student) inStudent.readObject();



	String type = a1.getType();
	//ySstem.out.println(type);

	//Display all pending requests
	//a1.processRequest();
	s1.search("able", s1.getStudentCourses());
	String message = a1.roomAvailability("Monday", "C21", "11:00", "12:00");
	System.out.println(message);

	//System.out.println(roomBooked.size());
	a1.bookRoomAdmin("21/04/2017", "Monday", "C21" , "11:00" , "12:00" , "purpose" ,a1.getType());

	f1.bookRoomFaculty("21/04/2017", "Friday", "C02" , "4:50" , "3:00" , "purpose" , type);

	f1.bookRoomFaculty("21/04/2017", "Monday", "C02" , "4:50" , "3:00" , "purpose" , type);
	//System.out.println(roomBooked.size());
	a1.cancelRoomBookingAdmin("21/04/2017", "Wednesday", "C02" , "4:50" , "3:00", a1.getType());
	//System.out.println(roomBooked.size());
	f1.cancelRoomBookingFaculty("21/04/2017", "Friday", "C02" , "4:50" , "3:00" , f1.getType());
	//System.out.println(roomBooked.size());
	a1.bookRoomAdmin("21/04/2017", "Friday", "C02" , "4:50" , "3:00" , "purpose" , type);
	//System.out.println(roomBooked.size());

	//String message2 = s1.roomAvailability("Thrusday", "C02", "4:50", "5:30");
	//System.out.println(message2);

	//s1.requestRoomBooking("21/04/2017", "Thrusday", "C02" , "4:50" , "5:30" , "purpose", s1.getType());

	s1.addCourse("CSE201", s1.getStudentCourses());
	//s1.addCourse("CSE112", s1.getStudentCourses());
	//System.out.println(s1.getStudentCourses().get(0).getCourseCode());
	//Display all the pending requests
	a1.processRequest("21/04/2017", "Thrusday", "C02" , "4:50" , "3:00" , "purpose", type, "Accept");

	//String message3 = a1.roomAvailability("Thrusday", "C02", "4:50", "5:30");
	//System.out.println(message3);

	//a1.bookRoom("21/04/2017", "Thrusday", "C02" , "4:50" , "3:00" , "purpose" ,type );

	//a1.processRequest("21/04/2017", "Thrusday", "C02" , "4:50" , "3:00" , "purpose", type);

	//String message3 = a1.roomAvailability("Thrusday", "C02", "4:50", "5:30");
	//System.out.println(message3);

	//Display roomBooked ArrayList
	//a1.cancelRoomBookingAdmin("21/04/2017", "Thrusday", "C02" , "4:50" , "5:00");

	//String message1 = a1.roomAvailability("Thrusday", "C02", "4:50", "5:30");
	//System.out.println(message1);

	//a1.bookRoom("21/04/2017", "Thrusday", "C02" , "4:50" , "3:00" , "purpose" ,type );

	//System.out.println(roomBooked1);

	//String message1 = a1.roomAvailability("Thrusday", "C02", "4:50", "5:30");
	//System.out.println(message1);

	//System.out.println(a1.getEmail());
	//System.out.println(a2.getEmail());

	}finally {

	inAdmin.close();
	inFaculty.close();
	//inRoomBooked.close();
	//inRoomBookingRequest.close();
	}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException{

	serialize();
	deserialize();

	}

}
