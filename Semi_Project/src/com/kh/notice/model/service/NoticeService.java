package com.kh.notice.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	
	public List<Notice> selectAllNotice(){
		
		Connection conn=getConnection();
		List<Notice> list=new NoticeDao().selectAllNotice(conn);
		close(conn);
		return list;
	}
	public List<Notice> allNotice() {
		Connection conn=getConnection();
		List<Notice> list=new NoticeDao().allNotice(conn);
		close(conn);
		return list;
	}
	
	public int insertNotice(Notice n) {
		Connection conn=getConnection();
		int result=new NoticeDao().insertNotice(conn,n);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	
	public Notice selectNo(int no) {
		Connection conn = getConnection();
		Notice n=new NoticeDao().selectNo(conn,no);
		close(conn);
		return n;
	}

	
	public int deleteNotice(int no){
		Connection conn =getConnection();
		int result = new NoticeDao().deleteNotice(conn,no);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public int updateNotice(Notice n) {
		Connection conn=getConnection();
		int result=new NoticeDao().updateNotice(conn,n);

		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
		
	}
	
	public int selectCount() {
		Connection conn =getConnection();
		int result=new NoticeDao().selectCount(conn);
		close(conn);
		return result;
	}
	
	public List<Notice> selectList(int cPage,int numPerPage) {
		Connection conn=getConnection();
		List<Notice> list=new NoticeDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	

}
