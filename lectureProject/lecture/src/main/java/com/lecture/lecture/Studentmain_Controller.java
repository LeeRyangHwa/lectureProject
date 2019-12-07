package com.lecture.lecture;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lecture.lecture.Assignment_DB.assignment;
import com.lecture.lecture.Assignment_DB.assignmentRepository;
import com.lecture.lecture.Lecture_DB.lecture;
import com.lecture.lecture.Lecture_DB.lectureRepository;
import com.lecture.lecture.Lecture_Detail.lecture_detail;
import com.lecture.lecture.Lecture_Detail.lecture_detailRepository;
import com.lecture.lecture.Professor_DB.professor;
import com.lecture.lecture.Professor_DB.professorRepository;
import com.lecture.lecture.Student_DB.student;
import com.lecture.lecture.Student_DB.studentRepository;
import com.lecture.lecture.Student_Lecture_DB.student_lecture;
import com.lecture.lecture.Student_Lecture_DB.student_lectureRepository;
import com.lecture.lecture.student_assignment_DB.student_assignment;
import com.lecture.lecture.student_assignment_DB.student_assignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class Studentmain_Controller {

    @Autowired
    studentRepository studentRepository;
    @Autowired
    lectureRepository lectureRepository;
    @Autowired
    student_lectureRepository student_lectureRepository;
    @Autowired
    professorRepository professorRepository;
    @Autowired
    lecture_detailRepository lecture_detailRepository;
    @Autowired
    assignmentRepository assignmentRepository;
    @Autowired
    student_assignmentRepository student_assignmentRepository;

    public String user;

    @GetMapping(value = "logout")
    public String logout(Model model){
        user = null;

        return "redirect:http://localhost:3000/signIn";
    }
    @RequestMapping(value = "/Main_page", method= {RequestMethod.GET,RequestMethod.POST})
    public String Main_page(Model model,
                            @RequestParam(value="user_id",required=false)String user_id){
        System.out.println("tmp_id="+user_id);
        if(user== null){
            user = user_id;
        }

        System.out.println("로그인 아이디="+user);

        List lecture_attend_Count = new ArrayList();   //m

        List lecture_attend_c = new ArrayList();

        String day ="";
        String start_time;
        String end_time;
        int num=0;
        int col=0;



        List<student_lecture> student_lectures = student_lectureRepository.findByStudent_id(user);
        JsonParser jsonParser = new JsonParser();

        for(int m =0; m <student_lectures.size(); m++) {
            lecture_attend_Count.add(student_lectures.get(m).getLecture_id());
        }

        for(int n=0; n<lecture_attend_Count.size(); n++) {
            List<lecture> lectures = lectureRepository.findByid((Long) lecture_attend_Count.get(n));
            List<lecture_detail> lecture_details = lecture_detailRepository.findByLecture_id((Long) lecture_attend_Count.get(n));
            num =0;

            day = lectures.get(0).getLecture_day();
            JsonArray jsonArray = (JsonArray) jsonParser.parse(day);
            String tmp="";
            String tmp_day="";

            if(col >7){
                col =0;
            }else
                col++;

            for(int i =0; i<lecture_details.size(); i++) {
                String get_dates = new SimpleDateFormat("yyyy-MM-dd").format(lecture_details.get(i).getLecture_date());



                JsonObject object = (JsonObject) jsonArray.get(num);

                String Day = object.get("lectureDay").getAsString();
                String Start = object.get("startTime").getAsString();
                String detail = object.get("detailTime").getAsString();

                StringTokenizer Strat_token = new StringTokenizer(Start,":",false);
                int S_hour = Integer.parseInt(Strat_token.nextToken());
                int S_minute= Integer.parseInt(Strat_token.nextToken());

                if(S_hour<10){
                    start_time = "0"+Start;
                }else
                    start_time = Start;

                if(tmp.equals("")){
                    tmp = Day;
                    tmp_day=get_dates;

                }else if(tmp.equals(Day)){
                    tmp = "";
                    get_dates =tmp_day;
                    i=i-1;
                }else{
                    tmp = "";

                }
                double add_time = Double.parseDouble(detail);
                int add_h = S_hour+(int) add_time;
                int add_m=0;

                add_m = S_minute+(int)(60/(1/(add_time%1)));
                add_m -= 15;



                if(add_m ==0){
                    end_time = String.valueOf(add_h)+":"+String.valueOf(add_m)+"0";
                }else {
                    end_time = String.valueOf(add_h) + ":" + String.valueOf(add_m);
                }

                if(S_minute == 0){
                    lecture_attend_c.add("{"+
                            "title:'" + lectures.get(0).getName()+"',"+
                            "start:'"+get_dates+"T"+ start_time+"0:00"+"',"+
                            "end:'"+get_dates+"T"+ end_time+":00"+"'"+","+
                            "color:colorList["+String.valueOf(col)+"]"+
                            "}");

                    System.out.println("title:'" + lectures.get(0).getName()+"'");
                    System.out.println("start:'"+get_dates+"T"+ Start+"0:00"+"'");
                    System.out.println("end:'"+get_dates+"T"+ end_time+":00"+"'");
                }else{
                    lecture_attend_c.add("{"+
                            "title:'" + lectures.get(0).getName()+"',"+
                            "start:'"+get_dates+"T"+ start_time+":00"+"',"+
                            "end:'"+get_dates+"T"+end_time+":00"+"'"+","+
                            "color:colorList["+String.valueOf(col)+"]"+
                            "}");

                    System.out.println("title:'" + lectures.get(0).getName()+"'");
                    System.out.println("start:'"+get_dates+"T"+ Start+":00"+"'");
                    System.out.println("end:'"+get_dates+"T"+end_time+":00"+"'");
                }

                if((jsonArray.size()-1)>num){
                    num++;
                }else{
                    num =0;
                }



            }
        }




        model.addAttribute("lecture_size",lecture_attend_c.size());
        model.addAttribute("lecture_attend_c",lecture_attend_c);



        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
        Date today = new Date();
        String today_info = format1.format(today);

        List<student_lecture> student_lectures1 = student_lectureRepository.findByStudent_id(user);
        List<assignment> assigment_list= new ArrayList<>();
        List lecture_nameList = new ArrayList();

        for(int i=0; i < student_lectures1.size(); i++){

            List<lecture> lectures = lectureRepository.findByid(student_lectures1.get(i).getLecture_id());
            List<assignment> assignments = assignmentRepository.findBylecture_id(lectures.get(0).getId());

            for(int n=0; n<assignments.size(); n++){
                Date end_day = assignments.get(n).getEnd_date();
                String end_info = format1.format(end_day);
                int compare = end_info.compareTo(today_info);

                System.out.println("끝="+end_info);
                System.out.println("오늘="+today_info);
                System.out.println("비교="+compare);
                if(compare > 0){
                    assigment_list.add(assignments.get(n));
                    lecture_nameList.add(lectures.get(n).getName());
                    System.out.println("추가!!");
                }

            }
        }

        model.addAttribute("size", lecture_nameList.size() - 1);
        model.addAttribute("lecture_nameList",lecture_nameList);
        model.addAttribute("assigment_list",assigment_list);


        return "main/Main_Page";
    }










    @RequestMapping(value = "/Lecture_listpage", method= {RequestMethod.GET,RequestMethod.POST})
    public String Lecture_page(Model model,
                               @RequestParam(value="check",required=false)Long removecheck){

        System.out.println("삭제:"+removecheck);


        List<student_lecture> student_lectures = student_lectureRepository.findByStudent_id(user);
        List<assignment> assignment_remove = assignmentRepository.findBylecture_id(removecheck);

        if(removecheck != null) {
            for (int i = 0; i < student_lectures.size(); i++) {

                if(student_lectures.get(i).getLecture_id() == removecheck){
                    for(int j=0; j<assignment_remove.size(); j++){
                        List<student_assignment> student_assignments = student_assignmentRepository.findByassignment_id(assignment_remove.get(j).getId());
                        for(int k=0; k<student_assignments.size();k++){
                            if(student_assignments.get(k).getStudent_id().equals(user)){
                                System.out.println("삭제될 id의 과제="+user);
                                student_assignmentRepository.delete(student_assignments.get(k));
                            }
                        }
                    }

                    student_lectureRepository.delete(student_lectures.get(i));
                    return "redirect:http://localhost:8080/Lecture_listpage";
                }
            }
        }

        List Lecture_list = new ArrayList();
        List <lecture> Lecture_info = new ArrayList();
        List tmp = new ArrayList();
        Long lectureid;

        for(int i=0;i<student_lectures.size();i++){
            lectureid = student_lectures.get(i).getLecture_id();
            System.out.println(lectureid);
            Lecture_list.add(lectureid);
        }
        System.out.println("size "+ student_lectures.size());

        for(int i=0; i<student_lectures.size();i++) {

            List<lecture> lectures = lectureRepository.findByid((Long) Lecture_list.get(i));
            List<professor> professors = professorRepository.findByid(lectures.get(0).getProfessor_id());
            lectures.get(0).setProfessor_id(professors.get(0).getName());

            System.out.println(lectures.get(0).getName());
            System.out.println(lectures.get(0).getProfessor_id());

            Lecture_info.add(lectures.get(0));
        }


        model.addAttribute("Lecture_info",Lecture_info);
        System.out.println("id="+user);

        return "Lecture/Lecture_listpage";
    }







    @RequestMapping(value = "/Lecture_page", method= {RequestMethod.GET,RequestMethod.POST})
    public String Lecture_detail(Model model,
                                 @RequestParam(value="id",required=false)Long id){
        String day, day_con="";
        String start_time="",end_time="";
        List tmp_schtime= new ArrayList();
        String tmp_Day="";
        int size = 0;

        int Lecture_continuity=0;
        List<lecture> lecture_content = lectureRepository.findByid(id);
        List<professor> professors = professorRepository.findByid(lecture_content.get(0).getProfessor_id());
        List time = new ArrayList();




        JsonParser jsonParser = new JsonParser();
        day = lecture_content.get(0).getLecture_day();
        lecture_content.get(0).setProfessor_id(professors.get(0).getName());
        JsonArray jsonArray = (JsonArray) jsonParser.parse(day);

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject object = (JsonObject) jsonArray.get(i);
            String Day = object.get("lectureDay").getAsString();
            String Start = object.get("startTime").getAsString();
            String detail = object.get("detailTime").getAsString();


            if(tmp_Day != ""){
                if(tmp_Day.equals(Day))
                    Lecture_continuity =1;
            }else{
                tmp_Day = Day;
            }

            StringTokenizer end = new StringTokenizer(Start,":",false);
            int hour =  Integer.parseInt(end.nextToken());
            int minute = Integer.parseInt(end.nextToken());
            if(minute==0){
                start_time = Start+"0"+" ~ ";
            }else{
                start_time = Start+" ~ ";
            }
            double add_time = Double.parseDouble(detail);
            System.out.println(add_time + "시간입니다.");
            int add_h = hour+(int) add_time;
            int add_m=0;

            add_m = minute+(int)(60/(1/(add_time%1)));
            add_m -= 15;

            if(add_m >= 60){
                add_h +=1;
                add_m -= 60;
            }
            System.out.println(add_m);
            if(add_m ==0){
                end_time = String.valueOf(add_h)+":"+String.valueOf(add_m)+"0";
            }else {
                end_time = String.valueOf(add_h) + ":" + String.valueOf(add_m);
            }

            day_con = start_time + end_time;
            tmp_schtime.add(day_con);
            time.add(Day +"요일 " +day_con);

            size += 1;
        }

        size -=1;
        model.addAttribute("lecture_content",lecture_content);
        model.addAttribute("time",time);
        model.addAttribute("size",size);

        System.out.println(lecture_content.get(0).getId());
        List<lecture_detail> lecture_details = lecture_detailRepository.findByLecture_id(id);
        String detail_dateTime="";
        int count=0;
        System.out.println("lecture_details id: "+lecture_details.get(0).getId());
        System.out.println("lecture_details Canceled: "+lecture_details.get(0).getCanceled());
        System.out.println("lecture_details Lecture_date: "+lecture_details.get(0).getLecture_date());
        System.out.println("lecture_details detail_time: "+lecture_details.get(0).getLecture_detail_time());
        System.out.println("lecture_details Lecture_id: "+lecture_details.get(0).getLecture_id());


        List<assignment> assignments = assignmentRepository.findBylecture_id(id);


        for(int i=0; i<lecture_details.size(); i++){
            detail_dateTime ="";
            String canceled="";
            String get_dates = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(lecture_details.get(i).getLecture_date());
            Double get_LCtime = lecture_details.get(i).getLecture_detail_time();
            String Detail_Day = lecture_details.get(i).getLecture_day();
            StringTokenizer dates_token = new StringTokenizer(get_dates," ",false);
            String ymd = dates_token.nextToken();

            detail_dateTime = (String) tmp_schtime.get(count);

            if (Lecture_continuity==1){
                detail_dateTime = detail_dateTime +" / "+tmp_schtime.get(1);
                count =0;
            }else if(count==1){
                count=0;
            }else
                count=1;
            if((lecture_details.get(0).getCanceled())==1){
                canceled = "휴강";
            }else{
                canceled = "";
            }
            lecture_details.get(i).setLecture_day(ymd + " ("+Detail_Day+") " + detail_dateTime);
            System.out.println(ymd + " ("+Detail_Day+") " + detail_dateTime +"      "+canceled);
        }

        model.addAttribute("lecture_details",lecture_details);


        return "Lecture/Lecture_page";
    }




    @RequestMapping(value = "/Lecture_assignment", method= {RequestMethod.GET,RequestMethod.POST})
    public String Lecture_assignment(Model model){

        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
        Date today = new Date();
        String today_info = format1.format(today);

        List<student_lecture> student_lectures = student_lectureRepository.findByStudent_id(user);
        List<assignment> assigment_list= new ArrayList<>();
        List lecture_nameList = new ArrayList();

        for(int i=0; i < student_lectures.size(); i++){

            List<lecture> lectures = lectureRepository.findByid(student_lectures.get(i).getLecture_id());
            List<assignment> assignments = assignmentRepository.findBylecture_id(lectures.get(0).getId());

            for(int n=0; n<assignments.size(); n++){
                Date end_day = assignments.get(n).getEnd_date();
                String end_info = format1.format(end_day);
                int compare = end_info.compareTo(today_info);

                System.out.println("끝="+end_info);
                System.out.println("오늘="+today_info);
                System.out.println("비교="+compare);
                if(compare > 0){
                    assigment_list.add(assignments.get(n));
                    lecture_nameList.add(lectures.get(n).getName());
                    System.out.println("추가!!");
                }

            }
        }

        model.addAttribute("size", lecture_nameList.size() - 1);
        model.addAttribute("lecture_nameList",lecture_nameList);
        model.addAttribute("assigment_list",assigment_list);

        return "assignment/Lecture_assignment";
    }





    @RequestMapping(value = "/mypage_main", method= {RequestMethod.GET,RequestMethod.POST})
    public String mypage_main(Model model,
                              @RequestParam(value="name",required=false)String name,
                              @RequestParam(value="phone",required=false)String phone,
                              @RequestParam(value="email",required=false)String email) throws Exception{

        List<student> studentinfo = studentRepository.findByid(user);
        if(name != null) {
            try {
                student student = new student();
                student.setId(studentinfo.get(0).getId());
                student.setName(name);
                student.setPassword(studentinfo.get(0).getPassword());
                student.setPhone(phone);
                student.setEmail(email);
                studentRepository.save(student);
            } catch (Exception e) {

            }
        }

        System.out.println(studentinfo);

        List list = new ArrayList();
        list.clear();
        list.add(studentinfo.get(0).getId());
        list.add(studentinfo.get(0).getName());
        list.add(studentinfo.get(0).getEmail());
        list.add(studentinfo.get(0).getPhone());

        model.addAttribute("studentinfo",list);


        return "Mypage/mypage_main";
    }



    @RequestMapping(value = "/Lecture_addPage", method= {RequestMethod.GET, RequestMethod.POST})
    public String Lecture_addPage(Model model,
                                  @RequestParam(value="Lecture_id",required=false)Long id){
        String day,day_str ="";

        if(id!=null) {
            try {
                List<lecture> lectures = lectureRepository.findByid(id);
                System.out.println("lectures =>" + lectures);
                System.out.println(lectures.get(0).getName());
                student_lecture student_lecture = new student_lecture();
                student_lecture.setLecture_id(lectures.get(0).getId());
                student_lecture.setStudent_id(user);
                student_lectureRepository.save(student_lecture);

            } catch (Exception e) {
                System.out.println("에러 메시지 : " + e.getMessage());
            }
        }

        System.out.println("!!!!!!!!!");
        List<lecture> lecture_list = lectureRepository.findAll();
        List<professor> professors = professorRepository.findAll();

        List<student_lecture> student_lectures_check = student_lectureRepository.findByStudent_id(user);    // 예외처리~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        List<lecture> lecture_addlist = new ArrayList();             // 예외처리~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        int check=0;

        JsonParser jsonParser = new JsonParser();

        for(int i=0; i<lecture_list.size(); i++){

            System.out.println(lecture_list.get(i).getProfessor_id());
            for(int j=0; j<professors.size(); j++){
                System.out.println(professors.get(j).getId());
                if(lecture_list.get(i).getProfessor_id().equals(professors.get(j).getId())){
                    lecture_list.get(i).setProfessor_id(professors.get(j).getName());

                    System.out.println(professors.get(j).getName());
                }
            }

            day = lecture_list.get(i).getLecture_day();
            System.out.println(day);

            JsonArray jsonArray = (JsonArray) jsonParser.parse(day);
            for (int j2 = 0; j2 < jsonArray.size(); j2++) {
                JsonObject object = (JsonObject) jsonArray.get(j2);
                String Day = object.get("lectureDay").getAsString();
                String Start = object.get("startTime").getAsString();
                String detail = object.get("detailTime").getAsString();

                if(day_str=="")
                    day_str = Day+"-"+Start+"("+detail+")";
                else
                    day_str = day_str+", "+Day+"-"+Start+"("+detail+")";
            }
            lecture_list.get(i).setLecture_day(day_str);
            check =0;
            for(int k=0; k< student_lectures_check.size(); k++){
                if(student_lectures_check.get(k).getLecture_id()==lecture_list.get(i).getId()){
                    check =1;
                }
            }
            if(check==0){
                lecture_addlist.add(lecture_list.get(i));
            }

            day_str = "";
        }

        model.addAttribute("lecture_list",lecture_addlist);

        return "Lecture/Lecture_addPage";
    }




    @RequestMapping(value = "/assignment_page", method= {RequestMethod.GET,RequestMethod.POST})
    public String assignment_page(Model model,
                                  @RequestParam(value="assignment_id",required=false)Long Assign_id,
                                  @RequestParam(value="part",required=false)String part){
        System.out.println("역할="+part);
        List<student_assignment> student_assignments = student_assignmentRepository.findByassignment_id(Assign_id);
        int overlap =1;

        if(student_assignments == null || part != null) {
            overlap =0;
        }else if(part == null) {
            overlap =1;
        }

        for (int i = 0; i < student_assignments.size(); i++) {
            if (user.equals(student_assignments.get(i).getStudent_id())) {
                overlap = 2;
            }
        }


        if(overlap == 0){
            student_assignment student_assignment = new student_assignment();

            student_assignment.setAssignment_id(Assign_id);
            student_assignment.setStudent_id(user);
            System.out.println("역할 저장="+part);
            student_assignment.setPart(part);

            student_assignmentRepository.save(student_assignment);
        }


        List<student> studentinfo = studentRepository.findByid(user);
        List<student_assignment> student_assignments2 = student_assignmentRepository.findByassignment_id(Assign_id);
        List Student_name = new ArrayList();
        List Student_id = new ArrayList();
        List Student_type = new ArrayList();

        for(int i=0; i<student_assignments2.size(); i++) {
            try{
                List<student> student_info = studentRepository.findByid(student_assignments2.get(i).getStudent_id());
                String type = student_assignments2.get(i).getPart();

                Student_name.add( student_info.get(0).getName());
                Student_id.add(student_info.get(0).getId());
                Student_type.add(type);
                System.out.println("참석자 ID=" + student_info.get(0).getId());
                System.out.println("참석자 이름=" + student_info.get(0).getName());
                System.out.println("참석자 타입 = "+type);

            }catch (Exception e){

            }

        }

        model.addAttribute("size",Student_name.size()-1);
        model.addAttribute("Student_name",Student_name);
        model.addAttribute("Student_id",Student_id);
        model.addAttribute("Student_type",Student_type);



        model.addAttribute("overlap",overlap);
        model.addAttribute("Assign_id",Assign_id);
        model.addAttribute("ID",studentinfo.get(0).getId());
        model.addAttribute("Name",studentinfo.get(0).getName());
        return "assignment/assignment_page";
    }

}
