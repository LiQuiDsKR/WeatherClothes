package com.liquidskr.service;

import com.liquidskr.dto.ItemDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClothesRecommendationService {

    private final String gptApiKey = "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"; // OpenAI API 키
    private final String gptUrl = "https://api.openai.com/v1/chat/completions";

    public List<ItemDTO> getClothesRecommendation(double temp, double windSpeed, int humidity, int cloudiness) {
        try {
            // 1. GPT 요청 생성
            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "gpt-4");
            requestBody.put("messages", new JSONArray().put(new JSONObject()
                    .put("role", "user")
                    .put("content", createPrompt(temp, windSpeed, humidity, cloudiness))));

            // 2. HTTP 요청 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(gptApiKey);

            // 3. RestTemplate 호출
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            String response = restTemplate.postForObject(gptUrl, entity, String.class);

            // 4. 응답 파싱
            JSONObject jsonResponse = new JSONObject(response);
            String gptContent = jsonResponse.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");

            // 5. GPT 응답을 ItemDTO 리스트로 변환
            return parseGptResponse(gptContent);

        } catch (Exception e) {
            throw new RuntimeException("의상 추천에 실패했습니다: " + e.getMessage());
        }
    }

    private String createPrompt(double temp, double windSpeed, int humidity, int cloudiness) {
        return String.format(
                "현재 날씨: 온도 %.1f°C, 풍속 %.1f m/s, 습도 %d%%, 구름량 %d%%. " +
                        "이 데이터를 기반으로 다음 형식으로 옷차림을 추천해주세요:\n\n" +
                        "상의: [추천 아이템 이름 및 간단한 설명]\n" +
                        "하의: [추천 아이템 이름 및 간단한 설명]\n" +
                        "신발: [추천 아이템 이름 및 간단한 설명]\n" +
                        "액세서리: [추천 아이템 이름 및 간단한 설명]\n",
                temp, windSpeed, humidity, cloudiness
        );
    }

    private List<ItemDTO> parseGptResponse(String gptContent) {
        List<ItemDTO> items = new ArrayList<>();

        // GPT 응답을 줄 단위로 분리
        String[] lines = gptContent.split("\n");
        for (String line : lines) {
            if (line.startsWith("상의:")) {
                items.add(createItem("상의", line));
            } else if (line.startsWith("하의:")) {
                items.add(createItem("하의", line));
            } else if (line.startsWith("신발:")) {
                items.add(createItem("신발", line));
            } else if (line.startsWith("액세서리:")) {
                items.add(createItem("액세서리", line));
            }
        }
        return items;
    }

    private ItemDTO createItem(String type, String line) {
        String name = extractName(line);
        String description = extractDescription(line);

        // 고유 ID 생성 및 기본 이미지 URL 설정
        String id = UUID.randomUUID().toString();
        String imageUrl = getDefaultImageUrl(type);

        return new ItemDTO(id, name, description, imageUrl);
    }

    private String extractName(String line) {
        // "상의: 가벼운 긴 팔티 혹은 얇은 가디건을 추천드립니다." -> "가벼운 긴 팔티"
        String[] parts = line.split(":")[1].trim().split(" ");
        return parts[0]; // 첫 번째 단어를 이름으로 사용
    }

    private String extractDescription(String line) {
        // "상의: 가벼운 긴 팔티 혹은 얇은 가디건을 추천드립니다." -> "가벼운 긴 팔티 혹은 얇은 가디건을 추천드립니다."
        return line.split(":")[1].trim();
    }

    private String getDefaultImageUrl(String type) {
        switch (type) {
            case "상의":
                return "/images/tops_default.png";
            case "하의":
                return "/images/bottoms_default.png";
            case "신발":
                return "/images/shoes_default.png";
            case "액세서리":
                return "/images/accessories_default.png";
            default:
                return "/images/default.png";
        }
    }
}
