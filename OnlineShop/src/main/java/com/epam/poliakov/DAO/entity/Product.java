package com.epam.poliakov.DAO.entity;

public class Product {

    int id;
    String name;
    String subject;
    double price;
    String origin;
    String image;

    public Product() {
    }

    public Product(String name, String subject, double price, String origin, String image) {
        this.name = name;
        this.subject = subject;
        this.price = price;
        this.origin = origin;
        this.image = image;
    }

    public Product(int id, String name, String subject, double price, String origin, String image) {
        this(name, subject, price, origin, image);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (subject != null ? !subject.equals(product.subject) : product.subject != null) return false;
        if (origin != null ? !origin.equals(product.origin) : product.origin != null) return false;
        return image != null ? image.equals(product.image) : product.image == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", price=" + price +
                ", origin='" + origin + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
