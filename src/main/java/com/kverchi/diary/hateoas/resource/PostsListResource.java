package com.kverchi.diary.hateoas.resource;

import com.kverchi.diary.model.entity.Comment;
import com.kverchi.diary.model.entity.Sight;
import com.kverchi.diary.model.entity.Post;
import com.kverchi.diary.model.entity.User;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Liudmyla Melnychuk on 4.6.2019.
 */
@Relation(value = "post", collectionRelation = "posts")
public class PostsListResource extends ResourceSupport {
    private final int postId;
    private final String title;
    private final String description;
    private final String previewImageUrl;
    private final ZonedDateTime updatedAt;
    private final User author;
    private final Sight sight;

    public PostsListResource(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.previewImageUrl = post.getPreviewImageUrl();
        this.updatedAt = post.getUpdatedAt();
        this.author = post.getAuthor();
        this.sight = post.getSight();
    }
    public int getPostId() {
        return postId;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public String getPreviewImageUrl() {
        return previewImageUrl;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public User getAuthor() {
        return author;
    }

    public Sight getSight() {
        return sight;
    }


}
