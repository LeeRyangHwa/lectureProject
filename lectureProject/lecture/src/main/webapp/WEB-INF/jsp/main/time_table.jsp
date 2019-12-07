<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8' />
    <link href='/packages/core/main.css' rel='stylesheet' />
    <link href='/packages/daygrid/main.css' rel='stylesheet' />
    <link href='/packages/timegrid/main.css' rel='stylesheet' />
    <link href='/packages/list/main.css' rel='stylesheet' />
    <script src='/vendor/rrule/rrule.js'></script>
    <script src='/packages/core/main.js'></script>
    <script src='/packages/interaction/main.js'></script>
    <script src='/packages/daygrid/main.js'></script>
    <script src='/packages/timegrid/main.js'></script>
    <script src='/packages/list/main.js'></script>
    <script src='/packages/rrule/main.js'></script>
    <script>
//        var colorList = ['black','white','yellow'];
        var colorList = ['#ACF3FF','#9EF048','#FFCFDA','#FFAAFF','#FFEB5A','#FFC7AD','#F49A56'];
        var Calendar = FullCalendar.Calendar;
        var Draggable = FullCalendarInteraction.Draggable

        var i=0;
        var now_day = new Date();
        document.addEventListener('DOMContentLoaded', function() {

            var calendarEl = document.getElementById('calendar');
            var lecture_size=${lecture_size};
            var lecture_attend_c =${lecture_attend_c};

            var e =[];
            for(var i =0; i<lecture_size; i++){
                e.push(lecture_attend_c[i]);
                console.log(lecture_attend_c[i]);
            }


            var calendar = new FullCalendar.Calendar(calendarEl, {
                plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list', 'rrule'],
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
                },

                monthNames: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
                monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
                dayNames: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
                dayNamesShort: ["일","월","화","수","목","금","토"],
                buttonText: {
                    today : "오늘",
                    month : "월",
                    week : "주",
                    day : "일"
                },
                defaultView: 'timeGridWeek',
                defaultDate: now_day,
                editable: true,
                events: e

            });


            calendar.render();
        });

    </script>
    <style>

        body {
            margin: 40px 10px;
            padding: 0;
            font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
            font-size: 14px;
        }

        #calendar {
            max-width: 900px;
            margin: 0 auto;
        }

    </style>
</head>
<body>

<div id='calendar'></div>

</body>
</html>
