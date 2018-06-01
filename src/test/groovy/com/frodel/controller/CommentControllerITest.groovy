package com.frodel.controller

import com.frodel.model.Comment
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private InitialisationService initialisationService;

    void "add a comment by calling url"(String aCommentContent) {

        when: "add comment requested"
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("content", aCommentContent);
        map.add("idCommentator", "1");
        Comment comment = restTemplate.postForObject("/comment", map, Comment.class)

        then: "the recover content of comment is the same that the send content"
        comment.content == aCommentContent

        where:
        aCommentContent | _
        "A comment" | _
    }

    def "test to find a comment with a given id calling url"() {
        given: "a comment id"
        Long id = initialisationService.totoComment.id

        when: "find comment by id requested"
        Comment comment = this.restTemplate.getForObject("/comment/id/" + id, Comment.class);

        then:"the result provides 1 comment"
        comment.content == initialisationService.totoComment.content
    }

    def "test to find all comments by calling url"() {

        when: "find comments requested"
        Iterable<Comment> comments = this.restTemplate.getForObject("/comments", Iterable.class);

        then:"the result provides 2 comments"
        comments.size() >= 2
    }
}
