async function fetchRecommendations() {
    try {
        const response = await fetch('/api/clothes-recommendation?temp=15&humidity=50&windSpeed=3&cloudiness=20');
        const items = await response.json();

        const itemList = document.getElementById('recommendedItems');
        itemList.innerHTML = items.map(item => `
            <div class="col-md-4">
                <div class="card">
                    <img src="${item.imageUrl}" class="card-img-top" alt="${item.name}">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.description}</p>
                    </div>
                </div>
            </div>
        `).join('');
    } catch (error) {
        console.error('추천 의상 불러오기 실패:', error);
    }
}

fetchRecommendations();
