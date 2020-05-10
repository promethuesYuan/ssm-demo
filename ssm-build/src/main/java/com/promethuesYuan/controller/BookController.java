package com.promethuesYuan.controller;

import com.promethuesYuan.pojo.Books;
import com.promethuesYuan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBooks")
    public String list(Model model){
        System.out.println("allbook页面");
        List<Books> books = bookService.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
        model.addAttribute("list", books);
        return "allBooks";
    }

    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPage(Books book){
        System.out.println(book);
        bookService.addBook(book);
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id, Model model){
        Books book = bookService.queryBookById(id);
        System.out.println(book);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("updateBook")
    public String updateBook(Model model, Books book){
        System.out.println(book);
        bookService.updateBook(book);
        return "redirect:/book/allBooks";

    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBooks";
    }
}
