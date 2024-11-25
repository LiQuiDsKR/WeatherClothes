package com.liquidskr.dto;

import java.time.LocalDateTime;

public class CommentDTO {
    private String id; // 댓글 고유 ID
    private String postId; // 관련된 게시글 ID
    private String author; // 작성자
    private String content; // 댓글 내용
    private LocalDateTime createdAt; // 작성 시간
}
