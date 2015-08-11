package find.service.fileservice;

import java.io.Serializable;
import java.util.ArrayList;

import antlr.collections.List;
import common.entity.PageBean;
import common.servicebase.BaseService;
import find.entity.File;
import find.entity.User;
import find.entity.Video;

public interface FileService extends BaseService<File>{
	public ArrayList<File> QueryFile(Object object,int currentPage,int fileType);
}
