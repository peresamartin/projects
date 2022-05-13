package com.maintenance.server;

import com.maintenance.server.felhasznalo.Felhasznalo;
import com.maintenance.server.felhasznalo.FelhasznaloDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	private FelhasznaloDao felhasznaloDao;

	@Test
	void addFelhasznaloTest() {
		/*Felhasznalo felhasznalo=new Felhasznalo();
		felhasznalo.setFelhasznalonev("asd");
		felhasznalo.setJelszo("asd");

		felhasznaloDao.save(felhasznalo);*/
		System.out.println(felhasznaloDao.letezik("ddfg","dghd"));

	}

}
