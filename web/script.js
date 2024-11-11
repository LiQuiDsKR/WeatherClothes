function setCity(city) { // 도시명 전달받아서 입력창에 설정
    document.getElementById("city").value = city;
    getWeather(); // 자동으로 날씨 조회 실행
}

function getWeather() {
    const city = document.getElementById("city").value;
    fetch(`http://localhost:8080/weather?city=${city}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("temp").querySelector(".card-text").innerText = `${data.temp}°C`;
            document.getElementById("feelsLike").querySelector(".card-text").innerText = `${data.feelsLike}°C`;
            document.getElementById("humidity").querySelector(".card-text").innerText = `${data.humidity}%`;
            document.getElementById("windSpeed").querySelector(".card-text").innerText = `${data.windSpeed} m/s`;
            document.getElementById("windDeg").querySelector(".card-text").innerText = `${data.windDeg}°`;
            document.getElementById("clouds").querySelector(".card-text").innerText = `${data.clouds}%`;
            document.getElementById("description").querySelector(".card-text").innerText = data.description;
            document.getElementById("sunrise").querySelector(".card-text").innerText = formatTime(data.sunrise);
            document.getElementById("sunset").querySelector(".card-text").innerText = formatTime(data.sunset);

            const outfit = recommendOutfit(data.temp);
            document.getElementById("outfit").innerText = outfit;
        })
        .catch(error => console.error("Error fetching weather:", error));
}

function recommendOutfit(temp) {
    if (temp >= 28) return "민소매, 반팔, 반바지, 린넨 옷을 추천합니다.";
    if (temp >= 23) return "반팔과 얇은 셔츠, 반바지, 면바지를 추천합니다.";
    if (temp >= 20) return "블라우스, 긴팔 티셔츠, 면바지, 슬랙스를 추천합니다.";
    if (temp >= 17) return "얇은 가디건이나 니트, 맨투맨, 후드, 긴 바지를 추천합니다.";
    if (temp >= 12) return "자켓, 가디건, 청자켓, 니트, 스타킹, 청바지를 추천합니다.";
    if (temp >= 9) return "트렌치 코트, 야상, 점퍼, 스타킹, 기모 바지를 추천합니다.";
    if (temp >= 5) return "울 코트, 히트텍, 가죽 옷, 기모 바지를 추천합니다.";
    return "패딩, 두꺼운 코트, 누빔 옷, 기모, 목도리를 추천합니다.";
}

function formatTime(timestamp) {
    const date = new Date(timestamp * 1000);
    const hours = date.getHours().toString().padStart(2, "0");
    const minutes = date.getMinutes().toString().padStart(2, "0");
    return `${hours}:${minutes}`;
}
