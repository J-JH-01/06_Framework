// 목록으로 버튼 동작 (메인페이지로 요청)
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () => {
  location.href = "/"; // 메인 페이지 요청(GET 방식)

})

// 완료 여부 변경 버튼
document.querySelector(".complete-btn").addEventListener("click", e =>{
  
  // 요소.dataset : data-* 속성에 저장된 값 반환
  // data-todo-no 세팅한 속성값 얻어오기
  // data-todo-no(html -를 사용) -> dataset.todoNo(js 카멜케이스)
  const todoNo = e.target.dataset.todoNo;

  let complete = e.target.innerText; // 기존 완료 여부 값 얻어오기
  
  // Y <-> N
  complete = (complete ==='Y') ? 'N' : 'Y';

  // 완료 여부 수정 요청하기
  location.href = `/todo/changeComplete?todoNo=${todoNo}&complete=${complete}`;

  // /todo/changeComplete?todoNo=${todoNo}&complete=${complete} = Y or N이 되는거임
  //console.log(todoNo);
})

// 수정 버튼
document.querySelector("#updateBtn").addEventListener("click", e =>{

  const todoNo = e.target.dataset.todoNo;

  location.href = `/todo/toUpdate?todoNo=${todoNo}`; 
})

// 삭제 버튼 
document.querySelector("#deleteBtn").addEventListener("click", e =>{

  const todoNo = e.target.dataset.todoNo;

  location.href=`/todo/delete?todoNo=${todoNo}`; 
})