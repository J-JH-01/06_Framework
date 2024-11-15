console.log("main.js loaded. ")

// 이메일, 비밀번호 미작성 시 로그인 막기
const loginForm = document.querySelector("#loginForm"); // form 태그
const loginEmail = document.querySelector("#loginForm input[name='memberEmail']"); // 이메일 input 태그
const loginPw = document.querySelector("#loginForm input[name='loginPw']"); // 비밀번호 input 태그

const tbody = document.querySelector("#memberList");
// #loginForm이 화면에 존재할 때 (==로그인 상태 아닐 때)
// -> 타임리프에 의해 로그인 되었다면 #loginForm 요소는 화면에 노출되지 않음
// -> 로그인 상태일 때 loginForm을 이용한 코드가 수행된다면
// -> 콘솔창에 error 발생

if(loginForm != null){
  // 제출 이벤트 발생 시
  loginForm.addEventListener("submit", e=>{

    // 이메일 미작성
    if(loginEmail.value.trim().length === 0){
      alert("이메일을 작성해주세요!")
      e.preventDefault(); // 기본 이벤트(제출) 막기
      loginEmail.focus(); // 초점 이동
      return;
    }
    // 비밀번호 미작성
    if(loginPw.value.trim().length === 0){
      alert("비밀번호를 작성해주세요!")
      e.preventDefault(); // 기본 이벤트(제출) 막기
      loginPw.focus(); // 초점 이동
      return;
    }
  })
}


document.querySelector("#selectMemberList").addEventListener("click", ()=>{
  fetch("/viewList")
  .then(resp => resp.json())
  .then(viewList => {
    tbody.innerHTML="";

    for(let view of viewList){
      const tr = document.createElement("tr");

      const arr = ['memberNo','memberEmail','memberNickname','memberDelFl']
      console.log(arr);

      for(let key of arr){
        const td = document.createElement("td");
        td.innerText = view[key]
        tr.append(td);
      }

      tbody.append(tr);
    }

  })
});

document.querySelector("#resetPw").addEventListener("click", ()=>{
  const input = document.querySelector("#resetMemberNo")


  fetch("/resetPass",{
    method : "POST", // POST 방식 요청
    headers : {"Content-type" : "application/json"}, // 요청 데이터의 형식을 JSON으로 지정
    body : input.value // 
  })
  .then(resp => resp.json()) // 반환된 값을 text로 변환
  .then( result => {
  
    if(result > 0) { 
      alert("변경 성공!!!");
      input.value ="";
    } else { // 실패
      alert("변경 실패...");
    }

  });

});

document.querySelector("#restorationBtn").addEventListener("click", ()=>{
  const input = document.querySelector("#restorationMemberNo")

  fetch("/restoration",{
    method : "POST", // POST 방식 요청
    headers : {"Content-type" : "application/json"}, // 요청 데이터의 형식을 JSON으로 지정
    body : input.value // 
  })
  .then(resp => resp.json()) // 반환된 값을 text로 변환
  .then( result => {
  
    if(result > 0) { 
      alert("변경 성공!!!");
      input.value ="";
    } else { // 실패
      alert("변경 실패...");
    }

  });

});




































