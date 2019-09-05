package com.wolox.camelproject.beans;

import java.util.List;

public class LibraryOne {

    private String isbn;
    private String title;
    private String subtitle;
    private List<String> publishers;
    private String publishDate;
    private int numberOfPages;
    private List<String> authors;
    private float price;
    private String libraryName;
    private String address;
    private String phone;
    private String email;

    public LibraryOne(String isbn, String title, String subtitle, List<String> publishers,
                      String publishDate, int numberOfPages, List<String> authors,
                      float price, String libraryName, String address, String phone, String email) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.publishers = publishers;
        this.publishDate = publishDate;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
        this.price = price;
        this.libraryName = libraryName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public LibraryOne(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
