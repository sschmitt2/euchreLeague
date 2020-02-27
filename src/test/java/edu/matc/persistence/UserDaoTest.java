package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// add unit tests to achieve 100% code coverage of your dao.
// You should run these tests repeatedly, in any order, and they should all pass every time!
// Javadoc comments
class UserDaoTest {

    UserDao dao;


    /**
     * Sets up the book table with fresh data and creates database instance
     */
    @BeforeEach
    void setUp() {

        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new UserDao();
    }

    /**
     * verifies success of getting id
     */
    @Test
    void getById() {
        User retrievedUser = dao.getById(1);
        
        assertEquals("Java: A Beginner’s Guide (Sixth Edition)", retrievedBook.getTitle());
        assertEquals("Herbert Schilt", retrievedBook.getAuthor());
        assertEquals("978-0071809252", retrievedBook.getIsbn());
        assertEquals(2014, retrievedBook.getPublicationYear());

    }

    /**
     * verifies that you can save and update a new book
     */
    @Test
    void saveOrUpdate() {
        String newAuthor = "Sarah Schmitt";
        Book bookToUpdate = dao.getById(3);
        bookToUpdate.setAuthor(newAuthor);
        dao.saveOrUpdate(bookToUpdate);
        Book retrievedBook = dao.getById(3);
        assertEquals(newAuthor, retrievedBook.getAuthor());
    }
    /**
     * verifies that you insert a new book
     */
    @Test
    void insert() {
        Book newBook = new Book(22, "You are a Badass", "Jen Sincero", "9780762447695", 2013);
        int id = dao.insert(newBook);
        assertNotEquals(0,id);
        Book insertedBook = dao.getById(id);
        assertEquals("You are a Badass", insertedBook.getTitle());
        assertEquals("Jen Sincero", insertedBook.getAuthor());
        assertEquals("9780762447695", insertedBook.getIsbn());
        assertEquals(2013, insertedBook.getPublicationYear());
    }

    /**
     * verifies that you can delete a book
     */
    @Test
    void delete() {
        Book retrievedBook = dao.getById(3);
        assertNotNull(retrievedBook);
        dao.delete(retrievedBook);

    }

    /**
     * verifies that you can retrieve all books
     */
    @Test
    void getAll() {
        List<Book> books = dao.getAll();
        assertEquals(3, books.size());
    }
}