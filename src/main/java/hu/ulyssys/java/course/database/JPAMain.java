package hu.ulyssys.java.course.database;

import hu.ulyssys.java.course.database.dao.PersistenceDAO;
import hu.ulyssys.java.course.database.entity.Author;
import hu.ulyssys.java.course.database.entity.BlogPost;

import java.util.Date;

public class JPAMain {
    public static void main(String[] args) {
        PersistenceDAO<Author> authorDAO = new PersistenceDAO(Author.class);
        PersistenceDAO<BlogPost> blogPostDAO = new PersistenceDAO<>(BlogPost.class);

        Author author = new Author();
        author.setFirstName("Agatha");
        author.setLastName("Christie");
        author.setUsername("agathachristie");
        author.setCreatedDate(new Date());
        author.setLastModifiedDate(new Date());

        authorDAO.save(author);

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Random blogpost");
        blogPost.setContent("Random stuff");
        blogPost.setCategory("Tech");
        blogPost.setCreatedDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setPublishedDate(new Date());

        blogPostDAO.save(blogPost);

        for (Author a : authorDAO.findAll()) {
            System.out.println("Id: " + a.getId() + " firstName: " + a.getFirstName() + " lastName: " + a.getLastName());
        }

        for (BlogPost b : blogPostDAO.findAll()) {
            System.out.println("Id: " + b.getId() + " title: " + b.getTitle() + " content: " + b.getContent());
        }
    }
}
