package com.systrack.admission;

import android.app.Application;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;



public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();
    String CurrentAcademicYear,courseMgtDivisionFlag,timeTable_WEEKDAY;
    String manageEmpStreamId,manageEmpStreamName,manageEmpMediumName,manageEmpDepartmentId,manageEmpDepartmentName,manageEmpDesignationId,manageEmpDesignationName,manageEmpCategoryId,manageEmpCategoryName;
String Employee_Profile_FullNAme,Employee_Profile_DesignationNAme,Employee_Profile_EmployeeID;
String manageEmpCourseFlag,manageEmpMediumFlag,classTimingBatchFlag,classTimingSectionFlag,stuAttendanceSubFlag,stuAttendanceClassTimeFlag,manageEmpDepartmentFlag,leaveAssignLeaveYearFlag,manageEmpDeSignationFlag;
String classTimingStreamId,classTimingStreamName,classTimingMedium,classTimingBatchId,classTimingBatchName,classTimingSemName,classTimingDivisionId,classTimingDivisionName;
    String timeTableStreamId,timeTableStreamName,timeTableMedium,timeTableBatchId,timeTableBatchName,
            timeTableSemName,timeTableDivisionId,timeTableDivisionName;

    String stuAttendanceStreamId,StuAttendanceStreamName,stuAttendanceMedium,stuAttendanceBatchId,stuAttendanceBatchName,stuAttendanceDivId,stuAttendanceDivName,stuAttendanceClassTimingId,stuAttendanceClassTimingName,stuAttendanceSectionName,stuAttendanceSubId,stuAttendanceSubName,stuAttendanceLectureDate;
    String leaveReportingStreamId,leaveReportingStreamName,leaveReportingMedium,leaveReportingDepartmentId,leaveReportingDepartmentName;
    String leaveAssignStreamId,leaveAssignStreamName,leaveAssignMedium,leaveAssignDepartmentId,leaveAssignDepartmentName,leaveAssignLeaveYearID,leaveAssignLeaveYearName;
    String leaveApplicantStreamId,leaveApplicantStreamName,leaveApplicantMedium;
String manageAttendanceSteamId,manageAttendanceStreamName,manageAttendanceMedium,manageAttendanceDepartmetId,manageAttendanceDepartmentName,manageAttendanceDate;

String empLeaveReportingLeaveYearId,empLeaveReportingLeaveYearName;
String examTimetableStreamId,examTimeTableStreamName,examTimeTableMedium,examTimeTableBatchId,examTimeTableBatchName, examTimeTableSectionName,examTimeTableYearId,examTimeTableYearName;
String hall_arrangement_yearId,hall_arrangement_yearName,hall_arrangement_examId,hall_arrangement_examName,hall_arrangement_hallNo,hall_arrangement_HallName;
String student_list_year_id,student_list_yearName,student_list_examId,student_list_examName,student_list_hallId,student_list_hallName,student_list_examTimeName;
String moderator_affiliation_yearId,moderator_affiliation_yearName,moderator_affiliation_streamId,moderator_affiliation_streamName,moderator_affiliation_medium,
        moderator_affiliation_batchId,moderator_affiliation_batchName,moderator_affiliation_sectionName,moderator_affiliation_divisionId,moderator_affiliation_divisionName;

String generate_marksheet_streamId,generate_marksheet_streamName,generate_marksheet_batchId,generate_marksheet_batchName,generate_marksheet_sectionName,
        generate_marksheet_medium,generate_marksheet_divisionId,generate_marksheet_divisionName,generate_marksheet_subjectId,generate_marksheet_subjectName;

String broadSheet_streamId,broadSheet_streamName,broadSheet_Medium,broadSheet_sectionId,broadSheet_sectionName,broadSheet_batch_id,broadSheet_batchName;
String teacher_allocation_streamId,teacher_allocation_streamName,teacher_allocation_medium,teacher_allocation_yearId,teacher_allocation_yearName,teacher_allocation_batchId,
        teacher_allocation_batchName,teacher_allocation_sectionName,teacher_allocation_sectionId;

String subject_allocation_streamID,subject_allocation_streamName,subject_allocation_medium,subject_allocation_batchId;
String manage_student_yearID,manage_student_yearName,manage_student_streamId,manage_student_streamName,manage_student_medium,manage_student_batchId,manage_student_batchName,
        manage_student_sectionName,manage_student_sectionId;

String assignment_streamId,assignment_streamName,assignment_medium,assignment_batchId,assignment_batchName,
        assignment_sectionId,assignment_sectionName,assignment_divId,assignment_divName,assignment_yearId,assignment_yearName;


    String publish_timeTable_timeTableId,publish_timeTable_examName,publish_timeTable_sectionId,publish_timeTable_batchId,publish_timeTable_minDate,publish_timeTable_maxDate,
    publish_timetable_batchName,publish_timetable_sectionName;
String myTimeTableDayWiseSpinnerId,myTimeTableDayWiseSpinnerName;

String employeeContactStreamId,employeeContactStreamName,employeeContactDesignationId,employeeContactDesignationName,employeeContactDepartmentId,employeeContactDepartmentName;
String student_contact_streamId,student_contact_streamName,student_contact_medium,student_contact_batchId,student_contact_batchName,student_contact_sectionId,student_contact_sectionName;

    public String getStudent_contact_streamId() {
        return student_contact_streamId;
    }

    public void setStudent_contact_streamId(String student_contact_streamId) {
        this.student_contact_streamId = student_contact_streamId;
    }

    public String getStudent_contact_streamName() {
        return student_contact_streamName;
    }

    public void setStudent_contact_streamName(String student_contact_streamName) {
        this.student_contact_streamName = student_contact_streamName;
    }

    public String getStudent_contact_medium() {
        return student_contact_medium;
    }

    public void setStudent_contact_medium(String student_contact_medium) {
        this.student_contact_medium = student_contact_medium;
    }

    public String getStudent_contact_batchId() {
        return student_contact_batchId;
    }

    public void setStudent_contact_batchId(String student_contact_batchId) {
        this.student_contact_batchId = student_contact_batchId;
    }

    public String getStudent_contact_batchName() {
        return student_contact_batchName;
    }

    public void setStudent_contact_batchName(String student_contact_batchName) {
        this.student_contact_batchName = student_contact_batchName;
    }

    public String getStudent_contact_sectionId() {
        return student_contact_sectionId;
    }

    public void setStudent_contact_sectionId(String student_contact_sectionId) {
        this.student_contact_sectionId = student_contact_sectionId;
    }

    public String getStudent_contact_sectionName() {
        return student_contact_sectionName;
    }

    public void setStudent_contact_sectionName(String student_contact_sectionName) {
        this.student_contact_sectionName = student_contact_sectionName;
    }

    public String getManageEmpDeSignationFlag() {
        return manageEmpDeSignationFlag;
    }

    public void setManageEmpDeSignationFlag(String manageEmpDeSignationFlag) {
        this.manageEmpDeSignationFlag = manageEmpDeSignationFlag;
    }

    public String getEmployeeContactStreamId() {
        return employeeContactStreamId;
    }

    public void setEmployeeContactStreamId(String employeeContactStreamId) {
        this.employeeContactStreamId = employeeContactStreamId;
    }

    public String getEmployeeContactStreamName() {
        return employeeContactStreamName;
    }

    public void setEmployeeContactStreamName(String employeeContactStreamName) {
        this.employeeContactStreamName = employeeContactStreamName;
    }

    public String getEmployeeContactDesignationId() {
        return employeeContactDesignationId;
    }

    public void setEmployeeContactDesignationId(String employeeContactDesignationId) {
        this.employeeContactDesignationId = employeeContactDesignationId;
    }

    public String getEmployeeContactDesignationName() {
        return employeeContactDesignationName;
    }

    public void setEmployeeContactDesignationName(String employeeContactDesignationName) {
        this.employeeContactDesignationName = employeeContactDesignationName;
    }

    public String getEmployeeContactDepartmentId() {
        return employeeContactDepartmentId;
    }

    public void setEmployeeContactDepartmentId(String employeeContactDepartmentId) {
        this.employeeContactDepartmentId = employeeContactDepartmentId;
    }

    public String getEmployeeContactDepartmentName() {
        return employeeContactDepartmentName;
    }

    public void setEmployeeContactDepartmentName(String employeeContactDepartmentName) {
        this.employeeContactDepartmentName = employeeContactDepartmentName;
    }

    String DateArray_Api,dashBoardMgtNoticeStreamID,dashBoardMgtNoticeStreamName;

    public String getDashBoardMgtNoticeStreamID() {
        return dashBoardMgtNoticeStreamID;
    }

    public void setDashBoardMgtNoticeStreamID(String dashBoardMgtNoticeStreamID) {
        this.dashBoardMgtNoticeStreamID = dashBoardMgtNoticeStreamID;
    }

    public String getDashBoardMgtNoticeStreamName() {
        return dashBoardMgtNoticeStreamName;
    }

    public void setDashBoardMgtNoticeStreamName(String dashBoardMgtNoticeStreamName) {
        this.dashBoardMgtNoticeStreamName = dashBoardMgtNoticeStreamName;
    }

    String[] monthly_attendance_Array;

    public String getMyTimeTableDayWiseSpinnerId() {
        return myTimeTableDayWiseSpinnerId;
    }

    public void setMyTimeTableDayWiseSpinnerId(String myTimeTableDayWiseSpinnerId) {
        this.myTimeTableDayWiseSpinnerId = myTimeTableDayWiseSpinnerId;
    }

    public String getMyTimeTableDayWiseSpinnerName() {
        return myTimeTableDayWiseSpinnerName;
    }

    public void setMyTimeTableDayWiseSpinnerName(String myTimeTableDayWiseSpinnerName) {
        this.myTimeTableDayWiseSpinnerName = myTimeTableDayWiseSpinnerName;
    }

    public String[] getMonthly_attendance_Array() {
        return monthly_attendance_Array;
    }

    public void setMonthly_attendance_Array(String[] monthly_attendance_Array) {
        this.monthly_attendance_Array = monthly_attendance_Array;
    }

    public String getDateArray_Api() {
        return DateArray_Api;
    }

    public void setDateArray_Api(String dateArray_Api) {
        DateArray_Api = dateArray_Api;
    }

    public String getPublish_timetable_batchName() {
        return publish_timetable_batchName;
    }

    public void setPublish_timetable_batchName(String publish_timetable_batchName) {
        this.publish_timetable_batchName = publish_timetable_batchName;
    }

    public String getPublish_timetable_sectionName() {
        return publish_timetable_sectionName;
    }

    public void setPublish_timetable_sectionName(String publish_timetable_sectionName) {
        this.publish_timetable_sectionName = publish_timetable_sectionName;
    }

    public String getPublish_timeTable_minDate() {
        return publish_timeTable_minDate;
    }

    public String getPublish_timeTable_timeTableId() {
        return publish_timeTable_timeTableId;
    }

    public void setPublish_timeTable_timeTableId(String publish_timeTable_timeTableId) {
        this.publish_timeTable_timeTableId = publish_timeTable_timeTableId;
    }

    public void setPublish_timeTable_minDate(String publish_timeTable_minDate) {
        this.publish_timeTable_minDate = publish_timeTable_minDate;
    }

    public String getPublish_timeTable_maxDate() {
        return publish_timeTable_maxDate;
    }

    public void setPublish_timeTable_maxDate(String publish_timeTable_maxDate) {
        this.publish_timeTable_maxDate = publish_timeTable_maxDate;
    }

    public String getPublish_timeTable_sectionId() {
        return publish_timeTable_sectionId;
    }

    public void setPublish_timeTable_sectionId(String publish_timeTable_sectionId) {
        this.publish_timeTable_sectionId = publish_timeTable_sectionId;
    }

    public String getPublish_timeTable_batchId() {
        return publish_timeTable_batchId;
    }

    public void setPublish_timeTable_batchId(String publish_timeTable_batchId) {
        this.publish_timeTable_batchId = publish_timeTable_batchId;
    }

    public String getPublish_timeTable_examName() {
        return publish_timeTable_examName;
    }

    public void setPublish_timeTable_examName(String publish_timeTable_examName) {
        this.publish_timeTable_examName = publish_timeTable_examName;
    }

    public String getAssignment_yearId() {
        return assignment_yearId;
    }

    public void setAssignment_yearId(String assignment_yearId) {
        this.assignment_yearId = assignment_yearId;
    }

    public String getAssignment_yearName() {
        return assignment_yearName;
    }

    public void setAssignment_yearName(String assignment_yearName) {
        this.assignment_yearName = assignment_yearName;
    }

    public String getAssignment_streamId() {
        return assignment_streamId;
    }

    public void setAssignment_streamId(String assignment_streamId) {
        this.assignment_streamId = assignment_streamId;
    }

    public String getAssignment_streamName() {
        return assignment_streamName;
    }

    public void setAssignment_streamName(String assignment_streamName) {
        this.assignment_streamName = assignment_streamName;
    }

    public String getAssignment_medium() {
        return assignment_medium;
    }

    public void setAssignment_medium(String assignment_medium) {
        this.assignment_medium = assignment_medium;
    }

    public String getAssignment_batchId() {
        return assignment_batchId;
    }

    public void setAssignment_batchId(String assignment_batchId) {
        this.assignment_batchId = assignment_batchId;
    }

    public String getAssignment_batchName() {
        return assignment_batchName;
    }

    public void setAssignment_batchName(String assignment_batchName) {
        this.assignment_batchName = assignment_batchName;
    }

    public String getAssignment_sectionId() {
        return assignment_sectionId;
    }

    public void setAssignment_sectionId(String assignment_sectionId) {
        this.assignment_sectionId = assignment_sectionId;
    }

    public String getAssignment_sectionName() {
        return assignment_sectionName;
    }

    public void setAssignment_sectionName(String assignment_sectionName) {
        this.assignment_sectionName = assignment_sectionName;
    }

    public String getAssignment_divId() {
        return assignment_divId;
    }

    public void setAssignment_divId(String assignment_divId) {
        this.assignment_divId = assignment_divId;
    }

    public String getAssignment_divName() {
        return assignment_divName;
    }

    public void setAssignment_divName(String assignment_divName) {
        this.assignment_divName = assignment_divName;
    }

    public String getManage_student_yearID() {
        return manage_student_yearID;
    }

    public void setManage_student_yearID(String manage_student_yearID) {
        this.manage_student_yearID = manage_student_yearID;
    }

    public String getManage_student_yearName() {
        return manage_student_yearName;
    }

    public void setManage_student_yearName(String manage_student_yearName) {
        this.manage_student_yearName = manage_student_yearName;
    }

    public String getManage_student_streamId() {
        return manage_student_streamId;
    }

    public void setManage_student_streamId(String manage_student_streamId) {
        this.manage_student_streamId = manage_student_streamId;
    }

    public String getManage_student_streamName() {
        return manage_student_streamName;
    }

    public void setManage_student_streamName(String manage_student_streamName) {
        this.manage_student_streamName = manage_student_streamName;
    }

    public String getManage_student_medium() {
        return manage_student_medium;
    }

    public void setManage_student_medium(String manage_student_medium) {
        this.manage_student_medium = manage_student_medium;
    }

    public String getManage_student_batchId() {
        return manage_student_batchId;
    }

    public void setManage_student_batchId(String manage_student_batchId) {
        this.manage_student_batchId = manage_student_batchId;
    }

    public String getManage_student_batchName() {
        return manage_student_batchName;
    }

    public void setManage_student_batchName(String manage_student_batchName) {
        this.manage_student_batchName = manage_student_batchName;
    }

    public String getManage_student_sectionName() {
        return manage_student_sectionName;
    }

    public void setManage_student_sectionName(String manage_student_sectionName) {
        this.manage_student_sectionName = manage_student_sectionName;
    }

    public String getManage_student_sectionId() {
        return manage_student_sectionId;
    }

    public void setManage_student_sectionId(String manage_student_sectionId) {
        this.manage_student_sectionId = manage_student_sectionId;
    }

    public String getSubject_allocation_streamID() {
        return subject_allocation_streamID;
    }

    public void setSubject_allocation_streamID(String subject_allocation_streamID) {
        this.subject_allocation_streamID = subject_allocation_streamID;
    }

    public String getSubject_allocation_streamName() {
        return subject_allocation_streamName;
    }

    public void setSubject_allocation_streamName(String subject_allocation_streamName) {
        this.subject_allocation_streamName = subject_allocation_streamName;
    }

    public String getSubject_allocation_medium() {
        return subject_allocation_medium;
    }

    public void setSubject_allocation_medium(String subject_allocation_medium) {
        this.subject_allocation_medium = subject_allocation_medium;
    }

    public String getSubject_allocation_batchId() {
        return subject_allocation_batchId;
    }

    public void setSubject_allocation_batchId(String subject_allocation_batchId) {
        this.subject_allocation_batchId = subject_allocation_batchId;
    }

    public String getSubject_allocation_batchName() {
        return subject_allocation_batchName;
    }

    public void setSubject_allocation_batchName(String subject_allocation_batchName) {
        this.subject_allocation_batchName = subject_allocation_batchName;
    }

    public String getSubject_allocation_sectionName() {
        return subject_allocation_sectionName;
    }

    public void setSubject_allocation_sectionName(String subject_allocation_sectionName) {
        this.subject_allocation_sectionName = subject_allocation_sectionName;
    }

    public String getSubject_allocation_empName() {
        return subject_allocation_empName;
    }

    public void setSubject_allocation_empName(String subject_allocation_empName) {
        this.subject_allocation_empName = subject_allocation_empName;
    }

    public String getSubject_allocation_empId() {
        return subject_allocation_empId;
    }

    public void setSubject_allocation_empId(String subject_allocation_empId) {
        this.subject_allocation_empId = subject_allocation_empId;
    }

    public String getSubject_allocation_yearId() {
        return subject_allocation_yearId;
    }

    public void setSubject_allocation_yearId(String subject_allocation_yearId) {
        this.subject_allocation_yearId = subject_allocation_yearId;
    }

    public String getSubject_allocation_yearName() {
        return subject_allocation_yearName;
    }

    public void setSubject_allocation_yearName(String subject_allocation_yearName) {
        this.subject_allocation_yearName = subject_allocation_yearName;
    }

    String subject_allocation_batchName;
    String subject_allocation_sectionName;
    String subject_allocation_empName;
    String subject_allocation_empId;
    String subject_allocation_yearId;
    String subject_allocation_yearName;
String selected_current_Leave_DurationID,selected_current_Leave_AppID,select_workloadAdjust_startDate,select_workloadAdjust_endDate;

    ArrayList<String> collection_saved;
    ArrayList<String> collection_saved_search;

    public String getSelect_workloadAdjust_startDate() {
        return select_workloadAdjust_startDate;
    }

    public void setSelect_workloadAdjust_startDate(String select_workloadAdjust_startDate) {
        this.select_workloadAdjust_startDate = select_workloadAdjust_startDate;
    }

    public String getSelect_workloadAdjust_endDate() {
        return select_workloadAdjust_endDate;
    }

    public void setSelect_workloadAdjust_endDate(String select_workloadAdjust_endDate) {
        this.select_workloadAdjust_endDate = select_workloadAdjust_endDate;
    }

    public String getSelected_current_Leave_AppID() {
        return selected_current_Leave_AppID;
    }

    public void setSelected_current_Leave_AppID(String selected_current_Leave_AppID) {
        this.selected_current_Leave_AppID = selected_current_Leave_AppID;
    }

    public String getSelected_current_Leave_DurationID() {
        return selected_current_Leave_DurationID;
    }

    public void setSelected_current_Leave_DurationID(String selected_current_Leave_DurationID) {
        this.selected_current_Leave_DurationID = selected_current_Leave_DurationID;
    }

    public String getTeacher_allocation_streamId() {
        return teacher_allocation_streamId;
    }

    public void setTeacher_allocation_streamId(String teacher_allocation_streamId) {
        this.teacher_allocation_streamId = teacher_allocation_streamId;
    }

    public String getTeacher_allocation_streamName() {
        return teacher_allocation_streamName;
    }

    public void setTeacher_allocation_streamName(String teacher_allocation_streamName) {
        this.teacher_allocation_streamName = teacher_allocation_streamName;
    }

    public String getTeacher_allocation_medium() {
        return teacher_allocation_medium;
    }

    public void setTeacher_allocation_medium(String teacher_allocation_medium) {
        this.teacher_allocation_medium = teacher_allocation_medium;
    }

    public String getTeacher_allocation_yearId() {
        return teacher_allocation_yearId;
    }

    public void setTeacher_allocation_yearId(String teacher_allocation_yearId) {
        this.teacher_allocation_yearId = teacher_allocation_yearId;
    }

    public String getTeacher_allocation_yearName() {
        return teacher_allocation_yearName;
    }

    public void setTeacher_allocation_yearName(String teacher_allocation_yearName) {
        this.teacher_allocation_yearName = teacher_allocation_yearName;
    }

    public String getTeacher_allocation_batchId() {
        return teacher_allocation_batchId;
    }

    public void setTeacher_allocation_batchId(String teacher_allocation_batchId) {
        this.teacher_allocation_batchId = teacher_allocation_batchId;
    }

    public String getTeacher_allocation_batchName() {
        return teacher_allocation_batchName;
    }

    public void setTeacher_allocation_batchName(String teacher_allocation_batchName) {
        this.teacher_allocation_batchName = teacher_allocation_batchName;
    }

    public String getTeacher_allocation_sectionName() {
        return teacher_allocation_sectionName;
    }

    public void setTeacher_allocation_sectionName(String teacher_allocation_sectionName) {
        this.teacher_allocation_sectionName = teacher_allocation_sectionName;
    }

    public String getTeacher_allocation_sectionId() {
        return teacher_allocation_sectionId;
    }

    public void setTeacher_allocation_sectionId(String teacher_allocation_sectionId) {
        this.teacher_allocation_sectionId = teacher_allocation_sectionId;
    }

    public ArrayList<String> getCollection_saved() {
        return collection_saved;
    }

    public void setCollection_saved(ArrayList<String> collection_saved) {
        this.collection_saved = collection_saved;
    }

    public ArrayList<String> getCollection_saved_search() {
        return collection_saved_search;
    }

    public void setCollection_saved_search(ArrayList<String> collection_saved_search) {
        this.collection_saved_search = collection_saved_search;
    }

    public String getBroadSheet_streamId() {
        return broadSheet_streamId;
    }

    public void setBroadSheet_streamId(String broadSheet_streamId) {
        this.broadSheet_streamId = broadSheet_streamId;
    }

    public String getBroadSheet_streamName() {
        return broadSheet_streamName;
    }

    public void setBroadSheet_streamName(String broadSheet_streamName) {
        this.broadSheet_streamName = broadSheet_streamName;
    }

    public String getBroadSheet_Medium() {
        return broadSheet_Medium;
    }

    public void setBroadSheet_Medium(String broadSheet_Medium) {
        this.broadSheet_Medium = broadSheet_Medium;
    }

    public String getBroadSheet_sectionId() {
        return broadSheet_sectionId;
    }

    public void setBroadSheet_sectionId(String broadSheet_sectionId) {
        this.broadSheet_sectionId = broadSheet_sectionId;
    }

    public String getBroadSheet_sectionName() {
        return broadSheet_sectionName;
    }

    public void setBroadSheet_sectionName(String broadSheet_sectionName) {
        this.broadSheet_sectionName = broadSheet_sectionName;
    }

    public String getBroadSheet_batch_id() {
        return broadSheet_batch_id;
    }

    public void setBroadSheet_batch_id(String broadSheet_batch_id) {
        this.broadSheet_batch_id = broadSheet_batch_id;
    }

    public String getBroadSheet_batchName() {
        return broadSheet_batchName;
    }

    public void setBroadSheet_batchName(String broadSheet_batchName) {
        this.broadSheet_batchName = broadSheet_batchName;
    }

    public String getGenerate_marksheet_streamId() {
        return generate_marksheet_streamId;
    }

    public void setGenerate_marksheet_streamId(String generate_marksheet_streamId) {
        this.generate_marksheet_streamId = generate_marksheet_streamId;
    }

    public String getGenerate_marksheet_streamName() {
        return generate_marksheet_streamName;
    }

    public void setGenerate_marksheet_streamName(String generate_marksheet_streamName) {
        this.generate_marksheet_streamName = generate_marksheet_streamName;
    }

    public String getGenerate_marksheet_batchId() {
        return generate_marksheet_batchId;
    }

    public void setGenerate_marksheet_batchId(String generate_marksheet_batchId) {
        this.generate_marksheet_batchId = generate_marksheet_batchId;
    }

    public String getGenerate_marksheet_batchName() {
        return generate_marksheet_batchName;
    }

    public void setGenerate_marksheet_batchName(String generate_marksheet_batchName) {
        this.generate_marksheet_batchName = generate_marksheet_batchName;
    }

    public String getGenerate_marksheet_sectionName() {
        return generate_marksheet_sectionName;
    }

    public void setGenerate_marksheet_sectionName(String generate_marksheet_sectionName) {
        this.generate_marksheet_sectionName = generate_marksheet_sectionName;
    }

    public String getGenerate_marksheet_medium() {
        return generate_marksheet_medium;
    }

    public void setGenerate_marksheet_medium(String generate_marksheet_medium) {
        this.generate_marksheet_medium = generate_marksheet_medium;
    }

    public String getGenerate_marksheet_divisionId() {
        return generate_marksheet_divisionId;
    }

    public void setGenerate_marksheet_divisionId(String generate_marksheet_divisionId) {
        this.generate_marksheet_divisionId = generate_marksheet_divisionId;
    }

    public String getGenerate_marksheet_divisionName() {
        return generate_marksheet_divisionName;
    }

    public void setGenerate_marksheet_divisionName(String generate_marksheet_divisionName) {
        this.generate_marksheet_divisionName = generate_marksheet_divisionName;
    }

    public String getGenerate_marksheet_subjectId() {
        return generate_marksheet_subjectId;
    }

    public void setGenerate_marksheet_subjectId(String generate_marksheet_subjectId) {
        this.generate_marksheet_subjectId = generate_marksheet_subjectId;
    }

    public String getGenerate_marksheet_subjectName() {
        return generate_marksheet_subjectName;
    }

    public void setGenerate_marksheet_subjectName(String generate_marksheet_subjectName) {
        this.generate_marksheet_subjectName = generate_marksheet_subjectName;
    }

    public String getModerator_affiliation_yearId() {
        return moderator_affiliation_yearId;
    }

    public void setModerator_affiliation_yearId(String moderator_affiliation_yearId) {
        this.moderator_affiliation_yearId = moderator_affiliation_yearId;
    }

    public String getModerator_affiliation_yearName() {
        return moderator_affiliation_yearName;
    }

    public void setModerator_affiliation_yearName(String moderator_affiliation_yearName) {
        this.moderator_affiliation_yearName = moderator_affiliation_yearName;
    }

    public String getModerator_affiliation_streamId() {
        return moderator_affiliation_streamId;
    }

    public void setModerator_affiliation_streamId(String moderator_affiliation_streamId) {
        this.moderator_affiliation_streamId = moderator_affiliation_streamId;
    }

    public String getModerator_affiliation_streamName() {
        return moderator_affiliation_streamName;
    }

    public void setModerator_affiliation_streamName(String moderator_affiliation_streamName) {
        this.moderator_affiliation_streamName = moderator_affiliation_streamName;
    }

    public String getModerator_affiliation_medium() {
        return moderator_affiliation_medium;
    }

    public void setModerator_affiliation_medium(String moderator_affiliation_medium) {
        this.moderator_affiliation_medium = moderator_affiliation_medium;
    }

    public String getModerator_affiliation_batchId() {
        return moderator_affiliation_batchId;
    }

    public void setModerator_affiliation_batchId(String moderator_affiliation_batchId) {
        this.moderator_affiliation_batchId = moderator_affiliation_batchId;
    }

    public String getModerator_affiliation_batchName() {
        return moderator_affiliation_batchName;
    }

    public void setModerator_affiliation_batchName(String moderator_affiliation_batchName) {
        this.moderator_affiliation_batchName = moderator_affiliation_batchName;
    }

    public String getModerator_affiliation_sectionName() {
        return moderator_affiliation_sectionName;
    }

    public void setModerator_affiliation_sectionName(String moderator_affiliation_sectionName) {
        this.moderator_affiliation_sectionName = moderator_affiliation_sectionName;
    }

    public String getModerator_affiliation_divisionId() {
        return moderator_affiliation_divisionId;
    }

    public void setModerator_affiliation_divisionId(String moderator_affiliation_divisionId) {
        this.moderator_affiliation_divisionId = moderator_affiliation_divisionId;
    }

    public String getModerator_affiliation_divisionName() {
        return moderator_affiliation_divisionName;
    }

    public void setModerator_affiliation_divisionName(String moderator_affiliation_divisionName) {
        this.moderator_affiliation_divisionName = moderator_affiliation_divisionName;
    }

    public String getCurrentAcademicYear() {
        return CurrentAcademicYear;
    }

    public void setCurrentAcademicYear(String currentAcademicYear) {
        CurrentAcademicYear = currentAcademicYear;
    }

    public String getStudent_list_year_id() {
        return student_list_year_id;
    }

    public void setStudent_list_year_id(String student_list_year_id) {
        this.student_list_year_id = student_list_year_id;
    }

    public String getStudent_list_yearName() {
        return student_list_yearName;
    }

    public void setStudent_list_yearName(String student_list_yearName) {
        this.student_list_yearName = student_list_yearName;
    }

    public String getStudent_list_examId() {
        return student_list_examId;
    }

    public void setStudent_list_examId(String student_list_examId) {
        this.student_list_examId = student_list_examId;
    }

    public String getStudent_list_examName() {
        return student_list_examName;
    }

    public void setStudent_list_examName(String student_list_examName) {
        this.student_list_examName = student_list_examName;
    }

    public String getStudent_list_hallId() {
        return student_list_hallId;
    }

    public void setStudent_list_hallId(String student_list_hallId) {
        this.student_list_hallId = student_list_hallId;
    }

    public String getStudent_list_hallName() {
        return student_list_hallName;
    }

    public void setStudent_list_hallName(String student_list_hallName) {
        this.student_list_hallName = student_list_hallName;
    }


    public String getStudent_list_examTimeName() {
        return student_list_examTimeName;
    }

    public void setStudent_list_examTimeName(String student_list_examTimeName) {
        this.student_list_examTimeName = student_list_examTimeName;
    }

    public String getHallArrangementExamNameFlag() {
        return HallArrangementExamNameFlag;
    }

    public void setHallArrangementExamNameFlag(String hallArrangementExamNameFlag) {
        HallArrangementExamNameFlag = hallArrangementExamNameFlag;
    }

    public String getHallArrangementExamNoFlag() {
        return HallArrangementExamNoFlag;
    }

    public void setHallArrangementExamNoFlag(String hallArrangementExamNoFlag) {
        HallArrangementExamNoFlag = hallArrangementExamNoFlag;
    }

    String HallArrangementExamNameFlag,HallArrangementExamNoFlag;

    public String getHall_arrangement_yearId() {
        return hall_arrangement_yearId;
    }

    public void setHall_arrangement_yearId(String hall_arrangement_yearId) {
        this.hall_arrangement_yearId = hall_arrangement_yearId;
    }

    public String getHall_arrangement_yearName() {
        return hall_arrangement_yearName;
    }

    public void setHall_arrangement_yearName(String hall_arrangement_yearName) {
        this.hall_arrangement_yearName = hall_arrangement_yearName;
    }

    public String getHall_arrangement_examId() {
        return hall_arrangement_examId;
    }

    public void setHall_arrangement_examId(String hall_arrangement_examId) {
        this.hall_arrangement_examId = hall_arrangement_examId;
    }

    public String getHall_arrangement_examName() {
        return hall_arrangement_examName;
    }

    public void setHall_arrangement_examName(String hall_arrangement_examName) {
        this.hall_arrangement_examName = hall_arrangement_examName;
    }

    public String getHall_arrangement_hallNo() {
        return hall_arrangement_hallNo;
    }

    public void setHall_arrangement_hallNo(String hall_arrangement_hallNo) {
        this.hall_arrangement_hallNo = hall_arrangement_hallNo;
    }

    public String getHall_arrangement_HallName() {
        return hall_arrangement_HallName;
    }

    public void setHall_arrangement_HallName(String hall_arrangement_HallName) {
        this.hall_arrangement_HallName = hall_arrangement_HallName;
    }

    public String getExamTimetableYearFlag() {
        return examTimetableYearFlag;
    }

    public void setExamTimetableYearFlag(String examTimetableYearFlag) {
        this.examTimetableYearFlag = examTimetableYearFlag;
    }

    String examTimetableYearFlag;

    public String getExamTimetableStreamId() {
        return examTimetableStreamId;
    }

    public void setExamTimetableStreamId(String examTimetableStreamId) {
        this.examTimetableStreamId = examTimetableStreamId;
    }

    public String getExamTimeTableStreamName() {
        return examTimeTableStreamName;
    }

    public void setExamTimeTableStreamName(String examTimeTableStreamName) {
        this.examTimeTableStreamName = examTimeTableStreamName;
    }

    public String getExamTimeTableMedium() {
        return examTimeTableMedium;
    }

    public void setExamTimeTableMedium(String examTimeTableMedium) {
        this.examTimeTableMedium = examTimeTableMedium;
    }

    public String getExamTimeTableBatchId() {
        return examTimeTableBatchId;
    }

    public void setExamTimeTableBatchId(String examTimeTableBatchId) {
        this.examTimeTableBatchId = examTimeTableBatchId;
    }

    public String getExamTimeTableBatchName() {
        return examTimeTableBatchName;
    }

    public void setExamTimeTableBatchName(String examTimeTableBatchName) {
        this.examTimeTableBatchName = examTimeTableBatchName;
    }

    public String getExamTimeTableSectionName() {
        return examTimeTableSectionName;
    }

    public void setExamTimeTableSectionName(String examTimeTableSectionName) {
        this.examTimeTableSectionName = examTimeTableSectionName;
    }

    public String getExamTimeTableYearId() {
        return examTimeTableYearId;
    }

    public void setExamTimeTableYearId(String examTimeTableYearId) {
        this.examTimeTableYearId = examTimeTableYearId;
    }

    public String getExamTimeTableYearName() {
        return examTimeTableYearName;
    }

    public void setExamTimeTableYearName(String examTimeTableYearName) {
        this.examTimeTableYearName = examTimeTableYearName;
    }

    public String getEmpLeaveReportingLeaveYearId() {
        return empLeaveReportingLeaveYearId;
    }

    public void setEmpLeaveReportingLeaveYearId(String empLeaveReportingLeaveYearId) {
        this.empLeaveReportingLeaveYearId = empLeaveReportingLeaveYearId;
    }

    public String getEmpLeaveReportingLeaveYearName() {
        return empLeaveReportingLeaveYearName;
    }

    public void setEmpLeaveReportingLeaveYearName(String empLeaveReportingLeaveYearName) {
        this.empLeaveReportingLeaveYearName = empLeaveReportingLeaveYearName;
    }

    public String getLeaveAssignLeaveYearFlag() {
        return leaveAssignLeaveYearFlag;
    }

    public void setLeaveAssignLeaveYearFlag(String leaveAssignLeaveYearFlag) {
        this.leaveAssignLeaveYearFlag = leaveAssignLeaveYearFlag;
    }

    public String getLeaveApplicantStreamId() {
        return leaveApplicantStreamId;
    }

    public String getManageAttendanceSteamId() {
        return manageAttendanceSteamId;
    }

    public void setManageAttendanceSteamId(String manageAttendanceSteamId) {
        this.manageAttendanceSteamId = manageAttendanceSteamId;
    }

    public String getManageAttendanceStreamName() {
        return manageAttendanceStreamName;
    }

    public void setManageAttendanceStreamName(String manageAttendanceStreamName) {
        this.manageAttendanceStreamName = manageAttendanceStreamName;
    }

    public String getManageAttendanceMedium() {
        return manageAttendanceMedium;
    }

    public void setManageAttendanceMedium(String manageAttendanceMedium) {
        this.manageAttendanceMedium = manageAttendanceMedium;
    }

    public String getManageAttendanceDepartmetId() {
        return manageAttendanceDepartmetId;
    }

    public void setManageAttendanceDepartmetId(String manageAttendanceDepartmetId) {
        this.manageAttendanceDepartmetId = manageAttendanceDepartmetId;
    }

    public String getManageAttendanceDepartmentName() {
        return manageAttendanceDepartmentName;
    }

    public void setManageAttendanceDepartmentName(String manageAttendanceDepartmentName) {
        this.manageAttendanceDepartmentName = manageAttendanceDepartmentName;
    }

    public String getManageAttendanceDate() {
        return manageAttendanceDate;
    }

    public void setManageAttendanceDate(String manageAttendanceDate) {
        this.manageAttendanceDate = manageAttendanceDate;
    }

    public void setLeaveApplicantStreamId(String leaveApplicantStreamId) {
        this.leaveApplicantStreamId = leaveApplicantStreamId;
    }

    public String getLeaveApplicantStreamName() {
        return leaveApplicantStreamName;
    }

    public void setLeaveApplicantStreamName(String leaveApplicantStreamName) {
        this.leaveApplicantStreamName = leaveApplicantStreamName;
    }

    public String getLeaveApplicantMedium() {
        return leaveApplicantMedium;
    }

    public void setLeaveApplicantMedium(String leaveApplicantMedium) {
        this.leaveApplicantMedium = leaveApplicantMedium;
    }

    public String getLeaveReportingStreamId() {
        return leaveReportingStreamId;
    }

    public String getLeaveAssignStreamId() {
        return leaveAssignStreamId;
    }

    public void setLeaveAssignStreamId(String leaveAssignStreamId) {
        this.leaveAssignStreamId = leaveAssignStreamId;
    }

    public String getLeaveAssignStreamName() {
        return leaveAssignStreamName;
    }

    public void setLeaveAssignStreamName(String leaveAssignStreamName) {
        this.leaveAssignStreamName = leaveAssignStreamName;
    }

    public String getLeaveAssignMedium() {
        return leaveAssignMedium;
    }

    public void setLeaveAssignMedium(String leaveAssignMedium) {
        this.leaveAssignMedium = leaveAssignMedium;
    }

    public String getLeaveAssignDepartmentId() {
        return leaveAssignDepartmentId;
    }

    public void setLeaveAssignDepartmentId(String leaveAssignDepartmentId) {
        this.leaveAssignDepartmentId = leaveAssignDepartmentId;
    }

    public String getLeaveAssignDepartmentName() {
        return leaveAssignDepartmentName;
    }

    public void setLeaveAssignDepartmentName(String leaveAssignDepartmentName) {
        this.leaveAssignDepartmentName = leaveAssignDepartmentName;
    }

    public String getLeaveAssignLeaveYearID() {
        return leaveAssignLeaveYearID;
    }

    public void setLeaveAssignLeaveYearID(String leaveAssignLeaveYearID) {
        this.leaveAssignLeaveYearID = leaveAssignLeaveYearID;
    }

    public String getLeaveAssignLeaveYearName() {
        return leaveAssignLeaveYearName;
    }

    public void setLeaveAssignLeaveYearName(String leaveAssignLeaveYearName) {
        this.leaveAssignLeaveYearName = leaveAssignLeaveYearName;
    }

    public void setLeaveReportingStreamId(String leaveReportingStreamId) {
        this.leaveReportingStreamId = leaveReportingStreamId;
    }

    public String getLeaveReportingStreamName() {
        return leaveReportingStreamName;
    }

    public void setLeaveReportingStreamName(String leaveReportingStreamName) {
        this.leaveReportingStreamName = leaveReportingStreamName;
    }

    public String getLeaveReportingMedium() {
        return leaveReportingMedium;
    }

    public void setLeaveReportingMedium(String leaveReportingMedium) {
        this.leaveReportingMedium = leaveReportingMedium;
    }

    public String getLeaveReportingDepartmentId() {
        return leaveReportingDepartmentId;
    }

    public void setLeaveReportingDepartmentId(String leaveReportingDepartmentId) {
        this.leaveReportingDepartmentId = leaveReportingDepartmentId;
    }

    public String getLeaveReportingDepartmentName() {
        return leaveReportingDepartmentName;
    }

    public void setLeaveReportingDepartmentName(String leaveReportingDepartmentName) {
        this.leaveReportingDepartmentName = leaveReportingDepartmentName;
    }

    public String getManageEmpDepartmentFlag() {
        return manageEmpDepartmentFlag;
    }

    public void setManageEmpDepartmentFlag(String manageEmpDepartmentFlag) {
        this.manageEmpDepartmentFlag = manageEmpDepartmentFlag;
    }

    public String getLectureClassTimingId() {
        return lectureClassTimingId;
    }

    public void setLectureClassTimingId(String lectureClassTimingId) {
        this.lectureClassTimingId = lectureClassTimingId;
    }

    public String getLectureClassTimingName() {
        return lectureClassTimingName;
    }

    public void setLectureClassTimingName(String lectureClassTimingName) {
        this.lectureClassTimingName = lectureClassTimingName;
    }

    String attendanceStstisticStreamId;
    String CustomMonthText;
    String DayofMonthCustom,current_Leave_Application_FromDate,current_Leave_Application_ToDate;
    String AttendanceStatsticsFromDate,leaveApplicationFromDate,leaveApplicationTodate,leaveApplicationDateRange;

    public String getCurrent_Leave_Application_FromDate() {
        return current_Leave_Application_FromDate;
    }

    public void setCurrent_Leave_Application_FromDate(String current_Leave_Application_FromDate) {
        this.current_Leave_Application_FromDate = current_Leave_Application_FromDate;
    }

    public String getCurrent_Leave_Application_ToDate() {
        return current_Leave_Application_ToDate;
    }

    public void setCurrent_Leave_Application_ToDate(String current_Leave_Application_ToDate) {
        this.current_Leave_Application_ToDate = current_Leave_Application_ToDate;
    }

    public String getLeaveApplicationDateRange() {
        return leaveApplicationDateRange;
    }

    public void setLeaveApplicationDateRange(String leaveApplicationDateRange) {
        this.leaveApplicationDateRange = leaveApplicationDateRange;
    }

    public String getLeaveApplicationFromDate() {
        return leaveApplicationFromDate;
    }

    public void setLeaveApplicationFromDate(String leaveApplicationFromDate) {
        this.leaveApplicationFromDate = leaveApplicationFromDate;
    }

    public String getLeaveApplicationTodate() {
        return leaveApplicationTodate;
    }

    public void setLeaveApplicationTodate(String leaveApplicationTodate) {
        this.leaveApplicationTodate = leaveApplicationTodate;
    }

    public String getSwitchLectureTypeStuAttendance() {
        return SwitchLectureTypeStuAttendance;
    }

    public void setSwitchLectureTypeStuAttendance(String switchLectureTypeStuAttendance) {
        SwitchLectureTypeStuAttendance = switchLectureTypeStuAttendance;
    }

    String AttendanceStatsticsToDate;
    String AttendanceStatisticsRange;
    String attendanceStstisticDivId;
    String attendanceStstisticDivName;
    String SwitchLectureTypeStatistics;
    String lectureAttendanceStreamId,lectureClassTimingId,lectureClassTimingName,SwitchLectureTypeStuAttendance;




    public String getLectureAttendanceLectureDate() {
        return lectureAttendanceLectureDate;
    }

    public void setLectureAttendanceLectureDate(String lectureAttendanceLectureDate) {
        this.lectureAttendanceLectureDate = lectureAttendanceLectureDate;
    }

    String lectureAttendanceLectureDate;
    String lectureAttendanceStreamName;


    public String getLectureAttendanceSubId() {
        return lectureAttendanceSubId;
    }

    public void setLectureAttendanceSubId(String lectureAttendanceSubId) {
        this.lectureAttendanceSubId = lectureAttendanceSubId;
    }

    public String getLectureAttendanceSubName() {
        return lectureAttendanceSubName;
    }

    public void setLectureAttendanceSubName(String lectureAttendanceSubName) {
        this.lectureAttendanceSubName = lectureAttendanceSubName;
    }

    String lectureAttendanceMedium,lectureAttendanceBatchId,lectureAttendanceBatchName;
    String lectureAttendanceSecName,lectureAttendanceDivId,lectureAttendanceDivName,
    lectureAttendanceSubId,lectureAttendanceSubName,lectureAttendanceClassTimingID,lectureAttendanceClassTimingName;

    public String getLectureAttendanceClassTimingID() {
        return lectureAttendanceClassTimingID;
    }

    public void setLectureAttendanceClassTimingID(String lectureAttendanceClassTimingID) {
        this.lectureAttendanceClassTimingID = lectureAttendanceClassTimingID;
    }

    public String getLectureAttendanceClassTimingName() {
        return lectureAttendanceClassTimingName;
    }

    public void setLectureAttendanceClassTimingName(String lectureAttendanceClassTimingName) {
        this.lectureAttendanceClassTimingName = lectureAttendanceClassTimingName;
    }

    public String getLectureAttendanceDivId() {
        return lectureAttendanceDivId;
    }

    public void setLectureAttendanceDivId(String lectureAttendanceDivId) {
        this.lectureAttendanceDivId = lectureAttendanceDivId;
    }

    public String getLectureAttendanceDivName() {
        return lectureAttendanceDivName;
    }

    public void setLectureAttendanceDivName(String lectureAttendanceDivName) {
        this.lectureAttendanceDivName = lectureAttendanceDivName;
    }

    public String getStuAttendanceLectureDate() {
        return stuAttendanceLectureDate;
    }

    public void setStuAttendanceLectureDate(String stuAttendanceLectureDate) {
        this.stuAttendanceLectureDate = stuAttendanceLectureDate;
    }

    public String getLectureAttendanceSecName() {
        return lectureAttendanceSecName;
    }

    public void setLectureAttendanceSecName(String lectureAttendanceSecName) {
        this.lectureAttendanceSecName = lectureAttendanceSecName;
    }

    public String getLectureAttendanceBatchId() {
        return lectureAttendanceBatchId;
    }

    public void setLectureAttendanceBatchId(String lectureAttendanceBatchId) {
        this.lectureAttendanceBatchId = lectureAttendanceBatchId;
    }

    public String getLectureAttendanceBatchName() {
        return lectureAttendanceBatchName;
    }

    public void setLectureAttendanceBatchName(String lectureAttendanceBatchName) {
        this.lectureAttendanceBatchName = lectureAttendanceBatchName;
    }

    public String getLectureAttendanceMedium() {
        return lectureAttendanceMedium;
    }

    public void setLectureAttendanceMedium(String lectureAttendanceMedium) {
        this.lectureAttendanceMedium = lectureAttendanceMedium;
    }

    public String getLectureAttendanceStreamId() {
        return lectureAttendanceStreamId;
    }

    public void setLectureAttendanceStreamId(String lectureAttendanceStreamId) {
        this.lectureAttendanceStreamId = lectureAttendanceStreamId;
    }

    public String getLectureAttendanceStreamName() {
        return lectureAttendanceStreamName;
    }

    public void setLectureAttendanceStreamName(String lectureAttendanceStreamName) {
        this.lectureAttendanceStreamName = lectureAttendanceStreamName;
    }

    public String getSwitchLectureTypeStatistics() {
        return SwitchLectureTypeStatistics;
    }

    public void setSwitchLectureTypeStatistics(String switchLectureTypeStatistics) {
        SwitchLectureTypeStatistics = switchLectureTypeStatistics;
    }

    public String getAttendanceStstisticDivId() {
        return attendanceStstisticDivId;
    }

    public void setAttendanceStstisticDivId(String attendanceStstisticDivId) {
        this.attendanceStstisticDivId = attendanceStstisticDivId;
    }

    public String getAttendanceStstisticDivName() {
        return attendanceStstisticDivName;
    }

    public void setAttendanceStstisticDivName(String attendanceStstisticDivName) {
        this.attendanceStstisticDivName = attendanceStstisticDivName;
    }

    public String getAttendanceStatsticsFromDate() {
        return AttendanceStatsticsFromDate;
    }

    public void setAttendanceStatsticsFromDate(String attendanceStatsticsFromDate) {
        AttendanceStatsticsFromDate = attendanceStatsticsFromDate;
    }

    public String getAttendanceStatsticsToDate() {
        return AttendanceStatsticsToDate;
    }

    public void setAttendanceStatsticsToDate(String attendanceStatsticsToDate) {
        AttendanceStatsticsToDate = attendanceStatsticsToDate;
    }

    public String getAttendanceStatisticsRange() {
        return AttendanceStatisticsRange;
    }

    public void setAttendanceStatisticsRange(String attendanceStatisticsRange) {
        AttendanceStatisticsRange = attendanceStatisticsRange;
    }

    public String getCustomMonthText() {
        return CustomMonthText;
    }

    public void setCustomMonthText(String customMonthText) {
        CustomMonthText = customMonthText;
    }

    public String getDayofMonthCustom() {
        return DayofMonthCustom;
    }

    public void setDayofMonthCustom(String dayofMonthCustom) {
        DayofMonthCustom = dayofMonthCustom;
    }

    public String getAttendanceStstisticStreamId() {
        return attendanceStstisticStreamId;
    }

    public void setAttendanceStstisticStreamId(String attendanceStstisticStreamId) {
        this.attendanceStstisticStreamId = attendanceStstisticStreamId;
    }

    public String getAttendanceStstisticStreamName() {
        return attendanceStstisticStreamName;
    }

    public void setAttendanceStstisticStreamName(String attendanceStstisticStreamName) {
        this.attendanceStstisticStreamName = attendanceStstisticStreamName;
    }

    public String getAttendanceStstisticMedium() {
        return attendanceStstisticMedium;
    }

    public void setAttendanceStstisticMedium(String attendanceStstisticMedium) {
        this.attendanceStstisticMedium = attendanceStstisticMedium;
    }

    public String getAttendanceStstisticBatchId() {
        return attendanceStstisticBatchId;
    }

    public void setAttendanceStstisticBatchId(String attendanceStstisticBatchId) {
        this.attendanceStstisticBatchId = attendanceStstisticBatchId;
    }

    public String getAttendanceStstisticBatchName() {
        return attendanceStstisticBatchName;
    }

    public void setAttendanceStstisticBatchName(String attendanceStstisticBatchName) {
        this.attendanceStstisticBatchName = attendanceStstisticBatchName;
    }

    public String getAttendanceStstisticSectionName() {
        return attendanceStstisticSectionName;
    }

    public void setAttendanceStstisticSectionName(String attendanceStstisticSectionName) {
        this.attendanceStstisticSectionName = attendanceStstisticSectionName;
    }

    public String getAttendanceStstisticSubId() {
        return attendanceStstisticSubId;
    }

    public void setAttendanceStstisticSubId(String attendanceStstisticSubId) {
        this.attendanceStstisticSubId = attendanceStstisticSubId;
    }

    public String getAttendanceStstisticSubName() {
        return attendanceStstisticSubName;
    }

    public void setAttendanceStstisticSubName(String attendanceStstisticSubName) {
        this.attendanceStstisticSubName = attendanceStstisticSubName;
    }

    String attendanceStstisticStreamName;
    String attendanceStstisticMedium;
    String attendanceStstisticBatchId;
    String attendanceStstisticBatchName;
    String attendanceStstisticSectionName;
    String attendanceStstisticSubId;
    String attendanceStstisticSubName;


    public String getStuAttendanceClassTimeFlag() {
        return stuAttendanceClassTimeFlag;
    }

    public void setStuAttendanceClassTimeFlag(String stuAttendanceClassTimeFlag) {
        this.stuAttendanceClassTimeFlag = stuAttendanceClassTimeFlag;
    }

    public String getStuAttendanceSubId() {
        return stuAttendanceSubId;
    }

    public void setStuAttendanceSubId(String stuAttendanceSubId) {
        this.stuAttendanceSubId = stuAttendanceSubId;
    }

    public String getStuAttendanceSubName() {
        return stuAttendanceSubName;
    }

    public void setStuAttendanceSubName(String stuAttendanceSubName) {
        this.stuAttendanceSubName = stuAttendanceSubName;
    }

    public String getStuAttendanceSectionName() {
        return stuAttendanceSectionName;
    }

    public void setStuAttendanceSectionName(String stuAttendanceSectionName) {
        this.stuAttendanceSectionName = stuAttendanceSectionName;
    }

    public String getStuAttendanceSubFlag() {
        return stuAttendanceSubFlag;
    }

    public void setStuAttendanceSubFlag(String stuAttendanceSubFlag) {
        this.stuAttendanceSubFlag = stuAttendanceSubFlag;
    }

    public String getStuAttendanceStreamName() {
        return StuAttendanceStreamName;
    }

    public void setStuAttendanceStreamName(String stuAttendanceStreamName) {
        StuAttendanceStreamName = stuAttendanceStreamName;
    }

    public String getStuAttendanceMedium() {
        return stuAttendanceMedium;
    }

    public void setStuAttendanceMedium(String stuAttendanceMedium) {
        this.stuAttendanceMedium = stuAttendanceMedium;
    }

    public String getStuAttendanceBatchId() {
        return stuAttendanceBatchId;
    }

    public void setStuAttendanceBatchId(String stuAttendanceBatchId) {
        this.stuAttendanceBatchId = stuAttendanceBatchId;
    }

    public String getStuAttendanceBatchName() {
        return stuAttendanceBatchName;
    }

    public void setStuAttendanceBatchName(String stuAttendanceBatchName) {
        this.stuAttendanceBatchName = stuAttendanceBatchName;
    }

    public String getStuAttendanceDivId() {
        return stuAttendanceDivId;
    }

    public void setStuAttendanceDivId(String stuAttendanceDivId) {
        this.stuAttendanceDivId = stuAttendanceDivId;
    }

    public String getStuAttendanceDivName() {
        return stuAttendanceDivName;
    }

    public void setStuAttendanceDivName(String stuAttendanceDivName) {
        this.stuAttendanceDivName = stuAttendanceDivName;
    }

    public String getStuAttendanceClassTimingId() {
        return stuAttendanceClassTimingId;
    }

    public void setStuAttendanceClassTimingId(String stuAttendanceClassTimingId) {
        this.stuAttendanceClassTimingId = stuAttendanceClassTimingId;
    }

    public String getStuAttendanceClassTimingName() {
        return stuAttendanceClassTimingName;
    }

    public void setStuAttendanceClassTimingName(String stuAttendanceClassTimingName) {
        this.stuAttendanceClassTimingName = stuAttendanceClassTimingName;
    }

    public String getStuAttendanceStreamId() {
        return stuAttendanceStreamId;
    }

    public void setStuAttendanceStreamId(String stuAttendanceStreamId) {
        this.stuAttendanceStreamId = stuAttendanceStreamId;
    }

    public String getClassTimingBatchFlag() {
        return classTimingBatchFlag;
    }

    public void setClassTimingBatchFlag(String classTimingBatchFlag) {
        this.classTimingBatchFlag = classTimingBatchFlag;
    }

    public String getClassTimingSectionFlag() {
        return classTimingSectionFlag;
    }

    public void setClassTimingSectionFlag(String classTimingSectionFlag) {
        this.classTimingSectionFlag = classTimingSectionFlag;
    }

    public String getTimeTableStreamId() {
        return timeTableStreamId;
    }

    public void setTimeTableStreamId(String timeTableStreamId) {
        this.timeTableStreamId = timeTableStreamId;
    }

    public String getTimeTableStreamName() {
        return timeTableStreamName;
    }

    public void setTimeTableStreamName(String timeTableStreamName) {
        this.timeTableStreamName = timeTableStreamName;
    }

    public String getTimeTableMedium() {
        return timeTableMedium;
    }

    public void setTimeTableMedium(String timeTableMedium) {
        this.timeTableMedium = timeTableMedium;
    }

    public String getTimeTableBatchId() {
        return timeTableBatchId;
    }

    public void setTimeTableBatchId(String timeTableBatchId) {
        this.timeTableBatchId = timeTableBatchId;
    }

    public String getTimeTableBatchName() {
        return timeTableBatchName;
    }

    public void setTimeTableBatchName(String timeTableBatchName) {
        this.timeTableBatchName = timeTableBatchName;
    }

    public String getTimeTableSemName() {
        return timeTableSemName;
    }

    public void setTimeTableSemName(String timeTableSemName) {
        this.timeTableSemName = timeTableSemName;
    }

    public String getTimeTableDivisionId() {
        return timeTableDivisionId;
    }

    public void setTimeTableDivisionId(String timeTableDivisionId) {
        this.timeTableDivisionId = timeTableDivisionId;
    }

    public String getTimeTableDivisionName() {
        return timeTableDivisionName;
    }

    public void setTimeTableDivisionName(String timeTableDivisionName) {
        this.timeTableDivisionName = timeTableDivisionName;
    }

    public String getManageEmpMediumFlag() {
        return manageEmpMediumFlag;
    }

    public void setManageEmpMediumFlag(String manageEmpMediumFlag) {
        this.manageEmpMediumFlag = manageEmpMediumFlag;
    }

    public String getManageEmpCourseFlag() {
        return manageEmpCourseFlag;
    }

    public void setManageEmpCourseFlag(String manageEmpCourseFlag) {
        this.manageEmpCourseFlag = manageEmpCourseFlag;
    }

    public String getManageEmpMediumName() {
        return manageEmpMediumName;
    }

    public void setManageEmpMediumName(String manageEmpMediumName) {
        this.manageEmpMediumName = manageEmpMediumName;
    }

    public String getManageEmpStreamId() {
        return manageEmpStreamId;
    }

    public void setManageEmpStreamId(String manageEmpStreamId) {
        this.manageEmpStreamId = manageEmpStreamId;
    }

    public String getManageEmpStreamName() {
        return manageEmpStreamName;
    }

    public void setManageEmpStreamName(String manageEmpStreamName) {
        this.manageEmpStreamName = manageEmpStreamName;
    }

    public String getManageEmpDepartmentId() {
        return manageEmpDepartmentId;
    }

    public void setManageEmpDepartmentId(String manageEmpDepartmentId) {
        this.manageEmpDepartmentId = manageEmpDepartmentId;
    }

    public String getManageEmpDepartmentName() {
        return manageEmpDepartmentName;
    }

    public void setManageEmpDepartmentName(String manageEmpDepartmentName) {
        this.manageEmpDepartmentName = manageEmpDepartmentName;
    }

    public String getManageEmpDesignationId() {
        return manageEmpDesignationId;
    }

    public void setManageEmpDesignationId(String manageEmpDesignationId) {
        this.manageEmpDesignationId = manageEmpDesignationId;
    }

    public String getManageEmpDesignationName() {
        return manageEmpDesignationName;
    }

    public void setManageEmpDesignationName(String manageEmpDesignationName) {
        this.manageEmpDesignationName = manageEmpDesignationName;
    }

    public String getManageEmpCategoryId() {
        return manageEmpCategoryId;
    }

    public void setManageEmpCategoryId(String manageEmpCategoryId) {
        this.manageEmpCategoryId = manageEmpCategoryId;
    }

    public String getManageEmpCategoryName() {
        return manageEmpCategoryName;
    }

    public void setManageEmpCategoryName(String manageEmpCategoryName) {
        this.manageEmpCategoryName = manageEmpCategoryName;
    }

    public String getEmployee_Profile_FullNAme() {
        return Employee_Profile_FullNAme;
    }

    public void setEmployee_Profile_FullNAme(String employee_Profile_FullNAme) {
        Employee_Profile_FullNAme = employee_Profile_FullNAme;
    }

    public String getEmployee_Profile_DesignationNAme() {
        return Employee_Profile_DesignationNAme;
    }

    public void setEmployee_Profile_DesignationNAme(String employee_Profile_DesignationNAme) {
        Employee_Profile_DesignationNAme = employee_Profile_DesignationNAme;
    }

    public String getEmployee_Profile_EmployeeID() {
        return Employee_Profile_EmployeeID;
    }

    public void setEmployee_Profile_EmployeeID(String employee_Profile_EmployeeID) {
        Employee_Profile_EmployeeID = employee_Profile_EmployeeID;
    }

    public String getClassTimingStreamId() {
        return classTimingStreamId;
    }

    public void setClassTimingStreamId(String classTimingStreamId) {
        this.classTimingStreamId = classTimingStreamId;
    }

    public String getClassTimingStreamName() {
        return classTimingStreamName;
    }

    public void setClassTimingStreamName(String classTimingStreamName) {
        this.classTimingStreamName = classTimingStreamName;
    }

    public String getClassTimingMedium() {
        return classTimingMedium;
    }

    public void setClassTimingMedium(String classTimingMedium) {
        this.classTimingMedium = classTimingMedium;
    }

    public String getClassTimingBatchId() {
        return classTimingBatchId;
    }

    public void setClassTimingBatchId(String classTimingBatchId) {
        this.classTimingBatchId = classTimingBatchId;
    }

    public String getClassTimingBatchName() {
        return classTimingBatchName;
    }

    public void setClassTimingBatchName(String classTimingBatchName) {
        this.classTimingBatchName = classTimingBatchName;
    }


    public String getClassTimingSemName() {
        return classTimingSemName;
    }

    public void setClassTimingSemName(String classTimingSemName) {
        this.classTimingSemName = classTimingSemName;
    }

    public String getClassTimingDivisionId() {
        return classTimingDivisionId;
    }

    public void setClassTimingDivisionId(String classTimingDivisionId) {
        this.classTimingDivisionId = classTimingDivisionId;
    }

    public String getClassTimingDivisionName() {
        return classTimingDivisionName;
    }

    public void setClassTimingDivisionName(String classTimingDivisionName) {
        this.classTimingDivisionName = classTimingDivisionName;
    }

    public String getCourseMgtDivisionFlag() {
        return courseMgtDivisionFlag;
    }

    public void setCourseMgtDivisionFlag(String courseMgtDivisionFlag) {
        this.courseMgtDivisionFlag = courseMgtDivisionFlag;
    }

    public String getTimeTable_WEEKDAY() {
        return timeTable_WEEKDAY;
    }

    public void setTimeTable_WEEKDAY(String timeTable_WEEKDAY) {
        this.timeTable_WEEKDAY = timeTable_WEEKDAY;
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "MM/dd/yyyy";
        String outputPattern = "dd/MM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String ConvertDate(String dateString,String inFormat,String outFormat){
        String result="";

        SimpleDateFormat formatterOld = new SimpleDateFormat(inFormat, Locale.getDefault());
        SimpleDateFormat formatterNew = new SimpleDateFormat(outFormat, Locale.getDefault());

        Date date=null;
        try {
            date = formatterOld.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            result = formatterNew.format(date);
        }
        return result;
    }

}
