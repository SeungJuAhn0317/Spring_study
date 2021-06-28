package com.cloud.bbs.service;
import com.cloud.bbs.dto.BBSDto;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.bbs.dto.BBSDto;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;

import com.cloud.bbs.dao.BBSDao;

@Service
public class BBSServiceimpl implements BBSService {
   
   @Autowired
   private BBSDao bbsDao;

   @Override
   public List<BBSDto> list() {
      return bbsDao.list();
   }

   @Override
   public String login(String id, String pass, HttpSession session) {
   String dbpass = bbsDao.login(id);
   
   if(dbpass ==null) {
      System.out.println("회원아님");
      return null;
   }
   else if(dbpass.equals(pass)){
      session.setAttribute("id",id);
      
      //redirect:가 붙으면 다시 서버에 요청을 한다.
      return "redirect:/list.bbs";
   }
   else {
      return "login";
   }
   

}

   @Override
   public void write(BBSDto article) {
      bbsDao.write(article);
   
      }

   
   @Override
   public BBSDto content(String articleNum) {
   
   return bbsDao.content(articleNum);
   
}

   @Override
   public BBSDto updateForm(String articleNum) {
      return bbsDao.updateForm(articleNum);
   }

   @Override
   public void update(BBSDto article) {
		bbsDao.update(article);
	
   }

   @Override
   public void delete(String articleNum) {
	   bbsDao.delete(articleNum);
	
   }
   
}