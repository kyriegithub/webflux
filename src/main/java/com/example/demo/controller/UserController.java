package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-11-03 23:03
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Map<Long, User> users=new HashMap<>();


    /**
     * 注解用于servlet生命周期 依赖关系注入完成后,完成初始化(类似上面的)
     * @throws Exception
     */
    @PostConstruct
    public  void init() throws  Exception{
        users.put(Long.valueOf(1),new User(1,"name1",20));
        users.put(Long.valueOf(2),new User(2,"name2",30));
    }


    /**
     * getall user
     * @return
     */
    @GetMapping("/list")
    public Flux<User> getAll(){
        return Flux.fromIterable(users.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList()));
    }


    /**
     * getone user
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<User>  getUser(@PathVariable Long id){
        return Mono.justOrEmpty(users.get(id));
    }

    /**
     * add user
     * @param user
     * @return
     */
    @PostMapping("")
    public  Mono<ResponseEntity>  addUser(@RequestBody User user){
        users.put(user.getId(),user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }

    /**
     * update user
     * @param  id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public  Mono<ResponseEntity>  updateUser(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        users.put(id,user);
        return Mono.just(new ResponseEntity("修改成功",HttpStatus.CREATED));
    }


    /**
     * deleted  user
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public   Mono<ResponseEntity> delUser(@PathVariable Long id){
        users.remove(id);
        return Mono.just(new ResponseEntity("删除成功",HttpStatus.CREATED));

    }










}
