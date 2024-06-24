function ajax_test1(){
    const xhr = new XMLHttpRequest();

    // 컨트롤러로 이동
    // 첫번째 매개변수 : 'post', 'get'
    // 두번째 매개변수 : 이동한 url
    // 세번째 매개변수 : true - 비동기 접근, false - 동기 접근
    xhr.open('post', '/test/test1', true);
    // 컨트롤러로 이동 시 데이터 전달 방식 지정
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                alert('ajax 통신 성공');
            }else {
                alert('ajax 통신 실패');
            }
        }
    };
}

function ajax_test2(){
    const xhr = new XMLHttpRequest();

    xhr.open('post', '/test/test2', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send('name=java&age=20');
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                alert('ajax 통신 성공');
            }else{
                alert('ajax 통신 실패');
            }
        }
    };
}

function ajax_test3(){
    const xhr = new XMLHttpRequest();
    xhr.open('post' , '/test/test3', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('name=java&age=20');
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //xhr.response : 컨트롤러에서 리턴되는 데이터
                alert('ajax 통신 성공');

                alert(xhr.response);
            }else{
                alert('ajax 통신 실패');
            }
        }
    };
}

function ajax_test4(){
    const xhr = new XMLHttpRequest();
    xhr.open('post' , '/test/test4', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //xhr.response : 컨트롤러에서 리턴되는 데이터
                alert('ajax 통신 성공');
                console.log(xhr.response);

                //받은 객체 데이터를 자바스크립트의 데이터 타입으로 변환.
                const result = JSON.parse(xhr.response);
                console.log('학생명 = ' + result.stuName);
                console.log(`학생 나이 = ${result.stuName}`);
            }else{
                alert('ajax 통신 실패');
            }
        }
    };
}

function ajax_test5(){
    const xhr = new XMLHttpRequest();
    xhr.open('post', '/test/test5', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //xhr.response : 컨트롤러에서 리턴되는 데이터
                alert('ajax 통신 성공');
                console.log(xhr.response);

                const stuList = JSON.parse(xhr.response);
                console.log(stuList);

                for(const stu of stuList){
                    console.log(`학번 = ${stu.stuNum} 이름 = ${stu.stuName} 나이 = ${stu.stuAge}`);
                }
            }else{
                alert('ajax 통신 실패');
            }
        }
    }
}