<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>JAVACHIP - LOGIN</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${path}/Login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/css/util.css">
	<link rel="stylesheet" type="text/css" href="${path}/Login/css/main.css">
<!--===============================================================================================-->

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-90 p-b-30">
				<form class="login100-form validate-form" action="${path}/javaChip?command=login" method="post">
					<span class="login100-form-title p-b-40">
						JAVACHIP Login
					</span>

					<div class="text-center p-t-55 p-b-30">
						<span class="txt1">
							ID&PWD
						</span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate="아이디를 입력하세요">
						<input class="input100" type="text" name="id" placeholder="ID">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-20" data-validate = "비밀번호를 입력하세요">
						<span class="btn-show-pass">
							<i class="fa fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="pwd" placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							로그인
						</button>
						
						<button class="login100-form-btn" onclick="window.open('${path}/regForm/regform.jsp', '_blank', 'width=600, height=400');">
							회원가입
						</button>
					</div>
					<br>
					<br>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn"onclick="window.open('findid.jsp', '_blank', 'width=600, height=400');">
							ID찾기
						</button>
						
						<button class="login100-form-btn" onclick="window.open('findpwd.jsp', '_blank', 'width=600, height=400');">
							비밀번호찾기
						</button>
					</div>
					
					<div class="flex-col-c p-t-224">
						

						<a href="${path}/marga/index.jsp" class="txt3 bo1 hov1">
							<span class="txt2 p-b-10">
							메인으로
						</span>
						</a>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/bootstrap/js/popper.js"></script>
	<script src="${path}/Login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/daterangepicker/moment.min.js"></script>
	<script src="${path}/Login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/js/main.js"></script>

</body>
</html>