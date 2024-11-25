async function saveOutfit() {
    const name = document.getElementById('outfitName').value;
    const description = document.getElementById('outfitDescription').value;

    try {
        await fetch('/api/outfits', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, description })
        });

        alert('코디 저장 완료!');
        fetchOutfits();
    } catch (error) {
        console.error('코디 저장 실패:', error);
    }
}

async function fetchOutfits() {
    try {
        const response = await fetch('/api/outfits');
        const outfits = await response.json();

        const outfitList = document.getElementById('savedOutfits');
        outfitList.innerHTML = outfits.map(outfit => `
            <li class="list-group-item">
                <h5>${outfit.name}</h5>
                <p>${outfit.description}</p>
            </li>
        `).join('');
    } catch (error) {
        console.error('코디 불러오기 실패:', error);
    }
}

document.getElementById('saveOutfitBtn').addEventListener('click', saveOutfit);
fetchOutfits();
