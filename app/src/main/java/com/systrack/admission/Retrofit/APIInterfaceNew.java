package com.systrack.admission.Retrofit;


import com.systrack.admission.pojo.AcademicyearInformationPojo;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.AttendanceStatisticInformationPojo;
import com.systrack.admission.pojo.BatchInformationPojo;
import com.systrack.admission.pojo.BookCategoryInformationPojo;
import com.systrack.admission.pojo.BroadSheetInformationPojo;
import com.systrack.admission.pojo.CategoryInformationPojo;
import com.systrack.admission.pojo.ClassDivisionInformationPojo;
import com.systrack.admission.pojo.ClassTimingInformationPojo;
import com.systrack.admission.pojo.CurrentTermInformationPojo;
import com.systrack.admission.pojo.DashboardInformationPojo;
import com.systrack.admission.pojo.DepartmentInformationPojo;
import com.systrack.admission.pojo.DesignationInformationPojo;
import com.systrack.admission.pojo.EmployeeAttendanceInformationPojo;
import com.systrack.admission.pojo.EmployeeContactInformationPojo;
import com.systrack.admission.pojo.EmployeeInformationPojo;
import com.systrack.admission.pojo.ExamIdInformationPojo;
import com.systrack.admission.pojo.ExamMasterInformationPojo;
import com.systrack.admission.pojo.ExamTimeTableInformationPojo;
import com.systrack.admission.pojo.GenerateMarksheetInformationPojo;
import com.systrack.admission.pojo.HallArrangementStudentInformationPojo;
import com.systrack.admission.pojo.HolidayInformationPojo;
import com.systrack.admission.pojo.LeaveApplicationInformationPojo;
import com.systrack.admission.pojo.LeaveAssignInformationPojo;
import com.systrack.admission.pojo.LeaveDurationInformationPojo;
import com.systrack.admission.pojo.LeaveInformationPojo;
import com.systrack.admission.pojo.LeaveReportInformationPojo;
import com.systrack.admission.pojo.LeaveTypeInformationPojo;
import com.systrack.admission.pojo.LectureAttendanceInformationPojo;
import com.systrack.admission.pojo.LoginInformationPojo;
import com.systrack.admission.pojo.MainDashBoardInformationPojo;
import com.systrack.admission.pojo.ManageEmployeeCoursePojo;
import com.systrack.admission.pojo.ManageEmployeeInformationPojo;
import com.systrack.admission.pojo.MessageInformationPojo;
import com.systrack.admission.pojo.ModeratorAffiliationInformationPojo;
import com.systrack.admission.pojo.PublishExamTimeTableInformationPojo;
import com.systrack.admission.pojo.PublishMarkSheetInformationPojo;
import com.systrack.admission.pojo.RoomCategoryInformationPojo;
import com.systrack.admission.pojo.SectionInformationPojo;
import com.systrack.admission.pojo.StudentAttendanceInformationPojo;
import com.systrack.admission.pojo.StudentInformationPojo;
import com.systrack.admission.pojo.SubjectAllocationInformationPojo;
import com.systrack.admission.pojo.TeacherAllocationInformationPojo;
import com.systrack.admission.pojo.TimeTableInformationPojo;
import com.systrack.admission.pojo.WeekDaysInformationPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterfaceNew {


    @FormUrlEncoded
    @POST("LoginService.asmx/ValidateUserAccount")
    Call<LoginInformationPojo> User_Login(@Field("username") String username, @Field("password") String password/*, @Header("app_mode") boolean app_mode*/);

    @FormUrlEncoded
    @POST("LoginService.asmx/Logout")
    Call<LoginInformationPojo> Logout(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("DesignationService.asmx/GetDesignationList")
    Call<DesignationInformationPojo> GetDesignationList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                        @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("DepartmentService.asmx/GetDepartmentList")
    Call<DepartmentInformationPojo> GetDepartmentList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                      @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);
    @FormUrlEncoded
    @POST("CategoryService.asmx/GetCategoryList")
    Call<CategoryInformationPojo> GetCategoryList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                  @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/FillCourseList")
    Call<ManageEmployeeCoursePojo> FillCourseList(@Field("entityId") String entityId, @Field("StreamId") String StreamId,
                                                  @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/FillMediumList")
    Call<ManageEmployeeCoursePojo> FillMediumList(@Field("collegeId") String collegeId, @Field("streamId") String streamId,
                                                  @Field("searchKe") String searchKe);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/FillDepartmentList")
    Call<ManageEmployeeCoursePojo> FillDepartmentList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                      @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/FillDesignationList")
    Call<ManageEmployeeCoursePojo> FillDesignationList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                       @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/FillCategoryList")
    Call<ManageEmployeeCoursePojo> FillCategoryList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                    @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/GetAllEmployeeList")
    Call<ManageEmployeeInformationPojo> GetAllEmployeeList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                           @Field("courseId") String courseId, @Field("departmentId") String departmentId,
                                                           @Field("designationId") String designationId, @Field("categoryId") String categoryId,
                                                           @Field("displayLength") String displayLength, @Field("searchKey") String searchKey,
                                                           @Field("medium") String medium);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/GetEmployeePersonalInfo")
    Call<ManageEmployeeInformationPojo> GetEmployeePersonalInfo(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                                @Field("employeeId") String employeeId);

    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/GetEmployeeGuardianInfo")
    Call<ManageEmployeeInformationPojo> GetEmployeeGuardianInfo(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                                @Field("employeeId") String employeeId);
    @FormUrlEncoded
    @POST("ManageEmployeeService.asmx/GetEmployeeOtherInfo")
    Call<ManageEmployeeInformationPojo> GetEmployeeOtherInfo(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                             @Field("employeeId") String employeeId);
    @FormUrlEncoded
    @POST("TimetableSevice.asmx/FillRoomCategoryList")
    Call<RoomCategoryInformationPojo> FillRoomCategoryList(@Field("collegeId") String collegeId, @Field("branchId") String branchId);

    @FormUrlEncoded
    @POST("TimetableSevice.asmx/GetRoomCategoryList")
    Call<RoomCategoryInformationPojo> GetRoomCategoryList(@Field("colegeId") String colegeId, @Field("branchId") String branchId,
                                                          @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);



    @FormUrlEncoded
    @POST("TimetableSevice.asmx/FillWeekDaysList")
    Call<WeekDaysInformationPojo> FillWeekDaysList(@Field("entityId") String entityId, @Field("branchId") String branchId);

    @FormUrlEncoded
    @POST("TimetableSevice.asmx/FillAdmissionYearList")
    Call<AdmissionYearInformationPojo> FillAdmissionYearList(@Field("collegeId") String collegeId);

    @FormUrlEncoded
    @POST("TimetableSevice.asmx/FillBatchList")
    Call<RoomCategoryInformationPojo> FillBatchList(@Field("academicId") String academicId, @Field("collegeId") String collegeId,
                                                    @Field("branchId") String branchId, @Field("batchId") String batchId,
                                                    @Field("courseId") String courseId, @Field("medium") String medium,
                                                    @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("TimetableSevice.asmx/FillSemesterList")
    Call<SectionInformationPojo> FillSemesterList(@Field("collegeId") String collegeId, @Field("StreamId") String StreamId,
                                                  @Field("currentTerm") String currentTerm, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("TimetableSevice.asmx/GetClassTimingList")
    Call<ClassTimingInformationPojo> GetClassTimingList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                        @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                        @Field("divisionId") String divisionId, @Field("displayLength") String displayLength,
                                                        @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ManageCourseService.asmx/FillEmployeeList")
    Call<EmployeeInformationPojo> FillEmployeeList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                   @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                   @Field("sectionId") String sectionId, @Field("medium") String medium,
                                                   @Field("courseId") String courseId, @Field("searchKey") String searchKey);



    @FormUrlEncoded
    @POST("TimetableSevice.asmx/GetTimeTableList")
    Call<TimeTableInformationPojo> GetTimeTableList(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                    @Field("courseId") String courseId, @Field("mediumId") String mediumId,
                                                    @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                    @Field("academicId") String academicId, @Field("divisionId") String divisionId);


    @FormUrlEncoded
    @POST("ManageStudentattendanceService.asmx/FillSubjectList")
    Call<StudentAttendanceInformationPojo> FillSubjectList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                           @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                           @Field("sectionId") String sectionId, @Field("courseId") String courseId,
                                                           @Field("medium") String medium, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageStudentattendanceService.asmx/FillClassTimingList")
    Call<ClassTimingInformationPojo> FillClassTimingList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                         @Field("batchId") String batchId, @Field("subjectId") String subjectId,
                                                         @Field("academicId") String academicId, @Field("sectionId") String sectionId,
                                                         @Field("courseId") String courseId, @Field("medium") String medium,
                                                         @Field("date") String date, @Field("timeTableType") String timeTableType,
                                                         @Field("divisionId") String divisionId);
    @FormUrlEncoded
    @POST("ManageattendancestatisticService.asmx/GetStudentSubjectWiseAttendanceStatistics")
    Call<AttendanceStatisticInformationPojo> GetStudentSubjectWiseAttendanceStatistics(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                                       @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                                                       @Field("sectionId") String sectionId, @Field("divisionId") String divisionId,
                                                                                       @Field("subjectId") String subjectId, @Field("lectureType") String lectureType,
                                                                                       @Field("fromDate") String fromDate, @Field("toDate") String toDate,
                                                                                       @Field("allowdivision") String allowdivision, @Field("courseId") String courseId,
                                                                                       @Field("medium") String medium, @Field("displayLength") String displayLength,
                                                                                       @Field("searchKey") String searchKey);
    @FormUrlEncoded
    @POST("TimetableSevice.asmx/FillCurrentTermList")
    Call<CurrentTermInformationPojo> FillCurrentTermList(@Field("collegeId") String collegeId);

    @FormUrlEncoded
    @POST("ManageHolidayService.asmx/GetAllHolidayList")
    Call<HolidayInformationPojo> GetAllHolidayList(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                   @Field("academicyearId") String academicyearId, @Field("displayLength") String displayLength,
                                                   @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("LactureAttendanceService.asmx/FillSubjectListLectureAttendance")
    Call<StudentAttendanceInformationPojo> FillSubjectListLectureAttendance(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                                            @Field("academicId") String academicId, @Field("batchId") String batchId,
                                                                            @Field("sectionId") String sectionId, @Field("courseId") String courseId,
                                                                            @Field("medium") String medium, @Field("employeeId") String employeeId,
                                                                            @Field("roleId") String roleId, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManagementLeaveService.asmx/GetLeaveTypeList")
    Call<LeaveTypeInformationPojo> GetLeaveTypeList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                    @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ManagementLeaveService.asmx/GetAllLeaveDurationList")
    Call<LeaveDurationInformationPojo> GetAllLeaveDurationList(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                               @Field("displayLength") String displayLength, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageStudentattendanceService.asmx/GetStudentAttendanceList")
    Call<StudentAttendanceInformationPojo> GetStudentAttendanceList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                    @Field("date") String date, @Field("academicId") String academicId,
                                                                    @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                                    @Field("subjectId") String subjectId, @Field("courseId") String courseId,
                                                                    @Field("medium") String medium, @Field("searchKey") String searchKey,
                                                                    @Field("lacType") String lacType, @Field("allowDivision") String allowDivision,
                                                                    @Field("classTiming") String classTiming, @Field("divisionId") String divisionId,
                                                                    @Field("labId") String labId, @Field("displayLength") String displayLength);

    @FormUrlEncoded
    @POST("ManagementLeaveService.asmx/GetAllLeaveReportData")
    Call<LeaveReportInformationPojo> GetAllLeaveReportData(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                           @Field("courseId") String courseId, @Field("departmentId") String departmentId,
                                                           @Field("medium") String medium, @Field("displayLength") String displayLength,
                                                           @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageAttendanceService.asmx/GetEmployeeAttendanceList")
    Call<EmployeeAttendanceInformationPojo> GetEmployeeAttendanceList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                      @Field("date") String date, @Field("departmentId") String departmentId,
                                                                      @Field("courseId") String courseId, @Field("medium") String medium,
                                                                      @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("LoginService.asmx/ChangePassword")
    Call<LoginInformationPojo> ChangePassword(@Field("userId") String userId, @Field("username") String username,
                                              @Field("currentPassword") String currentPassword, @Field("newpassword") String newpassword,
                                              @Field("confirmPassword") String confirmPassword);

    @FormUrlEncoded
    @POST("ManagementLeaveService.asmx/FillLeaveDurationList")
    Call<LeaveAssignInformationPojo> FillLeaveDurationList(@Field("collageId") String collageId, @Field("branchId") String branchId
            , @Field("searchKey") String searchKey);


    @FormUrlEncoded
    @POST("ManagementLeaveService.asmx/GetEmployeeListForLeaveAssign")
    Call<LeaveAssignInformationPojo> GetEmployeeListForLeaveAssign(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                                   @Field("courseId") String courseId, @Field("leavedurationId") String leavedurationId,
                                                                   @Field("medium") String medium, @Field("departmentId") String departmentId, @Field("displayLength") String displayLength, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManagementLeaveService.asmx/GetLeaveList")
    Call<LeaveInformationPojo> GetLeaveList(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                            @Field("courseId") String courseId, @Field("fromDate") String fromDate,
                                            @Field("toDate") String toDate, @Field("medium") String medium,
                                            @Field("displayLength") String displayLength, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetExamMasterList")
    Call<ExamMasterInformationPojo> GetExamMasterList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                      @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/FillAcademicyearList")
    Call<AcademicyearInformationPojo> FillAcademicyearList(@Field("collageId") String collageId, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetAllExamTimeTableDetail")
    Call<ExamTimeTableInformationPojo> GetAllExamTimeTableDetail(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                 @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                                 @Field("sectionId") String sectionId, @Field("displayLength") String displayLength,
                                                                 @Field("medium") String medium, @Field("courseId") String courseId,
                                                                 @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/FillExamNameList")
    Call<HallArrangementStudentInformationPojo> FillExamNameList(@Field("collegeId") String collegeId, @Field("branchId") String branchId
            , @Field("searchKey") String searchKey);


    @FormUrlEncoded
    @POST("ExaminationService.asmx/FillExamHallNoList")
    Call<HallArrangementStudentInformationPojo> FillExamHallNoList(@Field("collageId") String collageId, @Field("branchId") String branchId
            , @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetAllHallAllocationDetails")
    Call<HallArrangementStudentInformationPojo> GetAllHallAllocationDetails(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                            @Field("academicyearId") String academicyearId, @Field("examId") String examId,
                                                                            @Field("hallId") String hallId, @Field("displayLength") String displayLength,
                                                                            @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/FillExamTimeList")
    Call<HallArrangementStudentInformationPojo> FillExamTimeList(@Field("collageId") String collageId, @Field("branchId") String branchId,
                                                                 @Field("academicyearId") String academicyearId, @Field("examId") String examId,
                                                                 @Field("hallId") String hallId, @Field("searchKey") String searchKey);
    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetAllHallAllocatedStudentListDetails")
    Call<HallArrangementStudentInformationPojo> GetAllHallAllocatedStudentListDetails(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                                      @Field("academicyearId") String academicyearId, @Field("examId") String examId,
                                                                                      @Field("hallId") String hallId, @Field("displayLength") String displayLength,
                                                                                      @Field("datetime") String datetime, @Field("searchkey") String searchkey);


    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetAllPublishExamTimeTableList")
    Call<PublishExamTimeTableInformationPojo> GetAllPublishExamTimeTableList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                             @Field("displayLength") String displayLength, @Field("searchkey") String searchkey,
                                                                             @Field("academicyearId") String academicyearId, @Field("examId") String examId);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetExamIdList")
    Call<ExamIdInformationPojo> GetExamIdList(@Field("collegeId") String collegeId, @Field("branchId") String branchId);


    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetModeratorAffiliationList")
    Call<ModeratorAffiliationInformationPojo> GetModeratorAffiliationList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                          @Field("displayLength") String displayLength, @Field("courseId") String courseId,
                                                                          @Field("medium") String medium, @Field("searchkey") String searchkey,
                                                                          @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                                          @Field("sectionId") String sectionId, @Field("divisionId") String divisionId,
                                                                          @Field("examId") String examId);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetGenerateMarksheetList")
    Call<GenerateMarksheetInformationPojo> GetGenerateMarksheetList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                    @Field("academicyearId") String academicyearId, @Field("examId") String examId,
                                                                    @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                                    @Field("divisionId") String divisionId, @Field("subjectId") String subjectId,
                                                                    @Field("medium") String medium, @Field("courseId") String courseId,
                                                                    @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);


    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetAllPublishMarksheetList")
    Call<PublishMarkSheetInformationPojo> GetAllPublishMarksheetList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                     @Field("academicyearId") String academicyearId, @Field("examId") String examId,
                                                                     @Field("displayLength") String displayLength, @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/GetAllBroadSheetList")
    Call<BroadSheetInformationPojo> GetAllBroadSheetList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                         @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                         @Field("academicyearId") String academicyearId, @Field("examId") String examId,
                                                         @Field("courseId") String courseId, @Field("medium") String medium,
                                                         @Field("searchKey") String searchKey);
    @FormUrlEncoded
    @POST("ManageCourseService.asmx/GetBatchList")
    Call<BatchInformationPojo> GetBatchList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                            @Field("academicId") String academicId, @Field("displayLength") String displayLength,
                                            @Field("searchkey") String searchkey);


    @FormUrlEncoded
    @POST("ManageCourseService.asmx/GetTeacherAllocationList")
    Call<TeacherAllocationInformationPojo> GetTeacherAllocationList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                    @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                                    @Field("sectionId") String sectionId, @Field("medium") String medium,
                                                                    @Field("courseId") String courseId, @Field("displayLength") String displayLength,
                                                                    @Field("searchKey") String searchKey);
    @FormUrlEncoded
    @POST("ManageCourseService.asmx/GetDivisionList")
    Call<ClassDivisionInformationPojo> GetDivisionList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                       @Field("academicyearId") String academicyearId, @Field("displayLength") String displayLength,
                                                       @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageCourseService.asmx/GetSubjectAllocationList")
    Call<SubjectAllocationInformationPojo> GetSubjectAllocationList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                    @Field("academicyearId") String academicyearId, @Field("sectionId") String sectionId,
                                                                    @Field("employeeId") String employeeId, @Field("medium") String medium,
                                                                    @Field("courseId") String courseId, @Field("displayLength") String displayLength,
                                                                    @Field("searchkey") String searchkey);
    @FormUrlEncoded
    @POST("ManageLibraryService.asmx/GetBookCategoryList")
    Call<BookCategoryInformationPojo> GetBookCategoryList(@Field("entityId") String entityId, @Field("branchId") String branchId,
                                                          @Field("bookCatId") String bookCatId, @Field("displayLength") String displayLength,
                                                          @Field("searchkey") String searchkey);


    @FormUrlEncoded
    @POST("ManageStudentService.asmx/GetAllStudentList")
    Call<StudentInformationPojo> GetAllStudentList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                   @Field("academicyearId") String academicyearId, @Field("courseId") String courseId,
                                                   @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                   @Field("medium") String medium, @Field("displayLength") String displayLength,
                                                   @Field("searchkey") String searchkey);
    @FormUrlEncoded
    @POST("LactureAttendanceService.asmx/GetLectureAttendanceList")
    Call<LectureAttendanceInformationPojo> GetLectureAttendanceList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                    @Field("date") String date, @Field("academicId") String academicId,
                                                                    @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                                    @Field("subjectId") String subjectId, @Field("courseId") String courseId,
                                                                    @Field("medium") String medium, @Field("searchKey") String searchKey,
                                                                    @Field("lacType") String lacType, @Field("allowDivision") String allowDivision,
                                                                    @Field("classTiming") String classTiming, @Field("divisionId") String divisionId,
                                                                    @Field("labId") String labId, @Field("isPracticalEnabled") String isPracticalEnabled,
                                                                    @Field("employeeId") String employeeId, @Field("displayLength") String displayLength);
    @FormUrlEncoded
    @POST("ManageCourseService.asmx/FillDivisionList")
    Call<ClassDivisionInformationPojo> FillDivisionList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                        @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                        @Field("sectionId") String sectionId, @Field("medium") String medium,
                                                        @Field("courseId") String courseId, @Field("searchKey") String searchKey);
    @FormUrlEncoded
    @POST("ManageEmployeeLeaveServices.asmx/GetLeaveApplicationListForEmployeeCurrent")
    Call<LeaveApplicationInformationPojo> GetLeaveApplicationListForEmployeeCurrent(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                                    @Field("employeeId") String employeeId, @Field("leavedurationId") String leavedurationId,
                                                                                    @Field("startDate") String startDate, @Field("endDate") String endDate);

    @FormUrlEncoded
    @POST("ManageEmployeeLeaveServices.asmx/GetLeaveApplicationListForEmployeeHistory")
    Call<LeaveApplicationInformationPojo> GetLeaveApplicationListForEmployeeHistory(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                                    @Field("employeeId") String employeeId, @Field("leavedurationId") String leavedurationId);

    @FormUrlEncoded
    @POST("ManageEmployeeLeaveServices.asmx/ViewLeaveApplicationListForEmployeeCurrent")
    Call<LeaveApplicationInformationPojo> ViewLeaveApplicationListForEmployeeCurrent(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                                     @Field("leaveAppId") String leaveAppId, @Field("leavedurationId") String leavedurationId);

    @FormUrlEncoded
    @POST("ExaminationService.asmx/ViewPublishedExamTimeTableById")
    Call<PublishExamTimeTableInformationPojo> ViewPublishedExamTimeTableById(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                             @Field("timeTableId") String timeTableId, @Field("examName") String examName,
                                                                             @Field("batchId") String batchId, @Field("sectionId") String sectionId,
                                                                             @Field("startDate") String startDate, @Field("endDate") String endDate,
                                                                             @Field("roleId") String roleId, @Field("academicyearId") String academicyearId,
                                                                             @Field("examId") String examId, @Field("studentNo") String studentNo);
    @FormUrlEncoded
    @POST("ManageEmployeeAttendanceServices.asmx/GetEmployeeMonthlyAttendanceForEmployee")
    Call<EmployeeAttendanceInformationPojo> GetEmployeeMonthlyAttendanceForEmployee(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                                    @Field("employeeId") String employeeId, @Field("attDate") String attDate,
                                                                                    @Field("academicyearId") String academicyearId);

    @FormUrlEncoded
    @POST("ManageEmployeeLeaveServices.asmx/GetEmployeeTimeTableForLoadBalance")
    Call<LeaveApplicationInformationPojo> GetEmployeeTimeTableForLoadBalance(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                             @Field("employeeId") String employeeId, @Field("leavestartDate") String leavestartDate,
                                                                             @Field("leaveendDate") String leaveendDate, @Field("academicyearId") String academicyearId);
    @GET("TimetableSevice.asmx/FillWeekDays")
    Call<TimeTableInformationPojo> FillWeekDays();

    @FormUrlEncoded
    @POST("ManageEmployeeTimeTableServices.asmx/GetTimeTableDayWiseForEmployee")
    Call<TimeTableInformationPojo> GetTimeTableDayWiseForEmployee(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                  @Field("employeeId") String employeeId, @Field("weekday") String weekday,
                                                                  @Field("academicyearId") String academicyearId, @Field("searchKey") String searchKey);

    @FormUrlEncoded
    @POST("ManageAttendanceStatisticService.asmx/FillSubjectListForEmployee")
    Call<StudentAttendanceInformationPojo> FillSubjectListForEmployee(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                      @Field("academicyearId") String academicyearId, @Field("batchId") String batchId,
                                                                      @Field("sectionId") String sectionId, @Field("courseId") String courseId,
                                                                      @Field("medium") String medium, @Field("employeeId") String employeeId,
                                                                      @Field("searchKey") String searchKey);
    @FormUrlEncoded
    @POST("ManageMessageService.asmx/GetMessageList")
    Call<MessageInformationPojo> GetMessageList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                @Field("messageId") String messageId, @Field("displayLength") String displayLength,
                                                @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ManageNoticeService.asmx/GetAllNoticeData")
    Call<DashboardInformationPojo> GetAllNoticeData(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                    @Field("courseId") String courseId, @Field("searchKey") String searchKey,
                                                    @Field("displayLength") String displayLength);


    @FormUrlEncoded
    @POST("DashboardService.asmx/GetAllDashboardData")
    Call<MainDashBoardInformationPojo> GetAllDashboardData(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                           @Field("roleId") String roleId, @Field("sectionId") String sectionId,
                                                           @Field("userId") String userId);

    @FormUrlEncoded
    @POST("DashboardService.asmx/GetNoticeBoardData")
    Call<DashboardInformationPojo> GetNoticeBoardData(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                      @Field("userType") String userType);

    @FormUrlEncoded
    @POST("DashboardService.asmx/GetNoticeBoardData")
    Call<DashboardInformationPojo> GetStudentNoticeBordData(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                            @Field("userType") String userType, @Field("courseId") String courseId,
                                                            @Field("securitycontexRoleId") String securitycontexRoleId);

    @FormUrlEncoded
    @POST("EmployeeContactService.asmx/GetEmployeeContactList")
    Call<EmployeeContactInformationPojo> GetEmployeeContactList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                                @Field("couseId") String courseId, @Field("departmentId") String departmentId,
                                                                @Field("designationId") String designationId, @Field("displayLength") String displayLength,
                                                                @Field("searchkey") String searchkey);

    @FormUrlEncoded
    @POST("ManageAssignmentService.asmx/GetAllAssignmentList")
    Call<StudentInformationPojo> GetAllAssignmentList(@Field("collegeId") String collegeId, @Field("branchId") String branchId,
                                                      @Field("academicId") String academicId, @Field("courseId") String courseId,
                                                      @Field("mediumId") String mediumId, @Field("batchId") String batchId,
                                                      @Field("sectionId") String sectionId, @Field("allowdivision") String allowdivision,
                                                      @Field("divisionId") String divisionId, @Field("searchKey") String searchKey,
                                                      @Field("displayLength") String displayLength);

}





