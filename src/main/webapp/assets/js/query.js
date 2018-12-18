$(document).ready(function(){
	var id=prompt("请输入用户id","5");
	if (id==null || id=="")
	{
		id=prompt("请输入用户id","");
	}
	//ajax
	function getXMLHttpRequest(){
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}
		else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}
	var xhr=getXMLHttpRequest();
	
	xhr.onreadystatechange=function(){
		//alert(xhr.readyState);
	if(xhr.readyState==4){//请求正常
		if(xhr.status==200){//服务器响应一切正常
			//接收到返回的数据
			var usermsg=xhr.responseText;
			var mes=JSON.parse(usermsg);
			if(mes.key=="error"){
				alert("用户信息查询失败，刷新重试")
			}else{
				var user=JSON.parse(mes.user);
				alert(user.picture);
				$("#user-img").attr("src",user.picture);
				$("#name").val(user.name);
				$("#email").val(user.mail);
				//$("#sex").val(user.sex);
				$("#nation").val(user.nation);
				$("#education").val(user.education);
				$("#phone").val(user.phone);
				$("#introduce").val(user.introduce);
				if(user.sex==0){
					$("#sex").val("男");
				}else{
					$("#sex").val("女");
				}
			}
		}
	 }
	};
	xhr.open("post","queryuser.do",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("id="+id);
});