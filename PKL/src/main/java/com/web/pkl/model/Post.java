package com.web.pkl.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// User class 생성
@Entity(name="posts") // Entity을 통해 쉽게 쿼리문 사용
public class Post {
  @Id // Primary Key (id를 지정하지 않으면 오류 발생)
  @GeneratedValue(strategy = GenerationType.IDENTITY) // DB의 AutoIncreament 사용 가능
  private Long id;
  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  private String user;

  @CreationTimestamp
  private LocalDateTime created_at;

  @Builder
  public Post(String title, String description, String user, LocalDateTime created_at)
  {
    this.title = title;
    this.description = description;
    this.user = user;
    this.created_at = created_at;
  }
}
