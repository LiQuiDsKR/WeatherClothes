async function fetchWeather() {
    try {
        const response = await fetch('/api/weather?city=Seoul');
        const data = await response.json();

        document.getElementById('temperature').innerText = `${data.temp}°C`;
        document.getElementById('feelsLike').innerText = `${data.feelsLike}°C`;
    } catch (error) {
        console.error('날씨 정보를 가져오는 데 실패했습니다.', error);
    }
}

// 초기 로드
fetchWeather();
