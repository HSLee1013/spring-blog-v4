async function sendList() {
    // 1. API 요청
    let response = await fetch("http://localhost:8080/api/board");
    let responseBody = await response.json();

    // 2. 응답 처리
    let boards = responseBody.body;

    let listBox = document.querySelector("#list-box");
    boards.forEach(board => {
        let item = renderListItem(board);
        listBox.append(item);
    });
}

async function sendList2() {
    // 1. API 요청
    let response = await fetch("http://localhost:8080/api/board");
    let responseBody = await response.json();

    // 2. 응답 처리
    let boards = responseBody.body
    return boards;
}

async function sendDetail(id) {
    // 1. API 요청
    let response = await fetch(`http://localhost:8080/api/board/${id}`);
    let responseBody = await response.json();

    // 2. 응답 처리
    return responseBody.body;
}

async function sendSave() {
    // 1. 사용자 입력값 받기
    let board = {
        title: document.querySelector("#title").value,
        content: document.querySelector("#content").value,
    };
    // 2. JSON 변환
    let requestBody = JSON.stringify(board);
    // 3. API 요청
    let response = await fetch("http://localhost:8080/api/board", {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: requestBody
    });
    let responseBody = await response.json();
    // 4. 응답 처리
    if (responseBody.success) {
        renderList();
    } else {
        alert(responseBody.msg);
    }
}

async function sendDelete(id) {
    // 1. API 요청
    let response = await fetch(`http://localhost:8080/api/board/${id}`, {
        method: "DELETE"
    });
    let responseBody = await response.json();
    // 2. 응답 처리
    if (responseBody.success) {
        renderList();
    } else {
        alert(responseBody.msg);
    }
}

async function sendUpdate(id) {
    // 1. 사용자 입력값 받기
    let board = {
        title: document.querySelector("#title").value,
        content: document.querySelector("#content").value,
    };
    // 2. JSON 변환
    let requestBody = JSON.stringify(board);
    // 3. API 요청
    let response = await fetch(`http://localhost:8080/api/board/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: requestBody
    });
    let responseBody = await response.json();

    // 4. 응답 처리
    if (responseBody.success) {
        renderDetail(id);
    } else {
        alert(responseBody.msg);
    }
}