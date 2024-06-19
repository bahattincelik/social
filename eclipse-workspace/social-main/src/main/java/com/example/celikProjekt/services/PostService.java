package com.example.celikProjekt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.celikProjekt.entities.Post;
import com.example.celikProjekt.repos.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent()) {
			
			return postRepository.findByUserId(userId.get());
			
			
		}
		else {
			return postRepository.findAll();
		}
		
		
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(Post newPost) {
		return postRepository.save(newPost);
	}
	

}
