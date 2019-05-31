package br.com.microservices.redisservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Cacheable(value = "webservice-response", key="")
    @RequestMapping(value = "/call", method = RequestMethod.GET, produces = "application/json")
	public String call() {
		return callWebService();
	}
	
	public String callWebService() {
		System.out.println("Calling WebService...");
		RestTemplate template = new RestTemplate();
		return template.getForEntity("https://api.calendario.com.br/?ano=2019&estado=SP&cidade=SAO_PAULO&token=ZmlsaXBlaGNkcy5zcEBnbWFpbC5jb20maGFzaD0xMzUxNzQ4Njk&json=true", String.class).getBody();
	}
    
    @Autowired
    private PostService postService;

    @Cacheable(value = "post-single", key = "#id", unless = "#result.shares < 500")
    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable String id) throws PostNotFoundException {
        log.info("get post with id {}", id);
        return postService.getPostByID(id);
    }

    @CachePut(value = "post-single", key = "#post.id")
    @PutMapping("/update")
    public Post updatePostByID(@RequestBody Post post) throws PostNotFoundException {
        log.info("update post with id {}", post.getId());
        postService.updatePost(post);
        return post;
    }

    @CacheEvict(value = "post-single", key = "#id")
    @DeleteMapping("/delete/{id}")
    public void deletePostByID(@PathVariable String id) throws PostNotFoundException {
        log.info("delete post with id {}", id);
        postService.deletePost(id);
    }

    @Cacheable(value = "post-top")
    @GetMapping("/top")
    public List<Post> getTopPosts() {
        return postService.getTopPosts();
    }

    @CacheEvict(value = "post-top")
    @GetMapping("/top/evict")
    public void evictTopPosts() {
        log.info("Evict post-top");
    }

}

