// list 디자인
function renderList() {
    clear();
    let dom = `
                <table border="1">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="list-box">
                        
                    </tbody>
                </table>
             `;
    root.innerHTML = dom;
    sendList();
}

function renderListItem(board) {
    let dom = `            
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td><a href="javascript:void(0);" onclick="renderDetail(${board.id})">상세보기</a></td>            
            `;
    let item = document.createElement("tr");
    item.innerHTML = dom;
    return item;
}

async function renderList2() {
    clear();
    boards = await sendList2();
    console.log(boards);
    let dom = `
                <table border="1">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="list-box">
                        ${boards.map(board => renderListItem2(board)).join("")}
                    </tbody>
                </table>
             `;
    root.innerHTML = dom;
}

function renderListItem2(board) {
    let dom = `
            <tr>            
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td><a href="javascript:void(0);" onclick="renderDetail(${board.id})">상세보기</a></td>            
            </tr>
            `;
    return dom;
}

// detail 디자인
async function renderDetail(id) {
    clear();

    let board = await sendDetail(id);
    state = board;
    let dom = `
        <form>
            <button type="button" onclick="sendDelete(${board.id});">삭제</button>
        </form>
        <form>
            <button type="button" onclick="renderUpdateForm(${board.id});">수정</button>
        </form>
        <div>
            번호: ${board.id}<br>
            제목: ${board.title}<br>
            내용: ${board.content}<br>
            작성일: ${board.createdAt}<br>
        </div>
    `
    root.innerHTML = dom;
}

// saveForm 디자인
function renderSaveForm() {
    clear();
    let dom = `
                <form>
                    <input type="text" id="title" placeholder="제목"><br>
                    <input type="text" id="content" placeholder="내용"><br>
                    <button type="button" onclick="sendSave();">글쓰기</button>
                </form>
            `;
    root.innerHTML = dom;
}

// updateForm 디자인
async function renderUpdateForm(id) {
    clear();
    let dom = `
                <form>
                    <input type="number" value="${state.id}" readonly><br>
                    <input type="text" id="title" placeholder="제목" value="${state.title}"><br>
                    <input type="text" id="content" placeholder="내용" value="${state.content}"><br>
                    <input type="text" value="${state.createdAt}"" readonly><br>
                    <button type="button" onclick="sendUpdate(${state.id});">수정</button>
                </form>
            `
    root.innerHTML = dom;
}

// 화면 초기화
function clear() {
    root.innerHTML = "";
}