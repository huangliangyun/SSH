package com.javahly.test;


import com.javahly.entity.Role;
import com.javahly.entity.Users;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Operation {

    public void saveUsers() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Users u1 = new Users();
        u1.setUname("����");
        Users u2 = new Users();
        u2.setUname("����");
        session.save(u1);
        session.save(u2);
        session.getTransaction().commit();
        session.close();
    }

    public void saveRoles() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Role role1 = new Role();
        role1.setRname("admin");
        role1.setUrl("www.javahly.com,www.hly.com");
        Role role2 = new Role();
        role2.setRname("ѧ��");
        role2.setUrl("www.javahly.com,www.hly.com");
        Role role3 = new Role();
        role3.setRname("��ʦ");
        role3.setUrl("www.javahly.com,www.hly.com");
        session.save(role1);
        session.save(role2);
        session.save(role3);
        session.getTransaction().commit();
        session.close();
    }

    public void selectUser() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Users user1 = (Users) session.get(Users.class, 1);
        System.out.println("user1��" + user1.getUname());
        Users user2 = (Users) session.get(Users.class, 2);
        System.out.println("user1��" + user2.getUname());
        session.close();
    }

    public void selectRole() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Role role1 = (Role) session.get(Role.class, 1);
        System.out.println("role1��" + role1.getRname());
        Role role2 = (Role) session.get(Role.class, 2);
        System.out.println("role2��" + role2.getRname());
        Role role3 = (Role) session.get(Role.class, 3);
        System.out.println("role3��" + role3.getRname());
        session.close();
    }


    public void addUserRole() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();

        Users user1 = (Users) session.get(Users.class, 1);
        Users user2 = (Users) session.get(Users.class, 2);
        Role role1 = (Role) session.get(Role.class, 1);
        Role role2 = (Role) session.get(Role.class, 2);
        Role role3 = (Role) session.get(Role.class, 3);

        //����1���2�Ž�ɫ
        user1.getUserroles().add(role2);

        //����2���2�ź����Ž�ɫ
        user2.getUserroles().add(role2);
        user2.getUserroles().add(role3);

        //2,3�Ž�ɫ��Ӷ���
        role2.getUsers().add(user1);
        role3.getUsers().add(user1);
        role3.getUsers().add(user2);

        session.save(user1);
        session.save(user2);
        session.save(role2);
        session.save(role3);

        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {

        Operation op = new Operation();
        //op.saveUsers();
        //op.saveRoles();
        //op.selectUser();
        //op.selectRole();
        op.addUserRole();

    }
}
