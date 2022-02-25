<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- Ajax사용을 위한 준비 -->
	<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

	<script>
	
		window.onload=function(){
			//현재 페이지가 로드되면 자동으로 가장 먼저 실행되는 메서드
			testApi();
		}
	
		function testApi(){
			var url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
			var param = "";
			sendRequest(url, param, resultFn, "GET");
		}
		
		//콜백
		function resultFn(){
			if( xhr.readyState == 4 && xhr.status == 200 ){
				
				var data = xhr.responseText;
				var json = eval("["+data+"]");
				
				document.getElementById("type").innerHTML = json[0].boxOfficeResult.boxofficeType;
				document.getElementById("nm").innerHTML = json[0].boxOfficeResult.dailyBoxOfficeList[0].movieNm;
				document.getElementById("dt").innerHTML = json[0].boxOfficeResult.dailyBoxOfficeList[0].openDt;
			}
		}
	</script>

</head>

<body>
	<p id="type"></p>
	<p id="nm"></p>
	<p id="dt"></p>
</body>

</html>






