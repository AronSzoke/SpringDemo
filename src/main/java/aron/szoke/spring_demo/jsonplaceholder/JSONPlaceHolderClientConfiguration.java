package aron.szoke.spring_demo.jsonplaceholder;

import org.springframework.aop.TargetSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderClientConfiguration {

    @Bean("jsonplaceholder")
    CommandLineRunner commandLineRunner (JSONPlaceHolderClient jsonPlaceHolderClient){
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/posts");
            System.out.println(jsonPlaceHolderClient.getPosts().size());

            System.out.println();
            System.out.println("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println(jsonPlaceHolderClient.getPost(1));

            System.out.println();
            Post post = jsonPlaceHolderClient.getPost(5);
            System.out.println(post);
        };
    }
}
