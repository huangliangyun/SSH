package com.javahly.test;


import com.javahly.entity.Users;
import com.javahly.entity.UsersType;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Operation {

	public void One1Save(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		UsersType t1 = new UsersType();
		t1.setTypeName("��ͨ��Ա");

		UsersType t2 = new UsersType();
		t2.setTypeName("VIP��Ա");

		session.save(t1);
		session.save(t2);

		session.getTransaction().commit();

		session.close();
	}

	public void One1Update(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		UsersType t1 = (UsersType)session.get(UsersType.class,1);
		t1.setTypeName("��ͨ��Ա1");
		session.update(t1);

		session.getTransaction().commit();

		session.close();
	}

	public void One3Delete(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		UsersType t1 = (UsersType)session.get(UsersType.class,1);
		session.delete(t1);

		session.getTransaction().commit();

		session.close();
	}

	public void Many1Save(){

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

	public void Many1Update(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		Users t1 = (Users)session.get(Users.class,1);
		t1.setUname("��˼");
		session.update(t1);

		session.getTransaction().commit();

		session.close();
	}

	public void Many3Delete(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		Users u1 = (Users)session.get(Users.class,1);
		session.delete(u1);

		session.getTransaction().commit();

		session.close();
	}

	public void OneMany1Save(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		UsersType t1 = new UsersType();
		t1.setTypeName("��ͨ��Ա");

		UsersType t2 = new UsersType();
		t2.setTypeName("VIP��Ա");

		Users u1 = new Users();
		u1.setUname("����");

		Users u2 = new Users();
		u2.setUname("����");

		Users u3 = new Users();
		u3.setUname("����");

		Users u4 = new Users();
		u4.setUname("����");

		Users u5 = new Users();
		u5.setUname("����");


		t1.getUserSet().add(u1);
		t1.getUserSet().add(u2);
		t1.getUserSet().add(u3);
		t2.getUserSet().add(u4);
		t2.getUserSet().add(u5);

		session.save(t1);
		session.save(t2);

		session.save(u1);
		session.save(u2);
		session.save(u3);
		session.save(u4);
		session.save(u5);

		session.getTransaction().commit();

		session.close();
	}

	public void OneMany2Update(){

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();

		//��UsersType����id=1������(��ͨ��Ա)��Ϊ2(vip��Ա)
		//UsersType
		//typeId     typeNname
		// 1                              ��ͨ��Ա
		// 2          VIP��Ա

		//Users
		//uid     uname     tid
		// 1                    ����                     1	--��Ϊ-->  2
		// 2                    ����                     1
		// 3                    ����                     1
		// 4                    ����                     2
		// 5                    ����                     2
		Users u = (Users)session.get(Users.class,1);

		UsersType t1 = (UsersType)session.get(UsersType.class,1);
		UsersType t2 = (UsersType)session.get(UsersType.class,1);

		System.out.println("bef: t1.size = " + t1.getUserSet().size());
		System.out.println("bef: t2.size = " + t2.getUserSet().size());

		t1.getUserSet().remove(u);
		t2.getUserSet().add(u);

		session.update(t2);

		session.getTransaction().commit();

		session.close();

		System.out.println("after: t1.size = " + t1.getUserSet().size());
		System.out.println("after: t2.size = " + t2.getUserSet().size());
	}

	public void OneMany3Delete(){
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		//ɾ��UsersTypeid=1��ֵ,���UsersType id=1  ��ֵɾ��,Users tid��ֵΪnull

		UsersType t1 = (UsersType)session.get(UsersType.class, 1); //�Ƽ�

//		UsersType t1 = new UsersType();
//		t1.setTypeId(2);

		session.delete(t1);

		session.getTransaction().commit();
		session.close();

	}

	public void OneMany4Select(){
		Session session = new Configuration().configure().buildSessionFactory().openSession();

		//��UsersType id=1��Ӧ��Usersֵ��������� ����,����,����
		UsersType t1 = (UsersType)session.get(UsersType.class, 1);

		System.out.println(t1.getTypeName());
		System.out.println("�÷�����û���");

		for (Users u: t1.getUserSet()) {
			System.out.println("\t"+u.getUid()+"\t"+ u.getUname());
		}

		session.close();
	}

	public static void main(String[] args){

		Operation op = new Operation();
		op.One1Save();
		op.One1Update();
		//op.One3Delete();
		op.Many1Save();
		//op.Many1Update();
		//op.Many3Delete();
		//op.OneMany1Save();
		//op.OneMany2Update();
		//op.OneMany3Delete();
		//op.OneMany4Select();






	}
}
