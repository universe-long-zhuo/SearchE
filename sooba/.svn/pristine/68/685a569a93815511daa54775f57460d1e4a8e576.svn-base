<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv=Content-Type content="text/html;charset=gb2312">
		<title>文档高级搜索</title>
		<link href="css/souba.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function check(){
			var val= document.forms[0].fieldname.value;
			
			if(val==""){
				   return false;
			   }
			   else
			   {
			   document.forms[0].submit();
			   }
			}
		</script>
	</head>
	<body>
        
        <br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<img src="images/searchba.GIF" width=180 height=84 usemap="#mp" id=lg>
			<br>
			<br>
			<br>
			<br>
			

			<html:form action="AdvanceSearchAction" theme="simple" >
			<table>
				<tr>
				<td><font><b>选择检索的类型</b></font></td>
				<td>
				<select name="qtype">
                    <option value="term" selected="selected">精确
                	<option value="fuzz">模糊
                	<option value="pref">前缀
                </select>
				<html:textfield  name="fieldname" size="42" maxlength="100" required="true"></html:textfield> 
	            <input type="button" value="搜吧"  onclick="check()"/>
				</td>
				</tr>
				<tr>
				</tr>
				<tr>
				<td><font><b>选择每页显示的文档数</b></font></td>
				<td>
				<select name="pagetype">
                    <option value="10" selected="selected">每页显示10条
                	<option value="20">每页显示20条
                	<option value="50">每页显示50条
                </select>
				</td>
				</tr>
				<tr>
				</tr>
				<tr>
                <td><font><b>检索结果数目设置</b></font></td>
				<td>
				<select name="totalpage">
                    <option value="100" selected="selected">处理前100条
                	<option value="200">处理前200条
                	<option value="500">处理前500条

                </select>
				</td>

				</tr>
				<tr>
				</tr>				
				<tr>
				<td><font><b>选择检索的文档类型</b></font></td>
				<td>
				<select name="filetype">
                    <option value="pdf" selected="selected">PDF文档
                	<option value="doc">Word文档
                	<option value="all">全部文档
                </select>
				</td>
				</tr>
			</table>
			    							
			
      
			</html:form>
			
	
			
			
			<p id=km>

			</p>
			<p style="height: 60px">
			<table cellpadding=0 cellspacing=0 id=lk>
				<tr>
					<td></td>
				</tr>
			</table>

			<p style="height: 30px">
				<a
					
					href="#"><br>
				</a>
			</p>
			<p style="height: 14px">
			</p>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>

			<p id=b>
				<span>Copyright &copy; 1999 - 2010&nbsp; All Rights Reserved</span>
			</p>

		</center>
	</body>
</html>
