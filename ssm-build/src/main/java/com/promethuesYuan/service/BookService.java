package com.promethuesYuan.service;

import com.promethuesYuan.pojo.Books;

import java.util.List;

public interface BookService {
    //添加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //修改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询所有的书
    List<Books> queryAllBook();
}
