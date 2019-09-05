package com.wolox.camelproject.beans;

import java.util.ArrayList;
import java.util.List;

public class SecondLibrary {
    private String isbn;
    private String bookTitle;
    private String subtitle;
    private List<String> publishers;
    private String publishDate;
    private int pages;
    private List<String> authors;
    private float price;
    private String libraryName;
    private String address;
    private String phoneNumber;
    private String email;

    public SecondLibrary(){}

    public SecondLibrary(String isbn, String bookTitle, String subtitle, List<String> publishers, String publishDate, int pages, List<String> authors, float price, String libraryName, String address, String phoneNumber, String email) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.subtitle = subtitle;
        this.publishers = publishers;
        this.publishDate = publishDate;
        this.pages = pages;
        this.authors = authors;
        this.price = price;
        this.libraryName = libraryName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
