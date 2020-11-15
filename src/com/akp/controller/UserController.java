package com.akp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akp.model.UserAccount;
//
//@Controller
//@RequestMapping("user")

public class UserController {
	
	private static final String PERSISTENCE_UNIT_NAME = "akp";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from UserAccount t");
        List<UserAccount> todoList = q.getResultList();
        for (UserAccount todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        UserAccount todo = new UserAccount();
        todo.setName("Aung ");
        todo.setLoginId("aungkyawphyoe.ls@gmail.com");
        em.persist(todo);
        em.getTransaction().commit();

        em.close();

    }
//	@RequestMapping(value = "index", method = RequestMethod.GET)
//	public ModelAndView index(Model model) {
// 
//             System.out.println("Record Successfully Inserted In The Database");
//		model.addAttribute("Hello", "Hello World");
//		return new ModelAndView("index");
//	}
}
