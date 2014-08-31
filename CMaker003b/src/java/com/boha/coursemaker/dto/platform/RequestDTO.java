/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto.platform;

import com.boha.coursemaker.dto.ActivityDTO;
import com.boha.coursemaker.dto.AdministratorDTO;
import com.boha.coursemaker.dto.AuthorDTO;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CompanyDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.dto.CourseTraineeActivityDTO;
import com.boha.coursemaker.dto.CourseTraineeDTO;
import com.boha.coursemaker.dto.DemoAnnouncementDTO;
import com.boha.coursemaker.dto.EquipmentDTO;
import com.boha.coursemaker.dto.GcmDeviceDTO;
import com.boha.coursemaker.dto.HelpRequestDTO;
import com.boha.coursemaker.dto.HelpResponseDTO;
import com.boha.coursemaker.dto.HelpTypeDTO;
import com.boha.coursemaker.dto.InstructorClassDTO;
import com.boha.coursemaker.dto.InstructorDTO;
import com.boha.coursemaker.dto.InventoryDTO;
import com.boha.coursemaker.dto.LessonResourceDTO;
import com.boha.coursemaker.dto.ObjectiveDTO;
import com.boha.coursemaker.dto.RatingDTO;
import com.boha.coursemaker.dto.SkillDTO;
import com.boha.coursemaker.dto.SkillLevelDTO;
import com.boha.coursemaker.dto.TeamDTO;
import com.boha.coursemaker.dto.TeamMemberDTO;
import com.boha.coursemaker.dto.TraineeDTO;
import com.boha.coursemaker.dto.TraineeEquipmentDTO;
import com.boha.coursemaker.dto.TraineeShoutDTO;
import com.boha.coursemaker.dto.TraineeSkillDTO;
import com.boha.coursemaker.dto.TrainingClassDTO;
import com.boha.coursemaker.dto.TrainingClassEventDTO;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class RequestDTO {

    public static final int GET_COUNTRY_LIST = 100;
    public static final int GET_RATING_LIST = 101;
    public static final int GET_COMPANY_CLASS_LIST = 103;
    public static final int GET_COURSE_RATINGS = 105;
    public static final int GET_CATEGORY_LIST = 106;
    public static final int GET_COMPANY_DATA = 107;
    //
    public static final int ADD_TEAM = 110;
    public static final int DELETE_TEAM = 112;
    public static final int ADD_TEAM_MEMBER = 111;
    public static final int DEACTIVATE_TEAM_MEMBER = 113;
    public static final int ADD_DEMO_ANNOUNCEMENT = 114;
    public static final int CANCEL_DEMO_ANNOUNCEMENT = 115;
    //
    public static final int GET_TEAMS_BY_CLASS = 116;
    public static final int GET_TEAMS_BY_COMPANY = 117;
    public static final int GET_DEMO_ANNOUNCEMENTS_BY_CLASS = 118;
    public static final int GET_DEMO_ANNOUNCEMENTS_BY_COMPANY = 119;
    //training company operations
    public static final int REGISTER_TRAINING_COMPANY = 1;
    public static final int REGISTER_AUTHOR = 2;
    public static final int REGISTER_INSTRUCTOR = 3;
    public static final int REGISTER_TRAINEE = 4;
    public static final int IMPORT_TRAINEE_CSV = 5;
    public static final int REGISTER_ADMINISTRATOR = 6;
    public static final int GET_COMPANY_EQUIPMENT_LIST = 7;
    public static final int REGISTER_GCM_DEVICE = 8;
    //trainee operations
    public static final int ENROLL_IN_COURSE = 400;
    public static final int ADD_TRAINEE_RATINGS = 401;
    public static final int EVALUATE_TRAINEE_ACTIVITY = 402;
    public static final int GET_TRAINEE_ACTIVITY_LIST = 403;
    public static final int ADD_HELP_REQUEST = 404;
    public static final int GET_INSTRUCTOR_LIST_BY_CLASS = 405;
    public static final int SEND_TRAINEE_SHOUT = 406;
    //instructor operations
    public static final int ADD_INSTRUCTOR_RATINGS = 300;
    public static final int GET_TRAINEE_DATA = 301;
    public static final int GET_CLASS_ACTIVITY_LIST = 302;
    public static final int ENROLL_TRAINEES_FOR_ACTIVITIES = 303;
    public static final int GET_INSTRUCTOR_CLASSES = 304;
    public static final int ASSIGN_INSTRUCTOR_CLASS = 305;
    //author builder operations
    public static final int REGISTER_COURSE = 200;
    public static final int ADD_LESSON = 201;
    public static final int ADD_OBJECTIVES = 202;
    public static final int ADD_ACTIVITIES = 203;
    public static final int ADD_RESOURCES = 204;
    public static final int GET_COMPANY_COURSE_LIST = 205;
    public static final int UPDATE_LESSON = 228;
    public static final int UPDATE_OBJECTIVES = 206;
    public static final int UPDATE_ACTIVITIES = 207;
    public static final int DELETE_LESSON = 210;
    public static final int DELETE_OBJECTIVES = 211;
    public static final int DELETE_ACTIVITIES = 212;
    public static final int DELETE_LESSON_RESOURCES = 214;
    public static final int ADD_CATEGORY = 215;
    public static final int DELETE_CATEGORY = 216;
    public static final int ADD_COURSE_CATEGORY = 217;
    public static final int DELETE_COURSE_CATEGORY = 218;
    public static final int GET_COURSE_LIST_BY_CATEGORY = 219;
    public static final int GET_LESSON_LIST_BY_COURSE = 220;
    public static final int GET_OBJECTIVE_LIST_BY_COURSE = 221;
    public static final int GET_ACTIVITY_LIST_BY_LESSON = 222;
    public static final int GET_RESOURCE_LIST_BY_LESSON = 223;
    public static final int GET_CATEGORY_LIST_BY_COMPANY = 224;
    public static final int DELETE_COURSE = 225;
    public static final int UPDATE_CATEGORY = 226;
    public static final int UPDATE_COURSE = 227;
    public static final int GET_COURSE_LIST_BY_CLASS = 229;
    //logins
    public static final int LOGIN_AUTHOR = 500;
    public static final int LOGIN_INSTRUCTOR = 501;
    public static final int LOGIN_TRAINEE = 502;
    public static final int LOGIN_ADMINISTRATOR = 503;
    //admin operations
    public static final int ADD_TRAINING_CLASS = 600;
    public static final int ENROLL_TRAINEES_INTO_CLASS = 601;
    public static final int DEACTIVATE_TRAINEE = 602;
    public static final int DEACTIVATE_INSTRUCTOR = 603;
    public static final int DEACTIVATE_ADMIN = 604;
    public static final int DEACTIVATE_AUTHOR = 622;
    public static final int ADD_COURSES_TO_CLASS = 605;
    public static final int REQUEST_CLASS_COMPLETION_REPORT = 607;
    public static final int ADD_INVENTORY = 616;
    public static final int UPDATE_INVENTORY = 617;
    public static final int GET_INVENTORY_LIST = 618;
    public static final int GET_INVENTORY_LIST_BY_CLASS = 619;
    public static final int GET_HELP_REQUEST_LIST = 620;
    public static final int ADD_EQUIPMENT = 621;
    public static final int GET_INSTRUCTOR_LIST = 608;
    public static final int GET_CLASS_TRAINEE_LIST = 609;
    public static final int GET_CLASS_COURSE_LIST = 610;
    public static final int GET_CLASS_COURSE_TRAINEE_LIST = 611;
    public static final int GET_CLASS_COURSE_TRAINEE_ACTIVITY_LIST = 612;
    public static final int GET_CLASS_TRAINEE_EQUIPMENT_LIST = 613;
    public static final int ADD_TRAINEE_EQUPIMENT = 614;
    public static final int UPDATE_TRAINEE_EQUPIMENT = 615;
    public static final int GET_TRAINEE_ACTIVITY_TOTALS = 6161;
    public static final int GET_TRAINEE_ACTIVITY_TOTALS_BY_COMPANY = 6171;
    public static final int GET_TRAINEE_ACTIVITY_TOTALS_BY_INSTRUCTOR = 6181;
    public static final int UPDATE_INSTRUCTOR = 630;
    public static final int UPDATE_TRAINEE = 631;
    public static final int UPDATE_ADMIN = 632;
    public static final int UPDATE_AUTHOR = 633;
    public static final int UPDATE_EQUIPMENT = 640;
    public static final int DELETE_EQUIPMENT = 641;
    public static final int DELETE_INVENTORY = 642;
    public static final int GET_TRAINEE_EQUIPMENT_LIST_BY_EQUPMENTID = 643;
    public static final int GET_TRAINEE_EQUIPMENT_LIST_BY_INVENTORYID = 644;
    public static final int UPDATE_CLASS = 645;
    public static final int DELETE_CLASS = 646;
    public static final int GET_INVENTORY_LIST_BY_EQUIPMENT = 647;
    public static final int GET_CATEGORIES_BY_COMPANY = 648;
    //messaging
    public static final int GCM_REGISTER_DEVICE = 700;
    public static final int GCM_SEND_TRAINEE_TO_INSTRUCTOR_MSG = 701;
    public static final int GCM_SEND_INSTRUCTOR_TO_TRAINEE_MSG = 702;
    public static final int HELP_REQUESTS_BY_INSTRUCTOR = 800;
    public static final int HELP_REQUESTS_BY_TRAINEE = 801;
    public static final int HELP_REQUESTS_BY_CLASS = 802;
    public static final int HELP_REQUESTS_BY_CLASS_COURSE = 803;
    public static final int HELP_REQUESTS_BY_CLASS_ACTIVITY = 804;
    public static final int CREATE_CALENDAR = 900;
    public static final int ADD_EVENTS = 901;
    public static final int DELETE_CALENDAR = 902;
    public static final int DELETE_EVENT = 903;
    public static final int GET_EVENTS_BY_CLASS = 904;
    public static final int DELETE_INSTRUCTOR_CLASS = 905;
    public static final int UPDATE_EVENT = 906;
    public static final int GET_TRAINING_CLASSES_BY_INSTRUCTOR = 907;
    //
    public static final int SEND_PASSWORD_INSTRUCTOR = 1000;
    public static final int SEND_PASSWORD_TRAINEE = 1001;
    public static final int SEND_PASSWORD_ADMIN = 1002;
    public static final int SEND_PASSWORD_AUTHOR = 1003;
    public static final int SEND_PASSWORD_EXECUTIVE = 1004;
    public static final int ADD_RATING = 1005;
    public static final int UPDATE_RATING = 1006;
    public static final int DELETE_RATING = 1007;
    public static final int ADD_HELPTYPE = 1008;
    public static final int UPDATE_HELPTYPE = 1009;
    public static final int DELETE_HELPTYPE = 1010;
    //
    public static final int GET_ERROR_LIST = 1011;
    public static final int GET_OVERALL_STATS = 1012;
    public static final int GET_COMPANY_STATS = 1013;
    public static final int GET_SERVER_LOG = 1014;
    
    public static final int GET_SKILLS_LOOKUP = 1100;
    public static final int ADD_TRAINEE_SKILLS = 1101;
    public static final int GET_TRAINEE_SKILLS = 1102;
    public static final int GET_TRAINING_CLASS_SKILLS = 1103;
    
    public static final int SHUFFLE_CATEGORIES = 1200;
    public static final int SHUFFLE_COURSES = 1201;
    public static final int SHUFFLE_ACTIVITIES = 1202;
    
    public static final int ADD_COMPANY_SKILL = 1300;
    public static final int ADD_COMPANY_SKILL_LEVEL = 1301;
    public static final int UPDATE_TRAINEE_SKILLS = 1303;
    public static final int UPDATE_COMPANY_SKILL = 1304;
    public static final int UPDATE_COMPANY_SKILL_LEVEL = 1305;
    
    public static final int ADD_ADMIN_DEVICE = 1306;
    public static final int ADD_AUTHOR_DEVICE = 1307;
    public static final int ADD_INSTRUCTOR_DEVICE = 1308;
    public static final int ADD_TRAINEE_DEVICE = 1309;
    public static final int COPY_COMPANY_CATEGORIES = 1310;

    public static String getRequestString(int requestType) {
        switch (requestType) {
            case 100:
                return "GET_COUNTRY_LIST";
            case 101:
                return "GET_RATING_LIST";
            case 103:
                return "GET_COMPANY_CLASS_LIST";
            case 105:
                return "GET_COURSE_RATINGS";
            case 106:
                return "GET_CATEGORY_LIST";
            case 107:
                return "GET_COMPANY_DATA";
            case 110:
                return "ADD_TEAM";
            case 111:
                return "ADD_TEAM_MEMBER";
            case 112:
                return "DELETE_TEAM";
            case 113:
                return "DEACTIVATE_TEAM_MEMBER";
            case 114:
                return "ADD_DEMO_ANNOUNCEMENT";
            case 115:
                return "CANCEL_DEMO_ANNOUNCEMENT";
            case 116:
                return "GET_TEAMS_BY_CLASS";
            case 117:
                return "GET_TEAMS_BY_COMPANY";
            case 118:
                return "GET_DEMO_ANNOUNCEMENTS_BY_CLASS";
            case 119:
                return "GET_DEMO_ANNOUNCEMENTS_BY_COMPANY";
            case 1:
                return "REGISTER_TRAINING_COMPANY";
            case 2:
                return "REGISTER_AUTHOR";
            case 3:
                return "REGISTER_INSTRUCTOR";
            case 4:
                return "REGISTER_TRAINEE";
            case 5:
                return "IMPORT_TRAINEE_CSV";
            case 6:
                return "REGISTER_ADMINISTRATOR";
            case 7:
                return "GET_COMPANY_EQUIPMENT_LIST";
            case 8:
                return "REGISTER_GCM_DEVICE";
            case 400:
                return "ENROLL_IN_COURSE";
            case 401:
                return "ADD_TRAINEE_RATINGS";
            case 402:
                return "EVALUATE_TRAINEE_ACTIVITY";
            case 403:
                return "GET_TRAINEE_ACTIVITY_LIST";
            case 404:
                return "ADD_HELP_REQUEST";
            case 405:
                return "GET_INSTRUCTOR_LIST_BY_CLASS";
            case 406:
                return "SEND_TRAINEE_SHOUT";
            case 300:
                return "ADD_INSTRUCTOR_RATINGS";
            case 301:
                return "GET_TRAINEE_DATA";
            case 302:
                return "GET_CLASS_ACTIVITY_LIST";
            case 303:
                return "ENROLL_TRAINEES_FOR_ACTIVITIES";
            case 304:
                return "GET_INSTRUCTOR_CLASSES";
            case 305:
                return "ASSIGN_INSTRUCTOR_CLASS";
            case 200:
                return "REGISTER_COURSE";
            case 201:
                return "ADD_LESSON";
            case 202:
                return "ADD_OBJECTIVES";
            case 203:
                return "ADD_ACTIVITIES";
            case 204:
                return "ADD_RESOURCES";
            case 205:
                return "GET_COMPANY_COURSE_LIST";
            case 228:
                return "UPDATE_LESSON";
            case 206:
                return "UPDATE_OBJECTIVES";
            case 207:
                return "UPDATE_ACTIVITIES";
            case 210:
                return "DELETE_LESSON";
            case 211:
                return "DELETE_OBJECTIVES";
            case 212:
                return "DELETE_ACTIVITIES";
            case 214:
                return "DELETE_LESSON_RESOURCES";
            case 215:
                return "ADD_CATEGORY";
            case 216:
                return "DELETE_CATEGORY";
            case 217:
                return "ADD_COURSE_CATEGORY";
            case 218:
                return "DELETE_COURSE_CATEGORY";
            case 219:
                return "GET_COURSE_LIST_BY_CATEGORY";
            case 220:
                return "GET_LESSON_LIST_BY_COURSE";
            case 221:
                return "GET_OBJECTIVE_LIST_BY_COURSE";
            case 222:
                return "GET_ACTIVITY_LIST_BY_LESSON";
            case 223:
                return "GET_RESOURCE_LIST_BY_LESSON";
            case 224:
                return "GET_CATEGORY_LIST_BY_COMPANY";
            case 225:
                return "DELETE_COURSE";
            case 226:
                return "UPDATE_CATEGORY";
            case 227:
                return "UPDATE_COURSE";
            case 229:
                return "GET_COURSE_LIST_BY_CLASS";
            case 500:
                return "LOGIN_AUTHOR";
            case 501:
                return "LOGIN_INSTRUCTOR";
            case 502:
                return "LOGIN_TRAINEE";
            case 503:
                return "LOGIN_ADMINISTRATOR";
            case 600:
                return "ADD_TRAINING_CLASS";
            case 601:
                return "ENROLL_TRAINEES_INTO_CLASS";
            case 602:
                return "DEACTIVATE_TRAINEE";
            case 603:
                return "DEACTIVATE_INSTRUCTOR";
            case 604:
                return "DEACTIVATE_ADMIN";
            case 622:
                return "DEACTIVATE_AUTHOR";
            case 605:
                return "ADD_COURSES_TO_CLASS";
            case 607:
                return "REQUEST_CLASS_COMPLETION_REPORT";
            case 616:
                return "ADD_INVENTORY";
            case 617:
                return "UPDATE_INVENTORY";
            case 618:
                return "GET_INVENTORY_LIST";
            case 619:
                return "GET_INVENTORY_LIST_BY_CLASS";
            case 620:
                return "GET_HELP_REQUEST_LIST";
            case 621:
                return "ADD_EQUIPMENT";
            case 608:
                return "GET_INSTRUCTOR_LIST";
            case 609:
                return "GET_CLASS_TRAINEE_LIST";
            case 610:
                return "GET_CLASS_COURSE_LIST";
            case 611:
                return "GET_CLASS_COURSE_TRAINEE_LIST";
            case 612:
                return "GET_CLASS_COURSE_TRAINEE_ACTIVITY_LIST";
            case 613:
                return "GET_CLASS_TRAINEE_EQUIPMENT_LIST";
            case 614:
                return "ADD_TRAINEE_EQUPIMENT";
            case 615:
                return "UPDATE_TRAINEE_EQUPIMENT";
            case 6161:
                return "GET_TRAINEE_ACTIVITY_TOTALS";
            case 6171:
                return "GET_TRAINEE_ACTIVITY_TOTALS_BY_COMPANY";
            case 6181:
                return "GET_TRAINEE_ACTIVITY_TOTALS_BY_INSTRUCTOR";
            case 630:
                return "UPDATE_INSTRUCTOR";
            case 631:
                return "UPDATE_TRAINEE";
            case 632:
                return "UPDATE_ADMIN";
            case 633:
                return "UPDATE_AUTHOR";
            case 640:
                return "UPDATE_EQUIPMENT";
            case 641:
                return "DELETE_EQUIPMENT";
            case 642:
                return "DELETE_INVENTORY";
            case 643:
                return "GET_TRAINEE_EQUIPMENT_LIST_BY_EQUPMENTID";
            case 644:
                return "GET_TRAINEE_EQUIPMENT_LIST_BY_INVENTORYID";
            case 645:
                return "UPDATE_CLASS";
            case 646:
                return "DELETE_CLASS";
            case 647:
                return "GET_INVENTORY_LIST_BY_EQUIPMENT";
            case 648:
                return "GET_CATEGORIES_BY_COMPANY";
            case 700:
                return "GCM_REGISTER_DEVICE";
            case 701:
                return "GCM_SEND_TRAINEE_TO_INSTRUCTOR_MSG";
            case 702:
                return "GCM_SEND_INSTRUCTOR_TO_TRAINEE_MSG";
            case 800:
                return "HELP_REQUESTS_BY_INSTRUCTOR";
            case 801:
                return "HELP_REQUESTS_BY_TRAINEE";
            case 802:
                return "HELP_REQUESTS_BY_CLASS";
            case 803:
                return "HELP_REQUESTS_BY_CLASS_COURSE";
            case 804:
                return "HELP_REQUESTS_BY_CLASS_ACTIVITY";
            case 900:
                return "CREATE_CALENDAR";
            case 901:
                return "ADD_EVENTS";
            case 902:
                return "DELETE_CALENDAR";
            case 903:
                return "DELETE_EVENT";
            case 904:
                return "GET_EVENTS_BY_CLASS";
            case 905:
                return "DELETE_INSTRUCTOR_CLASS";
            case 906:
                return "UPDATE_EVENT";
            case 907:
                return "GET_TRAINING_CLASSES_BY_INSTRUCTOR";
            case 1000:
                return "SEND_PASSWORD_INSTRUCTOR";
            case 1001:
                return "SEND_PASSWORD_TRAINEE";
            case 1002:
                return "SEND_PASSWORD_ADMIN";
            case 1003:
                return "SEND_PASSWORD_AUTHOR";
            case 1004:
                return "SEND_PASSWORD_EXECUTIVE";
            case 1005:
                return "ADD_RATING";
            case 1006:
                return "UPDATE_RATING";
            case 1007:
                return "DELETE_RATING";
            case 1008:
                return "ADD_HELPTYPE";
            case 1009:
                return "UPDATE_HELPTYPE";
            case 1010:
                return "DELETE_HELPTYPE";
            case 1011:
                return "GET_ERROR_LIST";
            case 1012:
                return "GET_OVERALL_STATS";
            case 1013:
                return "GET_COMPANY_STATS";
            case 1014:
                return "GET_SERVER_LOG";
        }

        return "REQUEST_NOT_KNOWN_YET";
    }
    
    private int requestType;
    private long dateFrom, dateTo;
    private String email, cellphone, password, GCMregistrationID,
            title, summary, countryCode;
    private long startDate, endDate, calendarID;
    //operation variables
    private Integer companyID, lessonID, categoryID, cityID,
            authorID, instructorID, trainingClassID, inventoryID,
            courseID, activityID, courseTraineeActivityID,
            instructorClassID, demoAnnouncementID, fromCompanyID, toCompanyID,
            trainingClassCourseID, equipmentID, conditionFlag,
            administratorID, traineeID, traineeEquipmentID, trainingClassEventID;
    private List<Integer> IDs;
    private List<Integer> priorityFlags;
    private boolean returnEquipment;
    private RatingDTO rating;
    private HelpTypeDTO helpType;
    private CompanyDTO company;
    private AuthorDTO author;
    private TraineeShoutDTO traineeShout;
    private CourseTraineeDTO courseTrainee;
    private boolean zippedResponse = false;
    private TrainingClassDTO trainingClass;
    private AdministratorDTO administrator;
    private TraineeDTO trainee;
    private InstructorDTO instructor;
    private TraineeEquipmentDTO traineeEquipment;
    private CourseTraineeActivityDTO courseTraineeActivity;
    private HelpRequestDTO helpRequest;
    private HelpResponseDTO helpResponse;
    private InventoryDTO inventory;
    private EquipmentDTO equipment;
    private int trainingCompanyCourseID;
    private CourseDTO course;
    private CategoryDTO category;
    private ObjectiveDTO objective;
    private LessonResourceDTO lessonResource;
    private ActivityDTO activity;
    private GcmDeviceDTO gcmDevice;
    private TrainingClassEventDTO trainingClassEvent;
    private TeamDTO team;
    private TeamMemberDTO teamMember;
    private DemoAnnouncementDTO demoAnnouncement;
    private SkillDTO skill;
    private SkillLevelDTO skillLevel;
    private  List<TraineeSkillDTO> traineeSkillList;
    //
    List<ActivityDTO> activityList;
    List<ObjectiveDTO> objectiveList;
    List<LessonResourceDTO> lessonResourceList;
    List<InstructorClassDTO> instructorClassList;
    List<CourseDTO> courseList;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public long getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(long dateFrom) {
        this.dateFrom = dateFrom;
    }

    public long getDateTo() {
        return dateTo;
    }

    public void setDateTo(long dateTo) {
        this.dateTo = dateTo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGCMregistrationID() {
        return GCMregistrationID;
    }

    public void setGCMregistrationID(String GCMregistrationID) {
        this.GCMregistrationID = GCMregistrationID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public long getCalendarID() {
        return calendarID;
    }

    public void setCalendarID(long calendarID) {
        this.calendarID = calendarID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public Integer getCourseTraineeActivityID() {
        return courseTraineeActivityID;
    }

    public void setCourseTraineeActivityID(Integer courseTraineeActivityID) {
        this.courseTraineeActivityID = courseTraineeActivityID;
    }

    public Integer getInstructorClassID() {
        return instructorClassID;
    }

    public void setInstructorClassID(Integer instructorClassID) {
        this.instructorClassID = instructorClassID;
    }

    public Integer getDemoAnnouncementID() {
        return demoAnnouncementID;
    }

    public void setDemoAnnouncementID(Integer demoAnnouncementID) {
        this.demoAnnouncementID = demoAnnouncementID;
    }

    public Integer getFromCompanyID() {
        return fromCompanyID;
    }

    public void setFromCompanyID(Integer fromCompanyID) {
        this.fromCompanyID = fromCompanyID;
    }

    public Integer getToCompanyID() {
        return toCompanyID;
    }

    public void setToCompanyID(Integer toCompanyID) {
        this.toCompanyID = toCompanyID;
    }

    public Integer getTrainingClassCourseID() {
        return trainingClassCourseID;
    }

    public void setTrainingClassCourseID(Integer trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    public Integer getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(Integer conditionFlag) {
        this.conditionFlag = conditionFlag;
    }

    public Integer getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Integer administratorID) {
        this.administratorID = administratorID;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public Integer getTraineeEquipmentID() {
        return traineeEquipmentID;
    }

    public void setTraineeEquipmentID(Integer traineeEquipmentID) {
        this.traineeEquipmentID = traineeEquipmentID;
    }

    public Integer getTrainingClassEventID() {
        return trainingClassEventID;
    }

    public void setTrainingClassEventID(Integer trainingClassEventID) {
        this.trainingClassEventID = trainingClassEventID;
    }

    public List<Integer> getIDs() {
        return IDs;
    }

    public void setIDs(List<Integer> IDs) {
        this.IDs = IDs;
    }

    public List<Integer> getPriorityFlags() {
        return priorityFlags;
    }

    public void setPriorityFlags(List<Integer> priorityFlags) {
        this.priorityFlags = priorityFlags;
    }

    public boolean isReturnEquipment() {
        return returnEquipment;
    }

    public void setReturnEquipment(boolean returnEquipment) {
        this.returnEquipment = returnEquipment;
    }

    public RatingDTO getRating() {
        return rating;
    }

    public void setRating(RatingDTO rating) {
        this.rating = rating;
    }

    public HelpTypeDTO getHelpType() {
        return helpType;
    }

    public void setHelpType(HelpTypeDTO helpType) {
        this.helpType = helpType;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public TraineeShoutDTO getTraineeShout() {
        return traineeShout;
    }

    public void setTraineeShout(TraineeShoutDTO traineeShout) {
        this.traineeShout = traineeShout;
    }

    public CourseTraineeDTO getCourseTrainee() {
        return courseTrainee;
    }

    public void setCourseTrainee(CourseTraineeDTO courseTrainee) {
        this.courseTrainee = courseTrainee;
    }

    public boolean isZippedResponse() {
        return zippedResponse;
    }

    public void setZippedResponse(boolean zippedResponse) {
        this.zippedResponse = zippedResponse;
    }

    public TrainingClassDTO getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClassDTO trainingClass) {
        this.trainingClass = trainingClass;
    }

    public AdministratorDTO getAdministrator() {
        return administrator;
    }

    public void setAdministrator(AdministratorDTO administrator) {
        this.administrator = administrator;
    }

    public TraineeDTO getTrainee() {
        return trainee;
    }

    public void setTrainee(TraineeDTO trainee) {
        this.trainee = trainee;
    }

    public InstructorDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDTO instructor) {
        this.instructor = instructor;
    }

    public TraineeEquipmentDTO getTraineeEquipment() {
        return traineeEquipment;
    }

    public void setTraineeEquipment(TraineeEquipmentDTO traineeEquipment) {
        this.traineeEquipment = traineeEquipment;
    }

    public CourseTraineeActivityDTO getCourseTraineeActivity() {
        return courseTraineeActivity;
    }

    public void setCourseTraineeActivity(CourseTraineeActivityDTO courseTraineeActivity) {
        this.courseTraineeActivity = courseTraineeActivity;
    }

    public HelpRequestDTO getHelpRequest() {
        return helpRequest;
    }

    public void setHelpRequest(HelpRequestDTO helpRequest) {
        this.helpRequest = helpRequest;
    }

    public HelpResponseDTO getHelpResponse() {
        return helpResponse;
    }

    public void setHelpResponse(HelpResponseDTO helpResponse) {
        this.helpResponse = helpResponse;
    }

    public InventoryDTO getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDTO inventory) {
        this.inventory = inventory;
    }

    public EquipmentDTO getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentDTO equipment) {
        this.equipment = equipment;
    }

    public int getTrainingCompanyCourseID() {
        return trainingCompanyCourseID;
    }

    public void setTrainingCompanyCourseID(int trainingCompanyCourseID) {
        this.trainingCompanyCourseID = trainingCompanyCourseID;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public ObjectiveDTO getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveDTO objective) {
        this.objective = objective;
    }

    public LessonResourceDTO getLessonResource() {
        return lessonResource;
    }

    public void setLessonResource(LessonResourceDTO lessonResource) {
        this.lessonResource = lessonResource;
    }

    public ActivityDTO getActivity() {
        return activity;
    }

    public void setActivity(ActivityDTO activity) {
        this.activity = activity;
    }

    public GcmDeviceDTO getGcmDevice() {
        return gcmDevice;
    }

    public void setGcmDevice(GcmDeviceDTO gcmDevice) {
        this.gcmDevice = gcmDevice;
    }

    public TrainingClassEventDTO getTrainingClassEvent() {
        return trainingClassEvent;
    }

    public void setTrainingClassEvent(TrainingClassEventDTO trainingClassEvent) {
        this.trainingClassEvent = trainingClassEvent;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public TeamMemberDTO getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMemberDTO teamMember) {
        this.teamMember = teamMember;
    }

    public DemoAnnouncementDTO getDemoAnnouncement() {
        return demoAnnouncement;
    }

    public void setDemoAnnouncement(DemoAnnouncementDTO demoAnnouncement) {
        this.demoAnnouncement = demoAnnouncement;
    }

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }

    public SkillLevelDTO getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevelDTO skillLevel) {
        this.skillLevel = skillLevel;
    }

    public List<TraineeSkillDTO> getTraineeSkillList() {
        return traineeSkillList;
    }

    public void setTraineeSkillList(List<TraineeSkillDTO> traineeSkillList) {
        this.traineeSkillList = traineeSkillList;
    }

    public List<ActivityDTO> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityDTO> activityList) {
        this.activityList = activityList;
    }

    public List<ObjectiveDTO> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(List<ObjectiveDTO> objectiveList) {
        this.objectiveList = objectiveList;
    }

    public List<LessonResourceDTO> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResourceDTO> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }

    public List<InstructorClassDTO> getInstructorClassList() {
        return instructorClassList;
    }

    public void setInstructorClassList(List<InstructorClassDTO> instructorClassList) {
        this.instructorClassList = instructorClassList;
    }

    public List<CourseDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDTO> courseList) {
        this.courseList = courseList;
    }

    
}
