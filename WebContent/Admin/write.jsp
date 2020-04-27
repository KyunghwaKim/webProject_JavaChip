<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.model_num.value == "") {
	    alert( "모델번호를 입력해 주세요." );
	    f.model_num.focus();
		return false;
    }
	if ( f.model_name.value == "" ) {
		alert( "모델이름을 입력해 주세요." );
		f.model_name.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "가격을 입력해 주세요." );
		f.price.focus();
		return false;
	}
	if ( f.description.value == "" ) {
        alert( "상품 설명을 입력해 주세요." );
        f.description.focus();
        return false;
    }
	if ( f.password.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.password.focus();
        return false;
    }
	
    return true;
}
</SCRIPT>


</HEAD>
<BODY>

<form name="writeForm" method="post" action="../elec?command=insert" 
  onSubmit='return checkValid()' enctype="multipart/form-data">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="2" >
  
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b> 상품 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="model_num" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품이름</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="model_name" size="30"></span></b></td>
    </tr>    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">레벨</span></b></p>
        </td>
        <td>
        	<select>
        		<option>레벨선택</option>
        		<option>왕초보</option>
        		<option>초보</option>
        		<option>중수</option>
        		<option>고수</option>
        		<option>핵고수</option>        		
        	</select>        
        </td>        
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">카테고리</span></b></p>
        </td>
        <td>
        	<select>
        		<option>카테고리선택</option>
        		<option>JAVA</option>
        		<option>Python</option>
        		<option>HTML/CSS</option>
        		<option>JavaScript</option>
        		<option>C언어</option>
        		<option>패키지</option>        		        		
        	</select>        
        </td>        
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">강사명</span></b></p>
        </td>
        <td>
        	<select>
        		<option>강사선택</option>
        		<option>장희정강사</option>
        		<option>김민호강사</option>
        		<option>신진섭강사</option>
        		<option>신선호강사</option>
        		<option>이영진강사</option>
        		<option>정준영강사</option>
        		<option>김경화강사</option>        		
        	</select>        
        </td>        
    </tr>    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상세설명</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<textarea name="description" cols="50" rows="10"></textarea></span></b></td>
    </tr>    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*동영상첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>  
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*강의자료첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>   

    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=상품등록> 
        <input type=reset value=초기화></span></b></td>
    </tr>
</table>

</form>

</BODY>
</HTML>

