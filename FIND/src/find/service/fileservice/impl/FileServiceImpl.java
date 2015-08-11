package find.service.fileservice.impl;

import java.util.ArrayList;

import common.entity.PageBean;
import common.util.ConstantField;
import antlr.collections.List;
import find.dao.filedao.FileDAO;
import find.entity.File;
import find.entity.User;
import find.entity.Video;
import find.service.fileservice.FileService;

public class FileServiceImpl implements FileService{

	private FileDAO fileDAO;
	//查询文件
	@Override
	public ArrayList<File> QueryFile(Object object, int currentPage,
			int fileType) {
		try {
			String binaryName = null;
			String propertyName=null;
			String nameString=object.getClass().toString();
			switch (fileType) {
			case 0:
				binaryName=this.fileDAO.PhotoName;
				break;
			case 1:
				binaryName=this.fileDAO.VideoName;
				break;
			case 2:
				binaryName=this.fileDAO.WordName;
				break;
			default:
				break;
			}
			if(nameString.contains(this.fileDAO.UserName)){
				propertyName=ConstantField.USER;
			}else if (nameString.contains(this.fileDAO.ClassroomName)) {
				propertyName=ConstantField.CLASSROOM;
			}
			String hql="from " + binaryName+ " as model where model." + propertyName + "= ?" +" order by model.id desc";
			java.util.List list=this.fileDAO.sort(hql,object);
			ArrayList<File> list2=new ArrayList<>();
			if(list!=null){
				for(int i=(currentPage-1)*20;i<currentPage*20;i++){
					if(i>=list.size())
					{
						break;
					}else {
						list2.add((File) list.get(i));
					}
				}
				System.out.println(nameString);
				System.out.println(list2.size());
				return list2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void add(File t) {
	}

	@Override
	public void update(File t) {
		
	}

	@Override
	public void remove(File t) {
		
	}
	
	public FileDAO getFileDAO() {
		return fileDAO;
	}
	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}
	
}
