package com.liquidskr.dto;

import com.liquidskr.dto.ItemDTO;

import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
    private String id; // 게시글 고유 ID
    private String title; // 제목
    private String description; // 설명
    private String author; // 작성자
    private List<ItemDTO> items; // 코디 아이템 리스트
    private int likes; // 좋아요 수
    private List<CommentDTO> comments; // 댓글 리스트
    private LocalDateTime createdAt; // 작성 시간
}
