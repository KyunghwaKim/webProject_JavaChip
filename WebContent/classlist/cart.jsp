<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-Cart</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/heroic-features.css" rel="stylesheet">

<style>

table{
	border: 1px solid;
}

td, th{
	width: 400px;
	height: 40px;
	font-size: 20px;
	border: 1px solid;
	text-align: center;
}

</style>


</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="../marga/index.jsp">J A V A C H I P</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="../marga/index.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
		  <li class="nav-item">
		  <a class="nav-link" href="../Login/login.jsp">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../marga/index.jsp">로그아웃</a>
          </li>
         <li class="nav-item">
           <a class="nav-link" onclick="window.open('../regForm/regform.jsp', '_blank', 'width=600, height=400');">회원가입</a>
         </li>
          <li class="nav-item">
            <a class="nav-link" href="../mypage/mypage.jsp">마이페이지</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../classlist/cart.jsp">강의목록</a>
          </li>
          <li class="nav-item">
			 <a class="nav-link" href="../mygangisil/mygangisil.jsp"><span style="color: white; font-weight: bold">내강의실</span></a>
		  </li>
          <li class="nav-item">
            <a class="nav-link" href="../community/community.jsp">커뮤니티</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
      <h1 class="display-3">★BEST★</h1>
      <p class="lead">자바칩의 자랑 장희정 강사! 프로그래밍계의 전설! 패키지로 바로 만나보세요!</p>
      <a href="#" class="btn btn-primary btn-lg">패키지구매하기</a>
    </header>

	<div>
	
	<table>
		<tr><th rowspan="2">구분별</th><th colspan="3">검색조건을 선택하세요!</th></tr>
		<tr>
		<td>
		<select name="category">
			<option>카테고리별</option>
			<option>JAVA</option>
			<option>Python</option>
			<option>HTML&CSS</option>
			<option>JavaScript</option>
			<option>C언어</option>		
		</select>
		</td>
		<td>
		<select name="teacher">
			<option>강사별</option>
			<option>장희정강사</option>
			<option>김민호강사</option>
			<option>이영진강사</option>
			<option>김경화강사</option>
			<option>정준영강사</option>
			<option>신선호강사</option>
		</select>
		</td>
		<td>
		<select name="level">
			<option>레벨별</option>
			<option>왕초보</option>
			<option>초보</option>
			<option>중수</option>
			<option>고수</option>
			<option>마스터</option>			
		</select>
		</td>
		</tr>		
	</table>
	<p>
	
	</div>
    <!-- Page Features -->
    <div class="row text-center">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/1CTeacher.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">JAVA 왕초보</h4>
            <p class="card-text"> JAVA 입문자에게 적합! <br>이론부터 실습까지 철저한 <br>챕터로 구성!</p>
          </div>
          <div class="card-footer">
            <a href="../detail_information/detail.jsp" class="btn btn-primary">자세히보기</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/1HTMLTeacher.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">JAVA 초보</h4>
            <p class="card-text"> 다양한 예제를 통해 실습으로 기본기를 더욱 탄탄하게 다져줄 수 있는 구성!</p>
          </div>
          <div class="card-footer">
            <a href="../detail_information/detail.jsp" class="btn btn-primary">자세히보기</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/1JAVASCRIPTTeacher.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title"> JAVA 중수</h4>
            <p class="card-text"> JAVA 프로그래밍 고수로 가는 지름길!<br> 기본기와 심화학습을 동시에!</p>
          </div>
          <div class="card-footer">
            <a href="../detail_information/detail.jsp" class="btn btn-primary">자세히보기</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/1PythonTeacher.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title"> JAVA 고수</h4>
            <p class="card-text"> 키보드 피아니스트가 <br>가능하게 해주는 교육!</p>
          </div>
          <div class="card-footer">
            <a href="../detail_information/detail.jsp" class="btn btn-primary">자세히보기</a>
          </div>
        </div>
      </div>
      
      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/1CTeacher.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title"> C언어 왕초보</h4>
            <p class="card-text"> C언어 입문자에게 적합한 강의</p>
          </div>
          <div class="card-footer">
            <a href="../detail_information/detail.jsp" class="btn btn-primary">자세히보기</a>
          </div>
        </div>
      </div>     

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; KOSTA_2조 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
