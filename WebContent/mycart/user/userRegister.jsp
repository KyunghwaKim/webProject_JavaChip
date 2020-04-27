<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaChip</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}

.table-wrapper {
	background: #fff;
	padding: 20px 25px;
	margin: 30px 0;
	border-radius: 3px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 15px;
	background: #299be4;
	color: #fff;
	padding: 16px 30px;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title .btn {
	color: #566787;
	float: right;
	font-size: 13px;
	background: #fff;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}

.table-title .btn:hover, .table-title .btn:focus {
	color: #566787;
	background: #f2f2f2;
}

.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}

.table-title .btn span {
	float: left;
	margin-top: 2px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}

table.table tr th:first-child {
	width: 60px;
}

table.table tr th:last-child {
	width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}

table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
}

table.table td a:hover {
	color: #2196F3;
}

table.table td a.settings {
	color: #2196F3;
}

table.table td a.delete {
	color: #F44336;
}

table.table td i {
	font-size: 19px;
}

table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}

.status {
	font-size: 30px;
	margin: 2px 2px 0 0;
	display: inline-block;
	vertical-align: middle;
	line-height: 10px;
}

.text-success {
	color: #10c469;
}

.text-unsuccess {
	color: #ff1919;
}

.text-info {
	color: #62c9e8;
}

.text-warning {
	color: #FFC107;
}

.text-danger {
	color: #ff5b5b;
}

.pagination {
	float: right;
	margin: 0 0 5px;
}

.pagination li a {
	border: none;
	font-size: 13px;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 2px !important;
	text-align: center;
	padding: 0 6px;
}

.pagination li a:hover {
	color: #666;
}

.pagination li.active a, .pagination li.active a.page-link {
	background: #03A9F4;
}

.pagination li.active a:hover {
	background: #0397d6;
}

.pagination li.disabled i {
	color: #ccc;
}

.pagination li i {
	font-size: 16px;
	padding-top: 6px
}

.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}
.col-sm-71 {
	float: left;
	margin-top: 10px;
	font-size: 1px;
}
</style>
</head>
<!-- admin or teacher 등록 폼 -->
<script>
$(function(){
	$('#register').click(function(){
		$.ajax({
			url : "../insertPerson",
			type : "POST",
			data : "id="+$('#id').val()+"&pwd="+$('#pwd').val()+"&name="+$('#name').val()
			+"&phone="+$('#phone').val()+"&gender="+$('[name=gender]').val()+"&status="+$('[name=status]').val(),
			success : function(){
				alert("등록이 완료되었습니다!");
			}
		});
		
			
	});//end click
});//end ready
</script>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-5">
						<h2><b>사용자 등록</b></h2>
					</div>
					<div class="col-sm-71"></div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				
					<tr>
						<th>ID</th>
						<th><input id="id"></th>
					</tr>
					<tr>
						<th>비밀번호</th>
						<th><input id="pwd"></th>
					</tr>
					<tr>
						<th>이름</th>
						<th><input id="name"></th>
					</tr>
					<tr>
						<th>전화번호</th>
						<th><input id="phone"></th>
					</tr>
					<tr>
						<th>성별</th>
						<th><input type="radio" name="gender" value="1">&nbsp;&nbsp;남자 &nbsp;&nbsp;&nbsp;
							<input type="radio" name="gender" value="2">&nbsp;&nbsp;여자</th>
					</tr>
					<tr>
						<th>구분</th>
						<th><input type="radio" name="status" value="2">&nbsp;&nbsp;강사 &nbsp;&nbsp;&nbsp;
							<input type="radio" name="status" value="3">&nbsp;&nbsp;관리자</th>
					</tr>
			</table>
			<form action="updateCustomer">
				<button type="button" class="btn btn-primary" id="register">등록하기</button>
			</form>
		</div>
</body>
</html>