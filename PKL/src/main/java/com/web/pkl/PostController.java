package com.web.pkl;

import com.web.pkl.model.Post;
import com.web.pkl.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller // URL과 함수를 매핑
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @RequestMapping(value="/post", method = RequestMethod.POST)
  public String postNew(
      @RequestParam(value = "title")String title,
      @RequestParam(value = "description")String description,
      @RequestParam(value = "user")String user,
      @RequestParam(value = "create_at") LocalDateTime create_at
  ) {
    Post post = new Post(title = title, description = description, user = user, create_at = create_at);
    postRepository.save(post);
    return "redirect:/";
  }


}
