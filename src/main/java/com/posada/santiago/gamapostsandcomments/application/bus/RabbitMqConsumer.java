package com.posada.santiago.gamapostsandcomments.application.bus;


import com.google.gson.Gson;
import com.posada.santiago.gamapostsandcomments.application.bus.models.CommentModel;
import com.posada.santiago.gamapostsandcomments.application.bus.models.PostModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMqConsumer {

    private final Gson gson = new Gson();

    public static final String PROXY_QUEUE_POST_CREATED = "events.proxy.post.created";
    public static final String PROXY_QUEUE_COMMENT_ADDED = "events.proxy.comment.added";

    @RabbitListener(queues = PROXY_QUEUE_POST_CREATED)
    public void listenToPostCreatedQueue(String received) {
        /**Starting point*/
        PostModel postModel = gson.fromJson(received, PostModel.class);
        System.out.println(postModel);
    }

    @RabbitListener(queues = PROXY_QUEUE_COMMENT_ADDED)
    public void listenToCommentAddedQueue(String received) {
        /**Starting point*/
        CommentModel commentModel = gson.fromJson(received, CommentModel.class);
        System.out.println(commentModel);
    }
}
