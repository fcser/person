
//$("#code").disabled="true";
function checkdata(){
	//获取用户名
	var username = document.registerForm.username.value;
	//获取密码
	var password = document.registerForm.password.value;
	
	if(!checkUserName(username)){
		return false;
	}
	if(!checkPassWord(password)){
		return false;
	}
}

//判断用户名是否合理
function checkUserName(user){
	if(user.length < 3 || user.length > 18){
		alert("\请输入正确的用户名，用户名长度为3-18位");
		registerForm.username.focus();
		return false
	}
	return true;
}
function checkPassWord(pas){
	if(pas.length < 3 || pas.length > 18){
		alert("\请输入正确的密码，密码长度为3-18位");
		registerForm.password.focus();
		return false
	}
	return true;
}
function password2Change(input){
	//获取第一次输入的密码
	var str1 = document.registerForm.password.value;
	//获取第二次输入的密码
	var str2 = input.value;
	//判断两次密码是否一致
	if (str1 == str2) {
		input.style.borderColor = "green";
		input.style.color = "green";
	} else{
		input.style.borderColor = "red";
		input.style.color = "red";
		alert("两次密码不一致");
	}
}

$(document).ready(function(){
	var InterValObj; //timer变量，控制时间  
	var count = 60; //间隔函数，1秒执行  
	var curCount;//当前剩余秒数  
	var CODE="";//验证码
	var codeLength = 6;//验证码长度  
	var isPhone=true;
	var id=0;//用户id
	var num=0;
	$("#registuser").attr("disabled", "true"); 
	$("#skillsubmit").attr("disabled", "true"); 
	$("#award-submit").attr("disabled", "true"); 
	$("#education-submit").attr("disabled", "true"); 
	$("#project-submit").attr("disabled", "true"); 
	$("#work-submit").attr("disabled", "true"); 
	//检查手机号格式是否正确
	function isTruePhone(phone){
		if(phone.length!=11){
			alert("请仔细检查手机格式");
			return false;
		}
		return true;
	}
	//计时器
	function SetRemainTime() {  
	    if (curCount == 0) {                  
	        window.clearInterval(InterValObj);// 停止计时器  
	       //$("#phonetest").removeAttr("disabled");// 启用按钮  
	        $("#phonetest").html("重新发送验证码");  
	        CODE = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效  
	        $("#code").val("");
	    }else {  
	        curCount--;  
	        $("#phonetest").html("请在" + curCount + "秒内输入验证码");  
	    }  
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
	//运用ajax查询获取手机验证码
	$("#phonetest").click(function(){
		//alert("dian");
		//var user="zym"
		var phone=$("#phone").val();
		var code=$("#code").val();
		if(!isPhone){
			//alert(code);
			window.clearInterval(InterValObj);//停止定时器
			if(code==CODE){
				$("#phonetest").attr("disabled", "true"); //获取验证码按钮锁住
				$("#code").attr("disabled", "true");
				$("#phonetest").html("认证成功");
				$("#registuser").removeAttr("disabled");
				return ;
			}else{
				$("#phonetest").html("重新发送验证码");  
				isPhone=true;
		        CODE ="";//清除原有验证码
		        $("#code").val("");
		        return ;
			}
		}
		if(!isTruePhone(phone)){
			return;
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
					//alert(mes.message);
					$("#phone").val(mes.message);
					$("#phonetest").html("重新发送验证码"); 
				}else{
					isPhone=false;//接下来是验证码
					alert(mes.message);
					$("#code").removeAttr("disabled");//可以进行输入验证码了
					$("#phone").attr("disabled", "true"); 
					CODE=mes.verification;
					curCount=count;
					$("#phonetest").html("请在" + curCount + "秒内输入验证码");  
					InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次
					
				}
			}
		 }
		};
		xhr.open("post","checkPhone.do",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("phone="+phone);
	});
	$("#registuser").click(function(){
		//alert("开始注册用户");
		//var form=new FormData($("#picture").val());
		var user=JSON.stringify({
				name:$("#name").val(),
				mail:$("#email").val(),
				sex:$("#sex").val(),
				nation:$("#nation").val(),
				education:$("#education").val(),
				phone:$("#phone").val(),
				password:$("#password").val(),
				introduce:$("#introduce").val()
		});
		var form=new FormData();
		form.append("picture",$("#picture")[0].files[0]);
		form.append("user",user);
		//var picture=$("#picture").serialize();
		//alert(user);
		var xhr=getXMLHttpRequest();
		xhr.onreadystatechange=function(){
		if(xhr.readyState==4){//请求正常
			if(xhr.status==200){//服务器响应一切正常
				//接收到返回的数据
				var msg=xhr.responseText;
				var massage=JSON.parse(msg);
				alert(msg);
				if(massage.key=="error"){
					$("#registuser").html("重新注册");
				}else{
					alert("请记住你的id："+message.id);
					id=message.id;
					$("#registuser").attr("disabled", "true"); //不可再注册
					$("#skillsubmit").removeAttr("disabled");
					$("#work-submit").removeAttr("disabled");
					$("#award-submit").removeAttr("disabled");
					$("#education-submit").removeAttr("disabled");
					$("#project-submit").removeAttr("disabled");
				}
			}
		}
		};
		xhr.open("post","registuser.do",true);
		xhr.send(form);
	});
	$("#skillsubmit").click(function(){
		alert("注册技能");
		num=0;
		var award=JSON.stringify({
			userId:id,
			skill:$("#skill").val()
		});
		var xhr=getXMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){//请求正常
				if(xhr.status==200){//服务器响应一切正常
					//接收到返回的数据
					var msg=xhr.responseText;
					var massage=JSON.parse(msg);
					if(massage.key=="error"){
						alert(message.message);
						$("#skillsubmit").html("重新提交");
					}else{
						alert(message.message);
						//$("#registuser").attr("disabled", "true"); //不可再注册
						$("#skillsubmit").html("再提交一个");
						num=num+1;
						$("#num").html(num);
					}
				}
			}
		}
		xhr.open("post","registskill.do",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("skill="+skill);
	});
	$("#award-submit").click(function(){
		alert("注册奖项");
		num=0;
		var award=JSON.stringify({
			userId:id,
			award:$("award").val(),
			time:$("award-date").val()
	    });
		var xhr=getXMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){//请求正常
				if(xhr.status==200){//服务器响应一切正常
					//接收到返回的数据
					var msg=xhr.responseText;
					var massage=JSON.parse(msg);
					if(massage.key=="error"){
						alert(message.message);
						$("#award-submit").html("重新提交");
					}else{
						alert(message.message);
						//$("#registuser").attr("disabled", "true"); //不可再注册
						$("#award-submit").html("再提交一个");
						num=num+1;
						$("#award-num").html(num);
					}
				}
			}
		}
		xhr.open("post","registaward.do",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("award="+award);
	});
	$("#award-education").click(function(){
		alert("注册教育");
		var education=JSON.stringify({
			userId:id,
			school:$("school").val(),
			major:$("major").val(),
			intro:$("education-introduce").val(),
			begin:$("education-begin").val(),
			end:$("education-end").val()
	    });
		var xhr=getXMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){//请求正常
				if(xhr.status==200){//服务器响应一切正常
					//接收到返回的数据
					var msg=xhr.responseText;
					var massage=JSON.parse(msg);
					if(massage.key=="error"){
						alert(message.message);
						$("#education-submit").html("错误，重新提交");
					}else{
						alert(message.message);
						//$("#registuser").attr("disabled", "true"); //不可再注册
						$("#education-submit").html("再提交一个");
					}
				}
			}
		}
		xhr.open("post","registeducation.do",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("education="+education);
	});
	$("#award-education").click(function(){
		alert("注册项目");
		var project=JSON.stringify({
			userId:id,
			pname:$("pname").val(),
			pbegin:$("project-begin").val(),
			pend:$("project-end").val(),
			myWork:$("myWork").val(),
			pintro:$("project-introduce").val()
	    });
		var xhr=getXMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){//请求正常
				if(xhr.status==200){//服务器响应一切正常
					//接收到返回的数据
					var msg=xhr.responseText;
					var massage=JSON.parse(msg);
					if(massage.key=="error"){
						alert(message.message);
						$("#project-submit").html("错误，重新提交");
					}else{
						alert(message.message);
						//$("#registuser").attr("disabled", "true"); //不可再注册
						$("#project-submit").html("再提交一个");
					}
				}
			}
		}
		xhr.open("post","registeducation.do",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("project="+project);
	});
});
//ajax



