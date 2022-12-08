<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20221208</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> 
</script>
</head>
<body>
	<img alt="" src="https://quickchart.io/qr?text=%EC%B1%84%EC%A7%84%EC%98%81&dark=fff&light=000&ecLevel=H"> 
	<img src="https://via.placeholder.com/600x300.png?text=love"><br>
	<img src="https://dummyimage.com/300X300/000/fff"><br>
    <input type="button" id="aBtn" value="아작스요청🎯">
    <input type="button" id="aBtn2" value="아작스요청2🎯">
    <input type="button" id="aBtn3" value="아작스요청3🎯">
    <input type="button" id="aBtn4" value="아작스요청4🎯">
    <input type="button" id="aBtn5" value="아작스요청5🎯 VO사용">
<script>
    var vaBtn = document.querySelector("#aBtn");
    var vaBtn2 = document.querySelector("#aBtn2");
    var vaBtn3 = document.querySelector("#aBtn3");
    var vaBtn4 = document.querySelector("#aBtn4");
    var vaBtn5 = document.querySelector("#aBtn5");
    
    vaBtn5.onclick = function(){
        var merong = {
            name: "김아무개",
            idols:["레드벨벳", "있찡", "없찡"],
            age : 30,
            homeTown:"서울"
        }
        
        $.ajax({
            type: "post",
            url: "/ajax/getTest5",
            data : JSON.stringify(merong),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function(rslt){
                console.log("회신결과 : ",rslt);
            }
            // 실패 예외처리는 구글에서 검색해서 쓰세용!
        })
    }
    
    
    vaBtn4.onclick = function(){
        var merong = {
            name: "민지짱",
            idols:["레드벨벳", "있찡", "없찡"]
        }
        
        $.ajax({
            type: "post",
            url: "/ajax/getTest4",
            data : JSON.stringify(merong),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function(rslt){
                console.log("회신결과 : ",rslt);
            }
            // 실패 예외처리는 구글에서 검색해서 쓰세용!
        })
    }
    
    
    vaBtn3.onclick = function(){
        var dataArr = [
        	{name : "가가가", age:"10"},
        	{name : "나나나", age:"20"},
        	{name : "다다다", age:"30"},
        	{name : "라라라", age:"40"},
        ];
        
        $.ajax({
            type: "post",
            url: "/ajax/getTest3",
            data : JSON.stringify(dataArr),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function(rslt){
                console.log("회신결과 : ",rslt);
            }
            // 실패 예외처리는 구글에서 검색해서 쓰세용!
        })
    }
    
    
    vaBtn2.onclick = function(){
        // 자바스크립트<->자바 ::::: 배열 <-> 리스트, JSON <-> MAP
        var dataArr = ["햇님", "달님", "별님"]
        $.ajax({
            type: "post",
            url: "/ajax/getTest2",
            data : JSON.stringify(dataArr),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function(rslt){
                console.log("회신결과 : ",rslt);
            }
            // 실패 예외처리는 구글에서 검색해서 쓰세용!
        })
    }

    
    vaBtn.onclick = function(){
        // 자바스크립트<->자바 ::::: 배열 <-> 리스트, JSON <-> MAP
        var obj = {
            name: "이름이름",
            age: "몇살이게🧚‍♀️"
        }
        $.ajax({
            type: "post",
            url: "/ajax/getTest",
            data : JSON.stringify(obj),
            contentType: "application/json;charset=utf-8",
            dataType: "text",
            success: function(rslt){
                console.log("회신결과 : ",rslt);
            }
            // 실패 예외처리는 구글에서 검색해서 쓰세용!
        })
    }
</script>    
</body>
</html>