// 게시글 목록 불러오기
async function fetchPosts() {
    try {
        const response = await fetch('/api/posts');
        const posts = await response.json();

        const postList = document.getElementById('postList');
        postList.innerHTML = posts.map(post => `
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text">${post.description}</p>
                        <button class="btn btn-primary" onclick="viewPost('${post.id}')">자세히 보기</button>
                    </div>
                </div>
            </div>
        `).join('');
    } catch (error) {
        console.error('게시글 목록 불러오기 실패:', error);
    }
}

// 새 게시글 작성
async function createPost() {
    const title = document.getElementById('postTitle').value;
    const description = document.getElementById('postDescription').value;

    try {
        const response = await fetch('/api/posts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ title, description })
        });

        if (response.ok) {
            alert('게시글 작성 완료!');
            fetchPosts();
        } else {
            alert('게시글 작성 실패!');
        }
    } catch (error) {
        console.error('게시글 작성 실패:', error);
    }
}

// 게시글 상세 보기 (추가 구현 필요)
function viewPost(postId) {
    alert(`게시글 ID: ${postId} - 상세 보기는 구현 예정입니다.`);
}

// 이벤트 리스너 등록
document.getElementById('createPostBtn').addEventListener('click', createPost);

// 페이지 로드 시 게시글 목록 불러오기
fetchPosts();
