let index = {
	init: function(){ // 이벤트 리스너 바인딩
		$("#btn-save").on("click", () => {
			this.save();
		}); // 수정 추가할꺼면 그대로 복사해서 변수명만 바꿔줌
	},
	save: function(){ // 회원가입 로직 실행
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val(),
		};
		$.ajax({.
			type:"POST",
			url:"/auth/joinProc", // 권한과 인증이 필요없는 경우 auth
			data:JSON.stringify(data), // POST 방식이기 때문에 data를 날릴 수 있음
			contentType:"application/json; charset=utf-8", // 대소문자 구분
			dataType: "json"// 서버로부터 응답받을 때 데이터 타입
		}).done((resp)=>{
			console.log(resp); // 자바스크립트 오브젝트가 되서 날라옴
		}).fail((error)=>{
			console.log(error);	
		})
	},
}

index.init();