<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>JavaChip-Community</title>

  <!-- Bootstrap core CSS -->
  <link href="${path}/community/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">  

  <!-- Custom styles for this template -->
  <link href="${path}/community/css/simple-sidebar.css" rel="stylesheet">
<style>
table{
	width: 1200px;
	margin-top: 20px;

}
#formpwd{
	display: none;
}
</style>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>

	window.addEventListener("load", function(){
		
		var secret = document.getElementById("secrettype");
		var normal = document.getElementById("normaltype");
		var formpwd = document.getElementById("formpwd");	
		
		secret.onclick = function(){
			formpwd.style.display = 'inline-block';
		}
		normal.onclick = function(){
			formpwd.style.display = 'none';
		}
});
</script>
<script>
	$(function(){
		$('#btnSave').click(function(){ //qna등록
			if($('option').val() == null || $('#title').val() == null || $('#content').val()){
				alert("입력값이 부족합니다.");
				return;
			}else{
				location.href="javaChip?command=insertQnA&prodId"+$('option').val()+"&title="+$('#title').val()+"&content="+$('#content').val();
			}
		});//end save
	});//end load
</script>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${path}/marga/index.jsp">J A V A C H I P</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${path}/marga/index.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${path}/Login/login.jsp">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${path}/marga/index.jsp">로그아웃</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" onclick="window.open('${path}/regForm/regform.jsp', '_blank', 'width=600, height=400');">회원가입</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${path}/mypage/mypage.jsp">마이페이지</a>
          </li>        
            <li class="nav-item">
            <a class="nav-link" href="${path}/classlist/cart.jsp">강의목록</a>
          </li>
          <li class="nav-item">
			 <a class="nav-link" href="${path}/mygangisil/mygangisil.jsp"><span style="color: white; font-weight: bold">내강의실</span></a>
		  </li>
          <li class="nav-item">
            <a class="nav-link" href="${path}/community/community.jsp">커뮤니티</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Start Bootstrap </div>
      <div class="list-group list-group-flush">
        <a href="${path}/community/Q&Aboard.jsp" class="list-group-item list-group-item-action bg-light">Q&A게시판</a>
        <a href="${path}/community/evaluation.jsp" class="list-group-item list-group-item-action bg-light">강의평게시판</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">회사정보</a>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      
      <div class="container-fluid">
	    <h2 style="text-align: center; margin-top: 20px;">질문하기</h2>
	    <hr>

			<form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
	
				<table style="width: 300px;">
				
				<tr><th>옵션</th>
				<th>일반글<input type="radio" id="normaltype" name="secret" value="normal" checked="checked"></th>
				<th>비밀글<input type="radio" id="secrettype" name="secret" value="secret"></th>
				</tr>				
				
				</table>			
				<p>
				<div class="mb-3">
					<label for="title" style="font-weight: bold">작성자</label> ${userId}</div>
				<div class="mb-3">
					<label for="title" style="font-weight: bold">강좌 선택</label> <br>
					<select>
					<c:forEach items="${itemList}" var="item" varStatus="state">
						<option value="${item.product.id}">${item.product.name} / ${item.product.teacher.name}</option>
					</c:forEach>
					</select>
				</div>
				<div class="mb-3">
					<label for="title" style="font-weight: bold">제목</label>
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
				</div>			
				<div class="mb-3">
					<label for="content" style="font-weight: bold">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="질문작성" ></textarea>
				</div>
		
			<div class="mb-3" id="formpwd">
					<label for="password" style="font-weight: bold">비밀번호</label>
					<input type="password" class="form-control" name="title" id="title" placeholder="최대4자리" maxlength="4">
				</div>	
			</form>

			<div >

				<button type="button" class="btn btn-sm btn-primary" id="btnSave">등록하기</button>
				<button type="button" class="btn btn-sm btn-primary" onclick='location.href="../javaChip?command=selectAllQnA"'>목록</button>
			</div>
		</div>

	   </div>
	 </div>
    <!-- /#page-content-wrapper -->   
  	<!-- /#wrapper -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>
${id}
</body>

</html>
