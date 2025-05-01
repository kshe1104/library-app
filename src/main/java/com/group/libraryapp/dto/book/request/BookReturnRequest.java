package com.group.libraryapp.dto.book.request;

public class BookReturnRequest {
    //필요한 객체(정보) 생성

    private String userName;
    private String bookName;

    //가져다써야함으로 getter만 생성

    public String getUserName(){
        return userName;
    }

    public String getBookName(){
        return bookName;
    }

}
